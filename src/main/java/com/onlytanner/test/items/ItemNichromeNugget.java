package com.onlytanner.test.items;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.item.Item;

public class ItemNichromeNugget extends Item {

    public ItemNichromeNugget() {
        setUnlocalizedName(Reference.TestModItems.NICHROME_NUGGET.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.NICHROME_NUGGET.getRegistryName());
        setCreativeTab(TestMod.RESOURCES_TAB);
    }
}
