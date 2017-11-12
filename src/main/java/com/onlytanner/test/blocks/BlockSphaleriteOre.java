package com.onlytanner.test.blocks;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockSphaleriteOre extends Block {

	public BlockSphaleriteOre() {
		super(Material.ROCK);
		setUnlocalizedName(Reference.TestModBlocks.SPHALERITE_ORE.getUnlocalizedName());
		setRegistryName(Reference.TestModBlocks.SPHALERITE_ORE.getRegistryName());
		setHardness(3.0F);
		setHarvestLevel("pickaxe", 1);
		setCreativeTab(TestMod.RESOURCES_TAB);
	}

}
