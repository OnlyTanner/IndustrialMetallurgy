package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemSword;

public class ItemNickelSword extends ItemSword {

    public ItemNickelSword() {
        super(ModItems.NICKEL);
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.NICKEL_SWORD.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.NICKEL_SWORD.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
