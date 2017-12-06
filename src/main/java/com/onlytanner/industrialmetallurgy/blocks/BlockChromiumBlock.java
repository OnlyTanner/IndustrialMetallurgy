package com.onlytanner.industrialmetallurgy.blocks;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockChromiumBlock extends Block {

    public BlockChromiumBlock() {
        super(Material.IRON);
        setUnlocalizedName(Reference.IndustrialMetallurgyBlocks.CHROMIUM_BLOCK.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyBlocks.CHROMIUM_BLOCK.getRegistryName());
        setHardness(3.0F);
        setCreativeTab(IndustrialMetallurgy.RESOURCES_TAB);
    }
}
