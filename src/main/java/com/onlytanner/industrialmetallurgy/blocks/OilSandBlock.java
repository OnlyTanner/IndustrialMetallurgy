package com.onlytanner.industrialmetallurgy.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class OilSandBlock extends Block {

    public OilSandBlock() {
        super(AbstractBlock.Properties.create(Material.SAND)
                .hardnessAndResistance(2.0f, 2.0f)
                .sound(SoundType.SAND)
                .harvestLevel(0)
                .harvestTool(ToolType.SHOVEL));
    }

}
