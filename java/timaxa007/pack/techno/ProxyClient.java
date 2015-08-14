package timaxa007.pack.techno;

import net.minecraftforge.common.MinecraftForge;
import timaxa007.api.IProxyPackClient;
import timaxa007.pack.techno.event.EventTechnoClient;
import timaxa007.pack.techno.render.RenderMain;

public class ProxyClient implements IProxyPackClient {

	@Override
	public void preInit() {

	}

	@Override
	public void init() {

		MinecraftForge.EVENT_BUS.register(new EventTechnoClient());

		RenderMain.init();

	}

	@Override
	public void postInit() {
		
	}

}
