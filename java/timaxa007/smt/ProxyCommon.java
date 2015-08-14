package timaxa007.smt;

import org.apache.logging.log4j.Level;

import timaxa007.api.IProxyModuleCommon;
import timaxa007.api.IProxyPackCommon;
import cpw.mods.fml.common.FMLLog;

public class ProxyCommon {

	public static IProxyModuleCommon
	control_button,
	player_inventory,
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

	public static IProxyPackCommon
	conjoint,
	furniture,
	magic,
	mining,
	stock,
	techno,
	weapon
	;

	public void preInit() {

		verificationModuleCommon();

		if (control_button != null) control_button.preInit();
		if (player_inventory != null) player_inventory.preInit();
		if (crafting != null) crafting.preInit();
		if (environment != null) environment.preInit();
		if (status_player != null) status_player.preInit();
		if (weight != null) weight.preInit();
		if (effects != null) effects.preInit();
		if (colors != null) colors.preInit();
		if (fluids != null) fluids.preInit();
		if (forbidden != null) forbidden.preInit();
		if (texture_map != null) texture_map.preInit();
		if (information != null) information.preInit();

		verificationPackCommon();

		if (conjoint != null) conjoint.preInit();
		if (furniture != null) furniture.preInit();
		if (magic != null) magic.preInit();
		if (mining != null) mining.preInit();
		if (stock != null) stock.preInit();
		if (techno != null) techno.preInit();
		if (weapon != null) weapon.preInit();

	}

	public void init() {

		if (CoreSMT.config.debug) FMLLog.log(CoreSMT.MODID, Level.DEBUG, "Successful initialized common part.");

		if (control_button != null) control_button.init();
		if (player_inventory != null) player_inventory.init();
		if (crafting != null) crafting.init();
		if (environment != null) environment.init();
		if (status_player != null) status_player.init();
		if (weight != null) weight.init();
		if (effects != null) effects.init();
		if (colors != null) colors.init();
		if (fluids != null) fluids.init();
		if (forbidden != null) forbidden.init();
		if (texture_map != null) texture_map.init();
		if (information != null) information.init();

		if (conjoint != null) conjoint.init();
		if (furniture != null) furniture.init();
		if (magic != null) magic.init();
		if (mining != null) mining.init();
		if (stock != null) stock.init();
		if (techno != null) techno.init();
		if (weapon != null) weapon.init();

	}

	public void postInit() {

		if (control_button != null) control_button.postInit();
		if (player_inventory != null) player_inventory.postInit();
		if (crafting != null) crafting.postInit();
		if (environment != null) environment.postInit();
		if (status_player != null) status_player.postInit();
		if (weight != null) weight.postInit();
		if (effects != null) effects.postInit();
		if (colors != null) colors.postInit();
		if (fluids != null) fluids.postInit();
		if (forbidden != null) forbidden.postInit();
		if (texture_map != null) texture_map.postInit();
		if (information != null) information.postInit();

		if (conjoint != null) conjoint.postInit();
		if (furniture != null) furniture.postInit();
		if (magic != null) magic.postInit();
		if (mining != null) mining.postInit();
		if (stock != null) stock.postInit();
		if (techno != null) techno.postInit();
		if (weapon != null) weapon.postInit();

	}

	public static void verificationModuleCommon() {

		if (CoreSMT.config.isModuleControlButton)
			control_button = checkModuleCommon(CoreSMT.PATH_MODULE + ".control_button.ProxyCommon");

		if (CoreSMT.config.isModulePlayerInventory)
			player_inventory = checkModuleCommon(CoreSMT.PATH_MODULE + ".player_inventory.ProxyCommon");

		if (CoreSMT.config.isModuleCrafting)
			crafting = checkModuleCommon(CoreSMT.PATH_MODULE + ".crafting.ProxyCommon");

		if (CoreSMT.config.isModuleEnvironment)
			environment = checkModuleCommon(CoreSMT.PATH_MODULE + ".environment.ProxyCommon");

		if (CoreSMT.config.isModuleStatusPlayer)
			status_player = checkModuleCommon(CoreSMT.PATH_MODULE + ".status_player.ProxyCommon");

		if (CoreSMT.config.isModuleWeight)
			weight = checkModuleCommon(CoreSMT.PATH_MODULE + ".weight.ProxyCommon");

		if (CoreSMT.config.isModuleEffect)
			effects = checkModuleCommon(CoreSMT.PATH_MODULE + ".effect.ProxyCommon");

		if (CoreSMT.config.isModuleColors)
			colors = checkModuleCommon(CoreSMT.PATH_MODULE + ".colors.ProxyCommon");

		if (CoreSMT.config.isModuleSubstance)
			fluids = checkModuleCommon(CoreSMT.PATH_MODULE + ".substance.ProxyCommon");

		if (CoreSMT.config.isModuleForbidden)
			forbidden = checkModuleCommon(CoreSMT.PATH_MODULE + ".forbidden.ProxyCommon");

		if (CoreSMT.config.isModuleTextureMap)
			texture_map = checkModuleCommon(CoreSMT.PATH_MODULE + ".texture_map.ProxyCommon");

		if (CoreSMT.config.isModuleInformation)
			information = checkModuleCommon(CoreSMT.PATH_MODULE + ".information.ProxyCommon");

	}

	public static IProxyModuleCommon checkModuleCommon(String node) {
		try {return (IProxyModuleCommon)Class.forName(node).newInstance();}
		catch (InstantiationException e) {e.printStackTrace();}
		catch (IllegalAccessException e) {e.printStackTrace();}
		catch (ClassNotFoundException e) {e.printStackTrace();}
		return null;
	}

	public static void verificationPackCommon() {

		if (CoreSMT.config.isPackConjoint)
			conjoint = checkPackCommon(CoreSMT.PATH_PACK + ".conjoint.ProxyCommon");

		if (CoreSMT.config.isPackFurniture)
			furniture = checkPackCommon(CoreSMT.PATH_PACK + ".furniture.ProxyCommon");

		if (CoreSMT.config.isPackMagic)
			magic = checkPackCommon(CoreSMT.PATH_PACK + ".magic.ProxyCommon");

		if (CoreSMT.config.isPackMining)
			mining = checkPackCommon(CoreSMT.PATH_PACK + ".mining.ProxyCommon");

		if (CoreSMT.config.isPackStock)
			stock = checkPackCommon(CoreSMT.PATH_PACK + ".stock.ProxyCommon");

		if (CoreSMT.config.isPackTechno)
			techno = checkPackCommon(CoreSMT.PATH_PACK + ".techno.ProxyCommon");

		if (CoreSMT.config.isPackWeapon)
			weapon = checkPackCommon(CoreSMT.PATH_PACK + ".weapon.ProxyCommon");

	}

	public static IProxyPackCommon checkPackCommon(String node) {
		try {return (IProxyPackCommon)Class.forName(node).newInstance();}
		catch (InstantiationException e) {e.printStackTrace();}
		catch (IllegalAccessException e) {e.printStackTrace();}
		catch (ClassNotFoundException e) {e.printStackTrace();}
		return null;
	}

}
