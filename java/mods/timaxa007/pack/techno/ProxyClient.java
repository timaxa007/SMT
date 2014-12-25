package mods.timaxa007.pack.techno;

import mods.timaxa007.pack.techno.event.EventTechnoClient;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ProxyClient extends ProxyServer {

	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);

		MinecraftForge.EVENT_BUS.register(new EventTechnoClient());

	}

	public void init() {
		super.init();

		render.init();

	}

}
