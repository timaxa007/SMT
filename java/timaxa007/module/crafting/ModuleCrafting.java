package timaxa007.module.crafting;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Logger;

import timaxa007.api.IModuleClass;
import timaxa007.module.NodeModule.ModuleNode;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@ModuleNode(moduleTag = ModuleCrafting.MODID, moduleName = ModuleCrafting.MODNAME, moduleVersion = ModuleCrafting.VERSION)
/**@author timaxa007**/
public class ModuleCrafting implements IModuleClass {

	public static final String MODID = "crafting";
	public static final String MODNAME = "Crafting";
	public static final String VERSION = "0.001";

	public static Logger log;

	@Override
	public void preInit(FMLPreInitializationEvent event) {

		log = event.getModLog();
		log.info("Starting module " + ModuleCrafting.MODNAME + ", build: " + ModuleCrafting.VERSION + ".");

		Configuration cfg = new Configuration(new File("./config/smt/module", ModuleCrafting.MODID + ".cfg"));
		cfg.load();

		cfg.save();

	}

}
