package com.onlytanner.test.blocks;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockCupriteOre extends Block
{
	public BlockCupriteOre() 
	{
		super(Material.ROCK);
		setUnlocalizedName(Reference.TestModBlocks.CUPRITE_ORE.getUnlocalizedName());
		setRegistryName(Reference.TestModBlocks.CUPRITE_ORE.getRegistryName());
		setHardness(3.0F);
		setHarvestLevel("pickaxe", 1);
		setCreativeTab(TestMod.RESOURCES_TAB);
	}
}
