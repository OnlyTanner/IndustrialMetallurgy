package com.onlytanner.test.items;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.item.Item;

public class ItemCrushedBauxiteOre extends Item {

    public ItemCrushedBauxiteOre() {
        setUnlocalizedName(Reference.TestModItems.CRUSHED_BAUXITE_ORE.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.CRUSHED_BAUXITE_ORE.getRegistryName());
        setCreativeTab(TestMod.RESOURCES_TAB);
    }
}
