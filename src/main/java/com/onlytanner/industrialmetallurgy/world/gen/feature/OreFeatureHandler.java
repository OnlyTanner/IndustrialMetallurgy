package com.onlytanner.industrialmetallurgy.world.gen.feature;

import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;

public class OreFeatureHandler {

    public static ConfiguredFeature<?, ?> ORE_EMERALD_NETHER = Feature.ORE
            .withConfiguration(new OreFeatureConfig(
                    OreFeatureConfig.FillerBlockType.field_241883_b, BlockOreList.netheremerald_ore.getDefaultState(),
                    OreGenerationConfig.emeraldVeinSize.get()))
            .withPlacement(Placement.field_242907_l.configure(
                    new TopSolidRangeConfig(
                            OreGenerationConfig.emeraldMinHeight.get(),
                            0,
                            OreGenerationConfig.emeraldMaxHeight.get())))
            .func_242728_a().func_242731_b(OreGenerationConfig.emeraldPerChunk.get());

}
