package com.onlytanner.industrialmetallurgy.jei.categories;

import com.onlytanner.industrialmetallurgy.client.gui.SolderingStationScreen;
import com.onlytanner.industrialmetallurgy.jei.ItemStackDrawable;
import com.onlytanner.industrialmetallurgy.jei.ScreenDrawable;
import com.onlytanner.industrialmetallurgy.recipes.SolderingStationRecipe;
import com.onlytanner.industrialmetallurgy.recipes.SolderingStationRecipeBase;
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
import java.util.List;

public class SolderingStationRecipeCategory implements IRecipeCategory<SolderingStationRecipe> {

    @Override
    public ResourceLocation getUid() {
        return SolderingStationRecipeBase.RECIPE_TYPE_ID;
    }

    @Override
    public Class<? extends SolderingStationRecipe> getRecipeClass() {
        return SolderingStationRecipe.class;
    }

    @Override
    public String getTitle() {
        return "Soldering";
    }

    @Override
    public IDrawable getBackground() {
        return new ScreenDrawable(SolderingStationScreen.TEXTURE, 0, 0, 176, 166);
    }

    @Override
    public IDrawable getIcon() {
        return new ItemStackDrawable(new ItemStack(RegistryHandler.SOLDERING_STATION_ITEM.get()));
    }

    @Override
    public void setIngredients(SolderingStationRecipe solderingStationRecipe, IIngredients iIngredients) {
        iIngredients.setInputs(VanillaTypes.ITEM, Arrays.asList(solderingStationRecipe.getInput().getMatchingStacks()));
        iIngredients.setOutput(VanillaTypes.ITEM, solderingStationRecipe.getRecipeOutput());
    }

    @Override
    public void setRecipe(IRecipeLayout iRecipeLayout, SolderingStationRecipe solderingStationRecipe, IIngredients iIngredients) {
        IGuiItemStackGroup guiItemStackGroup = iRecipeLayout.getItemStacks();
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                guiItemStackGroup.init(index++, true, 41 + (j * 18), 16 + (i * 18));
            }
        }
        guiItemStackGroup.init(9, true, 131, 16);
        guiItemStackGroup.init(10, false, 135, 48);
        for (int i = 0; i < iIngredients.getInputs(VanillaTypes.ITEM).size(); i++) {
            guiItemStackGroup.set(i, iIngredients.getInputs(VanillaTypes.ITEM).get(i));
        }
        guiItemStackGroup.set(10, iIngredients.getOutputs(VanillaTypes.ITEM).get(0));
    }

}