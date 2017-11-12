package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemSword;

public class ItemNichromeSword extends ItemSword
{
	public ItemNichromeSword() 
	{
		super(ModItems.NICHROME);
		setUnlocalizedName(Reference.TestModItems.NICHROME_SWORD.getUnlocalizedName());
		setRegistryName(Reference.TestModItems.NICHROME_SWORD.getRegistryName());
		setCreativeTab(TestMod.TOOLS_TAB);
	}
}