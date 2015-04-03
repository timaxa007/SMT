package timaxa007.pack.furniture;

import net.minecraftforge.common.MinecraftForge;
import timaxa007.pack.api.IProxyPackCommon;
import timaxa007.pack.furniture.event.EventFurniture;
import timaxa007.pack.furniture.render.RenderMain;

public class ProxyCommon implements IProxyPackCommon {

	@Override
	public void preInit() {

		MinecraftForge.EVENT_BUS.register(new EventFurniture());

		RenderMain.preInit();
		
	}

	@Override
	public void init() {

	}

	@Override
	public void postInit() {
		
	}

}
