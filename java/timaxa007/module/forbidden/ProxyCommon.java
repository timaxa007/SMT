package timaxa007.module.forbidden;

import net.minecraftforge.common.MinecraftForge;
import timaxa007.api.IProxyModuleCommon;
import timaxa007.module.forbidden.event.EventOwner;

public class ProxyCommon implements IProxyModuleCommon {

	public void preInit() {

	}

	public void init() {

		MinecraftForge.EVENT_BUS.register(new EventOwner());

	}

	public void postInit() {
		
	}

}
