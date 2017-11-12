package com.onlytanner.test.items;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.item.Item;

public class ItemChromiumIngot extends Item 
{
	public ItemChromiumIngot()
	{
		setUnlocalizedName(Reference.TestModItems.CHROMIUM_INGOT.getUnlocalizedName());
		setRegistryName(Reference.TestModItems.CHROMIUM_INGOT.getRegistryName());
		setCreativeTab(TestMod.RESOURCES_TAB);
	}
}
