package com.onlytanner.industrialmetallurgy.gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.container.ContainerCoalGenerator;
import com.onlytanner.industrialmetallurgy.tileentities.TileEntityCoalGenerator;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiCoalGenerator extends GuiContainer {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/gui/container/coal_generator.png");
    private TileEntityCoalGenerator tileEntityCoalGenerator;

    public GuiCoalGenerator(InventoryPlayer invPlayer, TileEntityCoalGenerator tile) {
        super(new ContainerCoalGenerator(invPlayer, tile));
        tileEntityCoalGenerator = tile;

        xSize = 176;
        ySize = 166;
    }

    final int FLAME_XPOS = 81;
    final int FLAME_YPOS = 18;
    final int FLAME_ICON_U = 176;   // texture position of flame icon
    final int FLAME_ICON_V = 0;
    final int FLAME_WIDTH = 14;
    final int FLAME_HEIGHT = 14;
    
    final int ENERGY_BAR_XPOS = 152;
    final int ENERGY_BAR_YPOS = 8;
    final int ENERGY_BAR_ICON_U = 176;
    final int ENERGY_BAR_ICON_V = 14;
    final int ENERGY_BAR_WIDTH = 16;
    final int ENERGY_BAR_HEIGHT = 70;

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int x, int y) 
    {
        // Bind the image texture
        Minecraft.getMinecraft().getTextureManager().bindTexture(TEXTURE);
        // Draw the image
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
        
        // draw the fuel remaining bar for each fuel slot flame
        double burnRemaining = tileEntityCoalGenerator.fractionOfFuelRemaining(0);
        int yOffset = (int) ((1.0 - burnRemaining) * FLAME_HEIGHT);
        drawTexturedModalRect(guiLeft + FLAME_XPOS, 
                              guiTop + FLAME_YPOS + yOffset, FLAME_ICON_U, 
                              FLAME_ICON_V + yOffset, FLAME_WIDTH, 
                              FLAME_HEIGHT - yOffset);
        
        double energy = tileEntityCoalGenerator.getFractionOfEnergyRemaining();
        yOffset = (int) ((1.0 - energy) * ENERGY_BAR_HEIGHT);
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
        fontRendererObj.drawString(tileEntityCoalGenerator.getDisplayName().getUnformattedText(), LABEL_XPOS, LABEL_YPOS, Color.darkGray.getRGB());

        List<String> hoveringText = new ArrayList<String>();

        // If the mouse is over one of the burn time indicator add the burn time indicator hovering text
        if (isInRect(guiLeft + FLAME_XPOS, guiTop + FLAME_YPOS, FLAME_WIDTH, FLAME_HEIGHT, mouseX, mouseY)) {
            hoveringText.add("Fuel Time:");
            hoveringText.add(tileEntityCoalGenerator.secondsOfFuelRemaining(0) + "s");
        }
        
        if (isInRect(guiLeft + ENERGY_BAR_XPOS, guiTop + ENERGY_BAR_YPOS, ENERGY_BAR_WIDTH, ENERGY_BAR_HEIGHT, mouseX, mouseY))
        {
            hoveringText.add("Energy Stored:");
            hoveringText.add(tileEntityCoalGenerator.getEnergyToSplitShare() + "");
        }
        
        // If hoveringText is not empty draw the hovering text
        if (!hoveringText.isEmpty()) {
            drawHoveringText(hoveringText, mouseX - guiLeft, mouseY - guiTop, fontRendererObj);
        }
//			// You must re bind the texture and reset the colour if you still need to use it after drawing a string
//			Minecraft.getMinecraft().getTextureManager().bindTexture(TEXTURE);
//			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

    }

    // Returns true if the given x,y coordinates are within the given rectangle
    public static boolean isInRect(int x, int y, int xSize, int ySize, int mouseX, int mouseY) {
        return ((mouseX >= x && mouseX <= x + xSize) && (mouseY >= y && mouseY <= y + ySize));
    }
}
