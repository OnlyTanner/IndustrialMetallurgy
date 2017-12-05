package com.onlytanner.test.items;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.item.Item;

public class ItemCoalCoke extends Item {

    public ItemCoalCoke() {
        setUnlocalizedName(Reference.TestModItems.COAL_COKE.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.COAL_COKE.getRegistryName());
        setCreativeTab(TestMod.RESOURCES_TAB);
    }
}
