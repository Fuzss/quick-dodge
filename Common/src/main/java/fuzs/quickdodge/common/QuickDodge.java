package fuzs.quickdodge.common;

import fuzs.puzzleslib.common.api.config.v3.ConfigHolder;
import fuzs.puzzleslib.common.api.core.v1.ModConstructor;
import fuzs.puzzleslib.common.api.core.v1.context.EntityAttributesContext;
import fuzs.puzzleslib.common.api.core.v1.context.PayloadTypesContext;
import fuzs.puzzleslib.common.api.event.v1.entity.player.PlayerTickEvents;
import fuzs.quickdodge.common.config.ClientConfig;
import fuzs.quickdodge.common.config.CommonConfig;
import fuzs.quickdodge.common.config.ServerConfig;
import fuzs.quickdodge.common.handler.DodgeEffectsHandler;
import fuzs.quickdodge.common.init.ModRegistry;
import fuzs.quickdodge.common.network.ClientboundPlayDodgeAnimationMessage;
import fuzs.quickdodge.common.network.ServerboundTriggerDodgeMessage;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EntityType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuickDodge implements ModConstructor {
    public static final String MOD_ID = "quickdodge";
    public static final String MOD_NAME = "Quick Dodge";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public static final ConfigHolder CONFIG = ConfigHolder.builder(MOD_ID)
            .client(ClientConfig.class)
            .common(CommonConfig.class)
            .server(ServerConfig.class);

    @Override
    public void onConstructMod() {
        ModRegistry.bootstrap();
        registerEventHandlers();
    }

    private static void registerEventHandlers() {
        PlayerTickEvents.START.register(DodgeEffectsHandler::onStartPlayerTick);
        PlayerTickEvents.END.register(DodgeEffectsHandler::onPlayerTickEnd);
    }

    @Override
    public void onRegisterPayloadTypes(PayloadTypesContext context) {
        context.playToClient(ClientboundPlayDodgeAnimationMessage.class,
                ClientboundPlayDodgeAnimationMessage.STREAM_CODEC);
        context.playToServer(ServerboundTriggerDodgeMessage.class, ServerboundTriggerDodgeMessage.STREAM_CODEC);
    }

    @Override
    public void onRegisterEntityAttributes(EntityAttributesContext context) {
        context.registerAttribute(EntityType.PLAYER,
                ModRegistry.DODGE_STRENGTH_ATTRIBUTE,
                QuickDodge.CONFIG.get(CommonConfig.class).dodgeStrength);
    }

    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }
}
