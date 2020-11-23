package com.onlytanner.industrialmetallurgy.tileentity;

import com.onlytanner.industrialmetallurgy.IndustrialMetallurgy;
import com.onlytanner.industrialmetallurgy.blocks.ForgeTier4Block;
import com.onlytanner.industrialmetallurgy.containers.ForgeTier4Container;
import com.onlytanner.industrialmetallurgy.init.ModTileEntityTypes;
import com.onlytanner.industrialmetallurgy.recipes.ForgeRecipe;
import com.onlytanner.industrialmetallurgy.recipes.RecipeSerializerInit;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.items.wrapper.RecipeWrapper;

import javax.annotation.Nullable;
import java.util.Set;

public class ForgeTier4TileEntity extends AdvancedForgeTileEntity {

    public ForgeTier4TileEntity() {
        this(ModTileEntityTypes.FORGE_TIER4.get());
        this.maxSmeltTime = 50;
        this.maxTemperature = 3500;
        this.degreesPerTick = 20;
    }

    protected ForgeTier4TileEntity(final TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
        customName = new TranslationTextComponent("Tungsten Forge (Tier 4)");
    }

    @Override
    public void tick() {
        boolean dirty = false;
        if (this.world != null && !this.world.isRemote) {
            if (this.getRecipe() != null && canProcess() && energy >= ENERGY_USAGE_PER_TICK && currentTemperature > 2250) {
                this.world.setBlockState(this.getPos(), this.getBlockState().with(ForgeTier4Block.LIT, true));
                if (this.currentSmeltTime != this.maxSmeltTime) {
                    this.currentSmeltTime++;
                    this.currentTemperature = (this.currentTemperature < maxTemperature) ? this.currentTemperature + degreesPerTick : maxTemperature;
                    this.energy -= ENERGY_USAGE_PER_TICK;
                } else {
                    this.currentSmeltTime = 0;
                    this.currentTemperature = (this.currentTemperature < maxTemperature) ? this.currentTemperature + degreesPerTick : maxTemperature;
                    this.energy -= ENERGY_USAGE_PER_TICK;
                    processRecipe();
                    dirty = true;
                }
            }
            else if (this.getRecipe() != null && this.energy >= ENERGY_USAGE_PER_TICK && canProcess() && currentTemperature <= 2250) {
                this.world.setBlockState(this.getPos(), this.getBlockState().with(ForgeTier4Block.LIT, true));
                this.currentTemperature = (this.currentTemperature < maxTemperature) ? this.currentTemperature + degreesPerTick : maxTemperature;
                this.energy -= ENERGY_USAGE_PER_TICK;
            }
            else {
                this.world.setBlockState(this.getPos(), this.getBlockState().with(ForgeTier4Block.LIT, false));
                this.currentTemperature = (this.currentTemperature > 0) ? this.currentTemperature - 1 : 0;
                currentSmeltTime = 0;
            }
        }
        if (dirty) {
            this.markDirty();
            this.world.notifyBlockUpdate(this.getPos(), this.getBlockState(), this.getBlockState(),
                    Constants.BlockFlags.BLOCK_UPDATE);
        }
    }

    public void processRecipe() {
        ItemStack output = this.getRecipe().getRecipeOutput();
        this.inventory.insertItem(OUTPUT_ID, output.copy(), false);
        for (int i = 0; i < NUM_INPUT_SLOTS; i++) {
            if (this.inventory.getStackInSlot(i) != ItemStack.EMPTY && this.getRecipe() != null) {
                ItemStack[] list = this.getRecipe().getInput().getMatchingStacks();
                for (int j = 0; j < list.length; j++) {
                    if (list[j].getItem().equals(this.getInventory().getStackInSlot(i).getItem())) {
                        this.inventory.decrStackSize(i, list[j].getCount());
                    }
                }
            }
        }
    }

    public boolean canProcess() {
        if (getRecipe() != null && getRecipe().matches(new RecipeWrapper(this.inventory), world) &&
                (this.inventory.getStackInSlot(OUTPUT_ID).getCount() < 64) &&
                ((this.inventory.getStackInSlot(OUTPUT_ID) == ItemStack.EMPTY) ||
                        (this.inventory.getStackInSlot(OUTPUT_ID).getItem().equals(getRecipe().getRecipeOutput().getItem()))))
            return true;
        return false;
    }

    @Override
    public Container createMenu(final int windowID, final PlayerInventory playerInv, final PlayerEntity playerIn) {
        return new ForgeTier4Container(windowID, playerInv, this);
    }

    @Nullable
    @Override
    protected ForgeRecipe getRecipe() {
        if (this.inventory == null)
            return null;
        Set<IRecipe<?>> recipes = findRecipesByType(RecipeSerializerInit.FORGE_RECIPE_TYPE, this.world);
        for (IRecipe<?> iRecipe : recipes) {
            ForgeRecipe recipe = (ForgeRecipe) iRecipe;
            if (recipe.matches(new RecipeWrapper(this.inventory), this.world)) {
                return recipe;
            }
        }
        return null;
    }

    @Override
    public ITextComponent getDefaultName() {
        return new TranslationTextComponent("container." + IndustrialMetallurgy.MOD_ID + ".FORGE_TIER4");
    }

}
