package timaxa007.module.fluids;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Logger;

import timaxa007.api.IModuleClass;
import timaxa007.module.fluids.util.ListFluidType;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**@author timaxa007**/
public class ModuleFluids implements IModuleClass {

	public static final String MODID = "fluids";
	public static final String MODNAME = "Fluids";
	public static final String VERSION = "0.025";

	public static Logger log;

	@Override
	public void preInit(FMLPreInitializationEvent event) {

		log = event.getModLog();
		log.info("Starting module " + ModuleFluids.MODNAME + ", build: " + ModuleFluids.VERSION + ".");

		Configuration cfg = new Configuration(new File("./config/smt/module", ModuleFluids.MODID + ".cfg"));
		cfg.load();

		cfg.save();

		ListFluidType.init();

	}

}
