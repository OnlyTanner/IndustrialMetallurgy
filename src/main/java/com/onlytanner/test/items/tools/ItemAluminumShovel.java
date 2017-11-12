package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemSpade;

public class ItemAluminumShovel extends ItemSpade
{
	public ItemAluminumShovel() 
	{
		super(ModItems.ALUMINUM);
		setUnlocalizedName(Reference.TestModItems.ALUMINUM_SHOVEL.getUnlocalizedName());
		setRegistryName(Reference.TestModItems.ALUMINUM_SHOVEL.getRegistryName());
		setCreativeTab(TestMod.TOOLS_TAB);
	}
}
