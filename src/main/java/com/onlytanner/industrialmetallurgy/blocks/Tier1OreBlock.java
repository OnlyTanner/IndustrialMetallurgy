package com.onlytanner.industrialmetallurgy.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class Tier1OreBlock extends Block {

    public Tier1OreBlock() {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(3.0f, 4.0f)
                .sound(SoundType.STONE)
                .harvestLevel(1)
                .setRequiresTool()  // set requires tool
                .harvestTool(ToolType.PICKAXE));
    }

}
