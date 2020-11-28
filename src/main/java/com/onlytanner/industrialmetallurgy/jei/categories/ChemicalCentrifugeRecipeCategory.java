package com.onlytanner.industrialmetallurgy.jei.categories;

import com.onlytanner.industrialmetallurgy.client.gui.ChemicalCentrifugeScreen;
import com.onlytanner.industrialmetallurgy.jei.ItemStackDrawable;
import com.onlytanner.industrialmetallurgy.jei.ScreenDrawable;
import com.onlytanner.industrialmetallurgy.recipes.ChemicalCentrifugeRecipe;
import com.onlytanner.industrialmetallurgy.recipes.ChemicalCentrifugeRecipeBase;
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

public class ChemicalCentrifugeRecipeCategory implements IRecipeCategory<ChemicalCentrifugeRecipe> {

    @Override
    public ResourceLocation getUid() {
        return ChemicalCentrifugeRecipeBase.RECIPE_TYPE_ID;
    }

    @Override
    public Class<? extends ChemicalCentrifugeRecipe> getRecipeClass() {
        return ChemicalCentrifugeRecipe.class;
    }

    @Override
    public String getTitle() {
        return "Centrifuging";
    }

    @Override
    public IDrawable getBackground() {
        return new ScreenDrawable(ChemicalCentrifugeScreen.TEXTURE, 0, 0, 176, 166);
    }

    @Override
    public IDrawable getIcon() {
        return new ItemStackDrawable(new ItemStack(RegistryHandler.CHEMICAL_CENTRIFUGE_ITEM.get()));
    }

    @Override
    public void setIngredients(ChemicalCentrifugeRecipe chemicalCentrifugeRecipe, IIngredients iIngredients) {
        iIngredients.setInputs(VanillaTypes.ITEM, Arrays.asList(chemicalCentrifugeRecipe.getInput().getMatchingStacks()));
        iIngredients.setOutput(VanillaTypes.ITEM, chemicalCentrifugeRecipe.getRecipeOutput());
    }

    @Override
    public void setRecipe(IRecipeLayout iRecipeLayout, ChemicalCentrifugeRecipe chemicalCentrifugeRecipe, IIngredients iIngredients) {
        IGuiItemStackGroup guiItemStackGroup = iRecipeLayout.getItemStacks();
        guiItemStackGroup.init(0, true, 79, 16);
        guiItemStackGroup.init(1, true, 151, 7);
        guiItemStackGroup.init(2, false, 56, 50);
        guiItemStackGroup.init(3, false, 79, 57);
        guiItemStackGroup.init(4, false, 102, 50);
        guiItemStackGroup.set(0, iIngredients.getInputs(VanillaTypes.ITEM).get(0));
        if (iIngredients.getInputs(VanillaTypes.ITEM).size() > 1)
            guiItemStackGroup.set(1, iIngredients.getInputs(VanillaTypes.ITEM).get(1));
        List<ItemStack> outputs = chemicalCentrifugeRecipe.getAllOutput();
        guiItemStackGroup.set(2, outputs.get(0));
        guiItemStackGroup.set(3, outputs.get(1));
        guiItemStackGroup.set(4, outputs.get(2));
    }

}