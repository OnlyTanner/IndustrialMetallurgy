package com.onlytanner.test.items;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.item.Item;

public class ItemRefractoryBrick extends Item {

    public ItemRefractoryBrick() {
        setUnlocalizedName(Reference.TestModItems.REFRACTORY_BRICK.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.REFRACTORY_BRICK.getRegistryName());
        setCreativeTab(TestMod.SMELTING_TAB);
    }
}
