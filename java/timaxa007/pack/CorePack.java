package timaxa007.pack;

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

@Mod (modid = CorePack.MODID, name = CorePack.MODNAME, version = CorePack.VERSION, dependencies = "required-after:timaxa007")

public class CorePack {

	public static final String MODID = "pack_tms";
	public static final String MODNAME = "CorePack";
	public static final String VERSION = "0.2.2a";
	public static final String[] AUTHORS = new String[] {"timaxa007"};

	@Instance(CorePack.MODID) public static CorePack instance;
	@SidedProxy(modId = CorePack.MODID, 
			clientSide = "timaxa007.pack.ProxyPackClient", 
			serverSide = "timaxa007.pack.ProxyPackCommon")
	public static ProxyPackCommon proxy;
	public static Logger log;

	public static IPackClass
	furniture,
	item,
	magic,
	mining,
	stocks,
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
		log.info("Starting core packs, version: " + CorePack.VERSION + ".");

		Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
		cfg.load();

		disable_pack_furniture = cfg.get("disable_pack", "furniture", false).getBoolean(false);
		disable_pack_item = cfg.get("disable_pack", "item", false).getBoolean(false);
		disable_pack_magic = cfg.get("disable_pack", "magic", false).getBoolean(false);
		disable_pack_mining = cfg.get("disable_pack", "mining", false).getBoolean(false);
		disable_pack_stocks = cfg.get("disable_pack", "stocks", false).getBoolean(false);
		disable_pack_techno = cfg.get("disable_pack", "techno", false).getBoolean(false);
		disable_pack_weapon = cfg.get("disable_pack", "weapon", false).getBoolean(false);

		cfg.save();

		listPack();

		isPackFurniture = furniture != null;
		isPackItems = item != null;
		isPackMagic = magic != null;
		isPackMining = mining != null;
		isPackStock = stocks != null;
		isPackTechno = techno != null;
		isPackWeapons = weapon != null;

		if (isPackFurniture) furniture.preInit(event);
		if (isPackItems) item.preInit(event);
		if (isPackMagic) magic.preInit(event);
		if (isPackMining) mining.preInit(event);
		if (isPackStock) stocks.preInit(event);
		if (isPackTechno) techno.preInit(event);
		if (isPackWeapons) weapon.preInit(event);

		proxy.preInit();

	}

	@EventHandler
	public void init(FMLInitializationEvent event) {

		NetworkRegistry.INSTANCE.registerGuiHandler(CorePack.MODID, new HandlerGuiCorePack());

		proxy.init();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit();
	}

	public static void listPack() {
		//------------------------------------------------------------------------------------
		if (!disable_pack_furniture) {
			try {
				String node_furniture = "timaxa007.pack.furniture.PackFurniture";
				Object o_furniture = Class.forName(node_furniture).newInstance();
				furniture = (IPackClass)o_furniture;
			}
			catch (InstantiationException e) {e.printStackTrace();}
			catch (IllegalAccessException e) {e.printStackTrace();}
			catch (ClassNotFoundException e) {e.printStackTrace();}
		}
		//------------------------------------------------------------------------------------
		if (!disable_pack_item) {
			try {
				String node_item = "timaxa007.pack.item.PackItems";
				Object o_item = Class.forName(node_item).newInstance();
				item = (IPackClass)o_item;
			}
			catch (InstantiationException e) {e.printStackTrace();}
			catch (IllegalAccessException e) {e.printStackTrace();}
			catch (ClassNotFoundException e) {e.printStackTrace();}
		}
		//------------------------------------------------------------------------------------
		if (!disable_pack_magic) {
			try {
				String node_magic = "timaxa007.pack.magic.PackMagic";
				Object o_magic = Class.forName(node_magic).newInstance();
				magic = (IPackClass)o_magic;
			}
			catch (InstantiationException e) {e.printStackTrace();}
			catch (IllegalAccessException e) {e.printStackTrace();}
			catch (ClassNotFoundException e) {e.printStackTrace();}
		}
		//------------------------------------------------------------------------------------
		if (!disable_pack_mining) {
			try {
				String node_mining = "timaxa007.pack.mining.PackMining";
				Object o_mining = Class.forName(node_mining).newInstance();
				mining = (IPackClass)o_mining;
			}
			catch (InstantiationException e) {e.printStackTrace();}
			catch (IllegalAccessException e) {e.printStackTrace();}
			catch (ClassNotFoundException e) {e.printStackTrace();}
		}
		//------------------------------------------------------------------------------------
		if (!disable_pack_stocks) {
			try {
				String node_stocks = "timaxa007.pack.stock.PackStock";
				Object o_stocks = Class.forName(node_stocks).newInstance();
				stocks = (IPackClass)o_stocks;
			}
			catch (InstantiationException e) {e.printStackTrace();}
			catch (IllegalAccessException e) {e.printStackTrace();}
			catch (ClassNotFoundException e) {e.printStackTrace();}
		}
		//------------------------------------------------------------------------------------
		if (!disable_pack_techno) {
			try {
				String node_techno = "timaxa007.pack.techno.PackTechno";
				Object o_techno = Class.forName(node_techno).newInstance();
				techno = (IPackClass)o_techno;
			}
			catch (InstantiationException e) {e.printStackTrace();}
			catch (IllegalAccessException e) {e.printStackTrace();}
			catch (ClassNotFoundException e) {e.printStackTrace();}
		}
		//------------------------------------------------------------------------------------
		if (!disable_pack_weapon) {
			try {
				String node_weapon = "timaxa007.pack.weapon.PackWeapons";
				Object o_weapon = Class.forName(node_weapon).newInstance();
				weapon = (IPackClass)o_weapon;
			}
			catch (InstantiationException e) {e.printStackTrace();}
			catch (IllegalAccessException e) {e.printStackTrace();}
			catch (ClassNotFoundException e) {e.printStackTrace();}
		}
		//------------------------------------------------------------------------------------
	}

}
