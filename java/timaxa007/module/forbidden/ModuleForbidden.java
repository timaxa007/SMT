package timaxa007.module.forbidden;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Logger;

import timaxa007.api.IModuleClass;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**@author timaxa007**/
public class ModuleForbidden implements IModuleClass {

	public static final String MODID = "forbidden";
	public static final String MODNAME = "Forbidden";
	public static final String VERSION = "0.002";

	public static Logger log;

	@Override
	public void preInit(FMLPreInitializationEvent event) {

		log = event.getModLog();
		log.info("Starting module " + ModuleForbidden.MODNAME + ", build: " + ModuleForbidden.VERSION + ".");

		Configuration cfg = new Configuration(new File("./config/smt/module", ModuleForbidden.MODID + ".cfg"));
		cfg.load();

		cfg.save();

	}

}
