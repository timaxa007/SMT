package mods.timaxa007.pack.mining;

import mods.timaxa007.pack.mining.blocks.*;
import mods.timaxa007.pack.mining.items.*;
import mods.timaxa007.pack.mining.list.ListMining;
import mods.timaxa007.pack.mining.te.*;
import mods.timaxa007.pack.mining.world.*;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class ProxyServer {

public static CreativeTabs tabMiningPack = new TabMiningPack("tabMiningPack");
public static CreativeTabs tabToolsPack = new TabToolsPack("tabToolsPack");

public static ArmorMaterial METALSMATERIAL = EnumHelper.addArmorMaterial("METALSMATERIAL", 15, new int[]{3, 7, 5, 3}, 10);
public static ArmorMaterial GEMSMATERIAL = EnumHelper.addArmorMaterial("GEMSMATERIAL", 15, new int[]{5, 10, 7, 4}, 12);

public static final ToolMaterial TOOLGEMS = EnumHelper.addToolMaterial("TOOLGEMS", 3, 512, 7.0F, 3, 7);
public static final ToolMaterial TOOLMETALS = EnumHelper.addToolMaterial("TOOLMETALS", 2, 300, 6.0F, 2, 11);

//Blocks
public static BlockEarthCB blockEarth;
public static BlockSandCB blockSand;
public static BlockRockCB blockRock;
public static Block ore_rock_ores;
public static Block ore_nether_ores;
public static Block ore_ender_ores;
public static Block block_cristals;

//Items
public static Item items_for_mining;
public static Item toolKindlingFire;
public static Item toolSword;
public static Item toolAxe;
public static Item toolPickaxe;
public static Item toolShovel;
public static Item toolHoe;
public static Item toolShears;
public static Item toolHammer;
public static Item toolKnife;
public static Item toolScrewdriver;
public static Item toolScythe;
public static Item toolSickle;
public static Item toolRake;
public static Item itemCapsul;
public static Item tool_sword_big;

public static int render_block_cristals_modelID;

public static BiomeGenBase biome_test;
public static BiomeGenBase biome_hot;

public static int world_dim_mining_id;
public static int world_dim_only_day_id;
public static int world_dim_only_night_id;

public void preInit(FMLPreInitializationEvent event) {
Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
cfg.load();
/*
world_dim_mining_id = cfg.get("configs", "world_dim_mining_id", 30).getInt();
world_dim_only_day_id = cfg.get("configs", "world_dim_only_day_id", 31).getInt();
world_dim_only_night_id = cfg.get("configs", "world_dim_only_night_id", 32).getInt();
*/
cfg.save();

new ListMining();

//Blocks
blockEarth = (BlockEarthCB)(new BlockEarthCB());
blockSand = (BlockSandCB)(new BlockSandCB());
blockRock = (BlockRockCB)(new BlockRockCB());
ore_rock_ores = new OreOres().setBlockTextureName("stone");
ore_nether_ores = new OreOres().setBlockTextureName("netherrack");
ore_ender_ores = new OreOres().setBlockTextureName("end_stone");
block_cristals = new BlockCristals();

//Items
items_for_mining = new ItemsMining();
toolKindlingFire = new ToolKindlingFire();
toolSword = new ToolSword();
toolAxe = new ToolAxe();
toolPickaxe = new ToolPickaxe();
toolShovel = new ToolShovel();
toolHoe = new ToolHoe();
toolShears = new ToolShears();
toolHammer = new ToolHammer();
toolKnife = new ToolKnife();
toolScrewdriver = new ToolScrewdriver();
toolScythe = new ToolScythe();
toolSickle = new ToolSickle();
toolRake = new ToolRake();
itemCapsul = new ItemCapsul();
tool_sword_big = new ToolSwordBig();

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
/*
GameRegistry.registerWorldGenerator(new Generator_Mining());
biome_test = new BiomeTest(30);
biome_hot = new BiomeHot(31);
GameRegistry.addBiome(biome_test);
GameRegistry.addBiome(biome_hot);
*//*
DimensionManager.registerProviderType(world_dim_mining_id, WorldMining.class, true);
DimensionManager.registerDimension(world_dim_mining_id, world_dim_mining_id);

DimensionManager.registerProviderType(world_dim_only_day_id, WorldOnlyDay.class, true);
DimensionManager.registerDimension(world_dim_only_day_id, world_dim_only_day_id);

DimensionManager.registerProviderType(world_dim_only_night_id, WorldOnlyNight.class, true);
DimensionManager.registerDimension(world_dim_only_night_id, world_dim_only_night_id);
*/
Recipes_Mining.list();

}

public void init() {

}

}
