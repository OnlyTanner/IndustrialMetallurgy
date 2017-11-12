package com.onlytanner.test.items;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.item.Item;

public class ItemTinNugget extends Item {

    public ItemTinNugget() {
        setUnlocalizedName(Reference.TestModItems.TIN_NUGGET.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.TIN_NUGGET.getRegistryName());
        setCreativeTab(TestMod.RESOURCES_TAB);
    }
}
