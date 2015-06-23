package timaxa007.module.colors;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Logger;

import timaxa007.api.IModuleClass;
import timaxa007.module.NodeModule.ModuleNode;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@ModuleNode(moduleTag = ModuleColors.MODID, moduleName = ModuleColors.MODNAME, moduleVersion = ModuleColors.VERSION)
/**@author timaxa007**/
public class ModuleColors implements IModuleClass {

	public static final String MODID = "colors";
	public static final String MODNAME = "Colors";
	public static final String VERSION = "0.031";

	public static Logger log;

	@Override
	public void preInit(FMLPreInitializationEvent event) {

		log = event.getModLog();
		log.info("Starting module " + ModuleColors.MODNAME + ", build: " + ModuleColors.VERSION + ".");

		Configuration cfg = new Configuration(new File("./config/smt/module", ModuleColors.MODID + ".cfg"));
		cfg.load();

		cfg.save();

	}

}
