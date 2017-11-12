package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemSword;

public class ItemZincSword extends ItemSword
{
	public ItemZincSword() 
	{
		super(ModItems.ZINC);
		setUnlocalizedName(Reference.TestModItems.ZINC_SWORD.getUnlocalizedName());
		setRegistryName(Reference.TestModItems.ZINC_SWORD.getRegistryName());
		setCreativeTab(TestMod.TOOLS_TAB);
	}
}