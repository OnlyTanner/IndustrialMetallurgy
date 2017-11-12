package com.onlytanner.test.items;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.item.Item;

public class ItemCrushedChromiteOre extends Item {

    public ItemCrushedChromiteOre() {
        setUnlocalizedName(Reference.TestModItems.CRUSHED_CHROMITE_ORE.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.CRUSHED_CHROMITE_ORE.getRegistryName());
        setCreativeTab(TestMod.RESOURCES_TAB);
    }
}
