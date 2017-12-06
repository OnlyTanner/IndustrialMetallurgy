package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemSword;

public class ItemChromiumSword extends ItemSword {

    public ItemChromiumSword() {
        super(ModItems.CHROMIUM);
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.CHROMIUM_SWORD.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.CHROMIUM_SWORD.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
