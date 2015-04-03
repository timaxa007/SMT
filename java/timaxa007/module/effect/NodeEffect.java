package timaxa007.module.effect;

import org.apache.logging.log4j.Logger;

import timaxa007.module.api.IModuleClass;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class NodeEffect implements IModuleClass {

	public static final String MODID = "effects";
	public static final String MODNAME = "Effects";
	public static final String VERSION = "0.2a";
	public static final String[] AUTHORS = new String[] {"timaxa007"};

	public static Logger log;

	public void preInit(FMLPreInitializationEvent event) {

		log = event.getModLog();
		log.info("Starting module " + NodeEffect.MODNAME + ", version: " + NodeEffect.VERSION + ".");

	}

}
