package com.onlytanner.industrialmetallurgy.world.gen.feature;

import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.config.OreGenConfig;
import com.onlytanner.industrialmetallurgy.util.RegistryHandler;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraft.world.gen.feature.template.RuleTest;

public class OreFeatureHandler {

    public static final class FillerBlockType {
        public static final RuleTest END_STONE = new BlockMatchRuleTest(Blocks.END_STONE);
    }

    public static ConfiguredFeature<?, ?> ORE_ARGENTITE = Feature.ORE
            .withConfiguration(new OreFeatureConfig(
                    OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, RegistryHandler.ARGENTITE_ORE.get().getDefaultState(),
                    OreGenConfig.argentiteVeinSize.get()))
            .range(OreGenConfig.argentiteMaxHeight.get())
            .square().func_242731_b(OreGenConfig.argentitePerChunk.get());

    public static ConfiguredFeature<?, ?> ORE_BAUXITE = Feature.ORE
            .withConfiguration(new OreFeatureConfig(
                    OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, RegistryHandler.BAUXITE_ORE.get().getDefaultState(),
                    OreGenConfig.bauxiteVeinSize.get()))
            .range(OreGenConfig.bauxiteMaxHeight.get())
            .square().func_242731_b(OreGenConfig.bauxitePerChunk.get());

    public static ConfiguredFeature<?, ?> ORE_CASSITERITE = Feature.ORE
            .withConfiguration(new OreFeatureConfig(
                    OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, RegistryHandler.CASSITERITE_ORE.get().getDefaultState(),
                    OreGenConfig.cassiteriteVeinSize.get()))
            .range(OreGenConfig.cassiteriteMaxHeight.get())
            .square().func_242731_b(OreGenConfig.cassiteritePerChunk.get());

    public static ConfiguredFeature<?, ?> ORE_CHROMITE = Feature.ORE
            .withConfiguration(new OreFeatureConfig(
                    OreFeatureConfig.FillerBlockType.NETHERRACK, RegistryHandler.CHROMITE_ORE.get().getDefaultState(),
                    OreGenConfig.chromiteVeinSize.get()))
            .range(OreGenConfig.chromiteMaxHeight.get())
            .square().func_242731_b(OreGenConfig.chromitePerChunk.get());

    public static ConfiguredFeature<?, ?> ORE_COBALTITE = Feature.ORE
            .withConfiguration(new OreFeatureConfig(
                    OreFeatureConfig.FillerBlockType.NETHERRACK, RegistryHandler.COBALTITE_ORE.get().getDefaultState(),
                    OreGenConfig.cobaltiteVeinSize.get()))
            .range(OreGenConfig.cobaltiteMaxHeight.get())
            .square().func_242731_b(OreGenConfig.cobaltitePerChunk.get());

    public static ConfiguredFeature<?, ?> ORE_CUPRITE = Feature.ORE
            .withConfiguration(new OreFeatureConfig(
                    OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, RegistryHandler.CUPRITE_ORE.get().getDefaultState(),
                    OreGenConfig.cupriteVeinSize.get()))
            .range(OreGenConfig.cupriteMaxHeight.get())
            .square().func_242731_b(OreGenConfig.cupritePerChunk.get());

    public static ConfiguredFeature<?, ?> ORE_GALENA = Feature.ORE
            .withConfiguration(new OreFeatureConfig(
                    OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, RegistryHandler.GALENA_ORE.get().getDefaultState(),
                    OreGenConfig.galenaVeinSize.get()))
            .range(OreGenConfig.galenaMaxHeight.get())
            .square().func_242731_b(OreGenConfig.galenaPerChunk.get());

    public static ConfiguredFeature<?, ?> ORE_GARNIERITE = Feature.ORE
            .withConfiguration(new OreFeatureConfig(
                    OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, RegistryHandler.GARNIERITE_ORE.get().getDefaultState(),
                    OreGenConfig.garnieriteVeinSize.get()))
            .range(OreGenConfig.garnieriteMaxHeight.get())
            .square().func_242731_b(OreGenConfig.garnieritePerChunk.get());

