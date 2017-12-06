package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemHoe;

public class ItemTinHoe extends ItemHoe {

    public ItemTinHoe() {
        super(ModItems.TIN);
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.TIN_HOE.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.TIN_HOE.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
