package com.onlytanner.industrialmetallurgy.gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import com.onlytanner.industrialmetallurgy.Reference;
import com.onlytanner.industrialmetallurgy.container.ContainerForgeTier1;
import com.onlytanner.industrialmetallurgy.container.ContainerForgeTier2;
import com.onlytanner.industrialmetallurgy.tileentities.TileEntityForgeTier1;
import com.onlytanner.industrialmetallurgy.tileentities.TileEntityForgeTier2.Mode;
import com.onlytanner.industrialmetallurgy.tileentities.TileEntityForgeTier2;
import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiForgeTier2 extends GuiContainer {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/gui/container/forge_tier2.png");
    private final TileEntityForgeTier2 tileEntityForgeTier2;
    private final GuiButton changeMode;
    private static final int CHANGE_MODE_BUTTON_ID = 76;

    // some [x,y] coordinates of graphical elements
    final int COOK_BAR_XPOS = 60;
    final int COOK_BAR_YPOS = 35;
    final int COOK_BAR_ICON_U = 176;   // texture position of white arrow icon
    final int COOK_BAR_ICON_V = 14;
    final int COOK_BAR_WIDTH = 36;
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
    
    final int BUTTON_XPOS = 7;
    final int BUTTON_YPOS = 71;
    final int ALLOY_ICON_XPOS = 176;
    final int ALLOY_ICON_YPOS = 38;
    final int SMELT_ICON_XPOS = 184;
    final int SMELT_ICON_YPOS = 38;
    final int BUTTON_SIZE = 8;
    
    public GuiForgeTier2(InventoryPlayer invPlayer, TileEntityForgeTier2 tile) {
        super(new ContainerForgeTier2(invPlayer, tile));
        tileEntityForgeTier2 = tile;
        
        xSize = 176;
        ySize = 166;
        
        changeMode = new GuiButton(CHANGE_MODE_BUTTON_ID, BUTTON_XPOS, BUTTON_YPOS, "");
    }

    @Override
    public void initGui()
    {
        super.initGui();
        
        changeMode.xPosition = guiLeft + BUTTON_XPOS;
        changeMode.yPosition = guiTop + BUTTON_YPOS;
        
        changeMode.width = BUTTON_SIZE;
        changeMode.height = 7;
        
        buttonList.add(changeMode);
        
        updateChangeModeButton();
    }
    
    @Override
    protected void actionPerformed(GuiButton button) throws IOException
    {
        if (button.id == CHANGE_MODE_BUTTON_ID)
        {
            if (tileEntityForgeTier2.getMode() == Mode.ALLOY)
                tileEntityForgeTier2.setMode(Mode.SMELT);
            else
                tileEntityForgeTier2.setMode(Mode.ALLOY);
        }
        else
            super.actionPerformed(button);
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int x, int y) 
    {
        // Bind the image texture
        Minecraft.getMinecraft().getTextureManager().bindTexture(TEXTURE);
        // Draw the image
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

        // get cook progress as a double between 0 and 1
        double cookProgress = tileEntityForgeTier2.fractionOfCookTimeComplete();
        // draw the cook progress bar
        drawTexturedModalRect(guiLeft + COOK_BAR_XPOS, guiTop + COOK_BAR_YPOS, 
                              COOK_BAR_ICON_U, COOK_BAR_ICON_V, 
                              (int)(cookProgress * COOK_BAR_WIDTH), 
                              COOK_BAR_HEIGHT);

        // draw the fuel remaining bar for each fuel slot flame
        for (int i = 0; i < tileEntityForgeTier2.FUEL_SLOTS_COUNT; ++i) 
        {
            double burnRemaining = tileEntityForgeTier2.fractionOfFuelRemaining(i);
            int yOffset = (int) ((1.0 - burnRemaining) * FLAME_HEIGHT);
            drawTexturedModalRect(guiLeft + FLAME_XPOS + FLAME_X_SPACING * i, 
                                  guiTop + FLAME_YPOS + yOffset, FLAME_ICON_U, 
                                  FLAME_ICON_V + yOffset, FLAME_WIDTH, 
                                  FLAME_HEIGHT - yOffset);
        }

        drawTexturedModalRect(guiLeft + POINTER_XPOS, guiTop + getPointerLocationFromTemp(tileEntityForgeTier2),
                POINTER_ICON_U, POINTER_ICON_V, POINTER_WIDTH, POINTER_HEIGHT);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        super.drawGuiContainerForegroundLayer(mouseX, mouseY);

        final int LABEL_XPOS = 5;
        final int LABEL_YPOS = 5;
        fontRendererObj.drawString(tileEntityForgeTier2.getDisplayName().getUnformattedText(), LABEL_XPOS, LABEL_YPOS, Color.darkGray.getRGB());

        List<String> hoveringText = new ArrayList<String>();

        // If the mouse is over the progress bar add the progress bar hovering text
        if (isInRect(guiLeft + COOK_BAR_XPOS, guiTop + COOK_BAR_YPOS, COOK_BAR_WIDTH, COOK_BAR_HEIGHT, mouseX, mouseY)) {
            hoveringText.add("Progress:");
            int cookPercentage = (int) (tileEntityForgeTier2.fractionOfCookTimeComplete() * 100);
            hoveringText.add(cookPercentage + "%");
        }

        // If the mouse is over one of the burn time indicator add the burn time indicator hovering text
        if (isInRect(guiLeft + FLAME_XPOS, guiTop + FLAME_YPOS, FLAME_WIDTH, FLAME_HEIGHT, mouseX, mouseY)) {
            hoveringText.add("Fuel Time:");
            hoveringText.add(tileEntityForgeTier2.secondsOfFuelRemaining(0) + "s");
        }

        if (isInRect(guiLeft + POINTER_XPOS, guiTop + getPointerLocationFromTemp(tileEntityForgeTier2),
                POINTER_WIDTH, POINTER_HEIGHT, mouseX, mouseY)) {
            hoveringText.add("Temperature:");
            hoveringText.add(tileEntityForgeTier2.getTemperatureOfCurrent() + "\u00B0F");
        }
        
        if (isInRect(guiLeft + BUTTON_XPOS, guiTop + BUTTON_YPOS, BUTTON_SIZE, BUTTON_SIZE, mouseX, mouseY))
            if(tileEntityForgeTier2.getMode() == Mode.ALLOY)
                hoveringText.add("Alloy Mode");
            else
                hoveringText.add("Smelting Mode");
        
        // If hoveringText is not empty draw the hovering text
        if (!hoveringText.isEmpty()) {
            drawHoveringText(hoveringText, mouseX - guiLeft, mouseY - guiTop, fontRendererObj);
        }
//			// You must re bind the texture and reset the colour if you still need to use it after drawing a string
//			Minecraft.getMinecraft().getTextureManager().bindTexture(TEXTURE);
//			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

    }

    public void updateChangeModeButton()
    {
        if (tileEntityForgeTier2.getMode() == Mode.ALLOY)
            changeMode.drawTexturedModalRect(guiLeft + BUTTON_XPOS, guiTop + BUTTON_YPOS, ALLOY_ICON_XPOS, ALLOY_ICON_YPOS, BUTTON_SIZE, 7);
        else
            changeMode.drawTexturedModalRect(guiLeft + BUTTON_XPOS, guiTop + BUTTON_YPOS, SMELT_ICON_XPOS, SMELT_ICON_YPOS, BUTTON_SIZE, 7);
    }
    
    // Returns true if the given x,y coordinates are within the given rectangle
    public static boolean isInRect(int x, int y, int xSize, int ySize, int mouseX, int mouseY) {
        return ((mouseX >= x && mouseX <= x + xSize) && (mouseY >= y && mouseY <= y + ySize));
    }

    private static int getPointerLocationFromTemp(TileEntityForgeTier2 tile) {
        return 74 - ((tile.getTemperatureOfCurrent() - 750) / 101);
    }
}
