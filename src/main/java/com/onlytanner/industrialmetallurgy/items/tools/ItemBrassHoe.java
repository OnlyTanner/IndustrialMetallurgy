package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemHoe;

public class ItemBrassHoe extends ItemHoe {

    public ItemBrassHoe() {
        super(ModItems.BRASS);
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.BRASS_HOE.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.BRASS_HOE.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
