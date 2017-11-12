package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemSpade;

public class ItemChromiumShovel extends ItemSpade
{
	public ItemChromiumShovel() 
	{
		super(ModItems.CHROMIUM);
		setUnlocalizedName(Reference.TestModItems.CHROMIUM_SHOVEL.getUnlocalizedName());
		setRegistryName(Reference.TestModItems.CHROMIUM_SHOVEL.getRegistryName());
		setCreativeTab(TestMod.TOOLS_TAB);
	}
}
