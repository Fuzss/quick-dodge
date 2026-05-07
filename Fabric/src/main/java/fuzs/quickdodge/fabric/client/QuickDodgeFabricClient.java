package fuzs.quickdodge.fabric.client;

import fuzs.quickdodge.common.QuickDodge;
import fuzs.quickdodge.common.client.QuickDodgeClient;
import fuzs.puzzleslib.common.api.client.core.v1.ClientModConstructor;
import net.fabricmc.api.ClientModInitializer;

public class QuickDodgeFabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientModConstructor.construct(QuickDodge.MOD_ID, QuickDodgeClient::new);
    }
}
