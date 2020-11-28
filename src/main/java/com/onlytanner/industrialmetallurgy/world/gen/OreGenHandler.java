package com.onlytanner.industrialmetallurgy.world.gen;

import com.google.common.collect.Lists;
import com.onlytanner.industrialmetallurgy.config.OreGenConfig;
import com.onlytanner.industrialmetallurgy.world.gen.feature.OreFeatureHandler;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class OreGenHandler {

    public static void generateOres() {
        for (Map.Entry<RegistryKey<Biome>, Biome> biome : WorldGenRegistries.BIOME.getEntries() /* Collection of Biome Entries */) {
            if (biome.getValue().getCategory() == Biome.Category.NETHER) {
                if (OreGenConfig.cobaltiteGeneration.get())
                    addFeatureToBiome(biome.getValue(), GenerationStage.Decoration.UNDERGROUND_ORES, OreFeatureHandler.ORE_COBALTITE);
                if (OreGenConfig.chromiteGeneration.get())
                    addFeatureToBiome(biome.getValue(), GenerationStage.Decoration.UNDERGROUND_ORES, OreFeatureHandler.ORE_CHROMITE);
            }
            else if (biome.getValue().getCategory() == Biome.Category.THEEND) {
                if (OreGenConfig.scheeliteGeneration.get())
                    addFeatureToBiome(biome.getValue(), GenerationStage.Decoration.UNDERGROUND_ORES, OreFeatureHandler.ORE_SCHEELITE);
                if (OreGenConfig.lepidoliteGeneration.get())
                    addFeatureToBiome(biome.getValue(), GenerationStage.Decoration.UNDERGROUND_ORES, OreFeatureHandler.ORE_LEPIDOLITE);
            }
            else if ((biome.getValue().getCategory() == Biome.Category.PLAINS) || (biome.getValue().getCategory() == Biome.Category.ICY) || biome.getValue().getCategory() == Biome.Category.SAVANNA){
                if (OreGenConfig.argentiteGeneration.get())
                    addFeatureToBiome(biome.getValue(), GenerationStage.Decoration.UNDERGROUND_ORES, OreFeatureHandler.ORE_ARGENTITE);
                if (OreGenConfig.sphaleriteGeneration.get())
                    addFeatureToBiome(biome.getValue(), GenerationStage.Decoration.UNDERGROUND_ORES, OreFeatureHandler.ORE_SPHALERITE);
            }
            else if ((biome.getValue().getCategory() == Biome.Category.JUNGLE) || (biome.getValue().getCategory() == Biome.Category.EXTREME_HILLS) || (biome.getValue().getCategory() == Biome.Category.OCEAN)){
                if (OreGenConfig.bauxiteGeneration.get())
                    addFeatureToBiome(biome.getValue(), GenerationStage.Decoration.UNDERGROUND_ORES, OreFeatureHandler.ORE_BAUXITE);
                if (OreGenConfig.cassiteriteGeneration.get())
                    addFeatureToBiome(biome.getValue(), GenerationStage.Decoration.UNDERGROUND_ORES, OreFeatureHandler.ORE_CASSITERITE);
            }
            else if ((biome.getValue().getCategory() == Biome.Category.DESERT) || (biome.getValue().getCategory() == Biome.Category.MESA) || (biome.getValue().getCategory() == Biome.Category.BEACH)){
                if (OreGenConfig.cupriteGeneration.get())
                    addFeatureToBiome(biome.getValue(), GenerationStage.Decoration.UNDERGROUND_ORES, OreFeatureHandler.ORE_CUPRITE);
                if (OreGenConfig.rutileGeneration.get())
                    addFeatureToBiome(biome.getValue(), GenerationStage.Decoration.UNDERGROUND_ORES, OreFeatureHandler.ORE_RUTILE);
            }
            else if ((biome.getValue().getCategory() == Biome.Category.FOREST) || (biome.getValue().getCategory() == Biome.Category.TAIGA)){
                if (OreGenConfig.galenaGeneration.get())
                    addFeatureToBiome(biome.getValue(), GenerationStage.Decoration.UNDERGROUND_ORES, OreFeatureHandler.ORE_GALENA);
                if (OreGenConfig.garnieriteGeneration.get())
                    addFeatureToBiome(biome.getValue(), GenerationStage.Decoration.UNDERGROUND_ORES, OreFeatureHandler.ORE_GARNIERITE);
            }
            else if ((biome.getValue().getCategory() == Biome.Category.SWAMP) || (biome.getValue().getCategory() == Biome.Category.MUSHROOM)){
                if (OreGenConfig.pyrolusiteGeneration.get())
                    addFeatureToBiome(biome.getValue(), GenerationStage.Decoration.UNDERGROUND_ORES, OreFeatureHandler.ORE_PYROLUSITE);
            }
        }
    }

    public static void addFeatureToBiome(Biome biome, GenerationStage.Decoration decoration, ConfiguredFeature<?, ?> configuredFeature) {
        List<List<Supplier<ConfiguredFeature<?, ?>>>> biomeFeatures = new ArrayList<>(
                biome.getGenerationSettings().getFeatures() /* List of Configured Features */
        );
        while (biomeFeatures.size() <= decoration.ordinal()) {
            biomeFeatures.add(Lists.newArrayList());
        }
        List<Supplier<ConfiguredFeature<?, ?>>> features = new ArrayList<>(biomeFeatures.get(decoration.ordinal()));
        features.add(() -> configuredFeature);
        biomeFeatures.set(decoration.ordinal(), features);
        /* Change field_242484_f that contains the Configured Features of the Biome*/
        ObfuscationReflectionHelper.setPrivateValue(BiomeGenerationSettings.class, biome.getGenerationSettings(), biomeFeatures, "field_242484_f");
    }

}
