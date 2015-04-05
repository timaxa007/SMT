package timaxa007.pack;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Logger;

import timaxa007.pack.api.IPackClass;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod (modid = NodePack.MODID, name = NodePack.MODNAME, version = NodePack.VERSION, dependencies = "required-after:timaxa007")

public class NodePack {

	public static final String MODID = "tms_pack";
	public static final String MODNAME = "NodePack";
	public static final String VERSION = "0.2.2a";
	public static final String PATH = "timaxa007.pack";
	public static final String[] AUTHORS = new String[] {"timaxa007"};

	@Instance(NodePack.MODID) public static NodePack instance;
	@SidedProxy(modId = NodePack.MODID, 
			clientSide = PATH + ".ProxyPackClient", 
			serverSide = PATH + ".ProxyPackCommon")
	public static ProxyPackCommon proxy;
	public static Logger log;

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

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		log = event.getModLog();
		log.info("Starting core packs, version: " + NodePack.VERSION + ".");

		Configuration cfg = new Configuration(new File("./config/tms", NodePack.MODID + ".cfg"));
		cfg.load();

		disable_pack_furniture = cfg.get("disable_pack", "furniture", false).getBoolean(false);
		disable_pack_item = cfg.get("disable_pack", "item", false).getBoolean(false);
		disable_pack_magic = cfg.get("disable_pack", "magic", false).getBoolean(false);
		disable_pack_mining = cfg.get("disable_pack", "mining", false).getBoolean(false);
		disable_pack_stocks = cfg.get("disable_pack", "stocks", false).getBoolean(false);
		disable_pack_techno = cfg.get("disable_pack", "techno", false).getBoolean(false);
		disable_pack_weapon = cfg.get("disable_pack", "weapon", false).getBoolean(false);

		cfg.save();

		verificationPack();

		if (isPackFurniture) furniture.preInit(event);
		if (isPackItems) item.preInit(event);
		if (isPackMagic) magic.preInit(event);
		if (isPackMining) mining.preInit(event);
		if (isPackStock) stock.preInit(event);
		if (isPackTechno) techno.preInit(event);
		if (isPackWeapons) weapon.preInit(event);

		proxy.preInit();

	}

	@EventHandler
	public void init(FMLInitializationEvent event) {

		NetworkRegistry.INSTANCE.registerGuiHandler(NodePack.MODID, new HandlerGuiNodePack());

		proxy.init();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit();
	}

	public static void verificationPack() {

		if (!disable_pack_furniture)
			furniture = checkPack(PATH + ".furniture.PackFurniture");
		isPackFurniture = furniture != null;

		if (!disable_pack_item)
			item = checkPack(PATH + ".item.PackItems");
		isPackItems = item != null;

		if (!disable_pack_magic)
			magic = checkPack(PATH + ".magic.PackMagic");
		isPackMagic = magic != null;

		if (!disable_pack_mining)
			mining = checkPack(PATH + ".mining.PackMining");
		isPackMining = mining != null;

		if (!disable_pack_stocks)
			stock = checkPack(PATH + ".stock.PackStock");
		isPackStock = stock != null;

		if (!disable_pack_techno)
			techno = checkPack(PATH + ".techno.PackTechno");
		isPackTechno = techno != null;

		if (!disable_pack_weapon)
			weapon = checkPack(PATH + ".weapon.PackWeapons");
		isPackWeapons = weapon != null;

	}

	public static IPackClass checkPack(String node) {
		try {return (IPackClass)Class.forName(node).newInstance();}
		catch (InstantiationException e) {e.printStackTrace();}
		catch (IllegalAccessException e) {e.printStackTrace();}
		catch (ClassNotFoundException e) {e.printStackTrace();}
		return null;
	}

}
