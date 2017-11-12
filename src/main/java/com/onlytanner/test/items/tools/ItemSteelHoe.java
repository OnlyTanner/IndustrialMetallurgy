package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemHoe;

public class ItemSteelHoe extends ItemHoe {

    public ItemSteelHoe() {
        super(ModItems.STEEL);
        setUnlocalizedName(Reference.TestModItems.STEEL_HOE.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.STEEL_HOE.getRegistryName());
        setCreativeTab(TestMod.TOOLS_TAB);
    }
}
