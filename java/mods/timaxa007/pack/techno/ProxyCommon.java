package mods.timaxa007.pack.techno;

import mods.timaxa007.pack.techno.block.ListBlock;
import mods.timaxa007.pack.techno.event.EventTechno;
import mods.timaxa007.pack.techno.gui.HandlerGuiTechno;
import mods.timaxa007.pack.techno.item.ListItem;
import mods.timaxa007.pack.techno.lib.ListTechno;
import mods.timaxa007.pack.techno.recipe.Recipes_Techno;
import mods.timaxa007.pack.techno.render.RenderMain;
import mods.timaxa007.tms.util.IProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

public class ProxyCommon implements IProxy {

	public static ListBlock block;
	public static ListItem item;
	public static RenderMain render;

	//GUI
	//public static int guiID=0;
	public static int gui_electric_machines = 1;

	public void preInit(FMLPreInitializationEvent event) {

		Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
		cfg.load();
		//
		cfg.save();

		new ListTechno();

		block.preInit();
		item.preInit();
		render.preInit();

		Recipes_Techno.list();

		MinecraftForge.EVENT_BUS.register(new EventTechno());

	}

	public void init() {

		NetworkRegistry.INSTANCE.registerGuiHandler(PackTechno.MODID, new HandlerGuiTechno());

	}

}