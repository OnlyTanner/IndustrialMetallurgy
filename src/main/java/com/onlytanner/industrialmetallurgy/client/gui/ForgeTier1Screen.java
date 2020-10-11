package com.onlytanner.industrialmetallurgy.client.gui;

import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.containers.ForgeTier1Container;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class ForgeTier1Screen extends ContainerScreen {

    private static final ResourceLocation TEXTURE = new ResourceLocation(IndustrialMetallurgy.MOD_ID, "textures/gui/container/forge_main.png");

    public ForgeTier1Screen(ForgeTier1Container screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
        this.guiLeft = 0;
        this.guiTop = 0;
        this.xSize = 176;
        this.ySize = 166;
    }

}
