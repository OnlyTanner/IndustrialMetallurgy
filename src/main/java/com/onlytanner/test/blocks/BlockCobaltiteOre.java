package com.onlytanner.test.blocks;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockCobaltiteOre extends Block 
{
	public BlockCobaltiteOre() 
	{
		super(Material.ROCK);
		setUnlocalizedName(Reference.TestModBlocks.COBALTITE_ORE.getUnlocalizedName());
		setRegistryName(Reference.TestModBlocks.COBALTITE_ORE.getRegistryName());
		setHardness(8.0F);
		setHarvestLevel("pickaxe", 3);
		setCreativeTab(TestMod.RESOURCES_TAB);
	}
}
