package com.onlytanner.test.blocks;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockInvarBlock extends Block 
{
	public BlockInvarBlock()
	{
		super(Material.IRON);
		setUnlocalizedName(Reference.TestModBlocks.INVAR_BLOCK.getUnlocalizedName());
		setRegistryName(Reference.TestModBlocks.INVAR_BLOCK.getRegistryName());
		setHardness(3.0F);
		setCreativeTab(TestMod.RESOURCES_TAB);
	}
}
