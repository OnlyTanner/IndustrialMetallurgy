package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemSpade;

public class ItemNickelShovel extends ItemSpade
{
	public ItemNickelShovel() 
	{
		super(ModItems.NICKEL);
		setUnlocalizedName(Reference.TestModItems.NICKEL_SHOVEL.getUnlocalizedName());
		setRegistryName(Reference.TestModItems.NICKEL_SHOVEL.getRegistryName());
		setCreativeTab(TestMod.TOOLS_TAB);
	}
}