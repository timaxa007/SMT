package timaxa007.module.texture_map;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Logger;

import timaxa007.api.IModuleClass;
import timaxa007.module.texture_map.util.TextureMap;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**@author timaxa007**/
public class ModuleTextureMap implements IModuleClass {

	public static final String MODID = "texture_map";
	public static final String MODNAME = "TextureMap";
	public static final String VERSION = "0.001";

	public static Logger log;

	@Override
	public void preInit(FMLPreInitializationEvent event) {

		log = event.getModLog();
		log.info("Starting module " + ModuleTextureMap.MODNAME + ", build: " + ModuleTextureMap.VERSION + ".");

		Configuration cfg = new Configuration(new File("./config/smt/module", ModuleTextureMap.MODID + ".cfg"));
		cfg.load();

		cfg.save();

		TextureMap.preInit();

	}

}
