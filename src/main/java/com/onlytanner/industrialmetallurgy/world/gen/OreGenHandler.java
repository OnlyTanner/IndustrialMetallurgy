package com.onlytanner.industrialmetallurgy.world.gen;

import com.google.common.collect.Lists;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.util.RegistryHandler;
import net.minecraft.block.BlockState;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.DepthAverageConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import java.util.*;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = IndustrialMetallurgy.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class OreGenHandler {

    @SubscribeEvent
    public static void generateOres(FMLLoadCompleteEvent event) {
        registerOres();
        for (Map.Entry<RegistryKey<Biome>, Biome> biome : WorldGenRegistries.field_243657_i.func_239659_c_() /* Collection of Biome Entries */) {
            if (biome.getValue().getCategory().equals(Biome.Category.NETHER)) {
                addFeatureToBiome(
                        biome.getValue(),
                        GenerationStage.Decoration.UNDERGROUND_ORES,
                        WorldGenRegistries.field_243653_e.getOrDefault(RegistryHandler.COBALTITE_ORE.getId())
                );
                addFeatureToBiome(
                        biome.getValue(),
                        GenerationStage.Decoration.UNDERGROUND_ORES,
                        WorldGenRegistries.field_243653_e.getOrDefault(RegistryHandler.CHROMITE_ORE.getId())
                );
            }
            else if (biome.getValue().getCategory().equals(Biome.Category.THEEND)) {
                addFeatureToBiome(
                        biome.getValue(),
                        GenerationStage.Decoration.UNDERGROUND_ORES,
                        WorldGenRegistries.field_243653_e.getOrDefault(RegistryHandler.SCHEELITE_ORE.getId())
                );
                addFeatureToBiome(
                        biome.getValue(),
                        GenerationStage.Decoration.UNDERGROUND_ORES,
                        WorldGenRegistries.field_243653_e.getOrDefault(RegistryHandler.LEPIDOLITE_ORE.getId())
                );
            }
            else if (biome.getValue().getCategory().equals(Biome.Category.PLAINS) || biome.getValue().getCategory().equals(Biome.Category.ICY)){
                addFeatureToBiome(
                        biome.getValue(),
                        GenerationStage.Decoration.UNDERGROUND_ORES,
                        WorldGenRegistries.field_243653_e.getOrDefault(RegistryHandler.ARGENTITE_ORE.getId())
                );
                addFeatureToBiome(
                        biome.getValue(),
                        GenerationStage.Decoration.UNDERGROUND_ORES,
                        WorldGenRegistries.field_243653_e.getOrDefault(RegistryHandler.SPHALERITE_ORE.getId())
                );
            }
            else if (biome.getValue().getCategory().equals(Biome.Category.JUNGLE) || biome.getValue().getCategory().equals(Biome.Category.EXTREME_HILLS)){
                addFeatureToBiome(
                        biome.getValue(),
                        GenerationStage.Decoration.UNDERGROUND_ORES,
                        WorldGenRegistries.field_243653_e.getOrDefault(RegistryHandler.BAUXITE_ORE.getId())
                );
                addFeatureToBiome(
                        biome.getValue(),
                        GenerationStage.Decoration.UNDERGROUND_ORES,
                        WorldGenRegistries.field_243653_e.getOrDefault(RegistryHandler.CASSITERITE_ORE.getId())
                );
            }
            else if (biome.getValue().getCategory().equals(Biome.Category.DESERT) || biome.getValue().getCategory().equals(Biome.Category.MESA)){
                addFeatureToBiome(
                        biome.getValue(),
                        GenerationStage.Decoration.UNDERGROUND_ORES,
                        WorldGenRegistries.field_243653_e.getOrDefault(RegistryHandler.CUPRITE_ORE.getId())
                );
                addFeatureToBiome(
                        biome.getValue(),
                        GenerationStage.Decoration.UNDERGROUND_ORES,
                        WorldGenRegistries.field_243653_e.getOrDefault(RegistryHandler.RUTILE_ORE.getId())
                );
            }
            else if (biome.getValue().getCategory().equals(Biome.Category.FOREST) || biome.getValue().getCategory().equals(Biome.Category.MUSHROOM) || biome.getValue().getCategory().equals(Biome.Category.TAIGA)){
                addFeatureToBiome(
                        biome.getValue(),
                        GenerationStage.Decoration.UNDERGROUND_ORES,
                        WorldGenRegistries.field_243653_e.getOrDefault(RegistryHandler.GARNIERITE_ORE.getId())
                );
                addFeatureToBiome(
                        biome.getValue(),
                        GenerationStage.Decoration.UNDERGROUND_ORES,
                        WorldGenRegistries.field_243653_e.getOrDefault(RegistryHandler.GALENA_ORE.getId())
                );
            }
            else if (biome.getValue().getCategory().equals(Biome.Category.SWAMP) || biome.getValue().getCategory().equals(Biome.Category.MESA)){
                addFeatureToBiome(
                        biome.getValue(),
                        GenerationStage.Decoration.UNDERGROUND_ORES,
                        WorldGenRegistries.field_243653_e.getOrDefault(RegistryHandler.PYROLUSITE_ORE.getId())
                );
            }
        }
    }

    private static void registerOres() {
        // Argentite
        Registry.register(
                WorldGenRegistries.field_243653_e /* Feature Registering */,
                RegistryHandler.ARGENTITE_ORE.getId() /* Resource Location */,
                Feature.field_236289_V_ /* no_surface_ore */.withConfiguration(
                        new OreFeatureConfig(
                                OreFeatureConfig.FillerBlockType.field_241882_a /* base_stone_overworld */,
                                RegistryHandler.ARGENTITE_ORE.get().getDefaultState(),
                                64
                        )
                ).withPlacement(Placement.field_242910_o /* depth */ .configure(
                        new DepthAverageConfig(12, 12)
                )).func_242728_a() /* spreadHorizontally */ .func_242731_b(1) /* repeat */
        );
        // Bauxite
        Registry.register(
                WorldGenRegistries.field_243653_e /* Feature Registering */,
                RegistryHandler.BAUXITE_ORE.getId() /* Resource Location */,
                Feature.field_236289_V_ /* no_surface_ore */.withConfiguration(
                        new OreFeatureConfig(
                                OreFeatureConfig.FillerBlockType.field_241882_a /* base_stone_overworld */,
                                RegistryHandler.BAUXITE_ORE.get().getDefaultState(),
                                64
                        )
                ).withPlacement(Placement.field_242910_o /* depth */ .configure(
                        new DepthAverageConfig(12, 12)
                )).func_242728_a() /* spreadHorizontally */ .func_242731_b(1) /* repeat */
        );
        // Cassiterite
        Registry.register(
                WorldGenRegistries.field_243653_e /* Feature Registering */,
                RegistryHandler.CASSITERITE_ORE.getId() /* Resource Location */,
                Feature.field_236289_V_ /* no_surface_ore */.withConfiguration(
                        new OreFeatureConfig(
                                OreFeatureConfig.FillerBlockType.field_241882_a /* base_stone_overworld */,
                                RegistryHandler.CASSITERITE_ORE.get().getDefaultState(),
                                64
                        )
                ).withPlacement(Placement.field_242910_o /* depth */ .configure(
                        new DepthAverageConfig(12, 12)
                )).func_242728_a() /* spreadHorizontally */ .func_242731_b(1) /* repeat */
        );
        // Chromite
        Registry.register(
                WorldGenRegistries.field_243653_e /* Feature Registering */,
                RegistryHandler.CHROMITE_ORE.getId() /* Resource Location */,
                Feature.field_236289_V_ /* no_surface_ore */.withConfiguration(
                        new OreFeatureConfig(
                                OreFeatureConfig.FillerBlockType.field_241882_a /* base_stone_overworld */,
                                RegistryHandler.CHROMITE_ORE.get().getDefaultState(),
                                64
                        )
                ).withPlacement(Placement.field_242910_o /* depth */ .configure(
                        new DepthAverageConfig(12, 12)
                )).func_242728_a() /* spreadHorizontally */ .func_242731_b(1) /* repeat */
        );
        // Cobaltite
        Registry.register(
                WorldGenRegistries.field_243653_e /* Feature Registering */,
                RegistryHandler.COBALTITE_ORE.getId() /* Resource Location */,
                Feature.field_236289_V_ /* no_surface_ore */.withConfiguration(
                        new OreFeatureConfig(
                                OreFeatureConfig.FillerBlockType.field_241883_b /* nether */,
                                RegistryHandler.COBALTITE_ORE.get().getDefaultState(),
                                64
                        )
                ).withPlacement(Placement.field_242910_o /* depth */ .configure(
                        new DepthAverageConfig(12, 12)
                )).func_242728_a() /* spreadHorizontally */ .func_242731_b(1) /* repeat */
        );
        // Cuprite
        Registry.register(
                WorldGenRegistries.field_243653_e /* Feature Registering */,
                RegistryHandler.CUPRITE_ORE.getId() /* Resource Location */,
                Feature.field_236289_V_ /* no_surface_ore */.withConfiguration(
                        new OreFeatureConfig(
                                OreFeatureConfig.FillerBlockType.field_241882_a /* base_stone_overworld */,
                                RegistryHandler.CUPRITE_ORE.get().getDefaultState(),
                                64
                        )
                ).withPlacement(Placement.field_242910_o /* depth */ .configure(
                        new DepthAverageConfig(12, 12)
                )).func_242728_a() /* spreadHorizontally */ .func_242731_b(1) /* repeat */
        );
        // Galena
        Registry.register(
                WorldGenRegistries.field_243653_e /* Feature Registering */,
                RegistryHandler.GALENA_ORE.getId() /* Resource Location */,
                Feature.field_236289_V_ /* no_surface_ore */.withConfiguration(
                        new OreFeatureConfig(
                                OreFeatureConfig.FillerBlockType.field_241882_a /* base_stone_overworld */,
                                RegistryHandler.GALENA_ORE.get().getDefaultState(),
                                64
                        )
                ).withPlacement(Placement.field_242910_o /* depth */ .configure(
                        new DepthAverageConfig(12, 12)
                )).func_242728_a() /* spreadHorizontally */ .func_242731_b(1) /* repeat */
        );
        // Garnierite
        Registry.register(
                WorldGenRegistries.field_243653_e /* Feature Registering */,
                RegistryHandler.GARNIERITE_ORE.getId() /* Resource Location */,
                Feature.field_236289_V_ /* no_surface_ore */.withConfiguration(
                        new OreFeatureConfig(
                                OreFeatureConfig.FillerBlockType.field_241882_a /* base_stone_overworld */,
                                RegistryHandler.GARNIERITE_ORE.get().getDefaultState(),
                                64
                        )
                ).withPlacement(Placement.field_242910_o /* depth */ .configure(
                        new DepthAverageConfig(12, 12)
                )).func_242728_a() /* spreadHorizontally */ .func_242731_b(1) /* repeat */
        );
        // Lepidolite
        Registry.register(
                WorldGenRegistries.field_243653_e /* Feature Registering */,
                RegistryHandler.LEPIDOLITE_ORE.getId() /* Resource Location */,
                Feature.field_236289_V_ /* no_surface_ore */.withConfiguration(
                        new OreFeatureConfig(
                                OreFeatureConfig.FillerBlockType.field_241882_a /* base_stone_overworld */,
                                RegistryHandler.LEPIDOLITE_ORE.get().getDefaultState(),
                                64
                        )
                ).withPlacement(Placement.field_242910_o /* depth */ .configure(
                        new DepthAverageConfig(12, 12)
                )).func_242728_a() /* spreadHorizontally */ .func_242731_b(1) /* repeat */
        );
        // Pyrolusite
        Registry.register(
                WorldGenRegistries.field_243653_e /* Feature Registering */,
                RegistryHandler.PYROLUSITE_ORE.getId() /* Resource Location */,
                Feature.field_236289_V_ /* no_surface_ore */.withConfiguration(
                        new OreFeatureConfig(
                                OreFeatureConfig.FillerBlockType.field_241882_a /* base_stone_overworld */,
                                RegistryHandler.PYROLUSITE_ORE.get().getDefaultState(),
                                64
                        )
                ).withPlacement(Placement.field_242910_o /* depth */ .configure(
                        new DepthAverageConfig(12, 12)
                )).func_242728_a() /* spreadHorizontally */ .func_242731_b(1) /* repeat */
        );
        // Rutile
        Registry.register(
                WorldGenRegistries.field_243653_e /* Feature Registering */,
                RegistryHandler.RUTILE_ORE.getId() /* Resource Location */,
                Feature.field_236289_V_ /* no_surface_ore */.withConfiguration(
                        new OreFeatureConfig(
                                OreFeatureConfig.FillerBlockType.field_241882_a /* base_stone_overworld */,
                                RegistryHandler.RUTILE_ORE.get().getDefaultState(),
                                64
                        )
                ).withPlacement(Placement.field_242910_o /* depth */ .configure(
                        new DepthAverageConfig(12, 12)
                )).func_242728_a() /* spreadHorizontally */ .func_242731_b(1) /* repeat */
        );
        // Scheelite
        Registry.register(
                WorldGenRegistries.field_243653_e /* Feature Registering */,
                RegistryHandler.SCHEELITE_ORE.getId() /* Resource Location */,
                Feature.field_236289_V_ /* no_surface_ore */.withConfiguration(
                        new OreFeatureConfig(
                                OreFeatureConfig.FillerBlockType.field_241884_c /* the_end */,
                                RegistryHandler.SCHEELITE_ORE.get().getDefaultState(),
                                64
                        )
                ).withPlacement(Placement.field_242910_o /* depth */ .configure(
                        new DepthAverageConfig(12, 12)
                )).func_242728_a() /* spreadHorizontally */ .func_242731_b(1) /* repeat */
        );
        // Sphalerite
        Registry.register(
                WorldGenRegistries.field_243653_e /* Feature Registering */,
                RegistryHandler.SPHALERITE_ORE.getId() /* Resource Location */,
                Feature.field_236289_V_ /* no_surface_ore */.withConfiguration(
                        new OreFeatureConfig(
                                OreFeatureConfig.FillerBlockType.field_241882_a /* base_stone_overworld */,
                                RegistryHandler.SPHALERITE_ORE.get().getDefaultState(),
                                64
                        )
                ).withPlacement(Placement.field_242910_o /* depth */ .configure(
                        new DepthAverageConfig(12, 12)
                )).func_242728_a() /* spreadHorizontally */ .func_242731_b(1) /* repeat */
        );
    }

    public static void addFeatureToBiome(Biome biome, GenerationStage.Decoration decoration, ConfiguredFeature<?, ?> configuredFeature) {
        List<List<Supplier<ConfiguredFeature<?, ?>>>> biomeFeatures = new ArrayList<>(
                biome.func_242440_e().func_242498_c() /* List of Configured Features */
        );
        while (biomeFeatures.size() <= decoration.ordinal()) {
            biomeFeatures.add(Lists.newArrayList());
        }
        List<Supplier<ConfiguredFeature<?, ?>>> features = new ArrayList<>(biomeFeatures.get(decoration.ordinal()));
        features.add(() -> configuredFeature);
        biomeFeatures.set(decoration.ordinal(), features);
        /* Change field_242484_f that contains the Configured Features of the Biome*/
        ObfuscationReflectionHelper.setPrivateValue(BiomeGenerationSettings.class, biome.func_242440_e(), biomeFeatures, "field_242484_f");
    }

}
