package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemAxe;

public class ItemInvarAxe extends ItemAxe {

    public ItemInvarAxe() {
        super(ModItems.INVAR, ModItems.INVAR.getDamageVsEntity(), ModItems.INVAR.getEfficiencyOnProperMaterial());
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.INVAR_AXE.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.INVAR_AXE.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
