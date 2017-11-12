package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemHoe;

public class ItemNitinolHoe extends ItemHoe {

    public ItemNitinolHoe() {
        super(ModItems.NITINOL);
        setUnlocalizedName(Reference.TestModItems.NITINOL_HOE.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.NITINOL_HOE.getRegistryName());
        setCreativeTab(TestMod.TOOLS_TAB);
    }
}
