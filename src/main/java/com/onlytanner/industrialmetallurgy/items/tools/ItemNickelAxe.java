package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemAxe;

public class ItemNickelAxe extends ItemAxe {

    public ItemNickelAxe() {
        super(ModItems.NICKEL, ModItems.NICKEL.getDamageVsEntity(), ModItems.NICKEL.getEfficiencyOnProperMaterial());
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.NICKEL_AXE.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.NICKEL_AXE.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
