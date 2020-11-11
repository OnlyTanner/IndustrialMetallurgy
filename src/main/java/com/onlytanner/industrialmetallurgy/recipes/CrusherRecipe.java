package com.onlytanner.industrialmetallurgy.recipes;

import com.onlytanner.industrialmetallurgy.tileentity.CrusherTileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.items.wrapper.RecipeWrapper;

import java.util.ArrayList;
import java.util.List;

public class CrusherRecipe implements ForgeRecipeBase {

    private final ResourceLocation id;
    private Ingredient input;
    private ItemStack output;

    public CrusherRecipe(ResourceLocation id, Ingredient input, ItemStack output) {
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
        for (int i = 0; i < CrusherTileEntity.NUM_INPUT_SLOTS; i++) {
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
        return RecipeSerializerInit.CRUSHER_SERIALIZER.get();
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return NonNullList.from(null, input);
    }
}
