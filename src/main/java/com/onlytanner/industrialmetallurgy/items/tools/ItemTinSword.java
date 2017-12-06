package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemSword;

public class ItemTinSword extends ItemSword {

    public ItemTinSword() {
        super(ModItems.TIN);
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.TIN_SWORD.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.TIN_SWORD.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
