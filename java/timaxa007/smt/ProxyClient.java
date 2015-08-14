package timaxa007.smt;

import org.apache.logging.log4j.Level;

import timaxa007.api.IProxyModuleClient;
import timaxa007.api.IProxyPackClient;
import cpw.mods.fml.common.FMLLog;

public class ProxyClient extends ProxyCommon {

	public static IProxyModuleClient
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

	public static IProxyPackClient
	conjoint,
	furniture,
	magic,
	mining,
	stock,
	techno,
	weapon
	;

	public void preInit() {
		super.preInit();

		verificationModuleClient();

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

		verificationPackClient();

		if (conjoint != null) conjoint.preInit();
		if (furniture != null) furniture.preInit();
		if (magic != null) magic.preInit();
		if (mining != null) mining.preInit();
		if (stock != null) stock.preInit();
		if (forbidden != null) forbidden.preInit();
		if (weapon != null) weapon.preInit();

	}

	@Override
	public void init() {
		super.init();

		if (CoreSMT.config.debug) FMLLog.log(CoreSMT.MODID, Level.DEBUG, "Successful initialized client part.");

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

	@Override
	public void postInit() {
		super.postInit();

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

	public static void verificationModuleClient() {

		if (CoreSMT.config.isModuleControlButton)
			control_button = checkModuleClient(CoreSMT.PATH_MODULE + ".control_button.ProxyClient");

		if (CoreSMT.config.isModulePlayerInventory)
			player_inventory = checkModuleClient(CoreSMT.PATH_MODULE + ".player_inventory.ProxyClient");

		if (CoreSMT.config.isModuleCrafting)
			crafting = checkModuleClient(CoreSMT.PATH_MODULE + ".crafting.ProxyClient");

		if (CoreSMT.config.isModuleEnvironment)
			environment = checkModuleClient(CoreSMT.PATH_MODULE + ".environment.ProxyClient");

		if (CoreSMT.config.isModuleStatusPlayer)
			status_player = checkModuleClient(CoreSMT.PATH_MODULE + ".status_player.ProxyClient");

		if (CoreSMT.config.isModuleWeight)
			weight = checkModuleClient(CoreSMT.PATH_MODULE + ".weight.ProxyClient");

		if (CoreSMT.config.isModuleEffect)
			effects = checkModuleClient(CoreSMT.PATH_MODULE + ".effect.ProxyClient");

		if (CoreSMT.config.isModuleColors)
			colors = checkModuleClient(CoreSMT.PATH_MODULE + ".colors.ProxyClient");

		if (CoreSMT.config.isModuleSubstance)
			fluids = checkModuleClient(CoreSMT.PATH_MODULE + ".substance.ProxyClient");

		if (CoreSMT.config.isModuleForbidden)
			forbidden = checkModuleClient(CoreSMT.PATH_MODULE + ".forbidden.ProxyClient");

		if (CoreSMT.config.isModuleTextureMap)
			texture_map = checkModuleClient(CoreSMT.PATH_MODULE + ".texture_map.ProxyClient");

		if (CoreSMT.config.isModuleInformation)
			information = checkModuleClient(CoreSMT.PATH_MODULE + ".information.ProxyClient");

	}

	public static IProxyModuleClient checkModuleClient(String node) {
		try {return (IProxyModuleClient)Class.forName(node).newInstance();}
		catch (InstantiationException e) {e.printStackTrace();}
		catch (IllegalAccessException e) {e.printStackTrace();}
		catch (ClassNotFoundException e) {e.printStackTrace();}
		return null;
	}

	public static void verificationPackClient() {

		if (CoreSMT.config.isPackConjoint)
			conjoint = checkPackClient(CoreSMT.PATH_PACK + ".conjoint.ProxyClient");

		if (CoreSMT.config.isPackFurniture)
			furniture = checkPackClient(CoreSMT.PATH_PACK + ".furniture.ProxyClient");

		if (CoreSMT.config.isPackMagic)
			magic = checkPackClient(CoreSMT.PATH_PACK + ".magic.ProxyClient");

		if (CoreSMT.config.isPackMining)
			mining = checkPackClient(CoreSMT.PATH_PACK + ".mining.ProxyClient");

		if (CoreSMT.config.isPackStock)
			stock = checkPackClient(CoreSMT.PATH_PACK + ".stock.ProxyClient");

		if (CoreSMT.config.isPackTechno)
			techno = checkPackClient(CoreSMT.PATH_PACK + ".techno.ProxyClient");

		if (CoreSMT.config.isPackWeapon)
			weapon = checkPackClient(CoreSMT.PATH_PACK + ".weapon.ProxyClient");

	}

	public static IProxyPackClient checkPackClient(String node) {
		try {return (IProxyPackClient)Class.forName(node).newInstance();}
		catch (InstantiationException e) {e.printStackTrace();}
		catch (IllegalAccessException e) {e.printStackTrace();}
		catch (ClassNotFoundException e) {e.printStackTrace();}
		return null;
	}

}
