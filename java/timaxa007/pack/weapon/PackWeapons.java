package timaxa007.pack.weapon;

import java.io.File;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Logger;

import timaxa007.api.IPackClass;
import timaxa007.pack.weapon.block.ListBlock;
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

public class PackWeapons implements IPackClass {

	public static final String MODID = "weaponpack";
	public static final String MODNAME = "PackWeapon";
	public static final String VERSION = "0.120";
	public static final String[] AUTHORS = new String[] {"timaxa007"};

	//GUI
	public static int gui_scope_1 = 1;
	public static int gui_modify = 19;

	public static ListBlock block;
	public static ListItem item;
	public static RenderMain render;
	public static Logger log;
	public static SimpleNetworkWrapper network;

	public static CreativeTabs tab_weapons = new CreativeTabs("tab_weapons") {
		@SideOnly(Side.CLIENT) public Item getTabIconItem() {return PackWeapons.item.items_for_weapons;}
	};

	@Override
	public void preInit(FMLPreInitializationEvent event) {

		log = event.getModLog();
		log.info("Starting sub-mod " + PackWeapons.MODNAME + ", build: " + PackWeapons.VERSION + ".");

		Configuration cfg = new Configuration(new File("./config/tms/pack", PackWeapons.MODID + ".cfg"));
		cfg.load();

		block.claymore_be = cfg.get("block", "claymore", true).getBoolean();

		item.items_for_weapons_be = cfg.get("item", "items_for_weapons", true).getBoolean();
		item.molotov_cocktail_be = cfg.get("item", "molotov_cocktail", true).getBoolean();
		item.weapons_be = cfg.get("item", "weapons", true).getBoolean();
		item.ammos_be = cfg.get("item", "ammos", true).getBoolean();
		item.magazines_be = cfg.get("item", "magazines", true).getBoolean();

		cfg.save();

		network = NetworkRegistry.INSTANCE.newSimpleChannel(PackWeapons.MODID);
		RegisterMessage.init(network);

		new ListWeapon();

		block.preInit();
		item.preInit();

		Recipes_Weapons.list();

	}

	public void init(FMLInitializationEvent event) {

	}

}
