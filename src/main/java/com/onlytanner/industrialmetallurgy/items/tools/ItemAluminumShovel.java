package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemSpade;

public class ItemAluminumShovel extends ItemSpade {

    public ItemAluminumShovel() {
        super(ModItems.ALUMINUM);
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.ALUMINUM_SHOVEL.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.ALUMINUM_SHOVEL.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
