package com.onlytanner.test.items;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.item.Item;

public class ItemTungstenIngot extends Item {

    public ItemTungstenIngot() {
        setUnlocalizedName(Reference.TestModItems.TUNGSTEN_INGOT.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.TUNGSTEN_INGOT.getRegistryName());
        setCreativeTab(TestMod.RESOURCES_TAB);
    }
}
