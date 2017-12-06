package com.onlytanner.industrialmetallurgy.blocks;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockSteelBlock extends Block {

    public BlockSteelBlock() {
        super(Material.IRON);
        setUnlocalizedName(Reference.IndustrialMetallurgyBlocks.STEEL_BLOCK.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyBlocks.STEEL_BLOCK.getRegistryName());
        setHardness(8.0F);
        setCreativeTab(IndustrialMetallurgy.RESOURCES_TAB);
    }
}
