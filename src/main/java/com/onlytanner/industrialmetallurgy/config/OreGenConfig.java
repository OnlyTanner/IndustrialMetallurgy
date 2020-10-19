package com.onlytanner.industrialmetallurgy.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class OreGenConfig {

    public static ForgeConfigSpec.IntValue argentiteVeinSize;
    public static ForgeConfigSpec.IntValue argentitePerChunk;
    public static ForgeConfigSpec.IntValue argentiteMinHeight;
    public static ForgeConfigSpec.IntValue argentiteMaxHeight;

    public static ForgeConfigSpec.IntValue bauxiteVeinSize;
    public static ForgeConfigSpec.IntValue bauxitePerChunk;
    public static ForgeConfigSpec.IntValue bauxiteMinHeight;
    public static ForgeConfigSpec.IntValue bauxiteMaxHeight;

    public static ForgeConfigSpec.IntValue cassiteriteVeinSize;
    public static ForgeConfigSpec.IntValue cassiteritePerChunk;
    public static ForgeConfigSpec.IntValue cassiteriteMinHeight;
    public static ForgeConfigSpec.IntValue cassiteriteMaxHeight;

    public static ForgeConfigSpec.IntValue chromiteVeinSize;
    public static ForgeConfigSpec.IntValue chromitePerChunk;
    public static ForgeConfigSpec.IntValue chromiteMinHeight;
    public static ForgeConfigSpec.IntValue chromiteMaxHeight;

    public static ForgeConfigSpec.IntValue cobaltiteVeinSize;
    public static ForgeConfigSpec.IntValue cobaltitePerChunk;
    public static ForgeConfigSpec.IntValue cobaltiteMinHeight;
    public static ForgeConfigSpec.IntValue cobaltiteMaxHeight;

    public static ForgeConfigSpec.IntValue cupriteVeinSize;
    public static ForgeConfigSpec.IntValue cupritePerChunk;
    public static ForgeConfigSpec.IntValue cupriteMinHeight;
    public static ForgeConfigSpec.IntValue cupriteMaxHeight;

    public static ForgeConfigSpec.IntValue galenaVeinSize;
    public static ForgeConfigSpec.IntValue galenaPerChunk;
    public static ForgeConfigSpec.IntValue galenaMinHeight;
    public static ForgeConfigSpec.IntValue galenaMaxHeight;

    public static ForgeConfigSpec.IntValue garnieriteVeinSize;
    public static ForgeConfigSpec.IntValue garnieritePerChunk;
    public static ForgeConfigSpec.IntValue garnieriteMinHeight;
    public static ForgeConfigSpec.IntValue garnieriteMaxHeight;

    public static ForgeConfigSpec.IntValue lepidoliteVeinSize;
    public static ForgeConfigSpec.IntValue lepidolitePerChunk;
    public static ForgeConfigSpec.IntValue lepidoliteMinHeight;
    public static ForgeConfigSpec.IntValue lepidoliteMaxHeight;

    public static ForgeConfigSpec.IntValue pyrolusiteVeinSize;
    public static ForgeConfigSpec.IntValue pyrolusitePerChunk;
    public static ForgeConfigSpec.IntValue pyrolusiteMinHeight;
    public static ForgeConfigSpec.IntValue pyrolusiteMaxHeight;

    public static ForgeConfigSpec.IntValue rutileVeinSize;
    public static ForgeConfigSpec.IntValue rutilePerChunk;
    public static ForgeConfigSpec.IntValue rutileMinHeight;
    public static ForgeConfigSpec.IntValue rutileMaxHeight;

    public static ForgeConfigSpec.IntValue scheeliteVeinSize;
    public static ForgeConfigSpec.IntValue scheelitePerChunk;
    public static ForgeConfigSpec.IntValue scheeliteMinHeight;
    public static ForgeConfigSpec.IntValue scheeliteMaxHeight;

    public static ForgeConfigSpec.IntValue sphaleriteVeinSize;
    public static ForgeConfigSpec.IntValue sphaleritePerChunk;
    public static ForgeConfigSpec.IntValue sphaleriteMinHeight;
    public static ForgeConfigSpec.IntValue sphaleriteMaxHeight;

    //Ore Generation Toggle
    public static ForgeConfigSpec.BooleanValue argentiteGeneration;
    public static ForgeConfigSpec.BooleanValue bauxiteGeneration;
    public static ForgeConfigSpec.BooleanValue cassiteriteGeneration;
    public static ForgeConfigSpec.BooleanValue chromiteGeneration;
    public static ForgeConfigSpec.BooleanValue cobaltiteGeneration;
    public static ForgeConfigSpec.BooleanValue cupriteGeneration;
    public static ForgeConfigSpec.BooleanValue galenaGeneration;
    public static ForgeConfigSpec.BooleanValue garnieriteGeneration;
    public static ForgeConfigSpec.BooleanValue lepidoliteGeneration;
    public static ForgeConfigSpec.BooleanValue pyrolusiteGeneration;
    public static ForgeConfigSpec.BooleanValue rutileGeneration;
    public static ForgeConfigSpec.BooleanValue scheeliteGeneration;
    public static ForgeConfigSpec.BooleanValue sphaleriteGeneration;

    public static void Init(ForgeConfigSpec.Builder builder) {
        argentiteVeinSize = builder
                .defineInRange("ore_generation.argentite.argentiteVeinSize", 6, 0, 36);
        argentitePerChunk = builder
                .defineInRange("ore_generation.argentite.argentiteChance", 10, 0, 64);
        argentiteMinHeight = builder
                .defineInRange("ore_generation.argentite.argentiteMinHeight", 3, 0, 120);
        argentiteMaxHeight = builder
                .defineInRange("ore_generation.argentite.argentiteMaxHeight", 25, 0, 125);

        bauxiteVeinSize = builder
                .defineInRange("ore_generation.bauxite.bauxiteVeinSize", 8, 0, 36);
        bauxitePerChunk = builder
                .defineInRange("ore_generation.bauxite.bauxiteChance", 10, 0, 32);
        bauxiteMinHeight = builder
                .defineInRange("ore_generation.bauxite.bauxiteMinHeight", 10, 0, 120);
        bauxiteMaxHeight = builder
                .defineInRange("ore_generation.bauxite.bauxiteMaxHeight", 55, 0, 125);

        cassiteriteVeinSize = builder
                .defineInRange("ore_generation.cassiterite.cassiteriteVeinSize", 10, 0, 36);
        cassiteritePerChunk = builder
                .defineInRange("ore_generation.cassiterite.cassiteriteChance", 15, 0, 32);
        cassiteriteMinHeight = builder
                .defineInRange("ore_generation.cassiterite.cassiteriteMinHeight", 10, 0, 120);
        cassiteriteMaxHeight = builder
                .defineInRange("ore_generation.cassiterite.cassiteriteMaxHeight", 55, 0, 125);

        chromiteVeinSize = builder
                .defineInRange("ore_generation.chromite.chromiteVeinSize", 4, 0, 36);
        chromitePerChunk = builder
                .defineInRange("ore_generation.chromite.chromiteChance", 4, 0, 32);
        chromiteMinHeight = builder
                .defineInRange("ore_generation.chromite.chromiteMinHeight", 3, 0, 120);
        chromiteMaxHeight = builder
                .defineInRange("ore_generation.chromite.chromiteMaxHeight", 110, 0, 125);

        cobaltiteVeinSize = builder
                .defineInRange("ore_generation.cobaltite.cobaltiteVeinSize", 4, 0, 36);
        cobaltitePerChunk = builder
                .defineInRange("ore_generation.cobaltite.cobaltiteChance", 4, 0, 32);
        cobaltiteMinHeight = builder
                .defineInRange("ore_generation.cobaltite.cobaltiteMinHeight", 3, 0, 120);
        cobaltiteMaxHeight = builder
                .defineInRange("ore_generation.cobaltite.cobaltiteMaxHeight", 110, 0, 125);

        cupriteVeinSize = builder
                .defineInRange("ore_generation.cuprite.cupriteVeinSize", 10, 0, 36);
        cupritePerChunk = builder
                .defineInRange("ore_generation.cuprite.cupriteChance", 15, 0, 32);
        cupriteMinHeight = builder
                .defineInRange("ore_generation.cuprite.cupriteMinHeight", 10, 0, 120);
        cupriteMaxHeight = builder
                .defineInRange("ore_generation.cuprite.cupriteMaxHeight", 55, 0, 125);

        galenaVeinSize = builder
                .defineInRange("ore_generation.galena.galenaVeinSize", 6, 0, 36);
        galenaPerChunk = builder
                .defineInRange("ore_generation.galena.galenaChance", 10, 0, 32);
        galenaMinHeight = builder
                .defineInRange("ore_generation.galena.galenaMinHeight", 3, 0, 120);
        galenaMaxHeight = builder
                .defineInRange("ore_generation.galena.galenaMaxHeight", 25, 0, 125);

        garnieriteVeinSize = builder
                .defineInRange("ore_generation.garnierite.garnieriteVeinSize", 8, 0, 36);
        garnieritePerChunk = builder
                .defineInRange("ore_generation.garnierite.garnieriteChance", 12, 0, 32);
        garnieriteMinHeight = builder
                .defineInRange("ore_generation.garnierite.garnieriteMinHeight", 10, 0, 120);
        garnieriteMaxHeight = builder
                .defineInRange("ore_generation.garnierite.garnieriteMaxHeight", 40, 0, 125);

        lepidoliteVeinSize = builder
                .defineInRange("ore_generation.lepidolite.lepidoliteVeinSize", 4, 0, 36);
        lepidolitePerChunk = builder
                .defineInRange("ore_generation.lepidolite.lepidoliteChance", 2, 0, 32);
        lepidoliteMinHeight = builder
                .defineInRange("ore_generation.lepidolite.lepidoliteMinHeight", 25, 0, 120);
        lepidoliteMaxHeight = builder
                .defineInRange("ore_generation.lepidolite.lepidoliteMaxHeight", 100, 0, 125);

        pyrolusiteVeinSize = builder
                .defineInRange("ore_generation.pyrolusite.pyrolusiteVeinSize", 10, 0, 36);
        pyrolusitePerChunk = builder
                .defineInRange("ore_generation.pyrolusite.pyrolusiteChance", 15, 0, 32);
        pyrolusiteMinHeight = builder
                .defineInRange("ore_generation.pyrolusite.pyrolusiteMinHeight", 10, 0, 120);
        pyrolusiteMaxHeight = builder
                .defineInRange("ore_generation.pyrolusite.pyrolusiteMaxHeight", 30, 0, 125);

        rutileVeinSize = builder
                .defineInRange("ore_generation.rutile.rutileVeinSize", 6, 0, 36);
        rutilePerChunk = builder
                .defineInRange("ore_generation.rutile.rutileChance", 8, 0, 32);
        rutileMinHeight = builder
                .defineInRange("ore_generation.rutile.rutileMinHeight", 3, 0, 120);
        rutileMaxHeight = builder
                .defineInRange("ore_generation.rutile.rutileMaxHeight", 18, 0, 125);

        scheeliteVeinSize = builder
                .defineInRange("ore_generation.scheelite.scheeliteVeinSize", 4, 0, 36);
        scheelitePerChunk = builder
                .defineInRange("ore_generation.scheelite.scheeliteChance", 2, 0, 32);
        scheeliteMinHeight = builder
                .defineInRange("ore_generation.scheelite.scheeliteMinHeight", 25, 0, 120);
        scheeliteMaxHeight = builder
                .defineInRange("ore_generation.scheelite.scheeliteMaxHeight", 100, 0, 125);

        sphaleriteVeinSize = builder
                .defineInRange("ore_generation.sphalerite.sphaleriteVeinSize", 8, 0, 36);
        sphaleritePerChunk = builder
                .defineInRange("ore_generation.sphalerite.sphaleriteChance", 12, 0, 32);
        sphaleriteMinHeight = builder
                .defineInRange("ore_generation.sphalerite.sphaleriteMinHeight", 10, 0, 120);
        sphaleriteMaxHeight = builder
                .defineInRange("ore_generation.sphalerite.sphaleriteMaxHeight", 40, 0, 125);

        //World Ore Generation
        argentiteGeneration = builder
                .comment("Generate Argentite Ore")
                .define("ore_generation.world_generation.argentite", true);
        bauxiteGeneration = builder
                .comment("Generate Bauxite Ore")
                .define("ore_generation.world_generation.bauxite", true);
        cassiteriteGeneration = builder
                .comment("Generate Cassiterite Ore")
                .define("ore_generation.world_generation.cassiterite", true);
        chromiteGeneration = builder
                .comment("Generate Chromite Ore")
                .define("ore_generation.world_generation.chromite", true);
        cobaltiteGeneration = builder
                .comment("Generate Cobaltite Ore")
                .define("ore_generation.world_generation.cobaltite", true);
        cupriteGeneration = builder
                .comment("Generate Cuprite Ore")
                .define("ore_generation.world_generation.cuprite", true);
        galenaGeneration = builder
                .comment("Generate Galena Ore")
                .define("ore_generation.world_generation.galena", true);
        garnieriteGeneration = builder
                .comment("Generate Garnierite Ore")
                .define("ore_generation.world_generation.garnierite", true);
        lepidoliteGeneration = builder
                .comment("Generate Lepidolite Ore")
                .define("ore_generation.world_generation.lepidolite", true);
        pyrolusiteGeneration = builder
                .comment("Generate Pyrolusite Ore")
                .define("ore_generation.world_generation.pyrolusite", true);
        rutileGeneration = builder
                .comment("Generate Rutile Ore")
                .define("ore_generation.world_generation.rutile", true);
        scheeliteGeneration = builder
                .comment("Generate Scheelite Ore")
                .define("ore_generation.world_generation.scheelite", true);
        sphaleriteGeneration = builder
                .comment("Generate Sphalerite Ore")
                .define("ore_generation.world_generation.sphalerite", true);
    }

}
