package timaxa007.core;

import net.minecraftforge.common.MinecraftForge;
import timaxa007.core.event.EventItemStorageClient;
import timaxa007.core.event.EventSMT_Client;
import timaxa007.module.ModuleHelper;
import timaxa007.module.RegistrationModules;
import timaxa007.pack.PackHelper;
import timaxa007.pack.RegistrationPacks;
import cpw.mods.fml.common.FMLCommonHandler;

public class ProxyClient extends ProxyCommon {

	public void preInit() {
		super.preInit();
		RegistrationModules.verificationClient();
		RegistrationPacks.verificationClient();

		ModuleHelper.loadedClientPreInit();
		PackHelper.loadedClientPreInit();
	}

	public void init() {
		super.init();
		ModuleHelper.loadedClientInit();
		PackHelper.loadedClientInit();
		FMLCommonHandler.instance().bus().register(new EventItemStorageClient());
		MinecraftForge.EVENT_BUS.register(new EventSMT_Client());
	}

	public void postInit() {
		super.postInit();
		ModuleHelper.loadedClientPostInit();
		PackHelper.loadedClientPostInit();
	}

}
