package com.onlytanner.industrialmetallurgy.gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.container.ContainerElectricCrusher;
import com.onlytanner.industrialmetallurgy.tileentities.TileEntityElectricCrusher;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiElectricCrusher extends GuiContainer {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/gui/container/electric_crusher.png");
    private TileEntityElectricCrusher tileEntityElectricCrusher;

    // some [x,y] coordinates of graphical elements
    final int COOK_BAR_XPOS = 79;
    final int COOK_BAR_YPOS = 35;
    final int COOK_BAR_ICON_U = 176;   // texture position of white arrow icon
    final int COOK_BAR_ICON_V = 0;
    final int COOK_BAR_WIDTH = 24;
    final int COOK_BAR_HEIGHT = 17;
    
    final int ENERGY_BAR_XPOS = 8;
    final int ENERGY_BAR_YPOS = 8;
    final int ENERGY_BAR_ICON_U = 176;
    final int ENERGY_BAR_ICON_V = 17;
    final int ENERGY_BAR_WIDTH = 16;
    final int ENERGY_BAR_HEIGHT = 70;
    
    public GuiElectricCrusher(InventoryPlayer invPlayer, TileEntityElectricCrusher tile) {
        super(new ContainerElectricCrusher(invPlayer, tile));
        tileEntityElectricCrusher = tile;

        xSize = 176;
        ySize = 166;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int x, int y) {
        // Bind the image texture
        Minecraft.getMinecraft().getTextureManager().bindTexture(TEXTURE);
        // Draw the image
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

        // get cook progress as a double between 0 and 1
        double cookProgress = tileEntityElectricCrusher.fractionOfCookTimeComplete();
        // draw the cook progress bar
        drawTexturedModalRect(guiLeft + COOK_BAR_XPOS, guiTop + COOK_BAR_YPOS, COOK_BAR_ICON_U, COOK_BAR_ICON_V,
                (int) (cookProgress * COOK_BAR_WIDTH), COOK_BAR_HEIGHT);
        
        double energy = tileEntityElectricCrusher.getFractionOfEnergyRemaining();
        int yOffset = (int) ((1.0 - energy) * ENERGY_BAR_HEIGHT);
        drawTexturedModalRect(guiLeft + ENERGY_BAR_XPOS, 
                              guiTop + ENERGY_BAR_YPOS + yOffset, ENERGY_BAR_ICON_U, 
                              ENERGY_BAR_ICON_V + yOffset, ENERGY_BAR_WIDTH, 
                              ENERGY_BAR_HEIGHT - yOffset);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        super.drawGuiContainerForegroundLayer(mouseX, mouseY);

        final int LABEL_XPOS = 5;
        final int LABEL_YPOS = 5;
        fontRendererObj.drawString(tileEntityElectricCrusher.getDisplayName().getUnformattedText(), LABEL_XPOS, LABEL_YPOS, Color.darkGray.getRGB());

        List<String> hoveringText = new ArrayList<String>();

        // If the mouse is over the progress bar add the progress bar hovering text
        if (isInRect(guiLeft + COOK_BAR_XPOS, guiTop + COOK_BAR_YPOS, COOK_BAR_WIDTH, COOK_BAR_HEIGHT, mouseX, mouseY)) {
            hoveringText.add("Progress:");
            int cookPercentage = (int) (tileEntityElectricCrusher.fractionOfCookTimeComplete() * 100);
            hoveringText.add(cookPercentage + "%");
        }
        
        if (isInRect(guiLeft + ENERGY_BAR_XPOS, guiTop + ENERGY_BAR_YPOS, ENERGY_BAR_WIDTH, ENERGY_BAR_HEIGHT, mouseX, mouseY))
        {
            hoveringText.add("Energy Stored:");
            hoveringText.add(tileEntityElectricCrusher.getEnergyStored() + "/" + tileEntityElectricCrusher.MAX_CAPACITY);
        }

        // If hoveringText is not empty draw the hovering text
        if (!hoveringText.isEmpty()) {
            drawHoveringText(hoveringText, mouseX - guiLeft, mouseY - guiTop, fontRendererObj);
        }
    }

    // Returns true if the given x,y coordinates are within the given rectangle
    public static boolean isInRect(int x, int y, int xSize, int ySize, int mouseX, int mouseY) {
        return ((mouseX >= x && mouseX <= x + xSize) && (mouseY >= y && mouseY <= y + ySize));
    }
}
