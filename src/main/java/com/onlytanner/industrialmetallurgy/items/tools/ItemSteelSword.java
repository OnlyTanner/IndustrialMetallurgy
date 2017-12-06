package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemSword;

public class ItemSteelSword extends ItemSword {

    public ItemSteelSword() {
        super(ModItems.STEEL);
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.STEEL_SWORD.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.STEEL_SWORD.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
