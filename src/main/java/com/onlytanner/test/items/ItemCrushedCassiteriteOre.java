package com.onlytanner.test.items;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.item.Item;

public class ItemCrushedCassiteriteOre extends Item {

    public ItemCrushedCassiteriteOre() {
        setUnlocalizedName(Reference.TestModItems.CRUSHED_CASSITERITE_ORE.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.CRUSHED_CASSITERITE_ORE.getRegistryName());
        setCreativeTab(TestMod.RESOURCES_TAB);
    }
}
