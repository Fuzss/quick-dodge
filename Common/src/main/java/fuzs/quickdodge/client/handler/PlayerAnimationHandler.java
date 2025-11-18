package fuzs.quickdodge.client.handler;

import com.zigythebird.playeranim.animation.PlayerAnimationController;
import com.zigythebird.playeranim.api.PlayerAnimationAccess;
import com.zigythebird.playeranim.api.PlayerAnimationFactory;
import com.zigythebird.playeranimcore.animation.AnimationController;
import com.zigythebird.playeranimcore.animation.AnimationData;
import com.zigythebird.playeranimcore.enums.PlayState;
import fuzs.quickdodge.QuickDodge;
import fuzs.quickdodge.util.DodgeDirection;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Avatar;

public class PlayerAnimationHandler {
    private static final ResourceLocation PLAYER_ASSOCIATED_DATA_LOCATION = QuickDodge.id("animation");

    public static void registerPlayerAnimations() {
        PlayerAnimationFactory.ANIMATION_DATA_FACTORY.registerFactory(PLAYER_ASSOCIATED_DATA_LOCATION,
                1024,
                (Avatar avatar) -> {
                    return new PlayerAnimationController(avatar,
                            (AnimationController controller, AnimationData state, AnimationController.AnimationSetter animationSetter) -> {
                                return PlayState.STOP;
                            });
                });
    }

    public static void playPlayerAnimation(Avatar avatar, DodgeDirection dodgeDirection) {
        if (PlayerAnimationAccess.getPlayerAnimationLayer(avatar,
                PLAYER_ASSOCIATED_DATA_LOCATION) instanceof PlayerAnimationController controller) {
            controller.triggerAnimation(dodgeDirection.animationLocation);
        }
    }
}
