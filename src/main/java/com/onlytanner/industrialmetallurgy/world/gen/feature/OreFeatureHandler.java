package com.onlytanner.industrialmetallurgy.world.gen.feature;

import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.config.OreGenConfig;
import com.onlytanner.industrialmetallurgy.util.RegistryHandler;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;

public class OreFeatureHandler {

    public static ConfiguredFeature<?, ?> ORE_ARGENTITE = Feature.ORE
            .withConfiguration(new OreFeatureConfig(
                    OreFeatureConfig.FillerBlockType.field_241882_a, RegistryHandler.ARGENTITE_ORE.get().getDefaultState(),
                    OreGenConfig.argentiteVeinSize.get()))
            .func_242733_d(OreGenConfig.argentiteMaxHeight.get())
            .func_242728_a().func_242731_b(OreGenConfig.argentitePerChunk.get());

    public static ConfiguredFeature<?, ?> ORE_BAUXITE = Feature.ORE
            .withConfiguration(new OreFeatureConfig(
                    OreFeatureConfig.FillerBlockType.field_241882_a, RegistryHandler.BAUXITE_ORE.get().getDefaultState(),
                    OreGenConfig.bauxiteVeinSize.get()))
            .func_242733_d(OreGenConfig.bauxiteMaxHeight.get())
            .func_242728_a().func_242731_b(OreGenConfig.bauxitePerChunk.get());

    public static ConfiguredFeature<?, ?> ORE_CASSITERITE = Feature.ORE
            .withConfiguration(new OreFeatureConfig(
                    OreFeatureConfig.FillerBlockType.field_241882_a, RegistryHandler.CASSITERITE_ORE.get().getDefaultState(),
                    OreGenConfig.cassiteriteVeinSize.get()))
            .func_242733_d(OreGenConfig.cassiteriteMaxHeight.get())
            .func_242728_a().func_242731_b(OreGenConfig.cassiteritePerChunk.get());

    public static ConfiguredFeature<?, ?> ORE_CHROMITE = Feature.ORE
            .withConfiguration(new OreFeatureConfig(
                    OreFeatureConfig.FillerBlockType.field_241883_b, RegistryHandler.CHROMITE_ORE.get().getDefaultState(),
                    OreGenConfig.chromiteVeinSize.get()))
            .func_242733_d(OreGenConfig.chromiteMaxHeight.get())
            .func_242728_a().func_242731_b(OreGenConfig.chromitePerChunk.get());

    public static ConfiguredFeature<?, ?> ORE_COBALTITE = Feature.ORE
            .withConfiguration(new OreFeatureConfig(
                    OreFeatureConfig.FillerBlockType.field_241883_b, RegistryHandler.COBALTITE_ORE.get().getDefaultState(),
                    OreGenConfig.cobaltiteVeinSize.get()))
            .func_242733_d(OreGenConfig.cobaltiteMaxHeight.get())
            .func_242728_a().func_242731_b(OreGenConfig.cobaltitePerChunk.get());

    public static ConfiguredFeature<?, ?> ORE_CUPRITE = Feature.ORE
            .withConfiguration(new OreFeatureConfig(
                    OreFeatureConfig.FillerBlockType.field_241882_a, RegistryHandler.CUPRITE_ORE.get().getDefaultState(),
                    OreGenConfig.cupriteVeinSize.get()))
            .func_242733_d(OreGenConfig.cupriteMaxHeight.get())
            .func_242728_a().func_242731_b(OreGenConfig.cupritePerChunk.get());

    public static ConfiguredFeature<?, ?> ORE_GALENA = Feature.ORE
            .withConfiguration(new OreFeatureConfig(
                    OreFeatureConfig.FillerBlockType.field_241882_a, RegistryHandler.GALENA_ORE.get().getDefaultState(),
                    OreGenConfig.galenaVeinSize.get()))
            .func_242733_d(OreGenConfig.galenaMaxHeight.get())
            .func_242728_a().func_242731_b(OreGenConfig.galenaPerChunk.get());

    public static ConfiguredFeature<?, ?> ORE_GARNIERITE = Feature.ORE
            .withConfiguration(new OreFeatureConfig(
                    OreFeatureConfig.FillerBlockType.field_241882_a, RegistryHandler.GARNIERITE_ORE.get().getDefaultState(),
                    OreGenConfig.garnieriteVeinSize.get()))
            .func_242733_d(OreGenConfig.garnieriteMaxHeight.get())
            .func_242728_a().func_242731_b(OreGenConfig.garnieritePerChunk.get());

    public static ConfiguredFeature<?, ?> ORE_LEPIDOLITE = Feature.ORE
            .withConfiguration(new OreFeatureConfig(
                    OreFeatureConfig.FillerBlockType.field_241884_c, RegistryHandler.LEPIDOLITE_ORE.get().getDefaultState(),
                    OreGenConfig.lepidoliteVeinSize.get()))
            .func_242733_d(OreGenConfig.lepidoliteMaxHeight.get())
            .func_242728_a().func_242731_b(OreGenConfig.lepidolitePerChunk.get());

