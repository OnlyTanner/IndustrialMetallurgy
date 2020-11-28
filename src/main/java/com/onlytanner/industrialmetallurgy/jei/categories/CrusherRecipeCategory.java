package com.onlytanner.industrialmetallurgy.jei.categories;

import com.onlytanner.industrialmetallurgy.client.gui.CrusherScreen;
import com.onlytanner.industrialmetallurgy.jei.ItemStackDrawable;
import com.onlytanner.industrialmetallurgy.jei.ScreenDrawable;
import com.onlytanner.industrialmetallurgy.recipes.CrusherRecipe;
import com.onlytanner.industrialmetallurgy.recipes.CrusherRecipeBase;
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

public class CrusherRecipeCategory implements IRecipeCategory<CrusherRecipe> {

    @Override
    public ResourceLocation getUid() {
        return CrusherRecipeBase.RECIPE_TYPE_ID;
    }

    @Override
    public Class<? extends CrusherRecipe> getRecipeClass() {
        return CrusherRecipe.class;
    }

    @Override
    public String getTitle() {
        return "Crushing";
    }

    @Override
    public IDrawable getBackground() {
        return new ScreenDrawable(CrusherScreen.TEXTURE, 0, 0, 176, 166);
    }

    @Override
    public IDrawable getIcon() {
        return new ItemStackDrawable(new ItemStack(RegistryHandler.CRUSHER_ITEM.get()));
    }

    @Override
    public void setIngredients(CrusherRecipe crusherRecipe, IIngredients iIngredients) {
        iIngredients.setInputs(VanillaTypes.ITEM, Arrays.asList(crusherRecipe.getInput().getMatchingStacks()));
        iIngredients.setOutput(VanillaTypes.ITEM, crusherRecipe.getRecipeOutput());
    }

    @Override
    public void setRecipe(IRecipeLayout iRecipeLayout, CrusherRecipe crusherRecipe, IIngredients iIngredients) {
        IGuiItemStackGroup guiItemStackGroup = iRecipeLayout.getItemStacks();
        guiItemStackGroup.init(0, true, 55, 34);
        guiItemStackGroup.init(1, true, 151, 7);
        guiItemStackGroup.init(2, true, 151, 61);
        guiItemStackGroup.init(3, false, 115, 34);
        guiItemStackGroup.set(0, iIngredients.getInputs(VanillaTypes.ITEM).get(0));
        guiItemStackGroup.set(1, new ItemStack(RegistryHandler.BRASS_BURR_SET.get()));
        guiItemStackGroup.set(2, new ItemStack(RegistryHandler.SULFURIC_ACID_BOTTLE.get()));
        guiItemStackGroup.set(3, iIngredients.getOutputs(VanillaTypes.ITEM).get(0));
    }

}