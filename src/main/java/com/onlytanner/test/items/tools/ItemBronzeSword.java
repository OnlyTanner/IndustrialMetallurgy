package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemSword;

public class ItemBronzeSword extends ItemSword
{
	public ItemBronzeSword() 
	{
		super(ModItems.BRONZE);
		setUnlocalizedName(Reference.TestModItems.BRONZE_SWORD.getUnlocalizedName());
		setRegistryName(Reference.TestModItems.BRONZE_SWORD.getRegistryName());
		setCreativeTab(TestMod.TOOLS_TAB);
	}
}
