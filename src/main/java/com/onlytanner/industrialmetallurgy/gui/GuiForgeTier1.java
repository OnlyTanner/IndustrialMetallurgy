package com.onlytanner.industrialmetallurgy.gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.container.ContainerForgeTier1;
import com.onlytanner.industrialmetallurgy.items.crafting.ForgeRecipes;
import com.onlytanner.industrialmetallurgy.tileentities.TileEntityForgeTier1;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiForgeTier1 extends GuiContainer {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/gui/container/forge_tier1.png");
    private TileEntityForgeTier1 tileEntityForgeTier1;

    public GuiForgeTier1(InventoryPlayer invPlayer, TileEntityForgeTier1 tile) {
        super(new ContainerForgeTier1(invPlayer, tile));
        tileEntityForgeTier1 = tile;

        xSize = 176;
        ySize = 166;
    }

    // some [x,y] coordinates of graphical elements
    final int COOK_BAR_XPOS = 71;
    final int COOK_BAR_YPOS = 35;
    final int COOK_BAR_ICON_U = 176;   // texture position of white arrow icon
    final int COOK_BAR_ICON_V = 14;
    final int COOK_BAR_WIDTH = 24;
    final int COOK_BAR_HEIGHT = 17;

    final int FLAME_XPOS = 15;
    final int FLAME_YPOS = 19;
    final int FLAME_ICON_U = 176;   // texture position of flame icon
    final int FLAME_ICON_V = 0;
    final int FLAME_WIDTH = 14;
    final int FLAME_HEIGHT = 14;
    final int FLAME_X_SPACING = 18;

    final int POINTER_XPOS = 164;
    final int POINTER_ICON_U = 176;   // texture position of pointer icon
    final int POINTER_ICON_V = 31;
    final int POINTER_WIDTH = 7;
    final int POINTER_HEIGHT = 7;

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int x, int y) 
    {
        // Bind the image texture
        Minecraft.getMinecraft().getTextureManager().bindTexture(TEXTURE);
        // Draw the image
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

        // get cook progress as a double between 0 and 1
        double cookProgress = tileEntityForgeTier1.fractionOfCookTimeComplete();
        // draw the cook progress bar
        drawTexturedModalRect(guiLeft + COOK_BAR_XPOS, guiTop + COOK_BAR_YPOS, 
                              COOK_BAR_ICON_U, COOK_BAR_ICON_V, 
                              (int)(cookProgress * COOK_BAR_WIDTH), 
                              COOK_BAR_HEIGHT);

        // draw the fuel remaining bar for each fuel slot flame
        for (int i = 0; i < tileEntityForgeTier1.FUEL_SLOTS_COUNT; ++i) 
        {
            double burnRemaining = tileEntityForgeTier1.fractionOfFuelRemaining(i);
            int yOffset = (int) ((1.0 - burnRemaining) * FLAME_HEIGHT);
            drawTexturedModalRect(guiLeft + FLAME_XPOS + FLAME_X_SPACING * i, 
                                  guiTop + FLAME_YPOS + yOffset, FLAME_ICON_U, 
                                  FLAME_ICON_V + yOffset, FLAME_WIDTH, 
                                  FLAME_HEIGHT - yOffset);
        }

        drawTexturedModalRect(guiLeft + POINTER_XPOS, guiTop + getPointerLocationFromTemp(tileEntityForgeTier1),
                POINTER_ICON_U, POINTER_ICON_V, POINTER_WIDTH, POINTER_HEIGHT);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        super.drawGuiContainerForegroundLayer(mouseX, mouseY);

        final int LABEL_XPOS = 5;
        final int LABEL_YPOS = 5;
        fontRendererObj.drawString(tileEntityForgeTier1.getDisplayName().getUnformattedText(), LABEL_XPOS, LABEL_YPOS, Color.darkGray.getRGB());

        List<String> hoveringText = new ArrayList<String>();

        // If the mouse is over the progress bar add the progress bar hovering text
        if (isInRect(guiLeft + COOK_BAR_XPOS, guiTop + COOK_BAR_YPOS, COOK_BAR_WIDTH, COOK_BAR_HEIGHT, mouseX, mouseY)) {
            hoveringText.add("Progress:");
            int cookPercentage = (int) (tileEntityForgeTier1.fractionOfCookTimeComplete() * 100);
            hoveringText.add(cookPercentage + "%");
        }

        // If the mouse is over one of the burn time indicator add the burn time indicator hovering text
        if (isInRect(guiLeft + FLAME_XPOS, guiTop + FLAME_YPOS, FLAME_WIDTH, FLAME_HEIGHT, mouseX, mouseY)) {
            hoveringText.add("Fuel Time:");
            hoveringText.add(tileEntityForgeTier1.secondsOfFuelRemaining(0) + "s");
        }

        if (isInRect(guiLeft + POINTER_XPOS, guiTop + getPointerLocationFromTemp(tileEntityForgeTier1),
                POINTER_WIDTH, POINTER_HEIGHT, mouseX, mouseY)) {
            hoveringText.add("Temperature:");
            hoveringText.add(tileEntityForgeTier1.getTemperatureOfCurrent() + "\u00B0F");
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

    private static int getPointerLocationFromTemp(TileEntityForgeTier1 tile) {
        return 74 - ((tile.getTemperatureOfCurrent() - 500) / 66);
    }
}
