package timaxa007.pack.magic;

import timaxa007.pack.magic.block.ListBlock;
import timaxa007.pack.magic.event.EventMagic;
import timaxa007.pack.magic.event.EventMana;
import timaxa007.pack.magic.gui.HandlerGuiMagic;
import timaxa007.pack.magic.item.ListItem;
import timaxa007.pack.magic.lib.ListMagic;
import timaxa007.pack.magic.lib.Spells;
import timaxa007.pack.magic.recipe.Recipes_Magic;
import timaxa007.pack.magic.render.RenderMain;
import timaxa007.pack.magic.util.MaterialOreMagic;
import timaxa007.tms.EventTest;
import timaxa007.tms.util.IProxy;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

public class ProxyCommon implements IProxy {

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

	public void preInit(FMLPreInitializationEvent event) {

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

		cfg.save();

		new ListMagic();

		MinecraftForge.EVENT_BUS.register(new EventMagic());
		MinecraftForge.EVENT_BUS.register(new EventMana.Player());
		MinecraftForge.EVENT_BUS.register(new EventTest());

		block.preInit();
		item.preInit();
		render.preInit();

		Recipes_Magic.list();

	}

	public void init() {

		NetworkRegistry.INSTANCE.registerGuiHandler(PackMagic.MODID, new HandlerGuiMagic());
		MinecraftForge.EVENT_BUS.register(new Spells.EventSpellsCommon());
		FMLCommonHandler.instance().bus().register(new EventMana.Server());

	}

}
