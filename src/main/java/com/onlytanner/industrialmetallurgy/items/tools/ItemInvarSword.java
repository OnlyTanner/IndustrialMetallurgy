package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemSword;

public class ItemInvarSword extends ItemSword {

    public ItemInvarSword() {
        super(ModItems.INVAR);
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.INVAR_SWORD.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.INVAR_SWORD.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
