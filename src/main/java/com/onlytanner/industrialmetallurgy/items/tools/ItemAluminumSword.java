package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemSword;

public class ItemAluminumSword extends ItemSword {

    public ItemAluminumSword() {
        super(ModItems.ALUMINUM);
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.ALUMINUM_SWORD.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.ALUMINUM_SWORD.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
