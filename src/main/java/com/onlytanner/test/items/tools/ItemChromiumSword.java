package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemSword;

public class ItemChromiumSword extends ItemSword
{
	public ItemChromiumSword() 
	{
		super(ModItems.CHROMIUM);
		setUnlocalizedName(Reference.TestModItems.CHROMIUM_SWORD.getUnlocalizedName());
		setRegistryName(Reference.TestModItems.CHROMIUM_SWORD.getRegistryName());
		setCreativeTab(TestMod.TOOLS_TAB);
	}
}
