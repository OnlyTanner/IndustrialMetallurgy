package com.onlytanner.industrialmetallurgy.jei.categories;

import com.onlytanner.industrialmetallurgy.client.gui.ChemicalReactorScreen;
import com.onlytanner.industrialmetallurgy.jei.ItemStackDrawable;
import com.onlytanner.industrialmetallurgy.jei.ScreenDrawable;
import com.onlytanner.industrialmetallurgy.recipes.ChemicalReactorRecipe;
import com.onlytanner.industrialmetallurgy.recipes.ChemicalReactorRecipeBase;
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

public class ChemicalReactorRecipeCategory implements IRecipeCategory<ChemicalReactorRecipe> {

    @Override
    public ResourceLocation getUid() {
        return ChemicalReactorRecipeBase.RECIPE_TYPE_ID;
    }

    @Override
    public Class<? extends ChemicalReactorRecipe> getRecipeClass() {
        return ChemicalReactorRecipe.class;
    }

    @Override
    public String getTitle() {
        return "Reacting";
    }

    @Override
    public IDrawable getBackground() {
        return new ScreenDrawable(ChemicalReactorScreen.TEXTURE, 0, 0, 176, 166);
    }

    @Override
    public IDrawable getIcon() {
        return new ItemStackDrawable(new ItemStack(RegistryHandler.CHEMICAL_REACTOR_ITEM.get()));
    }

    @Override
    public void setIngredients(ChemicalReactorRecipe chemicalReactorRecipe, IIngredients iIngredients) {
        iIngredients.setInputs(VanillaTypes.ITEM, Arrays.asList(chemicalReactorRecipe.getInput().getMatchingStacks()));
        iIngredients.setOutput(VanillaTypes.ITEM, chemicalReactorRecipe.getRecipeOutput());
    }

    @Override
    public void setRecipe(IRecipeLayout iRecipeLayout, ChemicalReactorRecipe chemicalReactorRecipe, IIngredients iIngredients) {
        IGuiItemStackGroup guiItemStackGroup = iRecipeLayout.getItemStacks();
        guiItemStackGroup.init(0, true, 56, 23);
        guiItemStackGroup.init(1, true, 79, 16);
        guiItemStackGroup.init(2, true, 102, 23);
        guiItemStackGroup.init(3, false, 79, 57);
        guiItemStackGroup.init(4, false, 151, 61);
        guiItemStackGroup.set(0, iIngredients.getInputs(VanillaTypes.ITEM).get(0));
        guiItemStackGroup.set(1, iIngredients.getInputs(VanillaTypes.ITEM).get(1));
        guiItemStackGroup.set(2, iIngredients.getInputs(VanillaTypes.ITEM).get(2));
        List<ItemStack> outputs = chemicalReactorRecipe.getAllOutput();
        guiItemStackGroup.set(3, outputs.get(0));
        if (outputs.size() > 1)
            guiItemStackGroup.set(4, outputs.get(1));
    }

}