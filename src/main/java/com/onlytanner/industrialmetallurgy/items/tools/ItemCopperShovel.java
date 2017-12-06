package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemSpade;

public class ItemCopperShovel extends ItemSpade {

    public ItemCopperShovel() {
        super(ModItems.COPPER);
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.COPPER_SHOVEL.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.COPPER_SHOVEL.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
