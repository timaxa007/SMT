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

@Mod (modid = NodeModule.MODID, name = NodeModule.MODNAME, version = NodeModule.VERSION)

public class NodeModule {

	public static final String MODID = "tms_module";
	public static final String MODNAME = "NodeModule";
	public static final String VERSION = "0.2.1a";
	public static final String[] AUTHORS = new String[] {"timaxa007"};
	public static final String PATH = "timaxa007.module";

	@Instance(NodeModule.MODID) public static NodeModule instance;
	@SidedProxy(modId = NodeModule.MODID, clientSide = PATH + ".ProxyModuleClient", serverSide = PATH + ".ProxyModuleCommon")
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
		log.info("Starting core modules, version: " + NodeModule.VERSION + ".");

		Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
		cfg.load();

		disable_module_control_button = cfg.get("disable_module", "control_button", false).getBoolean(false);
		disable_module_environment = cfg.get("disable_module", "environment", false).getBoolean(false);
		disable_module_status_player = cfg.get("disable_module", "status_player", false).getBoolean(false);
		disable_module_weight = cfg.get("disable_module", "weight", false).getBoolean(false);
		disable_module_effects = cfg.get("disable_module", "effects", false).getBoolean(false);
		disable_module_colors = cfg.get("disable_module", "colors", false).getBoolean(false);

		cfg.save();

		verificationModule();

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

	public static void verificationModule() {

		if (!disable_module_control_button)
			control_button = checkModule(PATH + ".control_button.ModuleControlButton");
		isNodeControlButton = control_button != null;

		if (!disable_module_environment)
			environment = checkModule(PATH + ".environment.ModuleEnvironment");
		isNodeEnvironment = environment != null;

		if (!disable_module_status_player)
			status_player = checkModule(PATH + ".status_player.ModuleStatusPlayer");
		isNodeStatusPlayer = status_player != null;

		if (!disable_module_weight)
			weight = checkModule(PATH + ".weight.ModuleWeight");
		isNodeWeight = weight != null;

		if (!disable_module_effects)
			effects = checkModule(PATH + ".effect.ModuleEffect");
		isNodeEffect = effects != null;

		if (!disable_module_colors)
			colors = checkModule(PATH + ".colors.ModuleColors");
		isNodeColors = colors != null;

	}

	public static IModuleClass checkModule(String node) {
		try {return (IModuleClass)Class.forName(node).newInstance();}
		catch (InstantiationException e) {e.printStackTrace();}
		catch (IllegalAccessException e) {e.printStackTrace();}
		catch (ClassNotFoundException e) {e.printStackTrace();}
		return null;
	}

}
