package fuzs.quickdodge.common.config;

import fuzs.puzzleslib.common.api.config.v3.Config;
import fuzs.puzzleslib.common.api.config.v3.ConfigCore;

public class CommonConfig implements ConfigCore {
    @Config(description = "How far the player moves when dodging.", gameRestart = true)
    @Config.DoubleRange(min = 0.0, max = 128.0)
    public double dodgeStrength = 10.0;
}
