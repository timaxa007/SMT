package mods.timaxa007.pack.mining;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod (modid = PackMining.MODID, name = PackMining.MODNAME, version = PackMining.VERSION, dependencies = "required-after:timaxa007")
//@NetworkMod (clientSideRequired = true, serverSideRequired = false, versionBounds = PackInfo.VERSION)
//@NetworkMod (channels = PackInfo.MODID, clientSideRequired = true, serverSideRequired = true, versionBounds = "1.0.0")

public class PackMining {

	public static final String MODID = "01miningpack";
	public static final String MODNAME = "MiningPack";
	public static final String VERSION = "0.1a";
	public static final String AUTHOR = "timaxa007";

	@Instance(PackMining.MODID) public static PackMining instance;
	@SidedProxy(clientSide = "mods.timaxa007.pack.mining.ProxyClient", serverSide = "mods.timaxa007.pack.mining.ProxyCommon")
	public static ProxyCommon proxy;

	public static CreativeTabs tab_mining = new CreativeTabs("tab_mining") {
		public Item getTabIconItem() {
			return PackMining.proxy.item.items_for_mining;
		}
	};
	public static CreativeTabs tab_tools = new CreativeTabs("tab_tools") {
		public Item getTabIconItem() {
			return PackMining.proxy.item.items_for_mining;
		}
	};

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init();

	}

}
