package com.onlytanner.industrialmetallurgy.client.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.containers.ForgeTier1Container;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.widget.button.ImageButton;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ForgeTier1Screen extends ContainerScreen<ForgeTier1Container> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(IndustrialMetallurgy.MOD_ID, "textures/gui/container/forge_main.png");
    private static final ResourceLocation ALLOY_BUTTON = new ResourceLocation(IndustrialMetallurgy.MOD_ID, "textures/gui/container/forge_alloy_button.png");
    private static final ResourceLocation SMELT_BUTTON = new ResourceLocation(IndustrialMetallurgy.MOD_ID, "textures/gui/container/forge_smelt_button.png");
    private boolean isSmeltMode;

    public static final int BUTTON_SIZE = 16;
    public static final int ALLOY_BUTTON_X = 8;
    public static final int ALLOY_BUTTON_Y = 54;
    public static final int SMELT_BUTTON_X = 26;
    public static final int SMELT_BUTTON_Y = 54;

    public ForgeTier1Screen(ForgeTier1Container screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
        this.guiLeft = 0;
        this.guiTop = 0;
        this.xSize = 176;
        this.ySize = 166;
        this.isSmeltMode = true;
    }

    @Override
    public void render(MatrixStack matrixStack, final int mouseX, final int mouseY, final float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderHoveredTooltip(matrixStack, mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {
        this.minecraft.getTextureManager().bindTexture(TEXTURE);
        int backgroundX = (this.width - this.xSize) / 2;
        int backgroundY = (this.height - this.ySize) / 2;
        this.blit(matrixStack, backgroundX, backgroundY, 0, 0, this.xSize, this.ySize);
        this.addButton(new ImageButton(backgroundX + ALLOY_BUTTON_X, backgroundY + ALLOY_BUTTON_Y, BUTTON_SIZE, BUTTON_SIZE, 0, 0, BUTTON_SIZE, this.ALLOY_BUTTON, (button) -> {
            ((ImageButton)button).setPosition(backgroundX + ALLOY_BUTTON_X, backgroundY + ALLOY_BUTTON_Y);
        }));
        this.addButton(new ImageButton(backgroundX + SMELT_BUTTON_X, backgroundY + SMELT_BUTTON_Y, BUTTON_SIZE, BUTTON_SIZE, 0, 0, BUTTON_SIZE, this.SMELT_BUTTON, (button) -> {
            ((ImageButton)button).setPosition(backgroundX + SMELT_BUTTON_X, backgroundY + SMELT_BUTTON_Y);
        }));
        this.blit(matrixStack, this.guiLeft + 94, this.guiTop + 35, 176, 14, this.container.getSmeltProgressionScaled(), 16);
        int yOffset = 14 - this.container.getBurnTimeScaled();
        this.blit(matrixStack, this.guiLeft + 18, this.guiTop + 17 + yOffset, 176, yOffset, 14, this.container.getBurnTimeScaled());
    }

    @Override
    protected void drawGuiContainerForegroundLayer(MatrixStack matrixStack, int x, int y) {
        super.drawGuiContainerForegroundLayer(matrixStack, x, y);
        this.font.drawString(matrixStack, this.title.getUnformattedComponentText(), 8.0f, 8.0f, 0x404040);
        this.font.drawString(matrixStack, this.playerInventory.getDisplayName().getUnformattedComponentText(), 8.0f, 69.0f, 0x404040);
    }
}
