package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemAxe;

public class ItemNitinolAxe extends ItemAxe {

    public ItemNitinolAxe() {
        super(ModItems.NITINOL, ModItems.NITINOL.getDamageVsEntity(), ModItems.NITINOL.getEfficiencyOnProperMaterial());
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.NITINOL_AXE.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.NITINOL_AXE.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
