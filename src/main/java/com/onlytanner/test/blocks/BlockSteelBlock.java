package com.onlytanner.test.blocks;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockSteelBlock extends Block {

    public BlockSteelBlock() {
        super(Material.IRON);
        setUnlocalizedName(Reference.TestModBlocks.STEEL_BLOCK.getUnlocalizedName());
        setRegistryName(Reference.TestModBlocks.STEEL_BLOCK.getRegistryName());
        setHardness(8.0F);
        setCreativeTab(TestMod.RESOURCES_TAB);
    }
}
