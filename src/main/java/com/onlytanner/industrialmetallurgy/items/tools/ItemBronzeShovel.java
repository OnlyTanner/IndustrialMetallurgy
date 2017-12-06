package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemSpade;

public class ItemBronzeShovel extends ItemSpade {

    public ItemBronzeShovel() {
        super(ModItems.BRONZE);
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.BRONZE_SHOVEL.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.BRONZE_SHOVEL.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
