package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemSword;

public class ItemCopperSword extends ItemSword {

    public ItemCopperSword() {
        super(ModItems.COPPER);
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.COPPER_SWORD.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.COPPER_SWORD.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
