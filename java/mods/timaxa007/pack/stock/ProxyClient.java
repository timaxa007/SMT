package mods.timaxa007.pack.stock;

import mods.timaxa007.pack.stock.event.EventStockClient;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ProxyClient extends ProxyCommon {

	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);

		MinecraftForge.EVENT_BUS.register(new EventStockClient());

	}

	public void init() {
		super.init();

		render.init();

	}

}
