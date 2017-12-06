package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemSword;

public class ItemCobaltSword extends ItemSword {

    public ItemCobaltSword() {
        super(ModItems.COBALT);
        setUnlocalizedName(Reference.TestModItems.COBALT_SWORD.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.COBALT_SWORD.getRegistryName());
        setCreativeTab(TestMod.TOOLS_TAB);
    }
}
