package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemPickaxe;

public class ItemNickelPickaxe extends ItemPickaxe 
{
	public ItemNickelPickaxe() 
	{
		super(ModItems.NICKEL);
		setUnlocalizedName(Reference.TestModItems.NICKEL_PICKAXE.getUnlocalizedName());
		setRegistryName(Reference.TestModItems.NICKEL_PICKAXE.getRegistryName());
		setCreativeTab(TestMod.TOOLS_TAB);
	}
}