    public static ConfiguredFeature<?, ?> ORE_LEPIDOLITE = Feature.ORE
            .withConfiguration(new OreFeatureConfig(
                    FillerBlockType.END_STONE, RegistryHandler.LEPIDOLITE_ORE.get().getDefaultState(),
                    OreGenConfig.lepidoliteVeinSize.get()))
            .range(OreGenConfig.lepidoliteMaxHeight.get())
            .square().func_242731_b(OreGenConfig.lepidolitePerChunk.get());

    public static ConfiguredFeature<?, ?> ORE_PYROLUSITE = Feature.ORE
            .withConfiguration(new OreFeatureConfig(
                    OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, RegistryHandler.PYROLUSITE_ORE.get().getDefaultState(),
                    OreGenConfig.pyrolusiteVeinSize.get()))
            .range(OreGenConfig.pyrolusiteMaxHeight.get())
            .square().func_242731_b(OreGenConfig.pyrolusitePerChunk.get());

    public static ConfiguredFeature<?, ?> ORE_RUTILE = Feature.ORE
            .withConfiguration(new OreFeatureConfig(
                    OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, RegistryHandler.RUTILE_ORE.get().getDefaultState(),
                    OreGenConfig.rutileVeinSize.get()))
            .range(OreGenConfig.rutileMaxHeight.get())
            .square().func_242731_b(OreGenConfig.rutilePerChunk.get());

    public static ConfiguredFeature<?, ?> ORE_SCHEELITE = Feature.ORE
            .withConfiguration(new OreFeatureConfig(
                    FillerBlockType.END_STONE, RegistryHandler.SCHEELITE_ORE.get().getDefaultState(),
                    OreGenConfig.scheeliteVeinSize.get()))
            .range(OreGenConfig.scheeliteMaxHeight.get())
            .square().func_242731_b(OreGenConfig.scheelitePerChunk.get());

    public static ConfiguredFeature<?, ?> ORE_SPHALERITE = Feature.ORE
            .withConfiguration(new OreFeatureConfig(
                    OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, RegistryHandler.SPHALERITE_ORE.get().getDefaultState(),
                    OreGenConfig.sphaleriteVeinSize.get()))
            .range(OreGenConfig.sphaleriteMaxHeight.get())
            .square().func_242731_b(OreGenConfig.sphaleritePerChunk.get());


    public static void initModFeatures () {
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(IndustrialMetallurgy.MOD_ID, "ore_argentite"), ORE_ARGENTITE);
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(IndustrialMetallurgy.MOD_ID, "ore_bauxite"), ORE_BAUXITE);
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(IndustrialMetallurgy.MOD_ID, "ore_cassiterite"), ORE_CASSITERITE);
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(IndustrialMetallurgy.MOD_ID, "ore_chromite"), ORE_CHROMITE);
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(IndustrialMetallurgy.MOD_ID, "ore_cobaltite"), ORE_COBALTITE);
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(IndustrialMetallurgy.MOD_ID, "ore_cuprite"), ORE_CUPRITE);
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(IndustrialMetallurgy.MOD_ID, "ore_galena"), ORE_GALENA);
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(IndustrialMetallurgy.MOD_ID, "ore_garnierite"), ORE_GARNIERITE);
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(IndustrialMetallurgy.MOD_ID, "ore_lepidolite"), ORE_LEPIDOLITE);
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(IndustrialMetallurgy.MOD_ID, "ore_pyrolusite"), ORE_PYROLUSITE);
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(IndustrialMetallurgy.MOD_ID, "ore_rutile"), ORE_RUTILE);
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(IndustrialMetallurgy.MOD_ID, "ore_scheelite"), ORE_SCHEELITE);
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(IndustrialMetallurgy.MOD_ID, "ore_sphalerite"), ORE_SPHALERITE);
    }

}
