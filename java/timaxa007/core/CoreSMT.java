package timaxa007.core;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = CoreSMT.MODID, version = CoreSMT.VERSION)
public class CoreSMT {
	//-----------------------------------------------------------------------------------------------
	public static final String MODID = "smt";
	public static final String VERSION = "0.001a";
	//-----------------------------------------------------------------------------------------------
	@Mod.Instance(CoreSMT.MODID) public static CoreSMT instance;
	@SidedProxy(modId = CoreSMT.MODID, clientSide = "timaxa007.core.ProxyClient", serverSide = "timaxa007.core.ProxyCommon")
	public static ProxyCommon proxy;
	public static org.apache.logging.log4j.Logger log;
	public static final cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper network = 
			NetworkRegistry.INSTANCE.newSimpleChannel(CoreSMT.MODID);
	public static final Config config = new Config();
	//-----------------------------------------------------------------------------------------------
	@Mod.EventHandler
	public void preInit(cpw.mods.fml.common.event.FMLPreInitializationEvent event) {
		log = event.getModLog();

		config.main();

		timaxa007.core.packet.RegisterMessage.init(network);

		if (config.isModulesLoading) {
			config.module();
			timaxa007.module.RegistrationModules.verificationMain();
			timaxa007.module.ModuleHelper.loadedMain(event);
		}

		if (config.isPacksLoading) {
			config.pack();
			timaxa007.pack.RegistrationPacks.verificationMain();
			timaxa007.pack.PackHelper.loadedMain(event);
		}

		proxy.preInit();
	}

	@Mod.EventHandler
	public void init(cpw.mods.fml.common.event.FMLInitializationEvent event) {
		NetworkRegistry.INSTANCE.registerGuiHandler(CoreSMT.instance, new timaxa007.gui.HandlerGui());
		proxy.init();
	}

	@Mod.EventHandler
	public void postInit(cpw.mods.fml.common.event.FMLPostInitializationEvent event) {
		proxy.postInit();
	}
	//-----------------------------------------------------------------------------------------------
	@Mod.EventHandler
	public void serverStarting(cpw.mods.fml.common.event.FMLServerStartingEvent event) {

	}

	@Mod.EventHandler
	public void serverStarted(cpw.mods.fml.common.event.FMLServerStartedEvent event) {

	}
	//-----------------------------------------------------------------------------------------------
	@Mod.EventHandler
	public void serverStopping(cpw.mods.fml.common.event.FMLServerStoppingEvent event) {

	}

	@Mod.EventHandler
	public void serverStopped(cpw.mods.fml.common.event.FMLServerStoppedEvent event) {

	}
	//-----------------------------------------------------------------------------------------------
}
