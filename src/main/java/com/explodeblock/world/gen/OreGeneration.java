package com.explodeblock.world.gen;

import com.explodeblock.block.BlockRegistry;
import com.explodeblock.config.world.gen.OreExplodeConfig;
import com.explodeblock.util.Utils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class OreGeneration {
    public static final ConfiguredFeature<?, ?> ORE_EXPLODE;

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(Utils.MOD_ID, name), configuredFeature);
    }

    static {
        ORE_EXPLODE = register("ore_explode",
                Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, BlockRegistry.explode_block.get().getDefaultState(), OreExplodeConfig.VeinSize.get()))
                        .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(OreExplodeConfig.MinHeight.get(),0,OreExplodeConfig.MaxHeight.get())))
                        .square()
                        .count(OreExplodeConfig.Count.get()));
    }

    public static void OresGenerate(BiomeLoadingEvent event){
        event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ORE_EXPLODE);
    }

}
