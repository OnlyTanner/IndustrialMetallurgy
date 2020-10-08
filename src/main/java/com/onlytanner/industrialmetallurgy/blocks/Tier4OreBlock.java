package com.onlytanner.industrialmetallurgy.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class Tier4OreBlock extends Block {

    public Tier4OreBlock() {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(10.0f, 15.0f)
                .sound(SoundType.STONE)
                .harvestLevel(4)
                .func_235861_h_()  // set requires tool
                .harvestTool(ToolType.PICKAXE));
    }

}
