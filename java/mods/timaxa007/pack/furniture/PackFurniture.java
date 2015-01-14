package mods.timaxa007.pack.furniture;

import mods.timaxa007.pack.furniture.packet.RegisterPacket;
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

@Mod (modid = PackFurniture.MODID, name = PackFurniture.MODNAME, version = PackFurniture.VERSION, dependencies = "required-after:timaxa007")

public class PackFurniture {

	public static final String MODID = "furniturepack";
	public static final String MODNAME = "PackFurniture";
	public static final String VERSION = "0.1a";
	public static final String AUTHOR = "timaxa007";

	@Instance(PackFurniture.MODID) public static PackFurniture instance;
	@SidedProxy(modId = PackFurniture.MODID, clientSide = "mods.timaxa007.pack.furniture.ProxyClient", serverSide = "mods.timaxa007.pack.furniture.ProxyCommon")
	public static ProxyCommon proxy;
	public static Logger log;
	public static SimpleNetworkWrapper network;

	public static CreativeTabs tab_furniture = new CreativeTabs("tab_furniture") {
		public Item getTabIconItem() {
			return Item.getItemFromBlock(PackFurniture.proxy.block.cnstor_block);
		}
	};

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		log = event.getModLog();
		log.info("Startimg sub-mod " + PackFurniture.MODNAME + ".");

		network = NetworkRegistry.INSTANCE.newSimpleChannel(PackFurniture.MODID);
		RegisterPacket.init(network);

		proxy.preInit(event);

	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init();
	}

}
