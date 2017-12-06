package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemSpade;

public class ItemSteelShovel extends ItemSpade {

    public ItemSteelShovel() {
        super(ModItems.STEEL);
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.STEEL_SHOVEL.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.STEEL_SHOVEL.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
