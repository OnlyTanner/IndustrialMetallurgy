package com.onlytanner.test.blocks;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockZincBlock extends Block
{
	public BlockZincBlock() 
	{
		super(Material.IRON);
		setUnlocalizedName(Reference.TestModBlocks.ZINC_BLOCK.getUnlocalizedName());
		setRegistryName(Reference.TestModBlocks.ZINC_BLOCK.getRegistryName());
		setHardness(3.0F);
		setCreativeTab(TestMod.RESOURCES_TAB);
	}
}
