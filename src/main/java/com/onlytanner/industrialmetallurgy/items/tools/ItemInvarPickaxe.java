package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemPickaxe;

public class ItemInvarPickaxe extends ItemPickaxe {

    public ItemInvarPickaxe() {
        super(ModItems.INVAR);
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.INVAR_PICKAXE.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.INVAR_PICKAXE.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
