package timaxa007.module.colors;

import org.apache.logging.log4j.Logger;

import timaxa007.module.api.IModuleClass;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ModuleColors implements IModuleClass {

	public static final String MODID = "colors";
	public static final String MODNAME = "Colors";
	public static final String VERSION = "0.1.3a";
	public static final String[] AUTHORS = new String[] {"timaxa007"};

	public static Logger log;

	public void preInit(FMLPreInitializationEvent event) {

		log = event.getModLog();
		log.info("Starting module " + ModuleColors.MODNAME + ", version: " + ModuleColors.VERSION + ".");

	}

}
