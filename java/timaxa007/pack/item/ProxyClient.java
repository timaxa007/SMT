package timaxa007.pack.item;

import net.minecraftforge.common.MinecraftForge;
import timaxa007.api.IProxyPackClient;
import timaxa007.pack.item.event.EventPackItemsClient;
import timaxa007.pack.item.render.RenderMain;

public class ProxyClient implements IProxyPackClient {

	@Override
	public void preInit() {
		MinecraftForge.EVENT_BUS.register(new EventPackItemsClient());
	}

	@Override
	public void init() {
		RenderMain.init();
	}

	@Override
	public void postInit() {
	}

}
