package timaxa007.smt.lib;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import timaxa007.api.IModuleClass;
import timaxa007.api.IPackClass;
import timaxa007.smt.CoreSMT;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Config {

	public static boolean
	debug,
	show_tip_info_testing,
	show_system_info_testing
	;

	public static boolean
	disable_module_control_button,
	disable_module_survival_tabs,
	disable_module_crafting,
	disable_module_environment,
	disable_module_status_player,
	disable_module_weight,
	disable_module_effects,
	disable_module_colors,
	disable_module_fluids,
	disable_module_forbidden,
	disable_module_texture_map,
	disable_module_information
	;

	public static IModuleClass
	control_button,
	survival_tabs,
	crafting,
	environment,
	status_player,
	weight,
	effects,
	colors,
	fluids,
	forbidden,
	texture_map,
	information
	;

	public static boolean
	isModuleControlButton,
	isModuleSurvivalTabs,
	isModuleCrafting,
	isModuleEnvironment,
	isModuleStatusPlayer,
	isModuleWeight,
	isModuleEffect,
	isModuleColors,
	isModuleFluids,
	isModuleForbidden,
	isModuleTextureMap,
	isModuleInformation
	;

	public static IPackClass
	furniture,
	item,
	magic,
	mining,
	stock,
	techno,
	weapon
	;

	public static boolean
	isPackFurniture,
	isPackItems,
	isPackMagic,
	isPackMining,
	isPackStock,
	isPackTechno,
	isPackWeapons
	;

	public static boolean
	disable_pack_furniture,
	disable_pack_item,
	disable_pack_magic,
	disable_pack_mining,
	disable_pack_stocks,
	disable_pack_techno,
	disable_pack_weapon
	;

	public static void core(FMLPreInitializationEvent event) {

		Configuration cfg = new Configuration(new File("./config/smt", "core_smt.cfg"));
		cfg.load();

		debug = cfg.get("debugging", "debug", false).getBoolean();

		show_tip_info_testing = getProperty(cfg, "debugging", "show_tip_info_testing", 
				"Show additional information on the addInformation(...), if it exists?\n"
						+ "<true> - Yes, <false> - No.", false);

		show_system_info_testing = getProperty(cfg, "debugging", "show_system_info_testing", 
				"Show additional information on the System.out.println(...), if it exists?\n"
						+ "<true> - Yes, <false> - No.", false);

		cfg.save();

	}

	public static void module(FMLPreInitializationEvent event) {
		Configuration cfg_module = new Configuration(new File("./config/smt", "node_module.cfg"));

		cfg_module.load();

		disable_module_control_button = cfg_module.get("disable_module", "control_button", false).getBoolean();
		disable_module_survival_tabs = cfg_module.get("disable_module", "survival_tabs", false).getBoolean();
		disable_module_crafting = cfg_module.get("disable_module", "crafting", false).getBoolean();
		disable_module_environment = cfg_module.get("disable_module", "environment", false).getBoolean();
		disable_module_status_player = cfg_module.get("disable_module", "status_player", false).getBoolean();
		disable_module_weight = cfg_module.get("disable_module", "weight", false).getBoolean();
		disable_module_effects = cfg_module.get("disable_module", "effects", false).getBoolean();
		disable_module_colors = cfg_module.get("disable_module", "colors", false).getBoolean();
		disable_module_fluids = cfg_module.get("disable_module", "fluids", false).getBoolean();
		disable_module_forbidden = cfg_module.get("disable_module", "forbidden", false).getBoolean();
		disable_module_texture_map = cfg_module.get("disable_module", "texture_map", false).getBoolean();
		disable_module_information = cfg_module.get("disable_module", "information", false).getBoolean();

		cfg_module.save();

		verificationModule();

		if (isModuleControlButton) control_button.preInit(event);
		if (isModuleSurvivalTabs) survival_tabs.preInit(event);
		if (isModuleCrafting) crafting.preInit(event);
		if (isModuleEnvironment) environment.preInit(event);
		if (isModuleStatusPlayer) status_player.preInit(event);
		if (isModuleWeight) weight.preInit(event);
		if (isModuleEffect) effects.preInit(event);
		if (isModuleColors) colors.preInit(event);
		if (isModuleFluids) fluids.preInit(event);
		if (isModuleForbidden) forbidden.preInit(event);
		if (isModuleTextureMap) texture_map.preInit(event);
		if (isModuleInformation) information.preInit(event);
	}

	public static void pack(FMLPreInitializationEvent event) {
		Configuration cfg_pack = new Configuration(new File("./config/smt", "node_pack.cfg"));
		cfg_pack.load();

		disable_pack_furniture = cfg_pack.get("disable_pack", "furniture", false).getBoolean();
		disable_pack_item = cfg_pack.get("disable_pack", "item", false).getBoolean();
		disable_pack_magic = cfg_pack.get("disable_pack", "magic", false).getBoolean();
		disable_pack_mining = cfg_pack.get("disable_pack", "mining", false).getBoolean();
		disable_pack_stocks = cfg_pack.get("disable_pack", "stocks", false).getBoolean();
		disable_pack_techno = cfg_pack.get("disable_pack", "techno", false).getBoolean();
		disable_pack_weapon = cfg_pack.get("disable_pack", "weapon", false).getBoolean();

		cfg_pack.save();

		verificationPack();

		if (isPackFurniture) furniture.preInit(event);
		if (isPackItems) item.preInit(event);
		if (isPackMagic) magic.preInit(event);
		if (isPackMining) mining.preInit(event);
		if (isPackStock) stock.preInit(event);
		if (isPackTechno) techno.preInit(event);
		if (isPackWeapons) weapon.preInit(event);
	}

	public static boolean getProperty(Configuration cfg, String category, String name, String comment, boolean flag) {
		Property show_system_info_testing_cfg = cfg.get(category, name, flag);
		show_system_info_testing_cfg.comment = comment;
		return show_system_info_testing_cfg.getBoolean();
	}

	public static String getProperty(Configuration cfg, String category, String name, String comment, String flag) {
		Property show_system_info_testing_cfg = cfg.get(category, name, flag);
		show_system_info_testing_cfg.comment = comment;
		return show_system_info_testing_cfg.getString();
	}

	public static void verificationModule() {

		if (!disable_module_control_button)
			control_button = checkModule(CoreSMT.PATH_MODULE + ".control_button.ModuleControlButton");
		isModuleControlButton = control_button != null;

		if (!disable_module_survival_tabs)
			survival_tabs = checkModule(CoreSMT.PATH_MODULE + ".survival_tabs.ModuleSurvivalTabs");
		isModuleSurvivalTabs = survival_tabs != null;

		if (!disable_module_crafting)
			crafting = checkModule(CoreSMT.PATH_MODULE + ".crafting.ModuleCrafting");
		isModuleCrafting = crafting != null;

		if (!disable_module_environment)
			environment = checkModule(CoreSMT.PATH_MODULE + ".environment.ModuleEnvironment");
		isModuleEnvironment = environment != null;

		if (!disable_module_status_player)
			status_player = checkModule(CoreSMT.PATH_MODULE + ".status_player.ModuleStatusPlayer");
		isModuleStatusPlayer = status_player != null;

		if (!disable_module_weight)
			weight = checkModule(CoreSMT.PATH_MODULE + ".weight.ModuleWeight");
		isModuleWeight = weight != null;

		if (!disable_module_effects)
			effects = checkModule(CoreSMT.PATH_MODULE + ".effect.ModuleEffect");
		isModuleEffect = effects != null;

		if (!disable_module_colors)
			colors = checkModule(CoreSMT.PATH_MODULE + ".colors.ModuleColors");
		isModuleColors = colors != null;

		if (!disable_module_fluids)
			fluids = checkModule(CoreSMT.PATH_MODULE + ".fluids.ModuleFluids");
		isModuleFluids = fluids != null;

		if (!disable_module_forbidden)
			forbidden = checkModule(CoreSMT.PATH_MODULE + ".forbidden.ModuleForbidden");
		isModuleForbidden = forbidden != null;

		if (!disable_module_texture_map)
			texture_map = checkModule(CoreSMT.PATH_MODULE + ".texture_map.ModuleTextureMap");
		isModuleTextureMap = texture_map != null;

		if (!disable_module_information)
			information = checkModule(CoreSMT.PATH_MODULE + ".information.ModuleInformation");
		isModuleInformation = information != null;

	}

	public static IModuleClass checkModule(String node) {
		try {return (IModuleClass)Class.forName(node).newInstance();}
		catch (InstantiationException e) {e.printStackTrace();}
		catch (IllegalAccessException e) {e.printStackTrace();}
		catch (ClassNotFoundException e) {e.printStackTrace();}
		return null;
	}

	public static void verificationPack() {

		if (!disable_pack_furniture)
			furniture = checkPack(CoreSMT.PATH_PACK + ".furniture.PackFurniture");
		isPackFurniture = furniture != null;

		if (!disable_pack_item)
			item = checkPack(CoreSMT.PATH_PACK + ".item.PackItems");
		isPackItems = item != null;

		if (!disable_pack_magic)
			magic = checkPack(CoreSMT.PATH_PACK + ".magic.PackMagic");
		isPackMagic = magic != null;

		if (!disable_pack_mining)
			mining = checkPack(CoreSMT.PATH_PACK + ".mining.PackMining");
		isPackMining = mining != null;

		if (!disable_pack_stocks)
			stock = checkPack(CoreSMT.PATH_PACK + ".stock.PackStock");
		isPackStock = stock != null;

		if (!disable_pack_techno)
			techno = checkPack(CoreSMT.PATH_PACK + ".techno.PackTechno");
		isPackTechno = techno != null;

		if (!disable_pack_weapon)
			weapon = checkPack(CoreSMT.PATH_PACK + ".weapon.PackWeapons");
		isPackWeapons = weapon != null;

	}

	public static IPackClass checkPack(String node) {
		try {return (IPackClass)Class.forName(node).newInstance();}
		catch (InstantiationException e) {e.printStackTrace();}
		catch (IllegalAccessException e) {e.printStackTrace();}
		catch (ClassNotFoundException e) {e.printStackTrace();}
		return null;
	}

	//---------------------------------------------------------------------
	public static enum typeDifficulty {
		AUTO,
		EASY,
		MEDIUM,
		HARD,
		OTHER;
	}

	public static typeDifficulty getTypeDifficulty(String str) {
		if (str.equals("auto")) return typeDifficulty.AUTO;
		else if (str.equals("easy")) return typeDifficulty.EASY;
		else if (str.equals("medium")) return typeDifficulty.MEDIUM;
		else if (str.equals("hard")) return typeDifficulty.HARD;
		else return typeDifficulty.OTHER;
	}
	//---------------------------------------------------------------------
}
