package mods.timaxa007.pack.weapon;

import mods.timaxa007.pack.weapon.util.PacketWeapons;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

@Mod (modid = PackWeapons.MODID, name = PackWeapons.MODNAME, version = PackWeapons.VERSION, dependencies = "required-after:05magicpack")
//@NetworkMod (clientSideRequired = true, serverSideRequired = false, versionBounds = PackInfo.VERSION)
//@NetworkMod (channels = PackInfo.MODID, clientSideRequired = true, serverSideRequired = true, versionBounds = PackInfo.VERSION)

public class PackWeapons {

	public static final String MODID = "06weaponpack";
	public static final String MODNAME = "WeaponPack";
	public static final String VERSION = "0.1a";
	public static final String AUTHOR = "timaxa007";

	@Instance(PackWeapons.MODID) public static PackWeapons instance;
	@SidedProxy(clientSide = "mods.timaxa007.pack.weapon.ProxyClient", serverSide = "mods.timaxa007.pack.weapon.ProxyServer")
	public static ProxyServer proxy;
	public static SimpleNetworkWrapper network;

	public static CreativeTabs tab_weapons = new CreativeTabs("tab_weapons") {
		public Item getTabIconItem() {
			return PackWeapons.proxy.item.items_for_weapons;
		}
	};

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		network = NetworkRegistry.INSTANCE.newSimpleChannel(PackWeapons.MODID);
		network.registerMessage(PacketWeapons.Handler.class, PacketWeapons.class, 0, Side.SERVER);

		proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init();
	}

}
