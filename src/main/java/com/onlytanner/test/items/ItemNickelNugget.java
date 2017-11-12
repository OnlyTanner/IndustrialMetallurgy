package com.onlytanner.test.items;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.item.Item;

public class ItemNickelNugget extends Item {

    public ItemNickelNugget() {
        setUnlocalizedName(Reference.TestModItems.NICKEL_NUGGET.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.NICKEL_NUGGET.getRegistryName());
        setCreativeTab(TestMod.RESOURCES_TAB);
    }
}
