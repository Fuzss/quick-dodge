package fuzs.quickdodge.common.data.client;

import fuzs.puzzleslib.common.api.client.data.v2.AbstractLanguageProvider;
import fuzs.puzzleslib.common.api.data.v2.core.DataProviderContext;
import fuzs.quickdodge.common.QuickDodge;
import fuzs.quickdodge.common.client.QuickDodgeClient;
import fuzs.quickdodge.common.client.gui.components.toasts.DodgingToast;
import fuzs.quickdodge.common.init.ModRegistry;

public class ModLanguageProvider extends AbstractLanguageProvider {

    public ModLanguageProvider(DataProviderContext context) {
        super(context);
    }

    @Override
    public void addTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.addKeyCategory(QuickDodge.MOD_ID, QuickDodge.MOD_NAME);
        translationBuilder.add(QuickDodgeClient.DODGE_KEY_MAPPING, "Dodge");
        translationBuilder.add(ModRegistry.DODGE_STRENGTH_ATTRIBUTE.value(), "Dodge Strength");
        translationBuilder.add(ModRegistry.DODGE_SOUND_EVENT.value(), "Player dodges");
        translationBuilder.add(ModRegistry.FLEETFOOT_ENCHANTMENT, "Fleetfoot");
        translationBuilder.add(ModRegistry.FLEETFOOT_ENCHANTMENT,
                "desc",
                "Increases the distance traveled when dodging.");
        translationBuilder.add(ModRegistry.AIRSTRIDE_ENCHANTMENT, "Airstride");
        translationBuilder.add(ModRegistry.AIRSTRIDE_ENCHANTMENT, "desc", "Allows dodging while in mid-air.");
        translationBuilder.add(ModRegistry.SHOCKSTEP_ENCHANTMENT, "Shockstep");
        translationBuilder.add(ModRegistry.SHOCKSTEP_ENCHANTMENT, "desc", "Damages mobs when dashing through them.");
        translationBuilder.add(DodgingToast.SINGLE_TAP_TITLE_COMPONENT, "Move through the world");
        translationBuilder.add(DodgingToast.SINGLE_TAP_DESCRIPTION_COMPONENT, "Dodge with %s");
        translationBuilder.add(DodgingToast.DOUBLE_TAP_TITLE_COMPONENT, "Get ready to dodge");
        translationBuilder.add(DodgingToast.DOUBLE_TAP_DESCRIPTION_COMPONENT, "Double tap %s, %s, %s or %s");
    }
}
