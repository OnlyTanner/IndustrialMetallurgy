package com.onlytanner.test.proxy;

import com.onlytanner.test.init.ModBlocks;
import com.onlytanner.test.init.ModItems;

public class ClientProxy implements CommonProxy 
{
	@Override
	public void init() {
		ModItems.registerRenders();
		ModBlocks.registerRenders();
	}
}
