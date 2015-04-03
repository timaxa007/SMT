package timaxa007.module.effect;

import net.minecraftforge.common.MinecraftForge;
import timaxa007.module.api.IProxyModuleClient;
import timaxa007.module.effect.event.EventClient;

public class ProxyClient implements IProxyModuleClient {

	public void preInit() {

	}

	public void init() {

		MinecraftForge.EVENT_BUS.register(new EventClient());
		//FMLCommonHandler.instance().bus().register(new EventClient());

	}

	public void postInit() {

	}

}
