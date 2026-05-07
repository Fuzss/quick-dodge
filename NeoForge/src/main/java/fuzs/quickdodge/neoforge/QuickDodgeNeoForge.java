package fuzs.quickdodge.neoforge;

import fuzs.puzzleslib.common.api.core.v1.ModConstructor;
import fuzs.puzzleslib.neoforge.api.data.v2.core.DataProviderHelper;
import fuzs.quickdodge.QuickDodge;
import fuzs.quickdodge.data.tags.ModEnchantmentTagsProvider;
import fuzs.quickdodge.init.ModRegistry;
import net.neoforged.fml.common.Mod;

@Mod(QuickDodge.MOD_ID)
public class QuickDodgeNeoForge {

    public QuickDodgeNeoForge() {
        ModConstructor.construct(QuickDodge.MOD_ID, QuickDodge::new);
        DataProviderHelper.registerDataProviders(QuickDodge.MOD_ID,
                ModRegistry.REGISTRY_SET_BUILDER,
                ModEnchantmentTagsProvider::new);
    }
}
