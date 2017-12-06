package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemSword;

public class ItemZincSword extends ItemSword {

    public ItemZincSword() {
        super(ModItems.ZINC);
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.ZINC_SWORD.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.ZINC_SWORD.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
