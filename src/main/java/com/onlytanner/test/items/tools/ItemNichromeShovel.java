package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemSpade;

public class ItemNichromeShovel extends ItemSpade
{
	public ItemNichromeShovel() 
	{
		super(ModItems.NICHROME);
		setUnlocalizedName(Reference.TestModItems.NICHROME_SHOVEL.getUnlocalizedName());
		setRegistryName(Reference.TestModItems.NICHROME_SHOVEL.getRegistryName());
		setCreativeTab(TestMod.TOOLS_TAB);
	}
}