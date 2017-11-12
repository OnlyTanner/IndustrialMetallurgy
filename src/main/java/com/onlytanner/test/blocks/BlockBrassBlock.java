package com.onlytanner.test.blocks;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBrassBlock extends Block 
{
	public BlockBrassBlock() {
		super(Material.IRON);
		setUnlocalizedName(Reference.TestModBlocks.BRASS_BLOCK.getUnlocalizedName());
		setRegistryName(Reference.TestModBlocks.BRASS_BLOCK.getRegistryName());
		setHardness(3.0F);
		setCreativeTab(TestMod.RESOURCES_TAB);
	}
}
