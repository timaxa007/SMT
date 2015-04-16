package timaxa007.pack.furniture;

import net.minecraftforge.common.MinecraftForge;
import timaxa007.api.IProxyPackClient;
import timaxa007.pack.furniture.event.EventFurnitureClient;
import timaxa007.pack.furniture.render.RenderMain;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ProxyClient implements IProxyPackClient {

	@Override
	public void preInit() {

		MinecraftForge.EVENT_BUS.register(new EventFurnitureClient());

	}

	@Override
	public void init() {

		RenderMain.init();

	}

	@Override
	public void postInit() {
		
	}

}
