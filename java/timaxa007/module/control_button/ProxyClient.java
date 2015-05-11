package timaxa007.module.control_button;

import net.minecraftforge.common.MinecraftForge;
import timaxa007.api.IProxyModuleClient;
import timaxa007.module.control_button.event.EventActionArmorKey;
import timaxa007.module.control_button.event.EventActionMouse;
import timaxa007.module.control_button.event.EventActionPrimaryKey;
import timaxa007.module.control_button.event.EventControlButtonClient;
import timaxa007.module.control_button.event.EventUpdateClient;
import timaxa007.module.control_button.util.RegKey;
import cpw.mods.fml.common.FMLCommonHandler;

public class ProxyClient implements IProxyModuleClient {

	public void preInit() {

		RegKey.preInit();

	}

	public void init() {

		MinecraftForge.EVENT_BUS.register(new EventControlButtonClient());
		FMLCommonHandler.instance().bus().register(new EventUpdateClient());
		//MinecraftForge.EVENT_BUS.register(new EventMouse());
		FMLCommonHandler.instance().bus().register(new EventActionMouse());
		FMLCommonHandler.instance().bus().register(new EventActionPrimaryKey());
		FMLCommonHandler.instance().bus().register(new EventActionArmorKey());

	}

	public void postInit() {

	}

}
