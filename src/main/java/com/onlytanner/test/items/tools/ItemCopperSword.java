package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemSword;

public class ItemCopperSword extends ItemSword {

    public ItemCopperSword() {
        super(ModItems.COPPER);
        setUnlocalizedName(Reference.TestModItems.COPPER_SWORD.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.COPPER_SWORD.getRegistryName());
        setCreativeTab(TestMod.TOOLS_TAB);
    }
}
