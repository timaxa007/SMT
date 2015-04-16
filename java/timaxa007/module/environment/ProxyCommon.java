package timaxa007.module.environment;

import net.minecraftforge.common.MinecraftForge;
import timaxa007.api.IProxyModuleCommon;
import timaxa007.module.environment.util.EventEnvironment;
import cpw.mods.fml.common.FMLCommonHandler;

public class ProxyCommon implements IProxyModuleCommon {

	public void preInit() {

	}

	public void init() {

		MinecraftForge.EVENT_BUS.register(new EventEnvironment.Player());
		FMLCommonHandler.instance().bus().register(new EventEnvironment.Common());
	}

	public void postInit() {
		
	}

}
