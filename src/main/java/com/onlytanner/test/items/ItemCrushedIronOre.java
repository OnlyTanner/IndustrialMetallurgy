package com.onlytanner.test.items;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.item.Item;

public class ItemCrushedIronOre extends Item
{
	public ItemCrushedIronOre() 
	{
		setUnlocalizedName(Reference.TestModItems.CRUSHED_IRON_ORE.getUnlocalizedName());
		setRegistryName(Reference.TestModItems.CRUSHED_IRON_ORE.getRegistryName());
		setCreativeTab(TestMod.RESOURCES_TAB);
	}
}
