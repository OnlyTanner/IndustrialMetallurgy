package com.onlytanner.test.blocks;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockWolframiteOre extends Block {

    public BlockWolframiteOre() {
        super(Material.ROCK);
        setUnlocalizedName(Reference.TestModBlocks.WOLFRAMITE_ORE.getUnlocalizedName());
        setRegistryName(Reference.TestModBlocks.WOLFRAMITE_ORE.getRegistryName());
        setHardness(12.0F);
        setHarvestLevel("pickaxe", 3);
        setCreativeTab(TestMod.RESOURCES_TAB);
    }
}
