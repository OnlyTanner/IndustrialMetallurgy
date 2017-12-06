package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemHoe;

public class ItemChromiumHoe extends ItemHoe {

    public ItemChromiumHoe() {
        super(ModItems.CHROMIUM);
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.CHROMIUM_HOE.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.CHROMIUM_HOE.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
