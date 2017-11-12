package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemHoe;

public class ItemChromiumHoe extends ItemHoe
{
	public ItemChromiumHoe() 
	{
		super(ModItems.CHROMIUM);
		setUnlocalizedName(Reference.TestModItems.CHROMIUM_HOE.getUnlocalizedName());
		setRegistryName(Reference.TestModItems.CHROMIUM_HOE.getRegistryName());
		setCreativeTab(TestMod.TOOLS_TAB);
	}
}
