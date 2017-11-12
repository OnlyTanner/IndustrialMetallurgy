package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemSword;

public class ItemSteelSword extends ItemSword {

    public ItemSteelSword() {
        super(ModItems.STEEL);
        setUnlocalizedName(Reference.TestModItems.STEEL_SWORD.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.STEEL_SWORD.getRegistryName());
        setCreativeTab(TestMod.TOOLS_TAB);
    }
}
