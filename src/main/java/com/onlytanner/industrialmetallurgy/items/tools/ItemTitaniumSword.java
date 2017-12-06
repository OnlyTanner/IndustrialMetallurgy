package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemSword;

public class ItemTitaniumSword extends ItemSword {

    public ItemTitaniumSword() {
        super(ModItems.TITANIUM);
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.TITANIUM_SWORD.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.TITANIUM_SWORD.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
