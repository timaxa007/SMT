package timaxa007.module.weight;

import net.minecraftforge.common.MinecraftForge;
import timaxa007.api.IProxyModuleCommon;
import timaxa007.module.weight.util.EventWeight;
import cpw.mods.fml.common.FMLCommonHandler;

public class ProxyCommon implements IProxyModuleCommon {

	public void preInit() {

	}

	public void init() {

		MinecraftForge.EVENT_BUS.register(new EventWeight.Player());
		FMLCommonHandler.instance().bus().register(new EventWeight.Common());

	}

	public void postInit() {
		
	}

}
