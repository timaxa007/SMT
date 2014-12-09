package mods.timaxa007.pack.magic;

import mods.timaxa007.pack.magic.blocks.*;
import mods.timaxa007.pack.magic.gui.HandlerGuiMagic;
import mods.timaxa007.pack.magic.items.*;
import mods.timaxa007.pack.magic.list.ListMagic;
import mods.timaxa007.pack.magic.te.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;


public class ProxyServer {

public static CreativeTabs tabMagicPack = new TabMagicPack(CreativeTabs.getNextID(), "tabMagicPack");

public static EnumArmorMaterial MagicARMORMATERIAL = EnumHelper.addArmorMaterial("MagicARMORMATERIAL", 20, new int[]{10, 25, 10, 5}, 10);

public static EnumToolMaterial MAGICTOOL = EnumHelper.addToolMaterial("MAGIC", 4, 1024, 64, 8, 16);

public static final Material oreMagic = new MaterialOreMagic();

//Blocks
public static Block blockMagicMachines;public static int blockMagicMachinesblockID;
public static Block oreElements;public static int oreElementsblockID;
public static Block blockSlims;public static int blockSlimsblockID;
public static Block blockMagicCauldron;public static int blockMagicCauldronblockID;
public static Block block_locked;public static int block_locked_blockID;

//Items
public static Item items_for_magic;public static int items_for_magic_itemID;
public static ItemArmor armorMagicHelmet;public static int armorMagicHelmetitemID;
public static ItemArmor armorMagicChest;public static int armorMagicChestitemID;
public static ItemArmor armorMagicLeggin;public static int armorMagicLegginitemID;
public static ItemArmor armorMagicBoot;public static int armorMagicBootitemID;
public static Item shardElements;public static int shardElementsitemID;
public static Item toolMagicSword;public static int toolMagicSworditemID;
public static Item toolMagicAxe;public static int toolMagicAxeitemID;
public static Item toolMagicPickaxe;public static int toolMagicPickaxeitemID;
public static Item toolMagicShovel;public static int toolMagicShovelitemID;
public static Item toolMagicHoe;public static int toolMagicHoeitemID;
public static BowMagic bowMagic;public static int bowMagicitemID;
public static Item itemRandomItem;public static int itemRandomItemitemID;
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
blockMagicMachines = new BlockMagicMachines(blockMagicMachinesblockID);
oreElements = new OreElements(oreElementsblockID);
blockSlims = new BlockSlims(blockSlimsblockID);
blockMagicCauldron = new BlockMagicCauldron(blockMagicCauldronblockID);
block_locked = new BlockLocked(block_locked_blockID);

//Items
items_for_magic = new ItemsMagic(items_for_magic_itemID);
armorMagicHelmet = (ItemArmor)(new ArmorMagic(armorMagicHelmetitemID, MagicARMORMATERIAL, 4, 0).setUnlocalizedName("ArmorMagicHelmet"));
armorMagicChest = (ItemArmor)(new ArmorMagic(armorMagicChestitemID, MagicARMORMATERIAL, 4, 1).setUnlocalizedName("ArmorMagicChest"));
armorMagicLeggin = (ItemArmor)(new ArmorMagic(armorMagicLegginitemID, MagicARMORMATERIAL, 4, 2).setUnlocalizedName("ArmorMagicLeggin"));
armorMagicBoot = (ItemArmor)(new ArmorMagic(armorMagicBootitemID, MagicARMORMATERIAL, 4, 3).setUnlocalizedName("ArmorMagicBoot"));
shardElements = new ShardElements(shardElementsitemID);
toolMagicSword = new ToolMagicSword(toolMagicSworditemID, MAGICTOOL);
toolMagicAxe = new ToolMagicAxe(toolMagicAxeitemID, MAGICTOOL);
toolMagicPickaxe = new ToolMagicPickaxe(toolMagicPickaxeitemID, MAGICTOOL);
toolMagicShovel = new ToolMagicShovel(toolMagicShovelitemID, MAGICTOOL);
toolMagicHoe = new ToolMagicHoe(toolMagicHoeitemID, MAGICTOOL);
bowMagic = new BowMagic(bowMagicitemID);
itemRandomItem = new ItemRandomItem(itemRandomItemitemID);
itemWands = new ItemWands(itemWandsitemID);
itemStuffs = new ItemStuffs(itemStuffsitemID);
itemArrowMini = new ItemArrowMini(itemArrowMiniitemID);
item_teleport = new ItemTeleport(item_teleport_itemID);
item_globular = new ItemGlobular(item_globular_itemID);

//Blocks
GameRegistry.registerBlock(oreElements, ItemOreElements.class, "OreElements");
GameRegistry.registerBlock(blockSlims, ItemBlockSlims.class, "BlockSlims");
GameRegistry.registerBlock(blockMagicMachines, "BlockMagicMachines");
GameRegistry.registerBlock(blockMagicCauldron, "BlockMagicCauldron");
GameRegistry.registerBlock(block_locked, "BlockLocked");

//Items
GameRegistry.registerItem(items_for_magic, "ItemsMagic");
GameRegistry.registerItem(armorMagicHelmet, "ArmorMagicHelmet");
GameRegistry.registerItem(armorMagicChest, "ArmorMagicChest");
GameRegistry.registerItem(armorMagicLeggin, "ArmorMagicLeggin");
GameRegistry.registerItem(armorMagicBoot, "ArmorMagicBoot");
GameRegistry.registerItem(shardElements, "ShardElements");
GameRegistry.registerItem(toolMagicSword, "ToolMagicSword");
GameRegistry.registerItem(toolMagicAxe, "ToolMagicAxe");
GameRegistry.registerItem(toolMagicPickaxe, "ToolMagicPickaxe");
GameRegistry.registerItem(toolMagicShovel, "ToolMagicShovel");
GameRegistry.registerItem(toolMagicHoe, "ToolMagicHoe");
GameRegistry.registerItem(bowMagic, "BowMagic");
GameRegistry.registerItem(itemRandomItem, "ItemRandomItem");
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

NetworkRegistry.instance().registerGuiHandler(this, new HandlerGuiMagic());

Recipes_Magic.list();

}

