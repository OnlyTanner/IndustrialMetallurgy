package com.onlytanner.test.items;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.item.Item;

public class ItemBrassIngot extends Item {

    public ItemBrassIngot() {
        setUnlocalizedName(Reference.TestModItems.BRASS_INGOT.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.BRASS_INGOT.getRegistryName());
        setCreativeTab(TestMod.RESOURCES_TAB);
    }
}
