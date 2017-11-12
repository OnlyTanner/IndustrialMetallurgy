package com.onlytanner.test.items;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.item.Item;

public class ItemNitinolNugget extends Item {

    public ItemNitinolNugget() {
        setUnlocalizedName(Reference.TestModItems.NITINOL_NUGGET.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.NITINOL_NUGGET.getRegistryName());
        setCreativeTab(TestMod.RESOURCES_TAB);
    }
}
