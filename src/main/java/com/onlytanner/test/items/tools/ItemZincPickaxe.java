package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemPickaxe;

public class ItemZincPickaxe extends ItemPickaxe 
{
	public ItemZincPickaxe() 
	{
		super(ModItems.ZINC);
		setUnlocalizedName(Reference.TestModItems.ZINC_PICKAXE.getUnlocalizedName());
		setRegistryName(Reference.TestModItems.ZINC_PICKAXE.getRegistryName());
		setCreativeTab(TestMod.TOOLS_TAB);
	}
}
