package com.onlytanner.industrialmetallurgy.items.crafting;

import java.util.ArrayList;

import javax.annotation.Nullable;

import com.onlytanner.industrialmetallurgy.init.ModBlocks;
import com.onlytanner.industrialmetallurgy.init.ModItems;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ForgeRecipes {

    private static ArrayList<AlloyRecipe> smeltingList = new ArrayList<AlloyRecipe>();
    private int size;
    private static final ForgeRecipes FORGE_RECIPES = new ForgeRecipes();

    private ForgeRecipes() {
        size = 1;
        this.addAlloyRecipe(new ItemStack(ModItems.copper_ingot, 2), new ItemStack(ModItems.zinc_ingot), new ItemStack(ModItems.brass_ingot, 3), 1.05F, 1700);
        this.addAlloyRecipe(new ItemStack(ModItems.copper_ingot, 3), new ItemStack(ModItems.tin_ingot), new ItemStack(ModItems.bronze_ingot, 4), 1.4F, 1900);
        this.addAlloyRecipe(new ItemStack(Items.IRON_INGOT, 2), new ItemStack(ModItems.nickel_ingot), new ItemStack(ModItems.invar_ingot, 3), 1.05F, 2600);
        this.addAlloyRecipe(new ItemStack(ModItems.nickel_ingot, 4), new ItemStack(ModItems.chromium_ingot), new ItemStack(ModItems.nichrome_ingot, 5), 1.75F, 2600);
        this.addAlloyRecipe(new ItemStack(ModItems.nickel_ingot), new ItemStack(ModItems.titanium_ingot), new ItemStack(ModItems.nitinol_ingot, 2), 0.7F, 2400);
        this.addAlloyRecipe(new ItemStack(Items.IRON_INGOT), new ItemStack(ModItems.crushed_coal, 4), new ItemStack(ModItems.steel_ingot), 0.35F, 2700);
        this.addAlloyRecipe(new ItemStack(ModItems.cobalt_steel_ingot, 4), new ItemStack(ModItems.steel_ingot, 3), new ItemStack(ModItems.cobalt_ingot), 0.35F, 4700);
    }

    public static ForgeRecipes getInstance() {
        return FORGE_RECIPES;
    }

    /**
     * Adds an alloy recipe using two ItemStacks as the input for the recipe.
     */
    public void addAlloyRecipe(ItemStack input1, ItemStack input2, ItemStack stack, float experience, int temperature) {
        smeltingList.add(new AlloyRecipe(input1, input2, stack, experience, temperature));
        size++;
    }

    /**
     * Returns the alloy result of two items.
     */
    @Nullable
    public static ItemStack getAlloyResult(ItemStack input1, ItemStack input2) {
        for (AlloyRecipe instance : smeltingList) {
            if (isValidForSmelting(input1, input2, instance)) {
                return instance.getOutput();
            }
        }
        return null;
    }

    @Nullable
    public static ItemStack[] getReducedStacks(ItemStack input1, ItemStack input2) {
        ItemStack[] stack = new ItemStack[2];
        for (AlloyRecipe instance : smeltingList) {
            if (input1.getItem() == instance.getInput1().getItem() && input2.getItem() == instance.getInput2().getItem()) {
                stack[0] = instance.getInput1();
                stack[1] = instance.getInput2();
            } else if (input1.getItem() == instance.getInput2().getItem() && input2.getItem() == instance.getInput1().getItem()) {
                stack[0] = instance.getInput2();
                stack[1] = instance.getInput1();
            }
        }
        return stack;
    }

    /**
     * Returns the AlloyRecipe array representation of all the currently stored
     * alloy recipes
     *
     * @return AlloyRecipe array of all the alloy recipes
     */
    public ArrayList<AlloyRecipe> getSmeltingList() {
        return this.smeltingList;
    }

    public float getSmeltingExperience(ItemStack stack) {
        for (AlloyRecipe instance : smeltingList) {
            if (stack.getItem() == instance.getOutput().getItem()) {
                return instance.getExperience();
            }
        }
        return 0.0F;
    }

    public static boolean isValidForSmelting(ItemStack stack1, ItemStack stack2, AlloyRecipe recipe) {
        if ((((stack1.getItem() == recipe.getInput1().getItem()) && stack1.stackSize >= recipe.getInput1().stackSize)
                && (stack2.getItem() == recipe.getInput2().getItem() && stack2.stackSize >= recipe.getInput2().stackSize))
                || (((stack1.getItem() == recipe.getInput2().getItem()) && stack1.stackSize >= recipe.getInput2().stackSize)
                && (stack2.getItem() == recipe.getInput1().getItem() && stack2.stackSize >= recipe.getInput1().stackSize))) {
            return true;
        } else;
        return false;
    }

    public static boolean isPotentialInput(Item item) {
        for (AlloyRecipe recipe : smeltingList) {
            if (recipe.getInput1().getItem() == item || recipe.getInput2().getItem() == item) {
                return true;
            }
        }
        return false;
    }

    public static int getTemperature(Item metal) {
        if (metal != null) {
            for (AlloyRecipe recipe : smeltingList) {
                if (metal == recipe.getOutput().getItem()) {
                    return recipe.getTemperature();
                }
            }
        }
        return 1000;
    }

    /**
     * Representation of an alloy recipe which contains two input items and an
     * output. It also specifies the amount of experienced gained from any
     * specific recipe.
     *
     * @author Tanner Lisonbee
     */
    public class AlloyRecipe {

        private ItemStack input1, input2, output;
        private Float experience;
        private int temperature;

        protected AlloyRecipe(ItemStack input1, ItemStack input2, ItemStack output, Float experience, int temperature) {
            this.input1 = input1;
            this.input2 = input2;
            this.output = output;
            this.experience = experience;
            this.temperature = temperature;
        }

        protected ItemStack getInput1() {
            return input1;
        }

        protected ItemStack getInput2() {
            return input2;
        }

        protected ItemStack getOutput() {
            return output;
        }

        protected Float getExperience() {
            return experience;
        }

        protected int getTemperature() {
            return temperature;
        }
    }
}
