package timaxa007.module.substance;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Logger;

import timaxa007.api.IModuleClass;
import timaxa007.module.NodeModule.ModuleNode;
import timaxa007.module.substance.block.ListBlock;
import timaxa007.module.substance.util.ListSubstanceType;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@ModuleNode(moduleTag = ModuleSubstance.MODID, moduleName = ModuleSubstance.MODNAME, moduleVersion = ModuleSubstance.VERSION)
/**@author timaxa007**/
public class ModuleSubstance implements IModuleClass {

	public static final String MODID = "fluids";
	public static final String MODNAME = "Substance";
	public static final String VERSION = "0.026";

	public static Logger log;

	public static ListBlock block;
	//public static ListItem item;
	//public static RenderMain render;

	@Override
	public void preInit(FMLPreInitializationEvent event) {

		log = event.getModLog();
		log.info("Starting module " + ModuleSubstance.MODNAME + ", build: " + ModuleSubstance.VERSION + ".");

		Configuration cfg = new Configuration(new File("./config/smt/module", ModuleSubstance.MODID + ".cfg"));
		cfg.load();

		block.substance_fake_water_be = cfg.get("block", "substance_fake_water", true).getBoolean();
		block.substance_fake_water_flowing_be = cfg.get("block", "substance_fake_water_flowing", true).getBoolean();
		block.substance_fake_lava_be = cfg.get("block", "substance_fake_lava", true).getBoolean();
		block.substance_fake_lava_flowing_be = cfg.get("block", "substance_fake_lava_flowing", true).getBoolean();

		cfg.save();

		ListSubstanceType.init();

	}

}
