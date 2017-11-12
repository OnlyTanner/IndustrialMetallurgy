package com.onlytanner.test.blocks;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockRefractoryBricks extends Block {

    public BlockRefractoryBricks() {
        super(Material.ROCK);
        setUnlocalizedName(Reference.TestModBlocks.REFRACTORY_BRICKS.getUnlocalizedName());
        setRegistryName(Reference.TestModBlocks.REFRACTORY_BRICKS.getRegistryName());
        setHardness(3.0F);
        setCreativeTab(TestMod.SMELTING_TAB);
    }

}
