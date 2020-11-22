package com.onlytanner.industrialmetallurgy.jei;

import com.mojang.blaze3d.matrix.MatrixStack;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.gui.GuiUtils;
import org.lwjgl.opengl.GL11;

public class ScreenDrawable implements IDrawableStatic {

    private final ResourceLocation resourceLocation;
    private final int u, v, width, height, padTop, padBot, padLeft, padRight;

    public ScreenDrawable(ResourceLocation resourceLocation, int u, int v, int width, int height) {
        this(resourceLocation, u, v, width, height, 0, 0, 0, 0);
    }

    public ScreenDrawable(ResourceLocation resourceLocation, int u, int v, int width, int height, int padTop, int padBot, int padLeft, int padRight) {
        this.resourceLocation = resourceLocation;
        this.u = u;
        this.v = v;
        this.width = width;
        this.height = height;
        this.padTop = padTop;
        this.padBot = padBot;
        this.padLeft = padLeft;
        this.padRight = padRight;
    }

    @Override
    public int getWidth() {
        return width + padLeft + padRight;
    }

    @Override
    public int getHeight() {
        return height + padTop + padBot;
    }

    @Override
    public void draw(MatrixStack matrixStack) {
        draw(matrixStack, 0, 0);
    }

    @Override
    public void draw(MatrixStack matrixStack, int xOffset, int yOffset) {
        draw(matrixStack, xOffset, yOffset, 0, 0, 0, 0);
    }

    @Override
    public void draw(MatrixStack matrixStack, int xOffset, int yOffset, int maskTop, int maskBottom, int maskLeft, int maskRight) {
        Minecraft.getInstance().getTextureManager().bindTexture(this.resourceLocation);
        GL11.glEnable(3042);
        int x = xOffset + this.padLeft + maskLeft;
        int y = yOffset + this.padTop + maskTop;
        int u = this.u + maskLeft;
        int v = this.v + maskTop;
        int width = this.width - maskRight - maskLeft;
        int height = this.height - maskBottom - maskTop;
        GuiUtils.drawTexturedModalRect(matrixStack, x, y, u, v, width, height, 0);
        GL11.glDisable(3042);
    }
}
