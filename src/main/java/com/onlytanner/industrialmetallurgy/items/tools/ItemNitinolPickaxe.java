package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemPickaxe;

public class ItemNitinolPickaxe extends ItemPickaxe {

    public ItemNitinolPickaxe() {
        super(ModItems.NITINOL);
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.NITINOL_PICKAXE.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.NITINOL_PICKAXE.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
