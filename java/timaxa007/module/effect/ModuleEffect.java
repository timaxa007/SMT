package timaxa007.module.effect;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Logger;

import timaxa007.api.IModuleClass;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ModuleEffect implements IModuleClass {

	public static final String MODID = "effects";
	public static final String MODNAME = "Effects";
	public static final String VERSION = "0.2a";
	public static final String[] AUTHORS = new String[] {"timaxa007"};

	public static Logger log;

	public void preInit(FMLPreInitializationEvent event) {

		log = event.getModLog();
		log.info("Starting module " + ModuleEffect.MODNAME + ", version: " + ModuleEffect.VERSION + ".");

		Configuration cfg = new Configuration(new File("./config/tms/module", ModuleEffect.MODID + ".cfg"));
		cfg.load();

		cfg.save();

	}

}
