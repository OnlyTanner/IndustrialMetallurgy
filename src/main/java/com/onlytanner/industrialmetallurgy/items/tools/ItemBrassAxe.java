package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemAxe;

public class ItemBrassAxe extends ItemAxe {

    public ItemBrassAxe() {
        super(ModItems.BRASS, ModItems.BRASS.getDamageVsEntity(), ModItems.BRASS.getEfficiencyOnProperMaterial());
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.BRASS_AXE.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.BRASS_AXE.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
