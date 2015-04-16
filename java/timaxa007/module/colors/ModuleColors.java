package timaxa007.module.colors;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Logger;

import timaxa007.api.IModuleClass;
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

		Configuration cfg = new Configuration(new File("./config/tms/module", ModuleColors.MODID + ".cfg"));
		cfg.load();

		cfg.save();

	}

}
