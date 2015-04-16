package timaxa007.tms;

import net.minecraftforge.common.MinecraftForge;

import org.apache.logging.log4j.Level;

import timaxa007.api.IProxyModuleClient;
import timaxa007.api.IProxyPackClient;
import timaxa007.tms.event.EventClientTMS;
import cpw.mods.fml.common.FMLLog;

public class ProxyClient extends ProxyCommon {

	public static IProxyModuleClient 
	control_button,
	environment,
	status_player,
	weight,
	effects,
	colors
	;

	public static IProxyPackClient 
	furniture,
	item,
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
		if (environment != null) environment.preInit();
		if (status_player != null) status_player.preInit();
		if (weight != null) weight.preInit();
		if (effects != null) effects.preInit();
		if (colors != null) colors.preInit();

		verificationPackClient();

		if (furniture != null) furniture.preInit();
		if (item != null) item.preInit();
		if (magic != null) magic.preInit();
		if (mining != null) mining.preInit();
		if (stock != null) stock.preInit();
		if (techno != null) techno.preInit();
		if (weapon != null) weapon.preInit();

	}

	@Override
	public void init() {
		super.init();

		if (control_button != null) control_button.init();
		if (environment != null) environment.init();
		if (status_player != null) status_player.init();
		if (weight != null) weight.init();
		if (effects != null) effects.init();
		if (colors != null) colors.init();

		if (furniture != null) furniture.init();
		if (item != null) item.init();
		if (magic != null) magic.init();
		if (mining != null) mining.init();
		if (stock != null) stock.init();
		if (techno != null) techno.init();
		if (weapon != null) weapon.init();

		if (CoreTMS.debug) FMLLog.log(CoreTMS.MODID, Level.DEBUG, "Successful initialized client part.");

		MinecraftForge.EVENT_BUS.register(new EventClientTMS());

	}

	@Override
	public void postInit() {
		super.postInit();

		if (control_button != null) control_button.postInit();
		if (environment != null) environment.postInit();
		if (status_player != null) status_player.postInit();
		if (weight != null) weight.postInit();
		if (effects != null) effects.postInit();
		if (colors != null) colors.postInit();

		if (furniture != null) furniture.postInit();
		if (item != null) item.postInit();
		if (magic != null) magic.postInit();
		if (mining != null) mining.postInit();
		if (stock != null) stock.postInit();
		if (techno != null) techno.postInit();
		if (weapon != null) weapon.postInit();

	}

	public static void verificationModuleClient() {

		if (CoreTMS.isNodeControlButton)
			control_button = checkModuleClient(CoreTMS.PATH_MODULE + ".control_button.ProxyClient");

		if (CoreTMS.isNodeEnvironment)
			environment = checkModuleClient(CoreTMS.PATH_MODULE + ".environment.ProxyClient");

		if (CoreTMS.isNodeStatusPlayer)
			status_player = checkModuleClient(CoreTMS.PATH_MODULE + ".status_player.ProxyClient");

		if (CoreTMS.isNodeWeight)
			weight = checkModuleClient(CoreTMS.PATH_MODULE + ".weight.ProxyClient");

		if (CoreTMS.isNodeEffect)
			effects = checkModuleClient(CoreTMS.PATH_MODULE + ".effect.ProxyClient");

		if (CoreTMS.isNodeColors)
			colors = checkModuleClient(CoreTMS.PATH_MODULE + ".colors.ProxyClient");

	}

	public static IProxyModuleClient checkModuleClient(String node) {
		try {return (IProxyModuleClient)Class.forName(node).newInstance();}
		catch (InstantiationException e) {e.printStackTrace();}
		catch (IllegalAccessException e) {e.printStackTrace();}
		catch (ClassNotFoundException e) {e.printStackTrace();}
		return null;
	}

	public static void verificationPackClient() {

		if (CoreTMS.isPackFurniture)
			furniture = checkPackClient(CoreTMS.PATH_PACK + ".furniture.ProxyClient");

		if (CoreTMS.isPackItems)
			item = checkPackClient(CoreTMS.PATH_PACK + ".item.ProxyClient");

		if (CoreTMS.isPackMagic)
			magic = checkPackClient(CoreTMS.PATH_PACK + ".magic.ProxyClient");

		if (CoreTMS.isPackMining)
			mining = checkPackClient(CoreTMS.PATH_PACK + ".mining.ProxyClient");

		if (CoreTMS.isPackStock)
			stock = checkPackClient(CoreTMS.PATH_PACK + ".stock.ProxyClient");

		if (CoreTMS.isPackTechno)
			techno = checkPackClient(CoreTMS.PATH_PACK + ".techno.ProxyClient");

		if (CoreTMS.isPackWeapons)
			weapon = checkPackClient(CoreTMS.PATH_PACK + ".weapon.ProxyClient");

	}

	public static IProxyPackClient checkPackClient(String node) {
		try {return (IProxyPackClient)Class.forName(node).newInstance();}
		catch (InstantiationException e) {e.printStackTrace();}
		catch (IllegalAccessException e) {e.printStackTrace();}
		catch (ClassNotFoundException e) {e.printStackTrace();}
		return null;
	}

}
