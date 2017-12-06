package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemHoe;

public class ItemTungstenHoe extends ItemHoe {

    public ItemTungstenHoe() {
        super(ModItems.TUNGSTEN);
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.TUNGSTEN_HOE.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.TUNGSTEN_HOE.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
