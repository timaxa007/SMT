package mods.timaxa007.pack.stock;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod (modid = PackStock.MODID, name = PackStock.MODNAME, version = PackStock.VERSION, dependencies = "required-after:01miningpack")
//@NetworkMod (clientSideRequired = true, serverSideRequired = false, versionBounds = PackInfo.VERSION)
//@NetworkMod (channels = PackInfo.MODID, clientSideRequired = true, serverSideRequired = true, versionBounds = PackInfo.VERSION)

public class PackStock {

public static final String MODID = "02stockpack";
public static final String MODNAME = "StockPack";
public static final String VERSION = "0.1a";
public static final String AUTHOR = "timaxa007";

@Instance(PackStock.MODID) public static PackStock instance;
@SidedProxy(clientSide="mods.timaxa007.pack.stock.ProxyClient", serverSide="mods.timaxa007.pack.stock.ProxyServer")
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
