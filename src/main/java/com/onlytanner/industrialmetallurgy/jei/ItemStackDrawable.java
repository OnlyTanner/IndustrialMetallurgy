package com.onlytanner.industrialmetallurgy.jei;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.ItemStack;

public class ItemStackDrawable implements IDrawableStatic {

    private final ItemStack stack;

    public ItemStackDrawable(ItemStack stack) {
        this.stack = stack;
    }

    @Override
    public void draw(MatrixStack matrixStack, int xOffset, int yOffset) {
        draw(matrixStack, xOffset, yOffset);
    }

    @Override
    public void draw(MatrixStack matrixStack, int xOffset, int yOffset, int maskTop, int maskBottom, int maskLeft, int maskRight) {
        RenderHelper.enableStandardItemLighting();
        GlStateManager.enableDepthTest();
        Minecraft.getInstance().getItemRenderer().renderItemAndEffectIntoGUI(null, stack, xOffset, yOffset);
        GlStateManager.disableDepthTest();
        RenderHelper.disableStandardItemLighting();
    }

    @Override
    public int getWidth() {
        return 16;
    }

    @Override
    public int getHeight() {
        return 16;
    }

}
