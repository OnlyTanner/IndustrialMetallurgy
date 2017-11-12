package com.onlytanner.test.items;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.item.Item;

public class ItemZincIngot extends Item {

    public ItemZincIngot() {
        setUnlocalizedName(Reference.TestModItems.ZINC_INGOT.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.ZINC_INGOT.getRegistryName());
        setCreativeTab(TestMod.RESOURCES_TAB);
    }
}
