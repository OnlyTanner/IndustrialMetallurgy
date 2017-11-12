package com.onlytanner.test.blocks;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBauxiteOre extends Block 
{
	public BlockBauxiteOre() {
		super(Material.ROCK);
		setUnlocalizedName(Reference.TestModBlocks.BAUXITE_ORE.getUnlocalizedName());
		setRegistryName(Reference.TestModBlocks.BAUXITE_ORE.getRegistryName());
		setHardness(3.0F);
		setHarvestLevel("pickaxe", 1);
		setCreativeTab(TestMod.RESOURCES_TAB);
	}
}
