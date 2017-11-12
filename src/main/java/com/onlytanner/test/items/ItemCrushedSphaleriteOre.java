package com.onlytanner.test.items;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.item.Item;

public class ItemCrushedSphaleriteOre extends Item {

    public ItemCrushedSphaleriteOre() {
        setUnlocalizedName(Reference.TestModItems.CRUSHED_SPHALERITE_ORE.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.CRUSHED_SPHALERITE_ORE.getRegistryName());
        setCreativeTab(TestMod.RESOURCES_TAB);
    }
}
