package com.onlytanner.test.items;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.item.Item;

public class ItemCobaltIngot extends Item {

    public ItemCobaltIngot() {
        setUnlocalizedName(Reference.TestModItems.COBALT_INGOT.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.COBALT_INGOT.getRegistryName());
        setCreativeTab(TestMod.RESOURCES_TAB);
    }
}
