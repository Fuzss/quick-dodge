package fuzs.quickdodge.neoforge.client;

import fuzs.puzzleslib.common.api.client.core.v1.ClientModConstructor;
import fuzs.puzzleslib.neoforge.api.data.v2.core.DataProviderHelper;
import fuzs.quickdodge.common.QuickDodge;
import fuzs.quickdodge.common.client.QuickDodgeClient;
import fuzs.quickdodge.common.data.client.ModLanguageProvider;
import fuzs.quickdodge.neoforge.data.client.ModSoundProvider;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;

@Mod(value = QuickDodge.MOD_ID, dist = Dist.CLIENT)
public class QuickDodgeNeoForgeClient {

    public QuickDodgeNeoForgeClient() {
        ClientModConstructor.construct(QuickDodge.MOD_ID, QuickDodgeClient::new);
        DataProviderHelper.registerDataProviders(QuickDodge.MOD_ID, ModLanguageProvider::new, ModSoundProvider::new);
    }
}
