package timaxa007.pack.weapon;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Logger;

import timaxa007.pack.api.IPackClass;
import timaxa007.pack.weapon.block.ListBlock;
import timaxa007.pack.weapon.item.ListItem;
import timaxa007.pack.weapon.lib.ListWeapon;
import timaxa007.pack.weapon.packet.RegisterMessage;
import timaxa007.pack.weapon.recipe.Recipes_Weapons;
import timaxa007.pack.weapon.render.RenderMain;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PackWeapons implements IPackClass {

	public static final String MODID = "weaponpack";
	public static final String MODNAME = "PackWeapon";
	public static final String VERSION = "0.1a";
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
	    @SideOnly(Side.CLIENT)
		public Item getTabIconItem() {return PackWeapons.item.items_for_weapons;}
	};

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		log = event.getModLog();
		log.info("Starting sub-mod " + PackWeapons.MODNAME + ".");

		network = NetworkRegistry.INSTANCE.newSimpleChannel(PackWeapons.MODID);
		RegisterMessage.init(network);

		Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
		cfg.load();

		block.claymore_be = cfg.get("block", "claymore", true).getBoolean(true);

		item.items_for_weapons_be = cfg.get("item", "items_for_weapons", true).getBoolean(true);
		item.molotov_cocktail_be = cfg.get("item", "molotov_cocktail", true).getBoolean(true);
		item.weapons_be = cfg.get("item", "weapons", true).getBoolean(true);
		item.ammos_be = cfg.get("item", "ammos", true).getBoolean(true);
		item.magazines_be = cfg.get("item", "magazines", true).getBoolean(true);

		cfg.save();

		new ListWeapon();

		block.preInit();
		item.preInit();

		Recipes_Weapons.list();

	}

	@EventHandler
	public void init(FMLInitializationEvent event) {

	}

}
