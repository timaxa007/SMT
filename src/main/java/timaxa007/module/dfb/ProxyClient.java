package timaxa007.module.dfb;

import net.minecraftforge.common.MinecraftForge;
import timaxa007.module.api.IModuleClientSMT;

public class ProxyClient implements IModuleClientSMT {

	@Override
	public void preInit() {
		MinecraftForge.EVENT_BUS.register(new timaxa007.module.dfb.event.EventDurabilityBlockClient());
	}

	@Override
	public void init() {

	}

	@Override
	public void postInit() {

	}

}
