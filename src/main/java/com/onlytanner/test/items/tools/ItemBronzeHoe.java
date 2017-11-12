package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemHoe;

public class ItemBronzeHoe extends ItemHoe {

    public ItemBronzeHoe() {
        super(ModItems.BRONZE);
        setUnlocalizedName(Reference.TestModItems.BRONZE_HOE.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.BRONZE_HOE.getRegistryName());
        setCreativeTab(TestMod.TOOLS_TAB);
    }
}
