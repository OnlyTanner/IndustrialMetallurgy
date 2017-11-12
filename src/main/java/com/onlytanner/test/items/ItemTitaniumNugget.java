package com.onlytanner.test.items;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.item.Item;

public class ItemTitaniumNugget extends Item {

    public ItemTitaniumNugget() {
        setUnlocalizedName(Reference.TestModItems.TITANIUM_NUGGET.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.TITANIUM_NUGGET.getRegistryName());
        setCreativeTab(TestMod.RESOURCES_TAB);
    }
}
