package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemPickaxe;

public class ItemNichromePickaxe extends ItemPickaxe {

    public ItemNichromePickaxe() {
        super(ModItems.NICHROME);
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.NICHROME_PICKAXE.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.NICHROME_PICKAXE.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
