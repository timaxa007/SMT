package mods.timaxa007.pack.techno;

import mods.timaxa007.lib.LangLib;
import mods.timaxa007.pack.techno.blocks.*;
import mods.timaxa007.pack.techno.gui.HandlerGuiTechno;
import mods.timaxa007.pack.techno.items.*;
import mods.timaxa007.pack.techno.list.ListTechno;
import mods.timaxa007.pack.techno.te.*;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class ProxyServer {

public static CreativeTabs tabTechnoPack = new TabTechnoPack(CreativeTabs.getNextID(), "tabTechnoPack");

//Blocks
public static Block block_electric_machines;public static int block_electric_machines_blockID;
public static Block block_electric_wires;public static int block_electric_wires_blockID;
public static Block block_chip;public static int block_chip_blockID;
public static Block block_module_movement;public static int block_module_movement_blockID;

//Items
public static Item items_for_techno;public static int items_for_techno_itemID;
public static Item tool_electric_wrench;public static int tool_electric_wrench_itemID;
public static Item tool_electric_drills;public static int tool_electric_drills_itemID;

//GUI
//public static int guiID=0;
public static int guiElectricMachines = 1;

//Render Model ID
public static int render_block_electric_wires_modelID;
public static int render_block_chip_modelID;
public static int render_block_module_movement_modelID;

public void init() {
TickRegistry.registerTickHandler(new TickHandlerPackTechnoServer(), Side.SERVER);

new ListTechno();

//Blocks
block_electric_machines = new BlockElectricMachines(block_electric_machines_blockID);
block_electric_wires = new BlockElectricWires(block_electric_wires_blockID);
block_chip = new BlockChip(block_chip_blockID);
block_module_movement = new BlockModuleMovement(block_module_movement_blockID);
//transporter belt

//Items
items_for_techno = new ItemsTechno(items_for_techno_itemID);
tool_electric_wrench = new ToolElectricWrench(tool_electric_wrench_itemID);
tool_electric_drills = new ToolElectricDrills(tool_electric_drills_itemID);

//Blocks
GameRegistry.registerBlock(block_electric_machines, "BlockElectricMachines");//Microwave Oven
GameRegistry.registerBlock(block_electric_wires, "BlockElectricWires");
GameRegistry.registerBlock(block_chip, "BlockChip");
GameRegistry.registerBlock(block_module_movement, ItemBlockModuleMovement.class, "BlockModuleMovement");

//Items
GameRegistry.registerItem(items_for_techno, "ItemsTechno");
GameRegistry.registerItem(tool_electric_wrench, "ToolWrench");
GameRegistry.registerItem(tool_electric_drills, "ToolElectricDrills");

//Blocks
GameRegistry.registerTileEntity(TEElectricMachines.class, "TEElectricMachines");
GameRegistry.registerTileEntity(TEElectricWires.class, "TEElectricWires");
GameRegistry.registerTileEntity(TEChip.class, "TEChip");
GameRegistry.registerTileEntity(TEModuleMovement.class, "TEModuleMovement");

render_block_electric_wires_modelID = -1;
render_block_chip_modelID = -1;
render_block_module_movement_modelID = -1;

NetworkRegistry.instance().registerGuiHandler(this, new HandlerGuiTechno());

LangLib.registerLanguages();

Recipes_Techno.list();

}

public void preInit(FMLPreInitializationEvent event) {
Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
cfg.load();
int idblock = 2300;
int iditem = 5300;
//Blocks
block_electric_machines_blockID = cfg.getBlock("machines_electric", idblock++).getInt();
block_electric_wires_blockID = cfg.getBlock("electric_wires", idblock++).getInt();
block_chip_blockID = cfg.getBlock("block_chip", idblock++).getInt();
block_module_movement_blockID = cfg.getBlock("block_module_movement", idblock++).getInt();

//Items
items_for_techno_itemID = cfg.getItem("items_for_techno", iditem++).getInt();
tool_electric_wrench_itemID = cfg.getItem("tool_electric_wrench", iditem++).getInt();
tool_electric_drills_itemID = cfg.getItem("tool_electric_drills", iditem++).getInt();

cfg.save();
}

}
