package com.onlytanner.test.items;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.item.Item;

public class ItemAluminumIngot extends Item 
{
	public ItemAluminumIngot()
	{
		setUnlocalizedName(Reference.TestModItems.ALUMINUM_INGOT.getUnlocalizedName());
		setRegistryName(Reference.TestModItems.ALUMINUM_INGOT.getRegistryName());
		setCreativeTab(TestMod.RESOURCES_TAB);
	}
}
