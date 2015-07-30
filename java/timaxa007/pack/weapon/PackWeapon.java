package timaxa007.pack.weapon;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import org.apache.logging.log4j.Logger;

import timaxa007.api.IPackClass;
import timaxa007.pack.NodePack.PackNode;
import timaxa007.pack.weapon.block.ListBlock;
import timaxa007.pack.weapon.config.ConfigWeapon;
import timaxa007.pack.weapon.item.ListItem;
import timaxa007.pack.weapon.lib.ListWeapon;
import timaxa007.pack.weapon.packet.RegisterMessage;
import timaxa007.pack.weapon.recipe.Recipes_Weapons;
import timaxa007.pack.weapon.render.RenderMain;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@PackNode(moduleTag = PackWeapon.MODID, moduleName = PackWeapon.MODNAME, moduleVersion = PackWeapon.VERSION)
/**@author timaxa007**/
public class PackWeapon implements IPackClass {

	public static final String MODID = "weaponpack";
	public static final String MODNAME = "PackWeapon";
	public static final String VERSION = "0.121";

	public static final ConfigWeapon config = new ConfigWeapon();
	public static final ListBlock block = new ListBlock();
	public static final ListItem item = new ListItem();
	public static final RenderMain render = new RenderMain();
	public static Logger log;
	public static SimpleNetworkWrapper network;

	public static final CreativeTabs tab_weapons = new CreativeTabs("tab_weapons") {
		@SideOnly(Side.CLIENT) public Item getTabIconItem() {return PackWeapon.item.items_for_weapons;}
	};

	@Override
	public void preInit(FMLPreInitializationEvent event) {

		log = event.getModLog();
		log.info("Starting sub-mod " + PackWeapon.MODNAME + ", build: " + PackWeapon.VERSION + ".");

		config.main();

		network = NetworkRegistry.INSTANCE.newSimpleChannel(PackWeapon.MODID);
		RegisterMessage.init(network);

		ListWeapon.init();

		block.preInit();
		item.preInit();

		Recipes_Weapons.list();

	}

	public void init(FMLInitializationEvent event) {

	}

}
