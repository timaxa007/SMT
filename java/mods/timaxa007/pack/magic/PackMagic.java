package mods.timaxa007.pack.magic;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod (modid = PackMagic.MODID, name = PackMagic.MODNAME, version = PackMagic.VERSION, dependencies = "required-after:04technopack")
//@NetworkMod (clientSideRequired = true, serverSideRequired = false, versionBounds = PackInfo.VERSION)
//@NetworkMod (channels = PackInfo.MODID, clientSideRequired = true, serverSideRequired = true, versionBounds = PackInfo.VERSION)

public class PackMagic {

	public static final String MODID = "05magicpack";
	public static final String MODNAME = "MagicPack";
	public static final String VERSION = "0.1a";
	public static final String AUTHOR = "timaxa007";

	@Instance(PackMagic.MODID) public static PackMagic instance;
	@SidedProxy(clientSide = "mods.timaxa007.pack.magic.ProxyClient", serverSide = "mods.timaxa007.pack.magic.ProxyServer")
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
