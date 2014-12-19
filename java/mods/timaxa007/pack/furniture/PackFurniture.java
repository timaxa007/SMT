package mods.timaxa007.pack.furniture;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod (modid = PackFurniture.MODID, name = PackFurniture.MODNAME, version = PackFurniture.VERSION, dependencies = "required-after:02stockpack")
//@NetworkMod (clientSideRequired = true, serverSideRequired = false, versionBounds = PackInfo.VERSION)
//@NetworkMod (channels = PackInfo.MODID, clientSideRequired = true, serverSideRequired = true, versionBounds = PackInfo.VERSION)

public class PackFurniture {

	public static final String MODID = "03furniturepack";
	public static final String MODNAME = "FurniturePack";
	public static final String VERSION = "0.1a";
	public static final String AUTHOR = "timaxa007";

	@Instance(PackFurniture.MODID) public static PackFurniture instance;
	@SidedProxy(clientSide = "mods.timaxa007.pack.furniture.ProxyClient", serverSide = "mods.timaxa007.pack.furniture.ProxyServer")
	public static ProxyServer proxy;

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init();
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit(event);
	}

}
