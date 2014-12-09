package mods.timaxa007.pack.mining;

import mods.timaxa007.pack.mining.blocks.*;
import mods.timaxa007.pack.mining.items.*;
import mods.timaxa007.pack.mining.list.ListMining;
import mods.timaxa007.pack.mining.te.*;
import mods.timaxa007.pack.mining.world.*;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class ProxyServer {

public static CreativeTabs tabMiningPack = new TabMiningPack(CreativeTabs.getNextID(), "tabMiningPack");
public static CreativeTabs tabToolsPack = new TabToolsPack(CreativeTabs.getNextID(), "tabToolsPack");

public static EnumArmorMaterial METALSMATERIAL = EnumHelper.addArmorMaterial("METALSMATERIAL", 15, new int[]{3, 7, 5, 3}, 10);
public static EnumArmorMaterial GEMSMATERIAL = EnumHelper.addArmorMaterial("GEMSMATERIAL", 15, new int[]{5, 10, 7, 4}, 12);

public static final EnumToolMaterial TOOLGEMS = EnumHelper.addToolMaterial("TOOLGEMS", 3, 512, 7.0F, 3, 7);
public static final EnumToolMaterial TOOLMETALS = EnumHelper.addToolMaterial("TOOLMETALS", 2, 300, 6.0F, 2, 11);

//Blocks
public static BlockEarthCB blockEarth;public static int blockEarthblockID;
public static BlockSandCB blockSand;public static int blockSandblockID;
public static BlockRockCB blockRock;public static int blockRockblockID;
public static Block ore_rock_ores;public static int ore_rock_ores_blockID;
public static Block ore_nether_ores;public static int ore_nether_ores_blockID;
public static Block ore_ender_ores;public static int ore_ender_ores_blockID;
public static Block block_cristals;public static int block_cristals_blockID;

//Items
public static Item items_for_mining;public static int items_for_mining_itemID;
public static Item toolKindlingFire;public static int toolKindlingFireitemID;
public static Item toolSword;public static int toolSworditemID;
public static Item toolAxe;public static int toolAxeitemID;
public static Item toolPickaxe;public static int toolPickaxeitemID;
public static Item toolShovel;public static int toolShovelitemID;
public static Item toolHoe;public static int toolHoeitemID;
public static Item toolShears;public static int toolShearsitemID;
public static Item toolHammer;public static int toolHammeritemID;
public static Item toolKnife;public static int toolKnifeitemID;
public static Item toolScrewdriver;public static int toolScrewdriveritemID;
public static Item toolScythe;public static int toolScytheitemID;
public static Item toolSickle;public static int toolSickleitemID;
public static Item toolRake;public static int toolRakeitemID;
public static Item itemCapsul;public static int itemCapsulitemID;
public static Item tool_sword_big;public static int tool_sword_big_itemID;

public static int render_block_cristals_modelID;

public static BiomeGenBase biome_test;
public static BiomeGenBase biome_hot;

public static int world_dim_mining_id;
public static int world_dim_only_day_id;
public static int world_dim_only_night_id;

public void init() {
TickRegistry.registerTickHandler(new TickHandlerPackMiningServer(), Side.SERVER);

new ListMining();

//Blocks
blockEarth = (BlockEarthCB)(new BlockEarthCB(blockEarthblockID));
blockSand = (BlockSandCB)(new BlockSandCB(blockSandblockID));
blockRock = (BlockRockCB)(new BlockRockCB(blockRockblockID));
ore_rock_ores = new OreOres(ore_rock_ores_blockID).setTextureName("stone");
ore_nether_ores = new OreOres(ore_nether_ores_blockID).setTextureName("netherrack");
ore_ender_ores = new OreOres(ore_ender_ores_blockID).setTextureName("end_stone");
block_cristals = new BlockCristals(block_cristals_blockID);

//Items
items_for_mining = new ItemsMining(items_for_mining_itemID);
toolKindlingFire = new ToolKindlingFire(toolKindlingFireitemID);
toolSword = new ToolSword(toolSworditemID);
toolAxe = new ToolAxe(toolAxeitemID);
toolPickaxe = new ToolPickaxe(toolPickaxeitemID);
toolShovel = new ToolShovel(toolShovelitemID);
toolHoe = new ToolHoe(toolHoeitemID);
toolShears = new ToolShears(toolShearsitemID);
toolHammer = new ToolHammer(toolHammeritemID);
toolKnife = new ToolKnife(toolKnifeitemID);
toolScrewdriver = new ToolScrewdriver(toolScrewdriveritemID);
toolScythe = new ToolScythe(toolScytheitemID);
toolSickle = new ToolSickle(toolSickleitemID);
toolRake = new ToolRake(toolRakeitemID);
itemCapsul = new ItemCapsul(itemCapsulitemID);
tool_sword_big = new ToolSwordBig(tool_sword_big_itemID);

//Blocks
GameRegistry.registerBlock(blockEarth, ItemBlockEarthCB.class, "BlockEarthCB");
GameRegistry.registerBlock(blockSand, ItemBlockSandCB.class, "BlockSandCB");
GameRegistry.registerBlock(blockRock, ItemBlockRockCB.class, "BlockRockCB");
GameRegistry.registerBlock(ore_rock_ores, "OreRockOres");
GameRegistry.registerBlock(ore_nether_ores, "OreNetherOres");
GameRegistry.registerBlock(ore_ender_ores, "OreEnderOres");
GameRegistry.registerBlock(block_cristals, "BlockCristals");

//Items
GameRegistry.registerItem(items_for_mining, "ItemsMining");
GameRegistry.registerItem(toolKindlingFire, "ToolKindlingFire");
GameRegistry.registerItem(toolSword, "ToolSword");
GameRegistry.registerItem(toolAxe, "ToolAxe");
GameRegistry.registerItem(toolPickaxe, "ToolPickaxe");
GameRegistry.registerItem(toolShovel, "ToolShovel");
GameRegistry.registerItem(toolHoe, "ToolHoe");
GameRegistry.registerItem(toolShears, "ToolShears");
GameRegistry.registerItem(toolHammer, "ToolHammer");
GameRegistry.registerItem(toolKnife, "ToolKnife");
GameRegistry.registerItem(toolScrewdriver, "ToolScrewdriver");
GameRegistry.registerItem(toolScythe, "ToolScythe");
GameRegistry.registerItem(toolSickle, "ToolSickle");
GameRegistry.registerItem(toolRake, "ToolRake");
GameRegistry.registerItem(itemCapsul, "ItemCapsul");
GameRegistry.registerItem(tool_sword_big, "ToolSwordBig");

GameRegistry.registerTileEntity(TEBlockCristals.class, "TEBlockCristals");
GameRegistry.registerTileEntity(TEOreOres.class, "TEOreOres");

render_block_cristals_modelID = -1;

//OreDictionary.registerOre("ignotCopper", new ItemStack(itemMetals, 1, 64));

//ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(new ItemStack(itemMetals, 1, 64), 10, 70, 2));

GameRegistry.registerWorldGenerator(new Generator_Mining());
biome_test = new BiomeTest(30);
biome_hot = new BiomeHot(31);
GameRegistry.addBiome(biome_test);
GameRegistry.addBiome(biome_hot);

DimensionManager.registerProviderType(world_dim_mining_id, WorldMining.class, true);
DimensionManager.registerDimension(world_dim_mining_id, world_dim_mining_id);

DimensionManager.registerProviderType(world_dim_only_day_id, WorldOnlyDay.class, true);
DimensionManager.registerDimension(world_dim_only_day_id, world_dim_only_day_id);

DimensionManager.registerProviderType(world_dim_only_night_id, WorldOnlyNight.class, true);
DimensionManager.registerDimension(world_dim_only_night_id, world_dim_only_night_id);

Recipes_Mining.list();

}

public void preInit(FMLPreInitializationEvent event) {
Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
cfg.load();

world_dim_mining_id = cfg.get("configs", "world_dim_mining_id", 30).getInt();
world_dim_only_day_id = cfg.get("configs", "world_dim_only_day_id", 31).getInt();
world_dim_only_night_id = cfg.get("configs", "world_dim_only_night_id", 32).getInt();

int idblock = 2000;
int iditem = 5000;
//Blocks
blockEarthblockID = cfg.getBlock("earth", idblock++).getInt();
blockSandblockID = cfg.getBlock("sand", idblock++).getInt();
blockRockblockID = cfg.getBlock("rock", idblock++).getInt();
ore_rock_ores_blockID = cfg.getBlock("ore_rock_ores", idblock++).getInt();
ore_nether_ores_blockID = cfg.getBlock("ore_nether_ores", idblock++).getInt();
ore_ender_ores_blockID = cfg.getBlock("ore_ender_ores", idblock++).getInt();
block_cristals_blockID = cfg.getBlock("block_cristals", idblock++).getInt();

//Items
items_for_mining_itemID = cfg.getItem("items_for_mining", iditem++).getInt();
toolKindlingFireitemID = cfg.getItem("kindling_fire", iditem++).getInt();
toolSworditemID = cfg.getItem("sword", iditem++).getInt();
toolAxeitemID = cfg.getItem("axe", iditem++).getInt();
toolPickaxeitemID = cfg.getItem("pickaxe", iditem++).getInt();
toolShovelitemID = cfg.getItem("shovel", iditem++).getInt();
toolHoeitemID = cfg.getItem("hoe", iditem++).getInt();
toolShearsitemID = cfg.getItem("shears", iditem++).getInt();
toolHammeritemID = cfg.getItem("hammer", iditem++).getInt();
toolKnifeitemID = cfg.getItem("knife", iditem++).getInt();
toolScrewdriveritemID = cfg.getItem("screwdriver", iditem++).getInt();
toolScytheitemID = cfg.getItem("scythe", iditem++).getInt();
toolSickleitemID = cfg.getItem("sickle", iditem++).getInt();
toolRakeitemID = cfg.getItem("rake", iditem++).getInt();
itemCapsulitemID = cfg.getItem("capsul", iditem++).getInt();
tool_sword_big_itemID = cfg.getItem("tool_sword_big", iditem++).getInt();

cfg.save();
}

}
