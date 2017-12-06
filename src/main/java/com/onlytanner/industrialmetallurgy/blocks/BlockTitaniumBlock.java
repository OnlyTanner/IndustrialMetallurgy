package com.onlytanner.industrialmetallurgy.blocks;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockTitaniumBlock extends Block {

    public BlockTitaniumBlock() {
        super(Material.IRON);
        setUnlocalizedName(Reference.IndustrialMetallurgyBlocks.TITANIUM_BLOCK.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyBlocks.TITANIUM_BLOCK.getRegistryName());
        setHardness(3.0F);
        setCreativeTab(IndustrialMetallurgy.RESOURCES_TAB);
    }
}
