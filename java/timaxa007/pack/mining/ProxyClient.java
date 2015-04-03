package timaxa007.pack.mining;

import net.minecraftforge.common.MinecraftForge;
import timaxa007.pack.api.IProxyPackClient;
import timaxa007.pack.mining.event.EventMiningClient;
import timaxa007.pack.mining.render.RenderMain;

public class ProxyClient implements IProxyPackClient {

	@Override
	public void preInit() {

		MinecraftForge.EVENT_BUS.register(new EventMiningClient());

	}

	@Override
	public void init() {

		RenderMain.init();

	}

	@Override
	public void postInit() {

	}

}
