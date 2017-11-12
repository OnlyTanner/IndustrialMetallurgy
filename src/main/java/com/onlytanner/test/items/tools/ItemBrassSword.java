package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemSword;

public class ItemBrassSword extends ItemSword {

    public ItemBrassSword() {
        super(ModItems.BRASS);
        setUnlocalizedName(Reference.TestModItems.BRASS_SWORD.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.BRASS_SWORD.getRegistryName());
        setCreativeTab(TestMod.TOOLS_TAB);
    }
}
