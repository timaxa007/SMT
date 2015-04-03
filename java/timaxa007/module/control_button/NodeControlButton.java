package timaxa007.module.control_button;

import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Logger;

import timaxa007.module.api.IModuleClass;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class NodeControlButton implements IModuleClass {

	public static final String MODID = "control_button";
	public static final String MODNAME = "ControlButton";
	public static final String VERSION = "0.3a";
	public static final String[] AUTHORS = new String[] {"timaxa007"};

	public static Logger log;

	public static boolean button_left;
	public static boolean button_right;

	public void preInit(FMLPreInitializationEvent event) {

		log = event.getModLog();
		log.info("Starting module " + NodeControlButton.MODNAME + ", version: " + NodeControlButton.VERSION + ".");

		Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
		cfg.load();

		button_left = cfg.get("buttons", "button_left", false).getBoolean(false);
		button_right = cfg.get("buttons", "button_right", false).getBoolean(false);

		cfg.save();

	}

}
