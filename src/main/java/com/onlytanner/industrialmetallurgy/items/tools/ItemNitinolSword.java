package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemSword;

public class ItemNitinolSword extends ItemSword {

    public ItemNitinolSword() {
        super(ModItems.NITINOL);
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.NITINOL_SWORD.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.NITINOL_SWORD.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
