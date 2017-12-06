package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemHoe;

public class ItemNichromeHoe extends ItemHoe {

    public ItemNichromeHoe() {
        super(ModItems.NICHROME);
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.NICHROME_HOE.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.NICHROME_HOE.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
