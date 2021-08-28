package com.explodeblock.config.world.gen;

import net.minecraftforge.common.ForgeConfigSpec;

public class OreExplodeConfig {
    public static ForgeConfigSpec.IntValue VeinSize;
    public static ForgeConfigSpec.IntValue MinHeight;
    public static ForgeConfigSpec.IntValue MaxHeight;
    public static ForgeConfigSpec.IntValue Count;

    public static final int VeinSize_Default = 10;
    public static final int MinHeight_Default = 5;
    public static final int MaxHeight_Default = 70;
    public static final int Count_Default = 10;

    public static void setup(ForgeConfigSpec.Builder BUILDER) {
        BUILDER.push("ore_explode");
        VeinSize = BUILDER.defineInRange("VeinSize", VeinSize_Default, 0, Integer.MAX_VALUE);
        MinHeight = BUILDER.defineInRange("MinHeight", MinHeight_Default, 0, Integer.MAX_VALUE);
        MaxHeight = BUILDER.defineInRange("MaxHeight", MaxHeight_Default, 0, Integer.MAX_VALUE);
        Count = BUILDER.defineInRange("Count", Count_Default, 0, Integer.MAX_VALUE);
        BUILDER.pop();
    }

    public static void reset(){
        VeinSize.set(VeinSize_Default);
        MinHeight.set(MinHeight_Default);
        MaxHeight.set(MaxHeight_Default);
        Count.set(Count_Default);
    }
}
