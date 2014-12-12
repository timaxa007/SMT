package mods.timaxa007.pack.techno;

import mods.timaxa007.pack.techno.blocks.*;
import mods.timaxa007.pack.techno.gui.HandlerGuiTechno;
import mods.timaxa007.pack.techno.items.*;
import mods.timaxa007.pack.techno.list.ListTechno;
import mods.timaxa007.pack.techno.te.*;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class ProxyServer {

public static CreativeTabs tab_techno_pack = new TabTechnoPack("tab_techno_pack");

//Blocks
public static Block block_electric_machines;
public static Block block_electric_wires;
public static Block block_chip;
public static Block block_module_movement;

//Items
public static Item items_for_techno;
public static Item tool_electric_wrench;
public static Item tool_electric_drills;

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

//Blocks
block_electric_machines = new BlockElectricMachines();
block_electric_wires = new BlockElectricWires();
block_chip = new BlockChip();
block_module_movement = new BlockModuleMovement();
//transporter belt

//Items
items_for_techno = new ItemsTechno();
tool_electric_wrench = new ToolElectricWrench();
tool_electric_drills = new ToolElectricDrills();

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

Recipes_Techno.list();

}

public void init() {

NetworkRegistry.INSTANCE.registerGuiHandler(PackTechno.MODID, new HandlerGuiTechno());

}

}
