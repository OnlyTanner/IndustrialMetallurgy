package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemAxe;

public class ItemTinAxe extends ItemAxe {

    public ItemTinAxe() {
        super(ModItems.TIN, ModItems.TIN.getDamageVsEntity(), ModItems.TIN.getEfficiencyOnProperMaterial());
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.TIN_AXE.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.TIN_AXE.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
