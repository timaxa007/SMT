package timaxa007.pack.item;

import net.minecraftforge.common.MinecraftForge;
import timaxa007.pack.api.IProxyPackCommon;
import timaxa007.pack.item.event.EventPackItems;
import timaxa007.pack.item.render.RenderMain;

public class ProxyCommon implements IProxyPackCommon {

	@Override
	public void preInit() {

		MinecraftForge.EVENT_BUS.register(new EventPackItems());

		RenderMain.preInit();

	}

	@Override
	public void init() {

	}

	@Override
	public void postInit() {

	}

}
