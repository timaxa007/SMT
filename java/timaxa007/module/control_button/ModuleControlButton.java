package timaxa007.module.control_button;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Logger;

import timaxa007.api.IModuleClass;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ModuleControlButton implements IModuleClass {

	public static final String MODID = "control_button";
	public static final String MODNAME = "ControlButton";
	public static final String VERSION = "0.023";
	public static final String[] AUTHORS = new String[] {"timaxa007"};

	public static Logger log;

	public static boolean button_left;
	public static boolean button_right;

	@Override
	public void preInit(FMLPreInitializationEvent event) {

		log = event.getModLog();
		log.info("Starting module " + ModuleControlButton.MODNAME + ", build: " + ModuleControlButton.VERSION + ".");

		Configuration cfg = new Configuration(new File("./config/tms/module", ModuleControlButton.MODID + ".cfg"));
		cfg.load();

		button_left = cfg.get("buttons", "button_left", false).getBoolean(false);
		button_right = cfg.get("buttons", "button_right", false).getBoolean(false);

		cfg.save();

	}

}
