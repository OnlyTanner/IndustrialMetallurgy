package com.onlytanner.test.items;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.item.Item;

public class ItemBronzeNugget extends Item {

    public ItemBronzeNugget() {
        setUnlocalizedName(Reference.TestModItems.BRONZE_NUGGET.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.BRONZE_NUGGET.getRegistryName());
        setCreativeTab(TestMod.RESOURCES_TAB);
    }
}
