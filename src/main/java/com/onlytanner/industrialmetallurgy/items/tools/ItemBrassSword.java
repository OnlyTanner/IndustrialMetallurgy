package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemSword;

public class ItemBrassSword extends ItemSword {

    public ItemBrassSword() {
        super(ModItems.BRASS);
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.BRASS_SWORD.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.BRASS_SWORD.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
