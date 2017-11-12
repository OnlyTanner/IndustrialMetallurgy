package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemHoe;

public class ItemZincHoe extends ItemHoe {

    public ItemZincHoe() {
        super(ModItems.ZINC);
        setUnlocalizedName(Reference.TestModItems.ZINC_HOE.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.ZINC_HOE.getRegistryName());
        setCreativeTab(TestMod.TOOLS_TAB);
    }
}
