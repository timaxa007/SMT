package mods.timaxa007.pack.magic;

import mods.timaxa007.pack.magic.block.BlockList;
import mods.timaxa007.pack.magic.event.EventMagic;
import mods.timaxa007.pack.magic.gui.HandlerGuiMagic;
import mods.timaxa007.pack.magic.item.ItemList;
import mods.timaxa007.pack.magic.lib.ListMagic;
import mods.timaxa007.pack.magic.recipe.Recipes_Magic;
import mods.timaxa007.pack.magic.render.RenderMain;
import mods.timaxa007.pack.magic.util.MaterialOreMagic;
import mods.timaxa007.tms.util.IProxy;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

public class ProxyCommon implements IProxy {

	public static BlockList block;
	public static ItemList item;
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
	//ShardElements = gems

	//GUI
	//public static int guiID = 0;
	public static int gui_magic_machines = 1;

	public void preInit(FMLPreInitializationEvent event) {

		Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
		cfg.load();
		//
		cfg.save();

		new ListMagic();

		block.preInit();
		item.preInit();
		render.preInit();

		Recipes_Magic.list();

		MinecraftForge.EVENT_BUS.register(new EventMagic());

	}

	public void init() {

		NetworkRegistry.INSTANCE.registerGuiHandler(PackMagic.MODID, new HandlerGuiMagic());

	}

}