    public static ConfiguredFeature<?, ?> ORE_PYROLUSITE = Feature.ORE
            .withConfiguration(new OreFeatureConfig(
                    OreFeatureConfig.FillerBlockType.field_241882_a, RegistryHandler.PYROLUSITE_ORE.get().getDefaultState(),
                    OreGenConfig.pyrolusiteVeinSize.get()))
            .func_242733_d(OreGenConfig.pyrolusiteMaxHeight.get())
            .func_242728_a().func_242731_b(OreGenConfig.pyrolusitePerChunk.get());

    public static ConfiguredFeature<?, ?> ORE_RUTILE = Feature.ORE
            .withConfiguration(new OreFeatureConfig(
                    OreFeatureConfig.FillerBlockType.field_241882_a, RegistryHandler.RUTILE_ORE.get().getDefaultState(),
                    OreGenConfig.rutileVeinSize.get()))
            .func_242733_d(OreGenConfig.rutileMaxHeight.get())
            .func_242728_a().func_242731_b(OreGenConfig.rutilePerChunk.get());

    public static ConfiguredFeature<?, ?> ORE_SCHEELITE = Feature.ORE
            .withConfiguration(new OreFeatureConfig(
                    OreFeatureConfig.FillerBlockType.field_241884_c, RegistryHandler.SCHEELITE_ORE.get().getDefaultState(),
                    OreGenConfig.scheeliteVeinSize.get()))
            .func_242733_d(OreGenConfig.scheeliteMaxHeight.get())
            .func_242728_a().func_242731_b(OreGenConfig.scheelitePerChunk.get());

    public static ConfiguredFeature<?, ?> ORE_SPHALERITE = Feature.ORE
            .withConfiguration(new OreFeatureConfig(
                    OreFeatureConfig.FillerBlockType.field_241882_a, RegistryHandler.SPHALERITE_ORE.get().getDefaultState(),
                    OreGenConfig.sphaleriteVeinSize.get()))
            .func_242733_d(OreGenConfig.sphaleriteMaxHeight.get())
            .func_242728_a().func_242731_b(OreGenConfig.sphaleritePerChunk.get());


    public static void initModFeatures () {
        Registry.register(WorldGenRegistries.field_243653_e, new ResourceLocation(IndustrialMetallurgy.MOD_ID, "ore_argentite"), ORE_ARGENTITE);
        Registry.register(WorldGenRegistries.field_243653_e, new ResourceLocation(IndustrialMetallurgy.MOD_ID, "ore_bauxite"), ORE_BAUXITE);
        Registry.register(WorldGenRegistries.field_243653_e, new ResourceLocation(IndustrialMetallurgy.MOD_ID, "ore_cassiterite"), ORE_CASSITERITE);
        Registry.register(WorldGenRegistries.field_243653_e, new ResourceLocation(IndustrialMetallurgy.MOD_ID, "ore_chromite"), ORE_CHROMITE);
        Registry.register(WorldGenRegistries.field_243653_e, new ResourceLocation(IndustrialMetallurgy.MOD_ID, "ore_cobaltite"), ORE_COBALTITE);
        Registry.register(WorldGenRegistries.field_243653_e, new ResourceLocation(IndustrialMetallurgy.MOD_ID, "ore_cuprite"), ORE_CUPRITE);
        Registry.register(WorldGenRegistries.field_243653_e, new ResourceLocation(IndustrialMetallurgy.MOD_ID, "ore_galena"), ORE_GALENA);
        Registry.register(WorldGenRegistries.field_243653_e, new ResourceLocation(IndustrialMetallurgy.MOD_ID, "ore_garnierite"), ORE_GARNIERITE);
        Registry.register(WorldGenRegistries.field_243653_e, new ResourceLocation(IndustrialMetallurgy.MOD_ID, "ore_lepidolite"), ORE_LEPIDOLITE);
        Registry.register(WorldGenRegistries.field_243653_e, new ResourceLocation(IndustrialMetallurgy.MOD_ID, "ore_pyrolusite"), ORE_PYROLUSITE);
        Registry.register(WorldGenRegistries.field_243653_e, new ResourceLocation(IndustrialMetallurgy.MOD_ID, "ore_rutile"), ORE_RUTILE);
        Registry.register(WorldGenRegistries.field_243653_e, new ResourceLocation(IndustrialMetallurgy.MOD_ID, "ore_scheelite"), ORE_SCHEELITE);
        Registry.register(WorldGenRegistries.field_243653_e, new ResourceLocation(IndustrialMetallurgy.MOD_ID, "ore_sphalerite"), ORE_SPHALERITE);
    }

}
