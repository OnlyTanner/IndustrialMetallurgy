package com.onlytanner.industrialmetallurgy.client.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.containers.ForgeTier1Container;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.awt.*;

@OnlyIn(Dist.CLIENT)
public class ForgeTier1Screen extends ContainerScreen<ForgeTier1Container> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(IndustrialMetallurgy.MOD_ID, "textures/gui/container/forge_main.png");

    public ForgeTier1Screen(ForgeTier1Container screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
        this.guiLeft = 0;
        this.guiTop = 0;
        this.xSize = 176;
        this.ySize = 166;
    }

    @Override
    public void render(MatrixStack matrixStack, final int mouseX, final int mouseY, final float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        //this.renderToolTip(matrixStack, null, mouseX, mouseY, this.font);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(MatrixStack matrixStack, int mouseX, int mouseY) {
        super.drawGuiContainerForegroundLayer(matrixStack, mouseX, mouseY);
        this.font.drawString(matrixStack, "Forge (Tier 1)", 8.0f, 6.0f, Color.darkGray.getRGB());
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {
        RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.minecraft.getTextureManager().bindTexture(TEXTURE);
        int backgroundX = (this.width - this.xSize) / 2;
        int backgroundY = (this.height - this.ySize) / 2;
        this.blit(matrixStack, backgroundX, backgroundY, 0, 0, this.xSize, this.ySize);
    }
}
