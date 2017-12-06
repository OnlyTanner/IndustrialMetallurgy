package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemAxe;

public class ItemCobaltAxe extends ItemAxe {

    public ItemCobaltAxe() {
        super(ModItems.COBALT, ModItems.COBALT.getDamageVsEntity(), ModItems.COBALT.getEfficiencyOnProperMaterial());
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.COBALT_AXE.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.COBALT_AXE.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
