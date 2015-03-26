package timaxa007.module.control_button;

import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod (modid = CoreControlButton.MODID, name = CoreControlButton.MODNAME, version = CoreControlButton.VERSION)

public class CoreControlButton {

	public static final String MODID = "control_button";
	public static final String MODNAME = "ControlButton";
	public static final String VERSION = "0.1a";
	public static final String[] AUTHORS = new String[] {"timaxa007"};

	@Instance(CoreControlButton.MODID) public static CoreControlButton instance;
	@SidedProxy(modId = CoreControlButton.MODID, 
			clientSide = "timaxa007.module.control_button.ProxyClient", 
			serverSide = "timaxa007.module.control_button.ProxyCommon")
	public static ProxyCommon proxy;
	public static Logger log;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		log = event.getModLog();
		log.info("Starting module " + CoreControlButton.MODNAME + ".");

		proxy.preInit();

	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init();
	}

}
