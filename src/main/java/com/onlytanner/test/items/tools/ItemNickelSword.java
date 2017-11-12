package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemSword;

public class ItemNickelSword extends ItemSword {

    public ItemNickelSword() {
        super(ModItems.NICKEL);
        setUnlocalizedName(Reference.TestModItems.NICKEL_SWORD.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.NICKEL_SWORD.getRegistryName());
        setCreativeTab(TestMod.TOOLS_TAB);
    }
}
