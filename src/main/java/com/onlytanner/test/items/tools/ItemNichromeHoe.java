package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemHoe;

public class ItemNichromeHoe extends ItemHoe {

    public ItemNichromeHoe() {
        super(ModItems.NICHROME);
        setUnlocalizedName(Reference.TestModItems.NICHROME_HOE.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.NICHROME_HOE.getRegistryName());
        setCreativeTab(TestMod.TOOLS_TAB);
    }
}
