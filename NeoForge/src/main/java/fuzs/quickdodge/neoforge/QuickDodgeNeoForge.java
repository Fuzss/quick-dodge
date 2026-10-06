package fuzs.quickdodge.neoforge;

import fuzs.puzzleslib.common.api.core.v1.ModConstructor;
import fuzs.puzzleslib.neoforge.api.data.v3.core.DataProviderBuilder;
import fuzs.quickdodge.common.QuickDodge;
import fuzs.quickdodge.common.data.tags.ModEnchantmentTagsProvider;
import fuzs.quickdodge.common.init.ModRegistry;
import net.neoforged.fml.common.Mod;

@Mod(QuickDodge.MOD_ID)
public class QuickDodgeNeoForge {

    public QuickDodgeNeoForge() {
        ModConstructor.construct(QuickDodge.MOD_ID, QuickDodge::new);
        DataProviderBuilder.of(QuickDodge.MOD_ID)
                .setRegistrySetBuilder(ModRegistry.REGISTRY_SET_BUILDER)
                .addProvider(ModEnchantmentTagsProvider::new);
    }
}
