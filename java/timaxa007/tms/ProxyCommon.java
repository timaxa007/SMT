package timaxa007.tms;

import net.minecraftforge.common.MinecraftForge;

import org.apache.logging.log4j.Level;

import timaxa007.api.IProxyModuleCommon;
import timaxa007.api.IProxyPackCommon;
import timaxa007.tms.event.EventOwner;
import cpw.mods.fml.common.FMLLog;

public class ProxyCommon {

	public static IProxyModuleCommon 
	control_button,
	environment,
	status_player,
	weight,
	effects,
	colors,
	fluids
	;

	public static IProxyPackCommon 
	furniture,
	item,
	magic,
	mining,
	stock,
	techno,
	weapon
	;

	public void preInit() {

		verificationModuleCommon();

		if (control_button != null) control_button.preInit();
		if (environment != null) environment.preInit();
		if (status_player != null) status_player.preInit();
		if (weight != null) weight.preInit();
		if (effects != null) effects.preInit();
		if (colors != null) colors.preInit();
		if (fluids != null) fluids.preInit();

		verificationPackCommon();

		if (furniture != null) furniture.preInit();
		if (item != null) item.preInit();
		if (magic != null) magic.preInit();
		if (mining != null) mining.preInit();
		if (stock != null) stock.preInit();
		if (techno != null) techno.preInit();
		if (weapon != null) weapon.preInit();

	}

	public void init() {
		
		MinecraftForge.EVENT_BUS.register(new EventOwner());

		if (control_button != null) control_button.init();
		if (environment != null) environment.init();
		if (status_player != null) status_player.init();
		if (weight != null) weight.init();
		if (effects != null) effects.init();
		if (colors != null) colors.init();
		if (fluids != null) fluids.init();

		if (furniture != null) furniture.init();
		if (item != null) item.init();
		if (magic != null) magic.init();
		if (mining != null) mining.init();
		if (stock != null) stock.init();
		if (techno != null) techno.init();
		if (weapon != null) weapon.init();

		if (CoreTMS.config.debug) FMLLog.log(CoreTMS.MODID, Level.DEBUG, "Successful initialized common part.");
	}

	public void postInit() {

		if (control_button != null) control_button.postInit();
		if (environment != null) environment.postInit();
		if (status_player != null) status_player.postInit();
		if (weight != null) weight.postInit();
		if (effects != null) effects.postInit();
		if (colors != null) colors.postInit();
		if (fluids != null) fluids.postInit();

		if (furniture != null) furniture.postInit();
		if (item != null) item.postInit();
		if (magic != null) magic.postInit();
		if (mining != null) mining.postInit();
		if (stock != null) stock.postInit();
		if (techno != null) techno.postInit();
		if (weapon != null) weapon.postInit();

	}

	public static void verificationModuleCommon() {

		if (CoreTMS.config.isNodeControlButton)
			control_button = checkModuleCommon(CoreTMS.PATH_MODULE + ".control_button.ProxyCommon");

		if (CoreTMS.config.isNodeEnvironment)
			environment = checkModuleCommon(CoreTMS.PATH_MODULE + ".environment.ProxyCommon");

		if (CoreTMS.config.isNodeStatusPlayer)
			status_player = checkModuleCommon(CoreTMS.PATH_MODULE + ".status_player.ProxyCommon");

		if (CoreTMS.config.isNodeWeight)
			weight = checkModuleCommon(CoreTMS.PATH_MODULE + ".weight.ProxyCommon");

		if (CoreTMS.config.isNodeEffect)
			effects = checkModuleCommon(CoreTMS.PATH_MODULE + ".effect.ProxyCommon");

		if (CoreTMS.config.isNodeColors)
			colors = checkModuleCommon(CoreTMS.PATH_MODULE + ".colors.ProxyCommon");

		if (CoreTMS.config.isNodeFluids)
			fluids = checkModuleCommon(CoreTMS.PATH_MODULE + ".fluids.ProxyCommon");

	}

	public static IProxyModuleCommon checkModuleCommon(String node) {
		try {return (IProxyModuleCommon)Class.forName(node).newInstance();}
		catch (InstantiationException e) {e.printStackTrace();}
		catch (IllegalAccessException e) {e.printStackTrace();}
		catch (ClassNotFoundException e) {e.printStackTrace();}
		return null;
	}

	public static void verificationPackCommon() {

		if (CoreTMS.config.isPackFurniture)
			furniture = checkPackCommon(CoreTMS.PATH_PACK + ".furniture.ProxyCommon");

		if (CoreTMS.config.isPackItems)
			item = checkPackCommon(CoreTMS.PATH_PACK + ".item.ProxyCommon");

		if (CoreTMS.config.isPackMagic)
			magic = checkPackCommon(CoreTMS.PATH_PACK + ".magic.ProxyCommon");

		if (CoreTMS.config.isPackMining)
			mining = checkPackCommon(CoreTMS.PATH_PACK + ".mining.ProxyCommon");

		if (CoreTMS.config.isPackStock)
			stock = checkPackCommon(CoreTMS.PATH_PACK + ".stock.ProxyCommon");

		if (CoreTMS.config.isPackTechno)
			techno = checkPackCommon(CoreTMS.PATH_PACK + ".techno.ProxyCommon");

		if (CoreTMS.config.isPackWeapons)
			weapon = checkPackCommon(CoreTMS.PATH_PACK + ".weapon.ProxyCommon");

	}

	public static IProxyPackCommon checkPackCommon(String node) {
		try {return (IProxyPackCommon)Class.forName(node).newInstance();}
		catch (InstantiationException e) {e.printStackTrace();}
		catch (IllegalAccessException e) {e.printStackTrace();}
		catch (ClassNotFoundException e) {e.printStackTrace();}
		return null;
	}

}
