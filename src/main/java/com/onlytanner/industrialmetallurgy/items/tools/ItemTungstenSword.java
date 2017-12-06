package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemSword;

public class ItemTungstenSword extends ItemSword {

    public ItemTungstenSword() {
        super(ModItems.TUNGSTEN);
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.TUNGSTEN_SWORD.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.TUNGSTEN_SWORD.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
