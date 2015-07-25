package timaxa007.module.substance;

import timaxa007.api.IProxyModuleClient;

public class ProxyClient implements IProxyModuleClient {

	@Override
	public void preInit() {

	}

	@Override
	public void init() {

		//MinecraftForge.EVENT_BUS.register(new EventClient());
		//FMLCommonHandler.instance().bus().register(new EventClient());

	}

	@Override
	public void postInit() {

	}

}
