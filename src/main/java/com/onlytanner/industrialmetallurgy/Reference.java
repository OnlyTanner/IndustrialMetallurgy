package com.onlytanner.industrialmetallurgy;

public class Reference {
    public static final String MOD_ID = "industrialmetallurgy";
    public static final String NAME = "Industrial Metallurgy";
    public static final String VERSION = "1.0";
    public static final String ACCEPTED_VERSIONS = "[1.10.2]";

    public static final String CLIENT_PROXY_CLASS = "com.onlytanner.industrialmetallurgy.proxy.ClientProxy";
    public static final String SERVER_PROXY_CLASS = "com.onlytanner.industrialmetallurgy.proxy.ServerProxy";

    public static enum IndustrialMetallurgyItems {
        REFRACTORY_COMPOSITE("refractory_composite", "ItemRefractoryComposite"),
        REFRACTORY_BRICK("refractory_brick", "ItemRefractoryBrick"),
        COAL_COKE("coal_coke", "ItemCoalCoke"),
        FERTILIZER("fertilizer", "ItemFertilizer"),
        BITUMEN("bitumen", "ItemBitumen"),
        PEAT("peat", "ItemPeat"),
        SULFUR("sulfur", "ItemSulfur"),
        POTASSIUM_NITRATE("potassium_nitrate", "ItemPotassiumNitrate"),
        CRUSHED_COAL("crushed_coal", "ItemCrushedCoal"),
        CRUSHED_DIAMOND("crushed_diamond", "ItemCrushedDiamond"),
        TUNGSTEN_CARBIDE_DUST("tungsten_carbide_dust", "ItemTungstenCarbideDust"),
        SULFURIC_ACID_BOTTLE("sulfuric_acid_bottle", "ItemSulfuricAcidBottle"),
        METHANE_BOTTLE("methane_bottle", "ItemMethaneBottle"),
        PETROLEUM_BOTTLE("petroleum_bottle", "ItemPetroleumBottle"),
        ETHYLENE_BOTTLE("ethylene_bottle", "ItemEthyleneBottle"),
        MEMORY_WIRE("memory_wire", "ItemMemoryWire"),
        RESISTANCE_WIRE("resistance_wire", "ItemResistanceWire"),
        MAGNET_WIRE("magnet_wire", "ItemMagnetWire"),
        HDPE_SHEET("hdpe_sheet", "ItemHDPESheet"),
        STATOR("stator", "ItemStator"),
        ROTOR("rotor", "ItemRotor"),
        FIELD_COIL("field_coil", "ItemFieldCoil"),
        ELECTRIC_MOTOR("electric_motor", "ItemElectricMotor"),
        BATTERY_CELL("battery_cell", "ItemBatteryCell"),
        BATTERY_BANK("battery_bank", "ItemBatteryBank"),
        CONDUCTING_ELEMENT("conducting_element", "ItemConductingElement"),
        HEATING_ELEMENT("heating_element", "ItemHeatingElement"),
        INDUCTION_CORE("induction_core", "ItemInductionCore"),
        CRUSHED_BAUXITE_ORE("crushed_bauxite_ore", "ItemCrushedBauxiteOre"),
        CRUSHED_CASSITERITE_ORE("crushed_cassiterite_ore", "ItemCrushedCassiteriteOre"),
        CRUSHED_CHROMITE_ORE("crushed_chromite_ore", "ItemCrushedChromiteOre"),
        CRUSHED_COBALTITE_ORE("crushed_cobaltite_ore", "ItemCrushedCobaltiteOre"),
        CRUSHED_CUPRITE_ORE("crushed_cuprite_ore", "ItemCrushedCupriteOre"),
        CRUSHED_GARNIERITE_ORE("crushed_garnierite_ore", "ItemCrushedGarnieriteOre"),
        CRUSHED_GOLD_ORE("crushed_gold_ore", "ItemCrushedGoldOre"),
        CRUSHED_IRON_ORE("crushed_iron_ore", "ItemCrushedIronOre"),
        CRUSHED_RUTILE_ORE("crushed_rutile_ore", "ItemCrushedRutileOre"),
        CRUSHED_SPHALERITE_ORE("crushed_sphalerite_ore", "ItemCrushedSphaleriteOre"),
        CRUSHED_WOLFRAMITE_ORE("crushed_wolframite_ore", "ItemCrushedWolframiteOre"),
        ALLOY7201_INGOT("alloy7201_ingot", "ItemAlloy7201Ingot"),
        ALUMINUM_INGOT("aluminum_ingot", "ItemAluminumIngot"),
        BRASS_INGOT("brass_ingot", "ItemBrassIngot"),
        BRONZE_INGOT("bronze_ingot", "ItemBronzeIngot"),
        CHROMIUM_INGOT("chromium_ingot", "ItemChromiumIngot"),
        COBALT_INGOT("cobalt_ingot", "ItemCobaltIngot"),
        COBALT_STEEL_INGOT("cobalt_steel_ingot", "ItemCobaltSteelIngot"),
        COPPER_INGOT("copper_ingot", "ItemCopperIngot"),
        INVAR_INGOT("invar_ingot", "ItemInvarIngot"),
        KANTHAL_INGOT("kanthal_ingot", "ItemKanthalIngot"),
        NICHROME_INGOT("nichrome_ingot", "ItemNichromeIngot"),
        NICKEL_INGOT("nickel_ingot", "ItemNickelIngot"),
        NITINOL_INGOT("nitinol_ingot", "ItemNitinolIngot"),
        STEEL_INGOT("steel_ingot", "ItemSteelIngot"),
        TIN_INGOT("tin_ingot", "ItemTinIngot"),
        TITANIUM_INGOT("titanium_ingot", "ItemTitaniumIngot"),
        TUNGSTEN_STEEL_INGOT("tungsten_steel_ingot", "ItemTungstenSteelIngot"),
        TUNGSTEN_INGOT("tungsten_ingot", "ItemTungstenIngot"),
        ZINC_INGOT("zinc_ingot", "ItemZincIngot"),
        ALLOY7201_NUGGET("alloy7201_nugget", "ItemAlloy7201Nugget"),
        ALUMINUM_NUGGET("aluminum_nugget", "ItemAluminumNugget"),
        BRASS_NUGGET("brass_nugget", "ItemBrassNugget"),
        BRONZE_NUGGET("bronze_nugget", "ItemBronzeNugget"),
        CHROMIUM_NUGGET("chromium_nugget", "ItemChromiumNugget"),
        COBALT_NUGGET("cobalt_nugget", "ItemCobaltNugget"),
        COBALT_STEEL_NUGGET("cobalt_steel_nugget", "ItemCobaltSteelNugget"),
        COPPER_NUGGET("copper_nugget", "ItemCopperNugget"),
        INVAR_NUGGET("invar_nugget", "ItemInvarNugget"),
        KANTHAL_NUGGET("kanthal_nugget", "ItemKanthalNugget"),
        IRON_NUGGET("iron_nugget", "ItemIronNugget"),
        NICHROME_NUGGET("nichrome_nugget", "ItemNichromeNugget"),
        NICKEL_NUGGET("nickel_nugget", "ItemNickelNugget"),
        NITINOL_NUGGET("nitinol_nugget", "ItemNitinolNugget"),
        STEEL_NUGGET("steel_nugget", "ItemSteelNugget"),
        TIN_NUGGET("tin_nugget", "ItemTinNugget"),
        TITANIUM_NUGGET("titanium_nugget", "ItemTitaniumNugget"),
        TUNGSTEN_NUGGET("tungsten_nugget", "ItemTungstenNugget"),
        TUNGSTEN_STEEL_NUGGET("tungsten_steel_nugget", "ItemTungstenSteelNugget"),
        ZINC_NUGGET("zinc_nugget", "ItemZincNugget"),
        ALLOY7201_PICKAXE("alloy7201_pickaxe", "ItemAlloy7201Pickaxe"),
        ALUMINUM_PICKAXE("aluminum_pickaxe", "ItemAluminumPickaxe"),
        BRASS_PICKAXE("brass_pickaxe", "ItemBrassPickaxe"),
        BRONZE_PICKAXE("bronze_pickaxe", "ItemBronzePickaxe"),
        CHROMIUM_PICKAXE("chromium_pickaxe", "ItemChromiumPickaxe"),
        COBALT_PICKAXE("cobalt_pickaxe", "ItemCobaltPickaxe"),
        COPPER_PICKAXE("copper_pickaxe", "ItemCopperPickaxe"),
        INVAR_PICKAXE("invar_pickaxe", "ItemInvarPickaxe"),
        NICHROME_PICKAXE("nichrome_pickaxe", "ItemNichromePickaxe"),
        NICKEL_PICKAXE("nickel_pickaxe", "ItemNickelPickaxe"),
        NITINOL_PICKAXE("nitinol_pickaxe", "ItemNitinolPickaxe"),
        STEEL_PICKAXE("steel_pickaxe", "ItemSteelPickaxe"),
        TIN_PICKAXE("tin_pickaxe", "ItemTinPickaxe"),
        TITANIUM_PICKAXE("titanium_pickaxe", "ItemTitaniumPickaxe"),
        TUNGSTEN_PICKAXE("tungsten_pickaxe", "ItemTungstenPickaxe"),
        ZINC_PICKAXE("zinc_pickaxe", "ItemZincPickaxe"),
        ALLOY7201_SWORD("alloy7201_sword", "ItemAlloy7201Sword"),
        ALUMINUM_SWORD("aluminum_sword", "ItemAluminumSword"),
        BRASS_SWORD("brass_sword", "ItemBrassSword"),
        BRONZE_SWORD("bronze_sword", "ItemBronzeSword"),
        CHROMIUM_SWORD("chromium_sword", "ItemChromiumSword"),
        COBALT_SWORD("cobalt_sword", "ItemCobaltSword"),
        COPPER_SWORD("copper_sword", "ItemCopperSword"),
        INVAR_SWORD("invar_sword", "ItemInvarSword"),
        NICHROME_SWORD("nichrome_sword", "ItemNichromeSword"),
        NICKEL_SWORD("nickel_sword", "ItemNickelSword"),
        NITINOL_SWORD("nitinol_sword", "ItemNitinolSword"),
        STEEL_SWORD("steel_sword", "ItemSteelSword"),
        TIN_SWORD("tin_sword", "ItemTinSword"),
        TITANIUM_SWORD("titanium_sword", "ItemTitaniumSword"),
        TUNGSTEN_SWORD("tungsten_sword", "ItemTungstenSword"),
        ZINC_SWORD("zinc_sword", "ItemZincSword"),
        ALLOY7201_SHOVEL("alloy7201_shovel", "ItemAlloy7201Shovel"),
        ALUMINUM_SHOVEL("aluminum_shovel", "ItemAluminumShovel"),
        BRASS_SHOVEL("brass_shovel", "ItemBrassShovel"),
        BRONZE_SHOVEL("bronze_shovel", "ItemBronzeShovel"),
        CHROMIUM_SHOVEL("chromium_shovel", "ItemChromiumShovel"),
        COBALT_SHOVEL("cobalt_shovel", "ItemCobaltShovel"),
        COPPER_SHOVEL("copper_shovel", "ItemCopperShovel"),
        INVAR_SHOVEL("invar_shovel", "ItemInvarShovel"),
        NICHROME_SHOVEL("nichrome_shovel", "ItemNichromeShovel"),
        NICKEL_SHOVEL("nickel_shovel", "ItemNickelShovel"),
        NITINOL_SHOVEL("nitinol_shovel", "ItemNitinolShovel"),
        STEEL_SHOVEL("steel_shovel", "ItemSteelShovel"),
        TIN_SHOVEL("tin_shovel", "ItemTinShovel"),
        TITANIUM_SHOVEL("titanium_shovel", "ItemTitaniumShovel"),
        TUNGSTEN_SHOVEL("tungsten_shovel", "ItemTungstenShovel"),
        ZINC_SHOVEL("zinc_shovel", "ItemZincShovel"),
        ALLOY7201_AXE("alloy7201_axe", "ItemAlloy7201Axe"),
        ALUMINUM_AXE("aluminum_axe", "ItemAluminumAxe"),
        BRASS_AXE("brass_axe", "ItemBrassAxe"),
        BRONZE_AXE("bronze_axe", "ItemBronzeAxe"),
        CHROMIUM_AXE("chromium_axe", "ItemChromiumAxe"),
        COBALT_AXE("cobalt_axe", "ItemCobaltAxe"),
        COPPER_AXE("copper_axe", "ItemCopperAxe"),
        INVAR_AXE("invar_axe", "ItemInvarAxe"),
        NICHROME_AXE("nichrome_axe", "ItemNichromeAxe"),
        NICKEL_AXE("nickel_axe", "ItemNickelAxe"),
        NITINOL_AXE("nitinol_axe", "ItemNitinolAxe"),
        STEEL_AXE("steel_axe", "ItemSteelAxe"),
        TIN_AXE("tin_axe", "ItemTinAxe"),
        TITANIUM_AXE("titanium_axe", "ItemTitaniumAxe"),
        TUNGSTEN_AXE("tungsten_axe", "ItemTungstenAxe"),
        ZINC_AXE("zinc_axe", "ItemZincAxe"),
        ALLOY7201_HOE("alloy7201_hoe", "ItemAlloy7201Hoe"),
        ALUMINUM_HOE("aluminum_hoe", "ItemAluminumHoe"),
        BRASS_HOE("brass_hoe", "ItemBrassHoe"),
        BRONZE_HOE("bronze_hoe", "ItemBronzeHoe"),
        CHROMIUM_HOE("chromium_hoe", "ItemChromiumHoe"),
        COBALT_HOE("cobalt_hoe", "ItemCobaltHoe"),
        COPPER_HOE("copper_hoe", "ItemCopperHoe"),
        INVAR_HOE("invar_hoe", "ItemInvarHoe"),
        NICHROME_HOE("nichrome_hoe", "ItemNichromeHoe"),
        NICKEL_HOE("nickel_hoe", "ItemNickelHoe"),
        NITINOL_HOE("nitinol_hoe", "ItemNitinolHoe"),
        STEEL_HOE("steel_hoe", "ItemSteelHoe"),
        TIN_HOE("tin_hoe", "ItemTinHoe"),
        TITANIUM_HOE("titanium_hoe", "ItemTitaniumHoe"),
        TUNGSTEN_HOE("tungsten_hoe", "ItemTungstenHoe"),
        ZINC_HOE("zinc_hoe", "ItemZincHoe");

