package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemHoe;

public class ItemNitinolHoe extends ItemHoe {

    public ItemNitinolHoe() {
        super(ModItems.NITINOL);
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.NITINOL_HOE.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.NITINOL_HOE.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
