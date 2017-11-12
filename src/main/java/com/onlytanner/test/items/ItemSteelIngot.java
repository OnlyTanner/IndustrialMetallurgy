package com.onlytanner.test.items;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.item.Item;

public class ItemSteelIngot extends Item {

    public ItemSteelIngot() {
        setUnlocalizedName(Reference.TestModItems.STEEL_INGOT.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.STEEL_INGOT.getRegistryName());
        setCreativeTab(TestMod.RESOURCES_TAB);
    }
}
