package com.onlytanner.test.blocks;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBronzeBlock extends Block
{
	public BlockBronzeBlock() 
	{
		super(Material.IRON);
		setUnlocalizedName(Reference.TestModBlocks.BRONZE_BLOCK.getUnlocalizedName());
		setRegistryName(Reference.TestModBlocks.BRONZE_BLOCK.getRegistryName());
		setHardness(4.0F);
		setCreativeTab(TestMod.RESOURCES_TAB);
	}
}
