package com.onlytanner.test.items;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.item.Item;

public class ItemNitinolIngot extends Item {

    public ItemNitinolIngot() {
        setUnlocalizedName(Reference.TestModItems.NITINOL_INGOT.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.NITINOL_INGOT.getRegistryName());
        setCreativeTab(TestMod.RESOURCES_TAB);
    }
}
