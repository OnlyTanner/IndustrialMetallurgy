package com.onlytanner.test.items;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.item.Item;

public class ItemCrushedGarnieriteOre extends Item
{
	public ItemCrushedGarnieriteOre() 
	{
		setUnlocalizedName(Reference.TestModItems.CRUSHED_GARNIERITE_ORE.getUnlocalizedName());
		setRegistryName(Reference.TestModItems.CRUSHED_GARNIERITE_ORE.getRegistryName());
		setCreativeTab(TestMod.RESOURCES_TAB);
	}
}
