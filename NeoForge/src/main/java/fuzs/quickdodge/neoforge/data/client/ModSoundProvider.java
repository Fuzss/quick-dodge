package fuzs.quickdodge.neoforge.data.client;

import fuzs.quickdodge.common.init.ModRegistry;
import fuzs.puzzleslib.common.api.data.v3.core.DataProviderContext;
import fuzs.puzzleslib.neoforge.api.client.data.v3.sounds.AbstractSoundProvider;
import net.minecraft.sounds.SoundEvents;

public class ModSoundProvider extends AbstractSoundProvider {

    public ModSoundProvider(DataProviderContext context) {
        super(context);
    }

    @Override
    public void registerSounds() {
        this.add(ModRegistry.DODGE_SOUND_EVENT.value(), SoundEvents.PLAYER_ATTACK_SWEEP);
    }
}
