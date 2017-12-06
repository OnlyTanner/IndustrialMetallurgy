package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemAxe;

public class ItemCopperAxe extends ItemAxe {

    public ItemCopperAxe() {
        super(ModItems.COPPER, ModItems.COPPER.getDamageVsEntity(), ModItems.COPPER.getEfficiencyOnProperMaterial());
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.COPPER_AXE.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.COPPER_AXE.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
