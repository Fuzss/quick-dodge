package fuzs.quickdodge.common.client;

import com.mojang.blaze3d.platform.InputConstants;
import fuzs.puzzleslib.common.api.client.core.v1.ClientModConstructor;
import fuzs.puzzleslib.common.api.client.core.v1.context.KeyMappingsContext;
import fuzs.puzzleslib.common.api.client.event.v1.ClientTickEvents;
import fuzs.puzzleslib.common.api.client.event.v1.entity.player.ClientPlayerNetworkEvents;
import fuzs.puzzleslib.common.api.client.event.v1.entity.player.MovementInputUpdateCallback;
import fuzs.puzzleslib.common.api.client.key.v1.KeyActivationHandler;
import fuzs.puzzleslib.common.api.client.key.v1.KeyMappingHelper;
import fuzs.quickdodge.common.QuickDodge;
import fuzs.quickdodge.common.client.gui.components.toasts.DodgingToast;
import fuzs.quickdodge.common.client.handler.MovementInputHandler;
import fuzs.quickdodge.common.client.handler.PlayerAnimationHandler;
import fuzs.quickdodge.common.config.ClientConfig;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;

public class QuickDodgeClient implements ClientModConstructor {
    public static final KeyMapping DODGE_KEY_MAPPING = KeyMappingHelper.registerKeyMapping(QuickDodge.id("dodge"),
            InputConstants.KEY_LALT);

    @Override
    public void onConstructMod() {
        registerEventHandlers();
    }

    private static void registerEventHandlers() {
        ClientTickEvents.END.register(DodgingToast::onEndClientTick);
        ClientPlayerNetworkEvents.JOIN.register(DodgingToast::onPlayerJoin);
        MovementInputUpdateCallback.EVENT.register(MovementInputHandler::onMovementInputUpdate);
    }

    @Override
    public void onClientSetup() {
        PlayerAnimationHandler.registerPlayerAnimations();
    }

    @Override
    public void onRegisterKeyMappings(KeyMappingsContext context) {
        context.registerKeyMapping(DODGE_KEY_MAPPING, KeyActivationHandler.forGame((Minecraft minecraft) -> {
            if (!QuickDodge.CONFIG.get(ClientConfig.class).doubleTapMode) {
                MovementInputHandler.singleTapHandler(minecraft.player);
            }
        }));
    }
}
