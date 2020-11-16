package com.onlytanner.industrialmetallurgy.client.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.containers.ChemicalReactorContainer;
import com.onlytanner.industrialmetallurgy.containers.CrusherContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ChemicalReactorScreen extends ContainerScreen<ChemicalReactorContainer> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(IndustrialMetallurgy.MOD_ID, "textures/gui/container/chemical_reactor.png");

    private final int PROGRESS_X = 98, PROGRESS_Y = 47, PROGRESS_WIDTH = 9, PROGRESS_HEIGHT = 28;
    private final int ENERGY_X = 8, ENERGY_Y = 8, ENERGY_WIDTH = 16, ENERGY_HEIGHT = 70;

    public ChemicalReactorScreen(ChemicalReactorContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
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
        this.playerInventoryTitleX += 20;
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
            super.renderTooltip(matrixStack, new TranslationTextComponent("Progress: " + ((this.container.currentSmeltTime.get() * 100) / this.container.te.MAX_SMELT_TIME) + "%"), x, y);
        }
        if (x >= ENERGY_X + this.guiLeft && x <= ENERGY_X + ENERGY_WIDTH + this.guiLeft && y >= ENERGY_Y + this.guiTop && y <= ENERGY_Y + ENERGY_HEIGHT + this.guiTop) {
            super.renderTooltip(matrixStack, new TranslationTextComponent("Energy Stored: " + this.container.currentEnergy.get()), x, y);
        }
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {
        this.minecraft.getTextureManager().bindTexture(TEXTURE);
        int backgroundX = (this.width - this.xSize) / 2;
        int backgroundY = (this.height - this.ySize) / 2;
        this.blit(matrixStack, backgroundX, backgroundY, 0, 0, this.xSize, this.ySize);
        this.blit(matrixStack, this.guiLeft + PROGRESS_X, this.guiTop + PROGRESS_Y, 176, 0, 9, this.container.getSmeltProgressionScaled());
        int yOffset = 70 - this.container.getCurrentEnergyScaled();
        this.blit(matrixStack, this.guiLeft + 8, this.guiTop + 8 + yOffset, 176, yOffset + 28, 16, this.container.getCurrentEnergyScaled());
    }

    @Override
    protected void drawGuiContainerForegroundLayer(MatrixStack matrixStack, int x, int y) {
        super.drawGuiContainerForegroundLayer(matrixStack, x, y);
        this.font.drawString(matrixStack, this.title.getUnformattedComponentText(), 8.0f, 8.0f, 0x404040);
        this.font.drawString(matrixStack, this.playerInventory.getDisplayName().getUnformattedComponentText(), 8.0f, 69.0f, 0x404040);
    }
}
