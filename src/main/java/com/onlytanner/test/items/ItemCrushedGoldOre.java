package com.onlytanner.test.items;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.item.Item;

public class ItemCrushedGoldOre extends Item
{
	public ItemCrushedGoldOre() 
	{
		setUnlocalizedName(Reference.TestModItems.CRUSHED_GOLD_ORE.getUnlocalizedName());
		setRegistryName(Reference.TestModItems.CRUSHED_GOLD_ORE.getRegistryName());
		setCreativeTab(TestMod.RESOURCES_TAB);
	}
}
