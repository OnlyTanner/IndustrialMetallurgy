package com.onlytanner.industrialmetallurgy.world;

import java.util.Random;

import com.onlytanner.industrialmetallurgy.init.ModBlocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class ModWorldGen implements IWorldGenerator {

    private WorldGenerator gen_cuprite_ore;
    private WorldGenerator gen_cassiterite_ore;
    private WorldGenerator gen_chromite_ore;
    private WorldGenerator gen_cobaltite_ore;
    private WorldGenerator gen_sphalerite_ore;
    private WorldGenerator gen_bauxite_ore;
    private WorldGenerator gen_garnierite_ore;
    private WorldGenerator gen_rutile_ore;
    private WorldGenerator gen_wolframite_ore;

    public ModWorldGen() {
        gen_cuprite_ore = new WorldGenMinable(ModBlocks.cuprite_ore.getDefaultState(), 8);
        gen_cassiterite_ore = new WorldGenMinable(ModBlocks.cassiterite_ore.getDefaultState(), 8);
        gen_chromite_ore = new WorldGenMinable(ModBlocks.chromite_ore.getDefaultState(), 5);
        gen_cobaltite_ore = new WorldGenMinable(ModBlocks.cobaltite_ore.getDefaultState(), 4);
        gen_sphalerite_ore = new WorldGenMinable(ModBlocks.sphalerite_ore.getDefaultState(), 8);
        gen_bauxite_ore = new WorldGenMinable(ModBlocks.bauxite_ore.getDefaultState(), 8);
        gen_garnierite_ore = new WorldGenMinable(ModBlocks.garnierite_ore.getDefaultState(), 8);
        gen_rutile_ore = new WorldGenMinable(ModBlocks.rutile_ore.getDefaultState(), 5);
        gen_wolframite_ore = new WorldGenMinable(ModBlocks.wolframite_ore.getDefaultState(), 3);
    }

    @Override
    public void generate(Random rand, int chunk_X, int chunk_Z, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.getDimension()) {
            case 0: //Overworld
                runGenerator(this.gen_cuprite_ore, world, rand, chunk_X, chunk_Z, 8, 1, 63);
                runGenerator(this.gen_cassiterite_ore, world, rand, chunk_X, chunk_Z, 8, 1, 63);
                runGenerator(this.gen_chromite_ore, world, rand, chunk_X, chunk_Z, 2, 1, 20);
                runGenerator(this.gen_sphalerite_ore, world, rand, chunk_X, chunk_Z, 6, 20, 50);
                runGenerator(this.gen_bauxite_ore, world, rand, chunk_X, chunk_Z, 4, 1, 63);
                runGenerator(this.gen_garnierite_ore, world, rand, chunk_X, chunk_Z, 8, 1, 63);
                runGenerator(this.gen_rutile_ore, world, rand, chunk_X, chunk_Z, 3, 1, 30);
                break;
            case -1: //Nether
                runGenerator(this.gen_cobaltite_ore, world, rand, chunk_X, chunk_Z, 1, 1, 128);
                break;
            case 1: //End
                runGenerator(this.gen_wolframite_ore, world, rand, chunk_X, chunk_Z, 3, 20, 80);
                break;
        }
    }

    private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) {
        if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight) {
            throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");
        }

        int heightDiff = maxHeight - minHeight + 1;
        for (int i = 0; i < chancesToSpawn; i++) {
            int x = chunk_X * 16 + rand.nextInt(16);
            int y = minHeight + rand.nextInt(heightDiff);
            int z = chunk_Z * 16 + rand.nextInt(16);
            generator.generate(world, rand, new BlockPos(x, y, z));
        }
    }
}
