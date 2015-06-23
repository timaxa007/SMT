package timaxa007.module.effect;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Logger;

import timaxa007.api.IModuleClass;
import timaxa007.module.NodeModule.ModuleNode;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@ModuleNode(moduleTag = ModuleEffect.MODID, moduleName = ModuleEffect.MODNAME, moduleVersion = ModuleEffect.VERSION)
/**@author timaxa007**/
public class ModuleEffect implements IModuleClass {

	public static final String MODID = "effects";
	public static final String MODNAME = "Effects";
	public static final String VERSION = "0.001";

	public static Logger log;

	@Override
	public void preInit(FMLPreInitializationEvent event) {

		log = event.getModLog();
		log.info("Starting module " + ModuleEffect.MODNAME + ", build: " + ModuleEffect.VERSION + ".");

		Configuration cfg = new Configuration(new File("./config/smt/module", ModuleEffect.MODID + ".cfg"));
		cfg.load();

		cfg.save();

	}

}
