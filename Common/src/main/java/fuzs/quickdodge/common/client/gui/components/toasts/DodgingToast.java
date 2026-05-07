package fuzs.quickdodge.common.client.gui.components.toasts;

import fuzs.quickdodge.common.QuickDodge;
import fuzs.quickdodge.common.client.QuickDodgeClient;
import fuzs.quickdodge.common.config.ClientConfig;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.toasts.TutorialToast;
import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.tutorial.Tutorial;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.util.ARGB;
import net.neoforged.neoforge.common.ModConfigSpec;

public class DodgingToast extends TutorialToast {
    private static final Identifier BACKGROUND_SPRITE = Identifier.withDefaultNamespace("toast/tutorial");
    private static final Identifier DODGE_SPRITE = QuickDodge.id("toast/dodge");
    public static final Component SINGLE_TAP_TITLE_COMPONENT = Component.translatable("tutorial.single_tap_dodge.title");
    public static final Component SINGLE_TAP_DESCRIPTION_COMPONENT = Component.translatable(
            "tutorial.single_tap_dodge.description",
            Component.keybind(QuickDodgeClient.DODGE_KEY_MAPPING.getName()).withStyle(ChatFormatting.BOLD));
    public static final Component DOUBLE_TAP_TITLE_COMPONENT = Component.translatable("tutorial.double_tap_dodge.title");
    public static final Component DOUBLE_TAP_DESCRIPTION_COMPONENT = Component.translatable(
            "tutorial.double_tap_dodge.description",
            Tutorial.key("forward"),
            Tutorial.key("left"),
            Tutorial.key("back"),
            Tutorial.key("right"));

    private static int timeWaiting;

    public DodgingToast(Font font) {
        super(font, Icons.MOVEMENT_KEYS, getTitleComponent(), getDescriptionComponent(), false, 8000);
    }

    public static void onEndClientTick(Minecraft minecraft) {
        if (minecraft.level != null && !minecraft.isPaused()) {
            if (timeWaiting < 100 && ++timeWaiting == 100) {
                ModConfigSpec.BooleanValue displayTutorial = QuickDodge.CONFIG.get(ClientConfig.class).displayTutorial;
                if (displayTutorial.get()) {
                    minecraft.getToastManager().addToast(new DodgingToast(minecraft.font));
                    displayTutorial.set(false);
                    displayTutorial.save();
                }
            }
        }
    }

    public static void onPlayerJoin(LocalPlayer player, MultiPlayerGameMode multiPlayerGameMode, Connection connection) {
        timeWaiting = 0;
    }

    private static Component getTitleComponent() {
        return QuickDodge.CONFIG.get(ClientConfig.class).doubleTapMode ? DOUBLE_TAP_TITLE_COMPONENT :
                SINGLE_TAP_TITLE_COMPONENT;
    }

    private static Component getDescriptionComponent() {
        return QuickDodge.CONFIG.get(ClientConfig.class).doubleTapMode ? DOUBLE_TAP_DESCRIPTION_COMPONENT :
                SINGLE_TAP_DESCRIPTION_COMPONENT;
    }

    @Override
    public void extractRenderState(GuiGraphicsExtractor guiGraphics, Font font, long visibilityTime) {
        // Copied from the super method while replacing the icon render call.
        int height = this.height();
        guiGraphics.blitSprite(RenderPipelines.GUI_TEXTURED, BACKGROUND_SPRITE, 0, 0, this.width(), height);
        guiGraphics.blitSprite(RenderPipelines.GUI_TEXTURED, DODGE_SPRITE, 6, 6, 20, 20);
        int textHeight = this.lines.size() * 11;
        int textTop = 7 + (this.contentHeight() - textHeight) / 2;
        for (int l = 0; l < this.lines.size(); l++) {
            guiGraphics.text(font, this.lines.get(l), 30, textTop + l * 11, ARGB.opaque(0), false);
        }
    }
}
