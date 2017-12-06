package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemAxe;

public class ItemTungstenAxe extends ItemAxe {

    public ItemTungstenAxe() {
        super(ModItems.TUNGSTEN, ModItems.TUNGSTEN.getDamageVsEntity(), ModItems.TUNGSTEN.getEfficiencyOnProperMaterial());
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.TUNGSTEN_AXE.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.TUNGSTEN_AXE.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
