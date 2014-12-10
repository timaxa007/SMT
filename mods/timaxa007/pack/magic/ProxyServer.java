package mods.timaxa007.pack.magic;

import mods.timaxa007.pack.magic.blocks.*;
import mods.timaxa007.pack.magic.gui.HandlerGuiMagic;
import mods.timaxa007.pack.magic.items.*;
import mods.timaxa007.pack.magic.list.ListMagic;
import mods.timaxa007.pack.magic.te.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;


public class ProxyServer {

public static CreativeTabs tabMagicPack = new TabMagicPack("tabMagicPack");

public static final Material oreMagic = new MaterialOreMagic();

//Blocks
public static Block blockMagicMachines;public static int blockMagicMachinesblockID;
public static Block oreElements;public static int oreElementsblockID;
public static Block blockSlims;public static int blockSlimsblockID;
public static Block blockMagicCauldron;public static int blockMagicCauldronblockID;
public static Block block_locked;public static int block_locked_blockID;

//Items
public static Item items_for_magic;public static int items_for_magic_itemID;
public static Item shardElements;public static int shardElementsitemID;
public static BowMagic bowMagic;public static int bowMagicitemID;
public static Item itemWands;public static int itemWandsitemID;
public static Item itemStuffs;public static int itemStuffsitemID;
public static Item itemArrowMini;public static int itemArrowMiniitemID;
public static Item item_teleport;public static int item_teleport_itemID;
public static Item item_globular;public static int item_globular_itemID;

//GUI
//public static int guiID = 0;
public static int guiMagicMachines = 1;

public static int renderBlockMagicCauldronModelID;

public void init() {
TickRegistry.registerTickHandler(new TickHandlerPackMagicServer(), Side.SERVER);

new ListMagic();

//Blocks
blockMagicMachines = new BlockMagicMachines();
oreElements = new OreElements();
blockSlims = new BlockSlims();
blockMagicCauldron = new BlockMagicCauldron();
block_locked = new BlockLocked();

//Items
items_for_magic = new ItemsMagic();
shardElements = new ShardElements();
bowMagic = new BowMagic();
itemWands = new ItemWands();
itemStuffs = new ItemStuffs();
itemArrowMini = new ItemArrowMini();
item_teleport = new ItemTeleport();
item_globular = new ItemGlobular();

//Blocks
GameRegistry.registerBlock(oreElements, ItemOreElements.class, "OreElements");
GameRegistry.registerBlock(blockSlims, ItemBlockSlims.class, "BlockSlims");
GameRegistry.registerBlock(blockMagicMachines, "BlockMagicMachines");
GameRegistry.registerBlock(blockMagicCauldron, "BlockMagicCauldron");
GameRegistry.registerBlock(block_locked, "BlockLocked");

//Items
GameRegistry.registerItem(items_for_magic, "ItemsMagic");
GameRegistry.registerItem(shardElements, "ShardElements");
GameRegistry.registerItem(bowMagic, "BowMagic");
GameRegistry.registerItem(itemWands, "ItemWands");
GameRegistry.registerItem(itemStuffs, "ItemStuffs");
GameRegistry.registerItem(itemArrowMini, "ItemArrowMini");
GameRegistry.registerItem(item_teleport, "ItemTeleport");
GameRegistry.registerItem(item_globular, "ItemGlobular");

//Blocks
GameRegistry.registerTileEntity(TEMagicMachines.class, "TEMagicMachines");
GameRegistry.registerTileEntity(TEMagicCauldron.class, "TEMagicCauldron");
GameRegistry.registerTileEntity(TEBlockLocked.class, "TEBlockLocked");

renderBlockMagicCauldronModelID = -1;

MinecraftForge.EVENT_BUS.register(new EventMagic());

NetworkRegistry.INSTANCE.registerGuiHandler(this, new HandlerGuiMagic());

Recipes_Magic.list();

}

public void preInit(FMLPreInitializationEvent event) {

Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
cfg.load();

cfg.save();

}

}
