package timaxa007.pack.stock;

import timaxa007.pack.stock.packet.RegisterMessage;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod (modid = PackStock.MODID, name = PackStock.MODNAME, version = PackStock.VERSION, dependencies = "required-after:timaxa007")

public class PackStock {

	public static final String MODID = "stockpack";
	public static final String MODNAME = "PackStock";
	public static final String VERSION = "0.1a";
	public static final String[] AUTHORS = new String[] {"timaxa007"};

	@Instance(PackStock.MODID) public static PackStock instance;
	@SidedProxy(modId = PackStock.MODID, clientSide="timaxa007.pack.stock.ProxyClient", serverSide="timaxa007.pack.stock.ProxyCommon")
	public static ProxyCommon proxy;
	public static Logger log;
	public static SimpleNetworkWrapper network;

	public static CreativeTabs tab_stock = new CreativeTabs("tab_stock") {
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {return PackStock.proxy.item.items_for_stock;}
	};
	public static CreativeTabs tab_plant = new CreativeTabs("tab_plant") {
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {return PackStock.proxy.item.germination_plants;}
	};
	public static CreativeTabs tab_food = new CreativeTabs("tab_food") {
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {return PackStock.proxy.item.foods;}
	};
	public static CreativeTabs tab_medical = new CreativeTabs("tab_medical") {
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {return PackStock.proxy.item.medicals;}
	};
	public static CreativeTabs tab_apis = new CreativeTabs("tab_apis") {
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {return PackStock.proxy.item.bees;}
	};

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		log = event.getModLog();
		log.info("Starting sub-mod " + PackStock.MODNAME + ".");

		network = NetworkRegistry.INSTANCE.newSimpleChannel(PackStock.MODID);
		RegisterMessage.init(network);

		proxy.preInit(event);

	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init();
	}

}
