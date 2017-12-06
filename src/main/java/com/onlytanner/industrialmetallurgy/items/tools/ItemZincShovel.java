package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemSpade;

public class ItemZincShovel extends ItemSpade {

    public ItemZincShovel() {
        super(ModItems.ZINC);
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.ZINC_SHOVEL.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.ZINC_SHOVEL.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
