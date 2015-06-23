package timaxa007.module.survival_tabs;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Logger;

import timaxa007.api.IModuleClass;
import timaxa007.module.NodeModule.ModuleNode;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@ModuleNode(moduleTag = ModuleSurvivalTabs.MODID, moduleName = ModuleSurvivalTabs.MODNAME, moduleVersion = ModuleSurvivalTabs.VERSION)
/**@author timaxa007**/
public class ModuleSurvivalTabs implements IModuleClass {

	public static final String MODID = "survival_tabs";
	public static final String MODNAME = "SurvivalTabs";
	public static final String VERSION = "0.001";

	public static Logger log;

	@Override
	public void preInit(FMLPreInitializationEvent event) {

		log = event.getModLog();
		log.info("Starting module " + ModuleSurvivalTabs.MODNAME + ", build: " + ModuleSurvivalTabs.VERSION + ".");

		Configuration cfg = new Configuration(new File("./config/smt/module", ModuleSurvivalTabs.MODID + ".cfg"));
		cfg.load();

		cfg.save();

	}

}
