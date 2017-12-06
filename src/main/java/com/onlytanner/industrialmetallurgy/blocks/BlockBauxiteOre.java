package com.onlytanner.industrialmetallurgy.blocks;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBauxiteOre extends Block {

    public BlockBauxiteOre() {
        super(Material.ROCK);
        setUnlocalizedName(Reference.IndustrialMetallurgyBlocks.BAUXITE_ORE.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyBlocks.BAUXITE_ORE.getRegistryName());
        setHardness(3.0F);
        setHarvestLevel("pickaxe", 1);
        setCreativeTab(IndustrialMetallurgy.RESOURCES_TAB);
    }
}
