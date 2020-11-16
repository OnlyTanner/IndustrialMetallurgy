package com.onlytanner.industrialmetallurgy.recipes;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.items.wrapper.RecipeWrapper;

import java.util.ArrayList;
import java.util.List;

public class ChemicalCentrifugeRecipe implements ChemicalCentrifugeRecipeBase {

    private final ResourceLocation id;
    private Ingredient input;
    private List<ItemStack> output;

    public ChemicalCentrifugeRecipe(ResourceLocation id, Ingredient input, List<ItemStack> output) {
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
        List<ItemStack> invInput = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            if (inv.getStackInSlot(i) != ItemStack.EMPTY) {
                invInput.add(inv.getStackInSlot(i));
            }
        }
        if (invInput.size() != input.getMatchingStacks().length)
            return false;
        for (ItemStack stack : invInput)
            if (!input.test(stack))
                return false;
        return true;
    }

    public List<ItemStack> getAllOutput() {
        return output;
    }

    @Override
    public ItemStack getCraftingResult(RecipeWrapper inv) {
        return output.get(0);
    }

    @Override
    public ItemStack getRecipeOutput() {
        return output.get(0);
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return RecipeSerializerInit.CHEMICAL_CENTRIFUGE_SERIALIZER.get();
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return NonNullList.from(null, input);
    }
}
