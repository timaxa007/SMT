package timaxa007.module.fluids;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Logger;

import timaxa007.api.IModuleClass;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ModuleFluids implements IModuleClass {

	public static final String MODID = "fluids";
	public static final String MODNAME = "Fluids";
	public static final String VERSION = "0.3.3a";
	public static final String[] AUTHORS = new String[] {"timaxa007"};

	public static Logger log;

	@Override
	public void preInit(FMLPreInitializationEvent event) {

		log = event.getModLog();
		log.info("Starting module " + ModuleFluids.MODNAME + ", version: " + ModuleFluids.VERSION + ".");

		Configuration cfg = new Configuration(new File("./config/tms/module", ModuleFluids.MODID + ".cfg"));
		cfg.load();

		cfg.save();

		//if (fluid instanceof IFluids) ;

	}

}
