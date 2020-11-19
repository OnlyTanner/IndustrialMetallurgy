package com.onlytanner.industrialmetallurgy.recipes;

import com.onlytanner.industrialmetallurgy.tileentity.SolderingStationTileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public class SolderingStationRecipe implements SolderingStationRecipeBase {

    private final ResourceLocation id;
    private Ingredient input;
    private ItemStack output;

    public SolderingStationRecipe(ResourceLocation id, Ingredient input, ItemStack output) {
        this.id = id;
        this.input = input;
        this.output = output;
    }

    @Override
    public Ingredient getInput() {
        return input;
    }

    @Override
    public boolean matches(RecipeWrapper inv, World worldIn) {
        ItemStack[] matchingStacks = input.getMatchingStacks();
        for (int i = 0; i < matchingStacks.length; i++) {
            if (!inv.getStackInSlot(i).getItem().equals(matchingStacks[i].getItem()))
                return false;
        }
        return true;
    }

    @Override
    public ItemStack getCraftingResult(RecipeWrapper inv) {
        return output;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return output;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return RecipeSerializerInit.SOLDERING_STATION_SERIALIZER.get();
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return NonNullList.from(null, input);
    }
}
