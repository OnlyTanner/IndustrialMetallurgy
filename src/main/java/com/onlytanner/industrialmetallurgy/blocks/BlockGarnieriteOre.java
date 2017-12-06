package com.onlytanner.industrialmetallurgy.blocks;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockGarnieriteOre extends Block {

    public BlockGarnieriteOre() {
        super(Material.ROCK);
        setUnlocalizedName(Reference.IndustrialMetallurgyBlocks.GARNIERITE_ORE.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyBlocks.GARNIERITE_ORE.getRegistryName());
        setHardness(3.0F);
        setHarvestLevel("pickaxe", 1);
        setCreativeTab(IndustrialMetallurgy.RESOURCES_TAB);
    }
}
