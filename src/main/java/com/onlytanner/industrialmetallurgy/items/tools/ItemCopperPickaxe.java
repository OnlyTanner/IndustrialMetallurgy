package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemPickaxe;

public class ItemCopperPickaxe extends ItemPickaxe {

    public ItemCopperPickaxe() {
        super(ModItems.COPPER);
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.COPPER_PICKAXE.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.COPPER_PICKAXE.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
