package com.onlytanner.industrialmetallurgy.jei.categories;

import com.onlytanner.industrialmetallurgy.client.gui.CokeOvenScreen;
import com.onlytanner.industrialmetallurgy.jei.ItemStackDrawable;
import com.onlytanner.industrialmetallurgy.jei.ScreenDrawable;
import com.onlytanner.industrialmetallurgy.recipes.CokeOvenRecipe;
import com.onlytanner.industrialmetallurgy.recipes.CokeOvenRecipeBase;
import com.onlytanner.industrialmetallurgy.util.RegistryHandler;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.util.Arrays;

public class CokeOvenRecipeCategory implements IRecipeCategory<CokeOvenRecipe> {

    @Override
    public ResourceLocation getUid() {
        return CokeOvenRecipeBase.RECIPE_TYPE_ID;
    }

    @Override
    public Class<? extends CokeOvenRecipe> getRecipeClass() {
        return CokeOvenRecipe.class;
    }

    @Override
    public String getTitle() {
        return "Coking";
    }

    @Override
    public IDrawable getBackground() {
        return new ScreenDrawable(CokeOvenScreen.TEXTURE, 0, 0, 176, 166);
    }

    @Override
    public IDrawable getIcon() {
        return new ItemStackDrawable(new ItemStack(RegistryHandler.COKE_OVEN_ITEM.get()));
    }

    @Override
    public void setIngredients(CokeOvenRecipe cokeOvenRecipe, IIngredients iIngredients) {
        iIngredients.setInputs(VanillaTypes.ITEM, Arrays.asList(cokeOvenRecipe.getInput().getMatchingStacks()));
        iIngredients.setOutput(VanillaTypes.ITEM, cokeOvenRecipe.getRecipeOutput());
    }

    @Override
    public void setRecipe(IRecipeLayout iRecipeLayout, CokeOvenRecipe cokeOvenRecipe, IIngredients iIngredients) {
        IGuiItemStackGroup guiItemStackGroup = iRecipeLayout.getItemStacks();
        guiItemStackGroup.init(0, true, 55, 34);
        guiItemStackGroup.init(1, false, 115, 34);
        guiItemStackGroup.set(0, iIngredients.getInputs(VanillaTypes.ITEM).get(0));
        guiItemStackGroup.set(1, iIngredients.getOutputs(VanillaTypes.ITEM).get(0));
    }

}