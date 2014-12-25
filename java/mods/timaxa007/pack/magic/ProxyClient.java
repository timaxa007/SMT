package mods.timaxa007.pack.magic;

import mods.timaxa007.pack.magic.event.EventMagicClient;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ProxyClient extends ProxyServer {

	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);

		MinecraftForge.EVENT_BUS.register(new EventMagicClient());

	}

	public void init() {
		super.init();

		render.init();

	}

}
