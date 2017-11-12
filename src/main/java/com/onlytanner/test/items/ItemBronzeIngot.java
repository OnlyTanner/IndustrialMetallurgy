package com.onlytanner.test.items;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.item.Item;

public class ItemBronzeIngot extends Item {

    public ItemBronzeIngot() {
        setUnlocalizedName(Reference.TestModItems.BRONZE_INGOT.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.BRONZE_INGOT.getRegistryName());
        setCreativeTab(TestMod.RESOURCES_TAB);
    }
}
