package com.onlytanner.industrialmetallurgy.client.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.containers.BasicForgeContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BasicForgeScreen extends ContainerScreen<BasicForgeContainer> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(IndustrialMetallurgy.MOD_ID, "textures/gui/container/forge_main.png");

    private final int PROGRESS_X = 94, PROGRESS_Y = 34, PROGRESS_WIDTH = 24, PROGRESS_HEIGHT = 17;
    private final int FLAME_X = 17, FLAME_Y = 16, FLAME_SIZE = 16;
    private final int TEMP_X = 163, TEMP_Y = 6, TEMP_WIDTH = 5, TEMP_HEIGHT = 74;

    public BasicForgeScreen(BasicForgeContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
        this.guiLeft = 0;
        this.guiTop = 0;
        this.xSize = 176;
        this.ySize = 166;
    }

    @Override
    protected void init() {
        super.init();
        this.titleX = (this.xSize - this.font.getStringPropertyWidth(this.title)) / 2;
    }

    @Override
    public void render(MatrixStack matrixStack, final int mouseX, final int mouseY, final float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderHoveredTooltip(matrixStack, mouseX, mouseY);
        this.renderTooltips(matrixStack, mouseX, mouseY);
    }

    protected void renderTooltips(MatrixStack matrixStack, int x, int y) {
        if (x >= PROGRESS_X + this.guiLeft && x <= PROGRESS_X + PROGRESS_WIDTH + this.guiLeft && y >= PROGRESS_Y + this.guiTop && y <= PROGRESS_Y + PROGRESS_HEIGHT + this.guiTop) {
            super.renderTooltip(matrixStack, new TranslationTextComponent("Progress: " + ((this.container.currentSmeltTime.get() * 100) / this.container.te.maxSmeltTime) + "%"), x, y);
        }
        if (x >= FLAME_X + this.guiLeft && x <= FLAME_X + FLAME_SIZE + this.guiLeft && y >= FLAME_Y + this.guiTop && y <= FLAME_Y + FLAME_SIZE + this.guiTop) {
            super.renderTooltip(matrixStack, new TranslationTextComponent("Burn Time Remaining: " + (this.container.burnTimeRemaining.get() / 20) + "s"), x, y);
        }
        if (x >= TEMP_X + this.guiLeft && x <= TEMP_X + TEMP_WIDTH + this.guiLeft && y >= TEMP_Y + this.guiTop && y <= TEMP_Y + TEMP_HEIGHT + this.guiTop) {
            super.renderTooltip(matrixStack, new TranslationTextComponent("Temperature: " + this.container.currentTemperature.get() + "\u00B0F"), x, y);
        }
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {
        this.minecraft.getTextureManager().bindTexture(TEXTURE);
        int backgroundX = (this.width - this.xSize) / 2;
        int backgroundY = (this.height - this.ySize) / 2;
        this.blit(matrixStack, backgroundX, backgroundY, 0, 0, this.xSize, this.ySize);
        this.blit(matrixStack, this.guiLeft + 94, this.guiTop + 35, 176, 14, this.container.getSmeltProgressionScaled(), 16);
        int yOffset = 14 - this.container.getBurnTimeScaled();
        this.blit(matrixStack, this.guiLeft + 18, this.guiTop + 17 + yOffset, 176, yOffset, 14, this.container.getBurnTimeScaled());
        this.blit(matrixStack, this.guiLeft + 164, this.guiTop + 76 - this.container.getTemperatureScaled(), 176, 31, 7, 7);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(MatrixStack matrixStack, int x, int y) {
        super.drawGuiContainerForegroundLayer(matrixStack, x, y);
        this.font.drawString(matrixStack, this.title.getUnformattedComponentText(), 8.0f, 8.0f, 0x404040);
        this.font.drawString(matrixStack, this.playerInventory.getDisplayName().getUnformattedComponentText(), 8.0f, 69.0f, 0x404040);
    }
}
