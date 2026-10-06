package fuzs.quickdodge.common.data.client;

import fuzs.puzzleslib.common.api.client.data.v3.language.AbstractLanguageProvider;
import fuzs.puzzleslib.common.api.data.v3.core.DataProviderContext;
import fuzs.quickdodge.common.QuickDodge;
import fuzs.quickdodge.common.client.QuickDodgeClient;
import fuzs.quickdodge.common.client.gui.components.toasts.DodgingToast;
import fuzs.quickdodge.common.init.ModRegistry;

public class ModLanguageProvider extends AbstractLanguageProvider {

    public ModLanguageProvider(DataProviderContext context) {
        super(context);
    }

    @Override
    public void addTranslations() {
        this.addKeyCategory(QuickDodge.MOD_ID, QuickDodge.MOD_NAME);
        this.add(QuickDodgeClient.DODGE_KEY_MAPPING, "Dodge");
        this.add(ModRegistry.DODGE_STRENGTH_ATTRIBUTE.value(), "Dodge Strength");
        this.add(ModRegistry.DODGE_SOUND_EVENT.value(), "Player dodges");
        this.add(ModRegistry.FLEETFOOT_ENCHANTMENT, "Fleetfoot");
        this.add(ModRegistry.FLEETFOOT_ENCHANTMENT,
                "desc",
                "Increases the distance traveled when dodging.");
        this.add(ModRegistry.AIRSTRIDE_ENCHANTMENT, "Airstride");
        this.add(ModRegistry.AIRSTRIDE_ENCHANTMENT, "desc", "Allows dodging while in mid-air.");
        this.add(ModRegistry.SHOCKSTEP_ENCHANTMENT, "Shockstep");
        this.add(ModRegistry.SHOCKSTEP_ENCHANTMENT, "desc", "Damages mobs when dashing through them.");
        this.add(DodgingToast.SINGLE_TAP_TITLE_COMPONENT, "Move through the world");
        this.add(DodgingToast.SINGLE_TAP_DESCRIPTION_COMPONENT, "Dodge with %s");
        this.add(DodgingToast.DOUBLE_TAP_TITLE_COMPONENT, "Get ready to dodge");
        this.add(DodgingToast.DOUBLE_TAP_DESCRIPTION_COMPONENT, "Double tap %s, %s, %s or %s");
    }
}
