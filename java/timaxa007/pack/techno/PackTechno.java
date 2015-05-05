package timaxa007.pack.techno;

import java.io.File;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Logger;

import timaxa007.api.IPackClass;
import timaxa007.pack.techno.block.ListBlock;
import timaxa007.pack.techno.event.EventTechno;
import timaxa007.pack.techno.item.ListItem;
import timaxa007.pack.techno.lib.ListTechno;
import timaxa007.pack.techno.packet.RegisterMessage;
import timaxa007.pack.techno.recipe.Recipes_Techno;
import timaxa007.pack.techno.render.RenderMain;
import timaxa007.pack.techno.util.MaterialTechno;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PackTechno implements IPackClass {

	public static final String MODID = "technopack";
	public static final String MODNAME = "PackTechno";
	public static final String VERSION = "0.1a";
	public static final String[] AUTHORS = new String[] {"timaxa007"};

	public static Logger log;
	public static SimpleNetworkWrapper network;

	public static Material techno_block = new MaterialTechno();

	public static ListBlock block;
	public static ListItem item;
	public static RenderMain render;

	//GUI
	//public static int guiID = 0;
	public static int gui_electric_machines = 1;

	public static CreativeTabs tab_techno = new CreativeTabs("tab_techno") {
		@SideOnly(Side.CLIENT) public Item getTabIconItem() {return PackTechno.item.items_for_techno;}
	};

	@Override
	public void preInit(FMLPreInitializationEvent event) {

		log = event.getModLog();
		log.info("Starting sub-mod " + PackTechno.MODNAME + ".");

		Configuration cfg = new Configuration(new File("./config/tms/pack", PackTechno.MODID + ".cfg"));
		cfg.load();

		block.electric_machines_be = cfg.get("block", "electric_machines", true).getBoolean();
		block.electric_wires_be = cfg.get("block", "electric_wires", true).getBoolean();
		block.chip_be = cfg.get("block", "chip", true).getBoolean(true);
		block.module_movement_be = cfg.get("block", "module_movement", true).getBoolean();
		block.farm_mashines_be = cfg.get("block", "farm_mashines", true).getBoolean();

		item.items_for_techno_be = cfg.get("item", "items_for_techno", true).getBoolean();
		item.tool_electric_wrench_be = cfg.get("item", "tool_electric_wrench", true).getBoolean();
		item.tool_electric_drill_be = cfg.get("item", "tool_electric_drill", true).getBoolean();
		item.tool_electric_saw_be = cfg.get("item", "tool_electric_saw", true).getBoolean();

		cfg.save();

		network = NetworkRegistry.INSTANCE.newSimpleChannel(PackTechno.MODID);
		RegisterMessage.init(network);

		new ListTechno();

		block.preInit();
		item.preInit();

		Recipes_Techno.list();

		MinecraftForge.EVENT_BUS.register(new EventTechno());

	}

}
