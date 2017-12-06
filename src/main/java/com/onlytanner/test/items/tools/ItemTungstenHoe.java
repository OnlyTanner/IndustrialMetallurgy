package com.onlytanner.test.items.tools;

import com.onlytanner.test.Reference;
import com.onlytanner.test.TestMod;
import com.onlytanner.test.init.ModItems;

import net.minecraft.item.ItemHoe;

public class ItemTungstenHoe extends ItemHoe {

    public ItemTungstenHoe() {
        super(ModItems.TUNGSTEN);
        setUnlocalizedName(Reference.TestModItems.TUNGSTEN_HOE.getUnlocalizedName());
        setRegistryName(Reference.TestModItems.TUNGSTEN_HOE.getRegistryName());
        setCreativeTab(TestMod.TOOLS_TAB);
    }
}
