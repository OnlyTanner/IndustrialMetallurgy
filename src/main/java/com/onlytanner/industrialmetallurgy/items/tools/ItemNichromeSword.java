package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemSword;

public class ItemNichromeSword extends ItemSword {

    public ItemNichromeSword() {
        super(ModItems.NICHROME);
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.NICHROME_SWORD.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.NICHROME_SWORD.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
