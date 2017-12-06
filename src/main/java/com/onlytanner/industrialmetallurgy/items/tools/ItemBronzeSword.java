package com.onlytanner.industrialmetallurgy.items.tools;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.item.ItemSword;

public class ItemBronzeSword extends ItemSword {

    public ItemBronzeSword() {
        super(ModItems.BRONZE);
        setUnlocalizedName(Reference.IndustrialMetallurgyItems.BRONZE_SWORD.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyItems.BRONZE_SWORD.getRegistryName());
        setCreativeTab(IndustrialMetallurgy.TOOLS_TAB);
    }
}
