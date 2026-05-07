package fuzs.quickdodge.common.network;

import fuzs.puzzleslib.common.api.network.v4.MessageSender;
import fuzs.puzzleslib.common.api.network.v4.PlayerSet;
import fuzs.puzzleslib.common.api.network.v4.message.MessageListener;
import fuzs.puzzleslib.common.api.network.v4.message.play.ServerboundPlayMessage;
import fuzs.quickdodge.common.QuickDodge;
import fuzs.quickdodge.common.config.ServerConfig;
import fuzs.quickdodge.common.handler.DodgeEffectsHandler;
import fuzs.quickdodge.common.init.ModRegistry;
import fuzs.quickdodge.common.util.DodgeDirection;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityEvent;

public record ServerboundTriggerDodgeMessage(DodgeDirection dodgeDirection) implements ServerboundPlayMessage {
    public static final StreamCodec<ByteBuf, ServerboundTriggerDodgeMessage> STREAM_CODEC = StreamCodec.composite(
            DodgeDirection.STREAM_CODEC,
            ServerboundTriggerDodgeMessage::dodgeDirection,
            ServerboundTriggerDodgeMessage::new);

    @Override
    public MessageListener<Context> getListener() {
        return new MessageListener<Context>() {
            @Override
            public void accept(Context context) {
                ServerLevel serverLevel = context.level();
                ServerPlayer serverPlayer = context.player();
                if (QuickDodge.CONFIG.get(ServerConfig.class).dodgeSound) {
                    serverLevel.playSound(null,
                            serverPlayer,
                            ModRegistry.DODGE_SOUND_EVENT.value(),
                            SoundSource.PLAYERS,
                            1.0F,
                            4.0F + serverLevel.getRandom().nextFloat());
                }

                if (QuickDodge.CONFIG.get(ServerConfig.class).poofParticles) {
                    serverLevel.broadcastEntityEvent(serverPlayer, EntityEvent.POOF);
                }

                serverPlayer.invulnerableTime = Math.max(serverPlayer.invulnerableTime,
                        QuickDodge.CONFIG.get(ServerConfig.class).invincibilityTicks);
                DodgeEffectsHandler.setDodging(serverPlayer);
                MessageSender.broadcast(PlayerSet.nearPlayer(serverPlayer),
                        new ClientboundPlayDodgeAnimationMessage(serverPlayer.getId(),
                                ServerboundTriggerDodgeMessage.this.dodgeDirection));
            }
        };
    }
}
