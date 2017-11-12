package com.onlytanner.test.items;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;

import net.minecraft.item.Item;

public class ItemTitaniumIngot extends Item {

    public ItemTitaniumIngot() {
        setUnlocalizedName(Reference.TestModItems.TITANIUM_INGOT.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.TITANIUM_INGOT.getRegistryName());
        setCreativeTab(TestMod.RESOURCES_TAB);
    }
}
