package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemSpade;

public class ItemCopperShovel extends ItemSpade
{
	public ItemCopperShovel() 
	{
		super(ModItems.COPPER);
		setUnlocalizedName(Reference.TestModItems.COPPER_SHOVEL.getUnlocalizedName());
		setRegistryName(Reference.TestModItems.COPPER_SHOVEL.getRegistryName());
		setCreativeTab(TestMod.TOOLS_TAB);
	}
}