        private String unlocalizedName;
        private String registryName;

        IndustrialMetallurgyItems(String unlocalizedName, String registryName) {
            this.unlocalizedName = unlocalizedName;
            this.registryName = registryName;
        }

        public String getUnlocalizedName() {
            return unlocalizedName;
        }

        public String getRegistryName() {
            return registryName;
        }
    }

    public static enum IndustrialMetallurgyBlocks {
        BAUXITE_ORE("bauxite_ore", "BlockBauxiteOre"),
        CASSITERITE_ORE("cassiterite_ore", "BlockCassiteriteOre"),
        CHROMITE_ORE("chromite_ore", "BlockChromiteOre"),
        COBALTITE_ORE("cobaltite_ore", "BlockCobaltiteOre"),
        CUPRITE_ORE("cuprite_ore", "BlockCupriteOre"),
        GARNIERITE_ORE("garnierite_ore", "BlockGarnieriteOre"),
        RUTILE_ORE("rutile_ore", "BlockRutileOre"),
        SPHALERITE_ORE("sphalerite_ore", "BlockSphaleriteOre"),
        WOLFRAMITE_ORE("wolframite_ore", "BlockWolframiteOre"),
        COPPER_BLOCK("copper_block", "BlockCopperBlock"),
        TIN_BLOCK("tin_block", "BlockTinBlock"),
        CHROMIUM_BLOCK("chromium_block", "BlockChromiumBlock"),
        COBALT_BLOCK("cobalt_block", "BlockCobaltBlock"),
        COBALT_STEEL_BLOCK("cobalt_steel_block", "BlockCobaltSteelBlock"),
        TUNGSTEN_BLOCK("tungsten_block", "BlockTungstenBlock"),
        TUNGSTEN_STEEL_BLOCK("tungsten_steel_block", "BlockTungstenSteelBlock"),
        ZINC_BLOCK("zinc_block", "BlockZincBlock"),
        ALUMINUM_BLOCK("aluminum_block", "BlockAluminumBlock"),
        NICKEL_BLOCK("nickel_block", "BlockNickelBlock"),
        TITANIUM_BLOCK("titanium_block", "BlockTitaniumBlock"),
        BRONZE_BLOCK("bronze_block", "BlockBronzeBlock"),
        BRASS_BLOCK("brass_block", "BlockBrassBlock"),
        NICHROME_BLOCK("nichrome_block", "BlockNichromeBlock"),
        INVAR_BLOCK("invar_block", "BlockInvarBlock"),
        NITINOL_BLOCK("nitinol_block", "BlockNitinolBlock"),
        STEEL_BLOCK("steel_block", "BlockSteelBlock"),
        REFRACTORY_BRICKS("refractory_bricks", "BlockRefractoryBricks"),
        IRON_FORGE_CORE("iron_forge_core", "BlockIronForgeCore"),
        COBALT_FORGE_CORE("cobalt_forge_core", "BlockCobaltForgeCore"),
        TUNGSTEN_FORGE_CORE("tungsten_forge_core", "BlockTungstenForgeCore"),
        FORGE_TIER1("forge_tier1", "BlockForgeTier1"),
        FORGE_TIER2("forge_tier2", "BlockForgeTier2"),
        FORGE_TIER3("forge_tier3", "BlockForgeTier3"),
        LIT_FORGE_TIER1("lit_forge_tier1", "BlockLitForgeTier1"),
        LIT_FORGE_TIER2("lit_forge_tier2", "BlockLitForgeTier2"),
        LIT_FORGE_TIER3("lit_forge_tier3", "BlockLitForgeTier3"),
        COKE_OVEN("coke_oven", "BlockCokeOven"),
        LIT_COKE_OVEN("lit_coke_oven", "BlockLitCokeOven"),
        //BELLOW("bellow", "BlockBellow"),
        CRUSHER("crusher", "BlockCrusher"),
        COAL_GENERATOR("coal_generator", "BlockCoalGenerator"),
        LIT_COAL_GENERATOR("lit_coal_generator", "BlockLitCoalGenerator");

        private String unlocalizedName;
        private String registryName;

        IndustrialMetallurgyBlocks(String unlocalizedName, String registryName) {
            this.unlocalizedName = unlocalizedName;
            this.registryName = registryName;
        }

        public String getUnlocalizedName() {
            return unlocalizedName;
        }

        public String getRegistryName() {
            return registryName;
        }
    }
}