public void preInit(FMLPreInitializationEvent event) {

Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
cfg.load();
int idblock = 2400;
int iditem = 5400;
blockMagicMachinesblockID = cfg.getBlock("machines_magic", idblock++).getInt();
oreElementsblockID = cfg.getBlock("ore_elements", idblock++).getInt();
blockSlimsblockID = cfg.getBlock("slims", idblock++).getInt();
blockMagicCauldronblockID = cfg.getBlock("cauldron_magic", idblock++).getInt();
block_locked_blockID = cfg.getBlock("block_locked", idblock++).getInt();

//Items
items_for_magic_itemID = cfg.getItem("items_for_magic", iditem++).getInt();
armorMagicHelmetitemID = cfg.getItem("armor_magic_helmet", iditem++).getInt();
armorMagicChestitemID = cfg.getItem("armor_magic_chest", iditem++).getInt();
armorMagicLegginitemID = cfg.getItem("armor_magic_leggin", iditem++).getInt();
armorMagicBootitemID = cfg.getItem("armor_magic_boot", iditem++).getInt();
shardElementsitemID = cfg.getItem("shard_elements", iditem++).getInt();
toolMagicSworditemID = cfg.getItem("magic_sword", iditem++).getInt();
toolMagicAxeitemID = cfg.getItem("magic_axe", iditem++).getInt();
toolMagicPickaxeitemID = cfg.getItem("magic_pickaxe", iditem++).getInt();
toolMagicShovelitemID = cfg.getItem("magic_shovel", iditem++).getInt();
toolMagicHoeitemID = cfg.getItem("magic_hoe", iditem++).getInt();
bowMagicitemID = cfg.getItem("bow_magic", iditem++).getInt();
itemRandomItemitemID = cfg.getItem("item_random_item", iditem++).getInt();
itemWandsitemID = cfg.getItem("wands", iditem++).getInt();
itemStuffsitemID = cfg.getItem("stuffs", iditem++).getInt();
itemArrowMiniitemID = cfg.getItem("arrow_mini", iditem++).getInt();
item_teleport_itemID = cfg.getItem("item_teleport", iditem++).getInt();
item_globular_itemID = cfg.getItem("item_globular", iditem++).getInt();
cfg.save();

}

}
