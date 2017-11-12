package com.onlytanner.test.items;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.item.Item;

public class ItemCrushedRutileOre extends Item {

    public ItemCrushedRutileOre() {
        setUnlocalizedName(Reference.TestModItems.CRUSHED_RUTILE_ORE.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.CRUSHED_RUTILE_ORE.getRegistryName());
        setCreativeTab(TestMod.RESOURCES_TAB);
    }
}
