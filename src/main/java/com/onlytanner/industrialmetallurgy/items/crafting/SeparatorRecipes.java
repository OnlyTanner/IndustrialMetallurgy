package com.onlytanner.industrialmetallurgy.items.crafting;

import java.util.ArrayList;

import javax.annotation.Nullable;

import com.onlytanner.industrialmetallurgy.init.ModItems;
import net.minecraft.init.Blocks;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SeparatorRecipes
{
    private static ArrayList<SeparatorRecipe> separatorList = new ArrayList<SeparatorRecipe>();
    private static final SeparatorRecipes SEPARATOR_RECIPES = new SeparatorRecipes();

    private SeparatorRecipes()
    {
        this.addSeparatorRecipe(new ItemStack(ModItems.bitumen, 1), new ItemStack(Items.GLASS_BOTTLE, 2), new ItemStack(ModItems.ethylene_bottle, 1), new ItemStack(ModItems.petroleum_bottle, 1), new ItemStack(Item.getItemFromBlock(Blocks.GRAVEL), 1), 1.05F);
        
    }

    public static SeparatorRecipes getInstance()
    {
        return SEPARATOR_RECIPES;
    }

    /**
     * Adds an alloy recipe using two ItemStacks as the input for the recipe.
     */
    public void addSeparatorRecipe(ItemStack input1, ItemStack input2, ItemStack output1, ItemStack output2, ItemStack output3, float experience)
    {
        ArrayList<ItemStack> inputs = new ArrayList<ItemStack>();
        inputs.add(input1);
        inputs.add(input2);
    }

    /**
     * Returns the alloy result of two items.
     */
    @Nullable
    public static ArrayList<ItemStack> getSeparatorResult(ItemStack item, ItemStack bottles)
    {
        for (SeparatorRecipe instance : separatorList) {
            ArrayList<ItemStack> temp = new ArrayList<ItemStack>();
            temp.add(item);
            temp.add(bottles);
            if (isValidForSmelting(temp, instance)) {
                return instance.getOutputs();
            }
        }
        return null;
    }
    
    public int getNumBottles(ItemStack item) {
        for (SeparatorRecipe instance : separatorList) {
            if (instance.getInputs().get(0).getItem() == item.getItem())
                return instance.getInputs().get(1).stackSize;
        }
        return 0;
    }

    /**
     * Returns the AlloyRecipe array representation of all the currently stored
     * alloy recipes
     *
     * @return AlloyRecipe array of all the alloy recipes
     */
    public ArrayList<SeparatorRecipe> getSmeltingList()
    {
        return this.separatorList;
    }

    public float getSmeltingExperience(ItemStack stack)
    {
        for (SeparatorRecipe instance : separatorList) {
            if (stack.getItem() == instance.inputs.get(0).getItem()) {
                return instance.getExperience();
            }
        }
        return 0.0F;
    }

    public static boolean isValidForSmelting(ArrayList<ItemStack> inputs, SeparatorRecipe instance)
    {
        int count = inputs.size();
        if (count != instance.getInputs().size())
            return false;
        
        for (ItemStack recipe : instance.getInputs()) {
            for (ItemStack itemStack : inputs)
                if (itemStack != null && itemStack.getItem() == recipe.getItem() && itemStack.stackSize >= recipe.stackSize)
                    count--;
            if (count == 0)
                return true;
        }
        return false;
    }

    public static boolean isPotentialInput(Item item)
    {
        for (SeparatorRecipe recipe : separatorList) {
            for (ItemStack itemStack : recipe.getInputs()) {
                if (itemStack.getItem() == item || itemStack.getItem() == item) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Representation of an alloy recipe which contains two input items and an
     * output. It also specifies the amount of experienced gained from any
     * specific recipe.
     *
     * @author Tanner Lisonbee
     */
    public class SeparatorRecipe
    {
        private ArrayList<ItemStack> inputs;
        private ArrayList<ItemStack> outputs;
        private Float experience;

        protected SeparatorRecipe(ArrayList<ItemStack> inputs, ArrayList<ItemStack> outputs, Float experience, int temperature)
        {
            this.inputs = inputs;
            this.outputs = outputs;
            this.experience = experience;
        }

        protected ArrayList<ItemStack> getInputs()
        {
            return inputs;
        }

        protected ArrayList<ItemStack> getOutputs()
        {
            return outputs;
        }

        protected Float getExperience()
        {
            return experience;
        }
    }
}
