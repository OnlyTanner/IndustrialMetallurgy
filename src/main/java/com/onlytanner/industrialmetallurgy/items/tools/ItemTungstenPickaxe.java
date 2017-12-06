package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemPickaxe;

public class ItemTungstenPickaxe extends ItemPickaxe {

    public ItemTungstenPickaxe() {
        super(ModItems.TUNGSTEN);
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.TUNGSTEN_PICKAXE.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.TUNGSTEN_PICKAXE.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
