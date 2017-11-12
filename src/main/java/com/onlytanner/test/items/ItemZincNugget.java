package com.onlytanner.test.items;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.item.Item;

public class ItemZincNugget extends Item {

    public ItemZincNugget() {
        setUnlocalizedName(Reference.TestModItems.ZINC_NUGGET.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.ZINC_NUGGET.getRegistryName());
        setCreativeTab(TestMod.RESOURCES_TAB);
    }
}
