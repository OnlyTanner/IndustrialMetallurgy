package com.onlytanner.industrialmetallurgy.proxy;

import com.onlytanner.industrialmetallurgy.init.ModBlocks;
import com.onlytanner.industrialmetallurgy.init.ModItems;

public class ClientProxy implements CommonProxy {

    @Override
    public void init() {
        ModBlocks.registerRenders();
        ModItems.registerRenders();
    }
}
