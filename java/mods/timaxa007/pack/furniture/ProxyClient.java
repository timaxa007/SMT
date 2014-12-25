package mods.timaxa007.pack.furniture;

import mods.timaxa007.pack.furniture.event.EventFurnitureClient;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ProxyClient extends ProxyServer {

	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);

		MinecraftForge.EVENT_BUS.register(new EventFurnitureClient());

	}

	@Override
	public void init() {
		super.init();

		render.init();

	}

}
