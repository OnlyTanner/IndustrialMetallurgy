package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemSword;

public class ItemTinSword extends ItemSword
{
	public ItemTinSword() 
	{
		super(ModItems.TIN);
		setUnlocalizedName(Reference.TestModItems.TIN_SWORD.getUnlocalizedName());
		setRegistryName(Reference.TestModItems.TIN_SWORD.getRegistryName());
		setCreativeTab(TestMod.TOOLS_TAB);
	}
}
