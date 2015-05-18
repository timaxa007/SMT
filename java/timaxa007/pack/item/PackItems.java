package timaxa007.pack.item;

import java.io.File;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Logger;

import timaxa007.api.IPackClass;
import timaxa007.pack.item.block.ListBlock;
import timaxa007.pack.item.item.ListItem;
import timaxa007.pack.item.lib.ListPackItems;
import timaxa007.pack.item.packet.RegisterMessage;
import timaxa007.pack.item.recipe.RecipeToolHammer;
import timaxa007.pack.item.recipe.Recipes_PackItems;
import timaxa007.pack.item.render.RenderMain;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**@author timaxa007**/
public class PackItems implements IPackClass {

	public static final String MODID = "itemspack";
	public static final String MODNAME = "PackItems";
	public static final String VERSION = "0.117";

	public static Logger log;
	public static SimpleNetworkWrapper network;

	public static ListBlock block;
	public static ListItem item;
	public static RenderMain render;

	//GUI
	//public static int guiID = 0;
	public static int gui_items_machines = 1;

	public static CreativeTabs tab_items = new CreativeTabs("tab_items") {
		@SideOnly(Side.CLIENT) public Item getTabIconItem() {return PackItems.item.items_for_items;}
	};

	@Override
	public void preInit(FMLPreInitializationEvent event) {

		log = event.getModLog();
		log.info("Starting sub-mod " + PackItems.MODNAME + ", build: " + PackItems.VERSION + ".");

		Configuration cfg = new Configuration(new File("./config/SMT/pack", PackItems.MODID + ".cfg"));
		cfg.load();

		//block.items_machines_be = cfg.get("block", "items_machines", true).getBoolean();

		item.items_for_items_be = cfg.get("item", "items_for_items", true).getBoolean();

		item.tool_axe_be = cfg.get("item", "tool_axe", true).getBoolean();
		item.tool_shovel_be = cfg.get("item", "tool_shovel", true).getBoolean();
		item.tool_pickaxe_be = cfg.get("item", "tool_pickaxe", true).getBoolean();
		item.tool_hoe_be = cfg.get("item", "tool_hoe", true).getBoolean();
		item.tool_hammer_be = cfg.get("item", "tool_hammer", true).getBoolean();
		item.tool_sickle_be = cfg.get("item", "tool_sickle", true).getBoolean();
		item.tool_scythe_be = cfg.get("item", "tool_scythe", true).getBoolean();
		item.tool_sword_be = cfg.get("item", "tool_sword", true).getBoolean();
		item.tool_battle_axe_be = cfg.get("item", "tool_battle_axe", true).getBoolean();
		item.tool_battle_hammer_be = cfg.get("item", "tool_battle_hammer", true).getBoolean();
		item.tool_chisel_be = cfg.get("item", "tool_chisel", true).getBoolean();
		item.tool_cutter_be = cfg.get("item", "tool_cutter", true).getBoolean();
		item.tool_screwdriver_be = cfg.get("item", "tool_screwdriver", true).getBoolean();
		item.tool_wrench_be = cfg.get("item", "tool_wrench", true).getBoolean();
		item.tool_knife_be = cfg.get("item", "tool_knife", true).getBoolean();
		item.tool_fry_pan_be = cfg.get("item", "tool_fry_pan", true).getBoolean();
		item.tool_pan_be = cfg.get("item", "tool_pan", true).getBoolean();
		item.tool_jar_be = cfg.get("item", "tool_jar", true).getBoolean();
		item.tool_saw_be = cfg.get("item", "tool_saw", true).getBoolean();
		item.tool_crowbar_be = cfg.get("item", "tool_crowbar", true).getBoolean();
		item.tool_dagger_be = cfg.get("item", "tool_dagger", true).getBoolean();
		item.tool_cleaver_be = cfg.get("item", "tool_cleaver", true).getBoolean();
		item.tool_greatsword_be = cfg.get("item", "tool_greatsword", true).getBoolean();
		item.tool_spear_be = cfg.get("item", "tool_spear", true).getBoolean();
		item.tool_whip_be = cfg.get("item", "tool_whip", true).getBoolean();
		item.tool_shuriken_be = cfg.get("item", "tool_shuriken", true).getBoolean();
		item.tool_tomahawk_be = cfg.get("item", "tool_tomahawk", true).getBoolean();
		item.tool_shield_be = cfg.get("item", "tool_shield", true).getBoolean();
		item.tool_craft_be = cfg.get("item", "tool_craft", true).getBoolean();

		cfg.save();

		network = NetworkRegistry.INSTANCE.newSimpleChannel(PackItems.MODID);
		RegisterMessage.init(network);

		new ListPackItems();

		block.preInit();
		item.preInit();

		Recipes_PackItems.list();
		//GameRegistry.addRecipe(new RecipeArmorColor());
		GameRegistry.addRecipe(new RecipeToolHammer());

	}

	public void init(FMLInitializationEvent event) {

	}

}
