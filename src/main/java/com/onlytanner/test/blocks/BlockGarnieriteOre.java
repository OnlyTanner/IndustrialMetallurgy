package com.onlytanner.test.blocks;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockGarnieriteOre extends Block {

    public BlockGarnieriteOre() {
        super(Material.ROCK);
        setUnlocalizedName(Reference.TestModBlocks.GARNIERITE_ORE.getUnlocalizedName());
        setRegistryName(Reference.TestModBlocks.GARNIERITE_ORE.getRegistryName());
        setHardness(3.0F);
        setHarvestLevel("pickaxe", 1);
        setCreativeTab(TestMod.RESOURCES_TAB);
    }
}
