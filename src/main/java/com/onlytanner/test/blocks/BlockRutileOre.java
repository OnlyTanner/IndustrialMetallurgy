package com.onlytanner.test.blocks;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockRutileOre extends Block 
{

	public BlockRutileOre() 
	{
		super(Material.ROCK);
		setUnlocalizedName(Reference.TestModBlocks.RUTILE_ORE.getUnlocalizedName());
		setRegistryName(Reference.TestModBlocks.RUTILE_ORE.getRegistryName());
		setHardness(3.0F);
		setHarvestLevel("pickaxe", 2);
		setCreativeTab(TestMod.RESOURCES_TAB);
	}

}
