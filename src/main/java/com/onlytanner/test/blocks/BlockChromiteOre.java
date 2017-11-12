package com.onlytanner.test.blocks;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockChromiteOre extends Block {

    public BlockChromiteOre() {
        super(Material.ROCK);
        setUnlocalizedName(Reference.TestModBlocks.CHROMITE_ORE.getUnlocalizedName());
        setRegistryName(Reference.TestModBlocks.CHROMITE_ORE.getRegistryName());
        setHardness(3.0F);
        setHarvestLevel("pickaxe", 2);
        setCreativeTab(TestMod.RESOURCES_TAB);
    }
}
