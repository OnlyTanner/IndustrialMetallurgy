package com.onlytanner.industrialmetallurgy.blocks;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockNickelBlock extends Block {

    public BlockNickelBlock() {
        super(Material.IRON);
        setUnlocalizedName(Reference.IndustrialMetallurgyBlocks.NICKEL_BLOCK.getUnlocalizedName());
        setRegistryName(Reference.IndustrialMetallurgyBlocks.NICKEL_BLOCK.getRegistryName());
        setHardness(3.0F);
        setCreativeTab(IndustrialMetallurgy.RESOURCES_TAB);
    }
}
