package com.onlytanner.industrialmetallurgy.util;

import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

import java.util.function.Supplier;

public class ModItemTiers implements IItemTier {

    public static final IItemTier STEEL = new ModItemTiers(ItemTier.IRON.getHarvestLevel(), ItemTier.IRON.getMaxUses() * 3, ItemTier.DIAMOND.getEfficiency(), ItemTier.DIAMOND.getAttackDamage(), ItemTier.DIAMOND.getEnchantability(), () -> {
        return Ingredient.fromItems(RegistryHandler.STEEL_INGOT.get());
    });

    public static final IItemTier NEQUITUM = new ModItemTiers(ItemTier.NETHERITE.getHarvestLevel(), 0, ItemTier.NETHERITE.getEfficiency() + 1, ItemTier.NETHERITE.getAttackDamage() + 3, ItemTier.NETHERITE.getEnchantability() + 10, () -> {
        return Ingredient.fromItems(RegistryHandler.NEQUITUM_INGOT.get());
    });

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final LazyValue<Ingredient> repairMaterial;

    private ModItemTiers(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = new LazyValue<>(repairMaterial);
    }

    @Override
    public int getMaxUses() {
        return this.maxUses;
    }

    @Override
    public float getEfficiency() {
        return this.efficiency;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getHarvestLevel() {
        return this.harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.getValue();
    }

}
