package com.onlytanner.test.blocks;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockAluminumBlock extends Block {

    public BlockAluminumBlock() {
        super(Material.IRON);
        setUnlocalizedName(Reference.TestModBlocks.ALUMINUM_BLOCK.getUnlocalizedName());
        setRegistryName(Reference.TestModBlocks.ALUMINUM_BLOCK.getRegistryName());
        setHardness(3.0F);
        setCreativeTab(TestMod.RESOURCES_TAB);
    }
}
