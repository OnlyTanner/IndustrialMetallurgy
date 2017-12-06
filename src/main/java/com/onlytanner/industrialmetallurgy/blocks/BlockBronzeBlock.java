package com.onlytanner.industrialmetallurgy.blocks;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBronzeBlock extends Block {

    public BlockBronzeBlock() {
        super(Material.IRON);
        setUnlocalizedName(Reference.IndustrialMetallurgyBlocks.BRONZE_BLOCK.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyBlocks.BRONZE_BLOCK.getRegistryName());
        setHardness(4.0F);
        setCreativeTab(IndustrialMetallurgy.RESOURCES_TAB);
    }
}
