package timaxa007.module;

import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Logger;

import timaxa007.module.api.IModuleClass;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod (modid = CoreModule.MODID, name = CoreModule.MODNAME, version = CoreModule.VERSION)

public class CoreModule {

	public static final String MODID = "module_tms";
	public static final String MODNAME = "CoreModule";
	public static final String VERSION = "0.2.1a";
	public static final String[] AUTHORS = new String[] {"timaxa007"};

	@Instance(CoreModule.MODID) public static CoreModule instance;
	@SidedProxy(modId = CoreModule.MODID, 
			clientSide = "timaxa007.module.ProxyModuleClient", 
			serverSide = "timaxa007.module.ProxyModuleCommon")
	public static ProxyModuleCommon proxy;
	public static Logger log;

	public static IModuleClass
	control_button,
	environment,
	status_player,
	weight,
	effects,
	colors
	;

	public static boolean
	isNodeControlButton,
	isNodeEnvironment,
	isNodeStatusPlayer,
	isNodeWeight,
	isNodeEffect,
	isNodeColors
	;

	public static boolean
	disable_module_control_button,
	disable_module_environment,
	disable_module_status_player,
	disable_module_weight,
	disable_module_effects,
	disable_module_colors
	;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		log = event.getModLog();
		log.info("Starting core modules, version: " + CoreModule.VERSION + ".");

		Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
		cfg.load();

		disable_module_control_button = cfg.get("disable_module", "control_button", false).getBoolean(false);
		disable_module_environment = cfg.get("disable_module", "environment", false).getBoolean(false);
		disable_module_status_player = cfg.get("disable_module", "status_player", false).getBoolean(false);
		disable_module_weight = cfg.get("disable_module", "weight", false).getBoolean(false);
		disable_module_effects = cfg.get("disable_module", "effects", false).getBoolean(false);
		disable_module_colors = cfg.get("disable_module", "colors", false).getBoolean(false);

		cfg.save();

		listModule();

		isNodeControlButton = control_button != null;
		isNodeEnvironment = environment != null;
		isNodeStatusPlayer = status_player != null;
		isNodeWeight = weight != null;
		isNodeEffect = effects != null;
		isNodeColors = colors != null;

		if (isNodeControlButton) control_button.preInit(event);
		if (isNodeEnvironment) environment.preInit(event);
		if (isNodeStatusPlayer) status_player.preInit(event);
		if (isNodeWeight) weight.preInit(event);
		if (isNodeEffect) effects.preInit(event);
		if (isNodeColors) colors.preInit(event);

		proxy.preInit();

	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit();
	}

	public static void listModule() {
		//------------------------------------------------------------------------------------
		if (!disable_module_control_button) {
			try {
				String node_control_button = "timaxa007.module.control_button.NodeControlButton";
				Object o_control_button = Class.forName(node_control_button).newInstance();
				control_button = (IModuleClass)o_control_button;
			}
			catch (InstantiationException e) {e.printStackTrace();}
			catch (IllegalAccessException e) {e.printStackTrace();}
			catch (ClassNotFoundException e) {e.printStackTrace();}
		}
		//------------------------------------------------------------------------------------
		if (!disable_module_environment) {
			try {
				String node_environment = "timaxa007.module.environment.NodeEnvironment";
				Object o_environment = Class.forName(node_environment).newInstance();
				environment = (IModuleClass)o_environment;
			}
			catch (InstantiationException e) {e.printStackTrace();}
			catch (IllegalAccessException e) {e.printStackTrace();}
			catch (ClassNotFoundException e) {e.printStackTrace();}
		}
		//------------------------------------------------------------------------------------
		if (!disable_module_status_player) {
			try {
				String node_status_player = "timaxa007.module.status_player.NodeStatusPlayer";
				Object o_status_player = Class.forName(node_status_player).newInstance();
				status_player = (IModuleClass)o_status_player;
			}
			catch (InstantiationException e) {e.printStackTrace();}
			catch (IllegalAccessException e) {e.printStackTrace();}
			catch (ClassNotFoundException e) {e.printStackTrace();}
		}
		//------------------------------------------------------------------------------------
		if (!disable_module_weight) {
			try {
				String node_weight = "timaxa007.module.weight.NodeWeight";
				Object o_weight = Class.forName(node_weight).newInstance();
				weight = (IModuleClass)o_weight;
			}
			catch (InstantiationException e) {e.printStackTrace();}
			catch (IllegalAccessException e) {e.printStackTrace();}
			catch (ClassNotFoundException e) {e.printStackTrace();}
		}
		//------------------------------------------------------------------------------------
		if (!disable_module_effects) {
			try {
				String node_effects = "timaxa007.module.effect.NodeEffect";
				Object o_effects = Class.forName(node_effects).newInstance();
				effects = (IModuleClass)o_effects;
			}
			catch (InstantiationException e) {e.printStackTrace();}
			catch (IllegalAccessException e) {e.printStackTrace();}
			catch (ClassNotFoundException e) {e.printStackTrace();}
		}
		//------------------------------------------------------------------------------------
		if (!disable_module_colors) {
			try {
				String node_colors = "timaxa007.module.colors.NodeColors";
				Object o_colors = Class.forName(node_colors).newInstance();
				colors = (IModuleClass)o_colors;
			}
			catch (InstantiationException e) {e.printStackTrace();}
			catch (IllegalAccessException e) {e.printStackTrace();}
			catch (ClassNotFoundException e) {e.printStackTrace();}
		}
		//------------------------------------------------------------------------------------
	}

}
