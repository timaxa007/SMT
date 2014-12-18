package mods.timaxa007.pack.weapon;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod (modid = PackWeapon.MODID, name = PackWeapon.MODNAME, version = PackWeapon.VERSION, dependencies = "required-after:05magicpack")
//@NetworkMod (clientSideRequired = true, serverSideRequired = false, versionBounds = PackInfo.VERSION)
//@NetworkMod (channels = PackInfo.MODID, clientSideRequired = true, serverSideRequired = true, versionBounds = PackInfo.VERSION)

public class PackWeapon {

	public static final String MODID = "06weaponpack";
	public static final String MODNAME = "WeaponPack";
	public static final String VERSION = "0.1a";
	public static final String AUTHOR = "timaxa007";

	@Instance(PackWeapon.MODID) public static PackWeapon instance;
	@SidedProxy(clientSide = "mods.timaxa007.pack.weapon.ProxyClient", serverSide = "mods.timaxa007.pack.weapon.ProxyServer")
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
