package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemSword;

public class ItemCobaltSword extends ItemSword {

    public ItemCobaltSword() {
        super(ModItems.COBALT);
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.COBALT_SWORD.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.COBALT_SWORD.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
