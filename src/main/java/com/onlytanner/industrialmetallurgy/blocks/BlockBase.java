package com.onlytanner.industrialmetallurgy.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/**
 *
 * @author Tanner Lisonbee
 */
public class BlockBase extends Block
{
    public BlockBase(String unlocalizedName, String registryName, CreativeTabs tab, Material material, float hardness)
    {
        super(material);
        setUnlocalizedName(unlocalizedName);
        setRegistryName(registryName);
        setCreativeTab(tab);
        setHardness(hardness);
    }
}
