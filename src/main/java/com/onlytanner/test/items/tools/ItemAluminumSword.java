package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemSword;

public class ItemAluminumSword extends ItemSword
{
	public ItemAluminumSword() 
	{
		super(ModItems.ALUMINUM);
		setUnlocalizedName(Reference.TestModItems.ALUMINUM_SWORD.getUnlocalizedName());
		setRegistryName(Reference.TestModItems.ALUMINUM_SWORD.getRegistryName());
		setCreativeTab(TestMod.TOOLS_TAB);
	}
}
