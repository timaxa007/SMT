package timaxa007.core;

import net.minecraftforge.common.MinecraftForge;
import timaxa007.core.event.EventItemStorage;
import timaxa007.core.event.EventSMT;
import timaxa007.module.ModuleHelper;
import timaxa007.module.RegistrationModules;
import timaxa007.pack.PackHelper;
import timaxa007.pack.RegistrationPacks;
import cpw.mods.fml.common.FMLCommonHandler;

public class ProxyCommon {

	public void preInit() {
		RegistrationModules.verificationCommon();
		RegistrationPacks.verificationCommon();

		ModuleHelper.loadedCommonPreInit();
		PackHelper.loadedCommonPreInit();
	}

	public void init() {
		ModuleHelper.loadedCommonInit();
		PackHelper.loadedCommonInit();
		FMLCommonHandler.instance().bus().register(new EventItemStorage());
		MinecraftForge.EVENT_BUS.register(new EventSMT());
	}

	public void postInit() {
		ModuleHelper.loadedCommonPostInit();
		PackHelper.loadedCommonPostInit();
	}

}
