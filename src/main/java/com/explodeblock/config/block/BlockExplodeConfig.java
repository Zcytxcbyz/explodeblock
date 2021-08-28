package com.explodeblock.config.block;

import net.minecraftforge.common.ForgeConfigSpec;

public class BlockExplodeConfig{
    public static ForgeConfigSpec.DoubleValue ExplosionRange;

    public static final double ExplodeRange_Default = 4.0;

    public static void setup(ForgeConfigSpec.Builder BUILDER) {
        BUILDER.push("block_explode");
        ExplosionRange = BUILDER.defineInRange("ExplosionRange", ExplodeRange_Default, 0, Double.MAX_VALUE);
        BUILDER.pop();
    }

    public static void reset(){
        ExplosionRange.set(ExplodeRange_Default);
    }
}
