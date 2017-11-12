package com.onlytanner.test.items;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.item.Item;

public class ItemNichromeIngot extends Item 
{
	public ItemNichromeIngot()
	{
		setUnlocalizedName(Reference.TestModItems.NICHROME_INGOT.getUnlocalizedName());
		setRegistryName(Reference.TestModItems.NICHROME_INGOT.getRegistryName());
		setCreativeTab(TestMod.RESOURCES_TAB);
	}
}
