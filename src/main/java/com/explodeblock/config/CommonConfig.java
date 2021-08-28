package com.explodeblock.config;

import com.explodeblock.config.block.BlockExplodeConfig;
import com.explodeblock.config.world.gen.OreExplodeConfig;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.Arrays;

public class CommonConfig {
    public static ForgeConfigSpec CONFIG;
    public static ForgeConfigSpec.Builder BUILDER;

    static {
        BUILDER = new ForgeConfigSpec.Builder();
        BUILDER.push(Arrays.asList("world", "gen"));
        OreExplodeConfig.setup(BUILDER);
        BUILDER.pop(2);
        BUILDER.push("block");
        BlockExplodeConfig.setup(BUILDER);
        BUILDER.pop();
        CONFIG = BUILDER.build();
    }
}
