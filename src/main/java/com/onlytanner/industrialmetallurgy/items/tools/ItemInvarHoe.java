package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemHoe;

public class ItemInvarHoe extends ItemHoe {

    public ItemInvarHoe() {
        super(ModItems.INVAR);
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.INVAR_HOE.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.INVAR_HOE.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
