package com.onlytanner.test.items;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.item.Item;

public class ItemChromiumNugget extends Item {

    public ItemChromiumNugget() {
        setUnlocalizedName(Reference.TestModItems.CHROMIUM_NUGGET.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.CHROMIUM_NUGGET.getRegistryName());
        setCreativeTab(TestMod.RESOURCES_TAB);
    }
}
