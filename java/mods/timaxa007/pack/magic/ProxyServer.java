package mods.timaxa007.pack.magic;

import mods.timaxa007.pack.magic.block.*;
import mods.timaxa007.pack.magic.event.EventMagic;
import mods.timaxa007.pack.magic.gui.HandlerGuiMagic;
import mods.timaxa007.pack.magic.item.*;
import mods.timaxa007.pack.magic.lib.ListMagic;
import mods.timaxa007.pack.magic.tile.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class ProxyServer {

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

	//Blocks
	public static Block blockMagicMachines;
	public static Block blockSlims;
	public static Block blockMagicCauldron;
	public static Block block_locked;

	//Items
	public static Item items_for_magic;
	public static BowMagic bowMagic;
	public static Item itemWands;
	public static Item itemStuffs;
	public static Item itemArrowMini;
	public static Item item_teleport;
	public static Item item_globular;

	//GUI
	//public static int guiID = 0;
	public static int gui_magic_machines = 1;

	public static int render_block_magic_cauldron_modelID;

	public void preInit(FMLPreInitializationEvent event) {
		Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
		cfg.load();

		cfg.save();

		new ListMagic();

		//Blocks
		blockMagicMachines = new BlockMagicMachines();
		blockSlims = new BlockSlims();
		blockMagicCauldron = new BlockMagicCauldron();
		block_locked = new BlockLocked();

		//Items
		items_for_magic = new ItemsMagic();
		bowMagic = new BowMagic();
		itemWands = new ItemWands();
		itemStuffs = new ItemStuffs();
		itemArrowMini = new ItemArrowMini();
		item_teleport = new ItemTeleport();
		item_globular = new ItemGlobular();

		//Blocks
		GameRegistry.registerBlock(blockSlims, ItemBlockSlims.class, "BlockSlims");
		GameRegistry.registerBlock(blockMagicMachines, "BlockMagicMachines");
		GameRegistry.registerBlock(blockMagicCauldron, "BlockMagicCauldron");
		GameRegistry.registerBlock(block_locked, "BlockLocked");

		//Items
		GameRegistry.registerItem(items_for_magic, "ItemsMagic");
		GameRegistry.registerItem(bowMagic, "BowMagic");
		GameRegistry.registerItem(itemWands, "ItemWands");
		GameRegistry.registerItem(itemStuffs, "ItemStuffs");
		GameRegistry.registerItem(itemArrowMini, "ItemArrowMini");
		GameRegistry.registerItem(item_teleport, "ItemTeleport");
		GameRegistry.registerItem(item_globular, "ItemGlobular");

		//Blocks
		GameRegistry.registerTileEntity(TileEntityMagicMachines.class, "TileEntityMagicMachines");
		GameRegistry.registerTileEntity(TileEntityMagicCauldron.class, "TileEntityMagicCauldron");
		GameRegistry.registerTileEntity(TileEntityBlockLocked.class, "TileEntityBlockLocked");

		render_block_magic_cauldron_modelID = -1;

		MinecraftForge.EVENT_BUS.register(new EventMagic());

		Recipes_Magic.list();

	}

	public void init() {

		NetworkRegistry.INSTANCE.registerGuiHandler(PackMagic.MODID, new HandlerGuiMagic());

	}

}
