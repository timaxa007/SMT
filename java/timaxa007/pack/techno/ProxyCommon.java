package timaxa007.pack.techno;

import timaxa007.pack.techno.block.ListBlock;
import timaxa007.pack.techno.event.EventTechno;
import timaxa007.pack.techno.gui.HandlerGuiTechno;
import timaxa007.pack.techno.item.ListItem;
import timaxa007.pack.techno.lib.ListTechno;
import timaxa007.pack.techno.recipe.Recipes_Techno;
import timaxa007.pack.techno.render.RenderMain;
import timaxa007.tms.util.IProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

public class ProxyCommon implements IProxy {

	public static ListBlock block;
	public static ListItem item;
	public static RenderMain render;

	//GUI
	//public static int guiID = 0;
	public static int gui_electric_machines = 1;

	public void preInit(FMLPreInitializationEvent event) {

		Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
		cfg.load();

		block.electric_machines_be = cfg.get("block", "electric_machines", true).getBoolean(true);
		block.electric_wires_be = cfg.get("block", "electric_wires", true).getBoolean(true);
		block.chip_be = cfg.get("block", "chip", true).getBoolean(true);
		block.module_movement_be = cfg.get("block", "module_movement", true).getBoolean(true);
		block.farm_mashines_be = cfg.get("block", "farm_mashines", true).getBoolean(true);

		item.items_for_techno_be = cfg.get("item", "items_for_techno", true).getBoolean(true);
		item.tool_electric_wrench_be = cfg.get("item", "tool_electric_wrench", true).getBoolean(true);
		item.tool_electric_drills_be = cfg.get("item", "tool_electric_drills", true).getBoolean(true);

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
