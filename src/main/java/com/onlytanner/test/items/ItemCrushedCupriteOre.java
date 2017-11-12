package com.onlytanner.test.items;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.item.Item;

public class ItemCrushedCupriteOre extends Item
{
	public ItemCrushedCupriteOre() 
	{
		setUnlocalizedName(Reference.TestModItems.CRUSHED_CUPRITE_ORE.getUnlocalizedName());
		setRegistryName(Reference.TestModItems.CRUSHED_CUPRITE_ORE.getRegistryName());
		setCreativeTab(TestMod.RESOURCES_TAB);
	}
}
