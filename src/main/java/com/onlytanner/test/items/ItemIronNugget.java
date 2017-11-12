package com.onlytanner.test.items;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.item.Item;

public class ItemIronNugget extends Item {

    public ItemIronNugget() {
        setUnlocalizedName(Reference.TestModItems.IRON_NUGGET.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.IRON_NUGGET.getRegistryName());
        setCreativeTab(TestMod.RESOURCES_TAB);
    }
}
