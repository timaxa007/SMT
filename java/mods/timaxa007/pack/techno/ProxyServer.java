package mods.timaxa007.pack.techno;

import mods.timaxa007.pack.techno.block.BlockList;
import mods.timaxa007.pack.techno.event.EventTechno;
import mods.timaxa007.pack.techno.gui.HandlerGuiTechno;
import mods.timaxa007.pack.techno.item.ItemList;
import mods.timaxa007.pack.techno.lib.ListTechno;
import mods.timaxa007.pack.techno.recipe.Recipes_Techno;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

public class ProxyServer {

	public static BlockList block;
	public static ItemList item;

	//GUI
	//public static int guiID=0;
	public static int gui_electric_machines = 1;

	//Render Model ID
	public static int render_block_electric_wires_modelID;
	public static int render_block_chip_modelID;
	public static int render_block_module_movement_modelID;

	public void preInit(FMLPreInitializationEvent event) {

		Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
		cfg.load();

		cfg.save();

		new ListTechno();

		block.list();
		item.list();

		render_block_electric_wires_modelID = -1;
		render_block_chip_modelID = -1;
		render_block_module_movement_modelID = -1;

		Recipes_Techno.list();

		MinecraftForge.EVENT_BUS.register(new EventTechno());

	}

	public void init() {

		NetworkRegistry.INSTANCE.registerGuiHandler(PackTechno.MODID, new HandlerGuiTechno());

	}

}
