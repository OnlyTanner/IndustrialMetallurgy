package com.onlytanner.industrialmetallurgy.jei.categories;

import com.onlytanner.industrialmetallurgy.client.gui.ExtruderScreen;
import com.onlytanner.industrialmetallurgy.jei.ItemStackDrawable;
import com.onlytanner.industrialmetallurgy.jei.ScreenDrawable;
import com.onlytanner.industrialmetallurgy.recipes.ExtruderRecipe;
import com.onlytanner.industrialmetallurgy.recipes.ExtruderRecipeBase;
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

public class ExtruderRecipeCategory implements IRecipeCategory<ExtruderRecipe> {

    @Override
    public ResourceLocation getUid() {
        return ExtruderRecipeBase.RECIPE_TYPE_ID;
    }

    @Override
    public Class<? extends ExtruderRecipe> getRecipeClass() {
        return ExtruderRecipe.class;
    }

    @Override
    public String getTitle() {
        return "Extruding";
    }

    @Override
    public IDrawable getBackground() {
        return new ScreenDrawable(ExtruderScreen.TEXTURE, 0, 0, 176, 166);
    }

    @Override
    public IDrawable getIcon() {
        return new ItemStackDrawable(new ItemStack(RegistryHandler.EXTRUDER_ITEM.get()));
    }

    @Override
    public void setIngredients(ExtruderRecipe extruderRecipe, IIngredients iIngredients) {
        iIngredients.setInputs(VanillaTypes.ITEM, Arrays.asList(extruderRecipe.getInput().getMatchingStacks()));
        iIngredients.setOutput(VanillaTypes.ITEM, extruderRecipe.getRecipeOutput());
    }

    @Override
    public void setRecipe(IRecipeLayout iRecipeLayout, ExtruderRecipe extruderRecipe, IIngredients iIngredients) {
        IGuiItemStackGroup guiItemStackGroup = iRecipeLayout.getItemStacks();
        guiItemStackGroup.init(0, true, 55, 34);
        guiItemStackGroup.init(1, false, 115, 34);
        guiItemStackGroup.set(0, iIngredients.getInputs(VanillaTypes.ITEM).get(0));
        guiItemStackGroup.set(1, iIngredients.getOutputs(VanillaTypes.ITEM).get(0));
    }

}