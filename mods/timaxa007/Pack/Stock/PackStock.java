package mods.timaxa007.Pack.Stock;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod (modid = PackInfo.MODID, name = PackInfo.MODNAME, version = PackInfo.VERSION, dependencies = "required-after:01miningpack")
@NetworkMod (clientSideRequired = true, serverSideRequired = false, versionBounds = PackInfo.VERSION)
//@NetworkMod (channels = PackInfo.MODID, clientSideRequired = true, serverSideRequired = true, versionBounds = PackInfo.VERSION)

public class PackStock {
@Instance(PackInfo.MODID) public static PackStock instance;
@SidedProxy(clientSide="mods.timaxa007.Pack.Stock.ProxyClient", serverSide="mods.timaxa007.Pack.Stock.ProxyServer")
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
