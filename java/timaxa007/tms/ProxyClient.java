package timaxa007.tms;

import net.minecraftforge.common.MinecraftForge;

import org.apache.logging.log4j.Level;

import timaxa007.api.IProxyModuleClient;
import timaxa007.api.IProxyPackClient;
import timaxa007.tms.event.EventClientTMS;
import timaxa007.tms.lib.LangLib;
import cpw.mods.fml.common.FMLLog;

public class ProxyClient extends ProxyCommon {

	public static IProxyModuleClient 
	control_button,
	environment,
	status_player,
	weight,
	effects,
	colors,
	fluids
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
		if (fluids != null) fluids.preInit();

		verificationPackClient();

		if (furniture != null) furniture.preInit();
		if (item != null) item.preInit();
		if (magic != null) magic.preInit();
		if (mining != null) mining.preInit();
		if (stock != null) stock.preInit();
		if (techno != null) techno.preInit();
		if (weapon != null) weapon.preInit();

		LangLib.init(CoreTMS.MODID);

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
		if (fluids != null) fluids.init();

		if (furniture != null) furniture.init();
		if (item != null) item.init();
		if (magic != null) magic.init();
		if (mining != null) mining.init();
		if (stock != null) stock.init();
		if (techno != null) techno.init();
		if (weapon != null) weapon.init();

		if (CoreTMS.config.debug) FMLLog.log(CoreTMS.MODID, Level.DEBUG, "Successful initialized client part.");

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
		if (fluids != null) fluids.postInit();

		if (furniture != null) furniture.postInit();
		if (item != null) item.postInit();
		if (magic != null) magic.postInit();
		if (mining != null) mining.postInit();
		if (stock != null) stock.postInit();
		if (techno != null) techno.postInit();
		if (weapon != null) weapon.postInit();

	}

	public static void verificationModuleClient() {

		if (CoreTMS.config.isNodeControlButton)
			control_button = checkModuleClient(CoreTMS.PATH_MODULE + ".control_button.ProxyClient");

		if (CoreTMS.config.isNodeEnvironment)
			environment = checkModuleClient(CoreTMS.PATH_MODULE + ".environment.ProxyClient");

		if (CoreTMS.config.isNodeStatusPlayer)
			status_player = checkModuleClient(CoreTMS.PATH_MODULE + ".status_player.ProxyClient");

		if (CoreTMS.config.isNodeWeight)
			weight = checkModuleClient(CoreTMS.PATH_MODULE + ".weight.ProxyClient");

		if (CoreTMS.config.isNodeEffect)
			effects = checkModuleClient(CoreTMS.PATH_MODULE + ".effect.ProxyClient");

		if (CoreTMS.config.isNodeColors)
			colors = checkModuleClient(CoreTMS.PATH_MODULE + ".colors.ProxyClient");

		if (CoreTMS.config.isNodeFluids)
			fluids = checkModuleClient(CoreTMS.PATH_MODULE + ".fluids.ProxyClient");

	}

	public static IProxyModuleClient checkModuleClient(String node) {
		try {return (IProxyModuleClient)Class.forName(node).newInstance();}
		catch (InstantiationException e) {e.printStackTrace();}
		catch (IllegalAccessException e) {e.printStackTrace();}
		catch (ClassNotFoundException e) {e.printStackTrace();}
		return null;
	}

	public static void verificationPackClient() {

		if (CoreTMS.config.isPackFurniture)
			furniture = checkPackClient(CoreTMS.PATH_PACK + ".furniture.ProxyClient");

		if (CoreTMS.config.isPackItems)
			item = checkPackClient(CoreTMS.PATH_PACK + ".item.ProxyClient");

		if (CoreTMS.config.isPackMagic)
			magic = checkPackClient(CoreTMS.PATH_PACK + ".magic.ProxyClient");

		if (CoreTMS.config.isPackMining)
			mining = checkPackClient(CoreTMS.PATH_PACK + ".mining.ProxyClient");

		if (CoreTMS.config.isPackStock)
			stock = checkPackClient(CoreTMS.PATH_PACK + ".stock.ProxyClient");

		if (CoreTMS.config.isPackTechno)
			techno = checkPackClient(CoreTMS.PATH_PACK + ".techno.ProxyClient");

		if (CoreTMS.config.isPackWeapons)
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
