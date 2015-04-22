package timaxa007.pack.mining;

import net.minecraftforge.common.MinecraftForge;
import timaxa007.api.IProxyPackCommon;
import timaxa007.pack.mining.event.EventMining;
import timaxa007.pack.mining.render.RenderMain;

public class ProxyCommon implements IProxyPackCommon {

	@Override
	public void preInit() {

		MinecraftForge.EVENT_BUS.register(new EventMining());
		RenderMain.preInit();
		
	}

	@Override
	public void init() {
		
	}

	@Override
	public void postInit() {
		
	}

}
