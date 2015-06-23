package timaxa007.module.information;

import net.minecraftforge.common.MinecraftForge;
import timaxa007.api.IProxyModuleClient;
import timaxa007.module.information.event.EventClientInformation;

public class ProxyClient implements IProxyModuleClient {

	public void preInit() {

	}

	public void init() {
		MinecraftForge.EVENT_BUS.register(new EventClientInformation());
	}

	public void postInit() {

	}

}
