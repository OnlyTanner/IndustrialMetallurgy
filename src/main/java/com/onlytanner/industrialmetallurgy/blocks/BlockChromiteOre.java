package com.onlytanner.industrialmetallurgy.blocks;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockChromiteOre extends Block {

    public BlockChromiteOre() {
        super(Material.ROCK);
        setUnlocalizedName(Reference.IndustrialMetallurgyBlocks.CHROMITE_ORE.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyBlocks.CHROMITE_ORE.getRegistryName());
        setHardness(3.0F);
        setHarvestLevel("pickaxe", 2);
        setCreativeTab(IndustrialMetallurgy.RESOURCES_TAB);
    }
}
