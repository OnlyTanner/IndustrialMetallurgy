package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemAxe;

public class ItemBronzeAxe extends ItemAxe {

    public ItemBronzeAxe() {
        super(ModItems.BRONZE, ModItems.BRONZE.getDamageVsEntity(), ModItems.BRONZE.getEfficiencyOnProperMaterial());
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.BRONZE_AXE.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.BRONZE_AXE.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
