package com.onlytanner.test.items;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.item.Item;

public class ItemNickelIngot extends Item {

    public ItemNickelIngot() {
        setUnlocalizedName(Reference.TestModItems.NICKEL_INGOT.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.NICKEL_INGOT.getRegistryName());
        setCreativeTab(TestMod.RESOURCES_TAB);
    }
}
