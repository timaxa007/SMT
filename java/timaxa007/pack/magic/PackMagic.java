package timaxa007.pack.magic;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Logger;

import timaxa007.pack.api.IPackClass;
import timaxa007.pack.magic.block.ListBlock;
import timaxa007.pack.magic.event.EventMagic;
import timaxa007.pack.magic.event.EventMana;
import timaxa007.pack.magic.event.EventTest;
import timaxa007.pack.magic.item.ListItem;
import timaxa007.pack.magic.lib.ListMagic;
import timaxa007.pack.magic.packet.RegisterMessage;
import timaxa007.pack.magic.recipe.Recipes_Magic;
import timaxa007.pack.magic.render.RenderMain;
import timaxa007.pack.magic.util.MaterialOreMagic;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;

public class PackMagic implements IPackClass {

	public static final String MODID = "magicpack";
	public static final String MODNAME = "PackMagic";
	public static final String VERSION = "0.1a";
	public static final String[] AUTHORS = new String[] {"timaxa007"};

	public static Logger log;
	public static SimpleNetworkWrapper network;

	public static ListBlock block;
	public static ListItem item;
	public static RenderMain render;

	public static final Material ore_magic = new MaterialOreMagic();

	public static final String[] elementsNames = new String[] {
		"Air", 
		"Earth", 
		"Fire", 
		"Water", 
		"Sound", 
		"6", 
		"Lightning", 
		"Liquid", 
		"Flame", 
		"10", 
		"11", 
		"12", 
		"13", 
		"14", 
		"15", 
		"16"
	};
	//ShardElements ~= gems

	//GUI
	//public static int guiID = 0;
	public static int gui_magic_machines = 1;

	public static CreativeTabs tab_magic = new CreativeTabs("tab_magic") {
		public Item getTabIconItem() {
			return PackMagic.item.items_for_magic;
		}
	};

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		log = event.getModLog();
		log.info("Starting sub-mod " + PackMagic.MODNAME + ".");

		network = NetworkRegistry.INSTANCE.newSimpleChannel(PackMagic.MODID);
		RegisterMessage.init(network);

		Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
		cfg.load();

		block.magic_machines_be = cfg.get("block", "magic_machines", true).getBoolean(true);
		block.magic_slims_be = cfg.get("block", "magic_slims", true).getBoolean(true);
		block.magic_cauldron_be = cfg.get("block", "magic_cauldron", true).getBoolean(true);
		block.magic_locked_be = cfg.get("block", "magic_locked", true).getBoolean(true);

		item.items_for_magic_be = cfg.get("item", "items_for_magic", true).getBoolean(true);
		item.wands_be = cfg.get("item", "wands", true).getBoolean(true);
		item.stuffs_be = cfg.get("item", "stuffs", true).getBoolean(true);
		item.teleport_be = cfg.get("item", "teleport", true).getBoolean(true);
		item.globular_be = cfg.get("item", "globular", true).getBoolean(true);
		item.magic_bag_be = cfg.get("item", "magic_bag_be", true).getBoolean(true);

		cfg.save();

		new ListMagic();

		MinecraftForge.EVENT_BUS.register(new EventMagic());
		MinecraftForge.EVENT_BUS.register(new EventMana.Player());
		MinecraftForge.EVENT_BUS.register(new EventTest());

		block.preInit();
		item.preInit();

		Recipes_Magic.list();

	}

}
