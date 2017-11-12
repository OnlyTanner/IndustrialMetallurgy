package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemPickaxe;

public class ItemChromiumPickaxe extends ItemPickaxe
{
	public ItemChromiumPickaxe() 
	{
		super(ModItems.CHROMIUM);
		setUnlocalizedName(Reference.TestModItems.CHROMIUM_PICKAXE.getUnlocalizedName());
		setRegistryName(Reference.TestModItems.CHROMIUM_PICKAXE.getRegistryName());
		setCreativeTab(TestMod.TOOLS_TAB);
	}
}
