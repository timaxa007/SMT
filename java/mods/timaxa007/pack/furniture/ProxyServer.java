package mods.timaxa007.pack.furniture;

import mods.timaxa007.pack.furniture.block.*;
import mods.timaxa007.pack.furniture.event.EventFurniture;
import mods.timaxa007.pack.furniture.gui.HandlerGuiFurniture;
import mods.timaxa007.pack.furniture.item.*;
import mods.timaxa007.pack.furniture.lib.ListFurniture;
import mods.timaxa007.pack.furniture.recipe.FuelHandlerFurniture;
import mods.timaxa007.pack.furniture.recipe.RecipeArmorColor;
import mods.timaxa007.pack.furniture.recipe.RecipeCnstorBlockColors;
import mods.timaxa007.pack.furniture.recipe.Recipes_Armor;
import mods.timaxa007.pack.furniture.recipe.Recipes_Furniture;
import mods.timaxa007.pack.furniture.tile.*;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class ProxyServer {

	public static ArmorMaterial CLOTHWOOL = EnumHelper.addArmorMaterial("CLOTHWOOL", 6, new int[] {2, 3, 2, 1}, 10);
	public static ArmorMaterial COSTUME = EnumHelper.addArmorMaterial("COSTUME", 0, new int[] {2, 2, 2, 1}, 3);

	//Blocks
	public static Block block_furniture_machines;
	public static Block block_cnstor_block;
	public static Block block_cnstor_angle;
	public static Block block_cnstor_half;
	public static Block block_cnstor_button;
	public static Block block_cnstor_lever;
	public static Block block_cnstor_stairs;
	public static Block block_cnstor_fence;
	public static Block block_cnstor_wall;
	public static Block block_cnstor_door;
	public static Block block_cnstor_bed;

	public static Block air_light_0;
	public static Block air_light_1;
	public static Block air_light_2;
	public static Block air_light_3;
	public static Block air_light_4;
	public static Block air_light_5;
	public static Block air_light_6;
	public static Block air_light_7;
	public static Block air_light_8;
	public static Block air_light_9;
	public static Block air_light_10;
	public static Block air_light_11;
	public static Block air_light_12;
	public static Block air_light_13;
	public static Block air_light_14;
	public static Block air_light_15;
	public static Block air_light_16;

	public static Block block_light_0;
	public static Block block_light_1;
	public static Block block_light_2;
	public static Block block_light_3;
	public static Block block_light_4;
	public static Block block_light_5;
	public static Block block_light_6;
	public static Block block_light_7;
	public static Block block_light_8;
	public static Block block_light_9;
	public static Block block_light_10;
	public static Block block_light_11;
	public static Block block_light_12;
	public static Block block_light_13;
	public static Block block_light_14;
	public static Block block_light_15;
	public static Block block_light_16;

	public static Block block_lamps_click_on;
	public static Block block_lamps_click_off;
	public static Block block_lamps_on;
	public static Block block_lamps_off;
	public static Block block_lamps_on_invert;
	public static Block block_lamps_off_invert;
	public static Block block_stone_colona1_colors;
	public static Block block_candle;
	public static Block block_candle_light;
	public static Block block_crystals;
	public static Block block_barrels;
	public static Block block_bookshelf;
	public static Block block_table;
	public static Block block_chair;
	public static Block block_wardrobe;
	public static Block block_mincer;
	public static Block block_arm_chair;
	public static Block block_blender;
	public static Block block_grills;
	public static Block block_box_particles;
	public static Block block_bonfires;
	public static Block block_bonfires_burning;
	public static Block block_jar01;
	public static Block block_pipes;
	public static Block block_mashine_waiter;
	public static Block block_rock_blocks;
	public static Block block_glass_blocks;
	public static Block block_wood_blocks;
	public static Block block_ground_blocks;
	public static Block block_sand_blocks;
	public static Block block_cloth_blocks;
	public static Block block_metal_blocks;
	public static Block block_vegetable_face;
	public static Block block_furniture_chest;

	//Items
	public static Item items_for_furniture;
	public static ItemArmor armor_wool_colors_helmet;
	public static ItemArmor armor_wool_colors_chest;
	public static ItemArmor armor_wool_colors_leggin;
	public static ItemArmor armor_wool_colors_boot;
	public static Item item_colored;
	public static Item tool_brush;
	public static Item tool_airbrush;
	public static Item item_paint_can;
	public static Item item_backpack;
	public static Item item_filter_charcoal;
	public static Item item_kitchenware;
	public static ItemArmor armor_costumes_helmet;
	public static ItemArmor armor_costumes_chest;
	public static ItemArmor armor_costumes_leggin;
	public static ItemArmor armor_costumes_boot;
	public static ItemArmor armor_masks;
	public static ItemArmor armor_backpacks;
	public static Item item_particles_gun;
	public static ItemArmor armor_medieval_helmet;
	public static ItemArmor armor_medieval_chest;
	public static ItemArmor armor_medieval_leggin;
	public static ItemArmor armor_medieval_boot;
	public static ItemArmor armor_new_helmet;
	public static ItemArmor armor_new_chest;
	public static ItemArmor armor_new_leggin;
	public static ItemArmor armor_new_boot;

	//Blocks
	public static int render_block_cnstor_block_modelID;
	public static int render_block_cnstor_angle_modelID;
	public static int render_block_cnstor_fence_modelID;
	public static int render_block_lights_modelID;
	public static int render_block_lamps_on_modelID;
	public static int render_block_lamps_off_modelID;
	public static int render_block_lamps2_on_modelID;
	public static int render_block_lamps2_off_modelID;
	public static int render_block_candle_modelID;
	public static int render_block_crystals_modelID;
	public static int render_block_barrels_modelID;
	public static int render_block_bookshelf_modelID;
	public static int render_block_table_modelID;
	public static int render_block_chair_modelID;
	public static int render_block_wardrobe_modelID;
	public static int render_block_mincer_modelID;
	public static int render_block_armchair_modelID;
	public static int render_block_blender_modelID;
	public static int render_block_grills_modelID;
	public static int render_block_box_particles_modelID;
	public static int render_block_jar01_modelID;
	public static int render_block_pipes_modelID;
	public static int render_block_mashine_waiter_modelID;
	public static int render_block_furniture_chest_modelID;

	//GUI
	//public static int guiID = 0;
	public static int gui_furniture_machines = 1;
	public static int gui_furniture_chest = 15;
	public static int gui_bookshelf = 16;
	public static int gui_mincer = 17;
	public static int gui_grills = 18;
	public static int gui_mashine_water = 19;
	public static int gui_backpack = 20;

	public void preInit(FMLPreInitializationEvent event) {

		Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
		cfg.load();
		//
		cfg.save();

		new ListFurniture();

		//Blocks
		block_furniture_machines = new BlockFurnitureMachines();
		block_cnstor_block = new BlockCnstorBlock();
		block_cnstor_angle = new BlockCnstorAngle();
		block_cnstor_half = new BlockCnstorHalf();
		block_cnstor_button = new BlockCnstorButton();
		block_cnstor_lever = new BlockCnstorLever();
		block_cnstor_stairs = new BlockCnstorStairs();
		block_cnstor_fence = new BlockCnstorFence();
		block_cnstor_wall = new BlockCnstorWall();
		block_cnstor_door = new BlockCnstorDoor();
		block_cnstor_bed = new BlockCnstorBed();

		air_light_0 = new AirLight().setLightLevel(0.0F);
		air_light_1 = new AirLight().setLightLevel(0.0625F);
		air_light_2 = new AirLight().setLightLevel(0.125F);
		air_light_3 = new AirLight().setLightLevel(0.1875F);
		air_light_4 = new AirLight().setLightLevel(0.25F);
		air_light_5 = new AirLight().setLightLevel(0.3125F);
		air_light_6 = new AirLight().setLightLevel(0.375F);
		air_light_7 = new AirLight().setLightLevel(0.4375F);
		air_light_8 = new AirLight().setLightLevel(0.5F);
		air_light_9 = new AirLight().setLightLevel(0.5625F);
		air_light_10 = new AirLight().setLightLevel(0.625F);
		air_light_11 = new AirLight().setLightLevel(0.6875F);
		air_light_12 = new AirLight().setLightLevel(0.75F);
		air_light_13 = new AirLight().setLightLevel(0.8125F);
		air_light_14 = new AirLight().setLightLevel(0.875F);
		air_light_15 = new AirLight().setLightLevel(0.9375F);
		air_light_16 = new AirLight().setLightLevel(1.0F);

		block_light_0 = new BlockLight().setLightLevel(0.0F).setCreativeTab(PackFurniture.tab_furniture);
		block_light_1 = new BlockLight().setLightLevel(0.0625F);
		block_light_2 = new BlockLight().setLightLevel(0.125F);
		block_light_3 = new BlockLight().setLightLevel(0.1875F);
		block_light_4 = new BlockLight().setLightLevel(0.25F);
		block_light_5 = new BlockLight().setLightLevel(0.3125F);
		block_light_6 = new BlockLight().setLightLevel(0.375F);
		block_light_7 = new BlockLight().setLightLevel(0.4375F);
		block_light_8 = new BlockLight().setLightLevel(0.5F);
		block_light_9 = new BlockLight().setLightLevel(0.5625F);
		block_light_10 = new BlockLight().setLightLevel(0.625F);
		block_light_11 = new BlockLight().setLightLevel(0.6875F);
		block_light_12 = new BlockLight().setLightLevel(0.75F);
		block_light_13 = new BlockLight().setLightLevel(0.8125F);
		block_light_14 = new BlockLight().setLightLevel(0.875F);
		block_light_15 = new BlockLight().setLightLevel(0.9375F);
		block_light_16 = new BlockLight().setLightLevel(1.0F);

		block_lamps_click_on = new BlockLampsClicked(true).setBlockName("BlockLampsClickedOn");
		block_lamps_click_off = new BlockLampsClicked(false).setBlockName("BlockLampsClickedOff");
		block_lamps_on = new BlockLamps(true).setBlockName("BlockLampsOn");
		block_lamps_off = new BlockLamps(false).setBlockName("BlockLampsOff");
		block_lamps_on_invert = new BlockLampsInvert(true).setBlockName("BlockLampsInvertOn");
		block_lamps_off_invert = new BlockLampsInvert(false).setBlockName("BlockLampsInvertOff");
		block_candle = new BlockCandle().setLightLevel(0.0F);
		block_candle_light = new BlockCandle().setLightLevel(0.5F);
		block_crystals = new BlockCrystals();
		block_barrels = new BlockBarrels();
		block_bookshelf = new BlockBookshelf();
		block_table = new BlockTable();
		block_chair = new BlockChair();
		block_wardrobe = new BlockWardrobe();
		block_mincer = new BlockMincer();
		block_arm_chair = new BlockArmChair();
		block_blender = new BlockBlender();
		block_grills = new BlockGrills();
		block_box_particles = new BlockBoxParticles();
		block_bonfires = new BlockBonfires().setLightLevel(0.0F);
		block_bonfires_burning = new BlockBonfires().setLightLevel(0.75F);
		block_jar01 = new BlockJar01();
		block_pipes = new BlockPipes();
		block_mashine_waiter = new BlockMashineWater();
		block_rock_blocks = new BlockRockBlocks();
		block_glass_blocks = new BlockGlassBlocks();
		block_wood_blocks = new BlockWoodBlocks();
		block_ground_blocks = new BlockGroundBlocks();
		block_sand_blocks = new BlockSandBlocks();
		block_cloth_blocks = new BlockClothBlocks();
		block_metal_blocks = new BlockMetalBlocks();
		block_vegetable_face = new BlockVegetableFace();
		block_furniture_chest = new BlockFurnitureChest();

		//Items
		items_for_furniture = new ItemsFurniture();
		armor_wool_colors_helmet = (ItemArmor)(new ArmorWoolColors(CLOTHWOOL, 0, 0).setUnlocalizedName("ArmorWoolColorsHelmet"));
		armor_wool_colors_chest = (ItemArmor)(new ArmorWoolColors(CLOTHWOOL, 0, 1).setUnlocalizedName("ArmorWoolColorsChest"));
		armor_wool_colors_leggin = (ItemArmor)(new ArmorWoolColors(CLOTHWOOL, 0, 2).setUnlocalizedName("ArmorWoolColorsLeggin"));
		armor_wool_colors_boot = (ItemArmor)(new ArmorWoolColors(CLOTHWOOL, 0, 3).setUnlocalizedName("ArmorWoolColorsBoot"));
		item_colored = new ItemColored();
		tool_brush = new ToolBrush();
		tool_airbrush = new ToolAirBrush();
		item_paint_can = new ItemPaintCan();
		item_backpack = new ItemBackpack();
		item_filter_charcoal = new ItemFilterCharcoal();
		item_kitchenware = new ItemKitchenware();
		armor_costumes_helmet = (ItemArmor) new ArmorCostumes(COSTUME, 0, 0).setUnlocalizedName("armor_costumes_helmet");
		armor_costumes_chest = (ItemArmor) new ArmorCostumes(COSTUME, 0, 1).setUnlocalizedName("armor_costumes_chest");
		armor_costumes_leggin = (ItemArmor) new ArmorCostumes(COSTUME, 0, 2).setUnlocalizedName("armor_costumes_leggin");
		armor_costumes_boot = (ItemArmor) new ArmorCostumes(COSTUME, 0, 3).setUnlocalizedName("armor_costumes_boot");
		armor_masks = new ArmorMasks();
		armor_backpacks = new ArmorBackpacks();
		item_particles_gun = new ItemParticlesGun();
		armor_medieval_helmet = (ItemArmor) new ArmorMedieval(COSTUME, 0, 0).setUnlocalizedName("armor_medieval_helmet");
		armor_medieval_chest = (ItemArmor) new ArmorMedieval(COSTUME, 0, 1).setUnlocalizedName("armor_medieval_chest");
		armor_medieval_leggin = (ItemArmor) new ArmorMedieval(COSTUME, 0, 2).setUnlocalizedName("armor_medieval_leggin");
		armor_medieval_boot = (ItemArmor) new ArmorMedieval(COSTUME, 0, 3).setUnlocalizedName("armor_medieval_boot");
		armor_new_helmet = (ItemArmor) new ArmorNew(COSTUME, 0, 0).setUnlocalizedName("armor_new_helmet");
		armor_new_chest = (ItemArmor) new ArmorNew(COSTUME, 0, 1).setUnlocalizedName("armor_new_chest");
		armor_new_leggin = (ItemArmor) new ArmorNew(COSTUME, 0, 2).setUnlocalizedName("armor_new_leggin");
		armor_new_boot = (ItemArmor) new ArmorNew(COSTUME, 0, 3).setUnlocalizedName("armor_new_boot");

		//Blocks
		render_block_cnstor_block_modelID = -1;
		render_block_cnstor_angle_modelID = -1;
		render_block_cnstor_fence_modelID = -1;
		render_block_lights_modelID = -1;
		render_block_lamps_on_modelID = -1;
		render_block_lamps_off_modelID = -1;
		render_block_lamps2_on_modelID = -1;
		render_block_lamps2_off_modelID = -1;
		render_block_candle_modelID = -1;
		render_block_crystals_modelID = -1;
		render_block_barrels_modelID = -1;
		render_block_bookshelf_modelID = -1;
		render_block_table_modelID = -1;
		render_block_chair_modelID = -1;
		render_block_wardrobe_modelID = -1;
		render_block_mincer_modelID = -1;
		render_block_armchair_modelID = -1;
		render_block_blender_modelID = -1;
		render_block_grills_modelID = -1;
		render_block_box_particles_modelID = -1;
		render_block_jar01_modelID = -1;
		render_block_pipes_modelID = -1;
		render_block_mashine_waiter_modelID = -1;
		render_block_furniture_chest_modelID = -1;

		//Blocks
		GameRegistry.registerBlock(block_furniture_machines, "BlockMachines");
		GameRegistry.registerBlock(block_cnstor_block, ItemBlockCnstorBlock.class, "BlockCnstorBlock");
		GameRegistry.registerBlock(block_cnstor_angle, ItemBlockCnstorAngle.class, "BlockCnstorAngle");
		GameRegistry.registerBlock(block_cnstor_half, ItemBlockCnstorHalf.class, "BlockCnstorHalf");
		GameRegistry.registerBlock(block_cnstor_button, ItemBlockCnstorButton.class, "BlockCnstorButton");
		GameRegistry.registerBlock(block_cnstor_lever, ItemBlockCnstorLever.class, "BlockCnstorLever");
		GameRegistry.registerBlock(block_cnstor_stairs, ItemBlockCnstorStairs.class, "BlockCnstorStairs");
		GameRegistry.registerBlock(block_cnstor_fence, ItemBlockCnstorFence.class, "BlockCnstorFence");
		GameRegistry.registerBlock(block_cnstor_wall, ItemBlockCnstorWall.class, "BlockCnstorWall");
		GameRegistry.registerBlock(block_cnstor_door, ItemBlockCnstorDoor.class, "BlockCnstorDoor");
		GameRegistry.registerBlock(block_cnstor_bed, ItemBlockCnstorBed.class, "BlockCnstorBed");

		GameRegistry.registerBlock(air_light_0, "AirLight0");
		GameRegistry.registerBlock(air_light_1, "AirLight1");
		GameRegistry.registerBlock(air_light_2, "AirLight2");
		GameRegistry.registerBlock(air_light_3, "AirLight3");
		GameRegistry.registerBlock(air_light_4, "AirLight4");
		GameRegistry.registerBlock(air_light_5, "AirLight5");
		GameRegistry.registerBlock(air_light_6, "AirLight6");
		GameRegistry.registerBlock(air_light_7, "AirLight7");
		GameRegistry.registerBlock(air_light_8, "AirLight8");
		GameRegistry.registerBlock(air_light_9, "AirLight9");
		GameRegistry.registerBlock(air_light_10, "AirLight10");
		GameRegistry.registerBlock(air_light_11, "AirLight11");
		GameRegistry.registerBlock(air_light_12, "AirLight12");
		GameRegistry.registerBlock(air_light_13, "AirLight13");
		GameRegistry.registerBlock(air_light_14, "AirLight14");
		GameRegistry.registerBlock(air_light_15, "AirLight15");
		GameRegistry.registerBlock(air_light_16, "AirLight16");

		GameRegistry.registerBlock(block_light_0, "BlockLight0");
		GameRegistry.registerBlock(block_light_1, "BlockLight1");
		GameRegistry.registerBlock(block_light_2, "BlockLight2");
		GameRegistry.registerBlock(block_light_3, "BlockLight3");
		GameRegistry.registerBlock(block_light_4, "BlockLight4");
		GameRegistry.registerBlock(block_light_5, "BlockLight5");
		GameRegistry.registerBlock(block_light_6, "BlockLight6");
		GameRegistry.registerBlock(block_light_7, "BlockLight7");
		GameRegistry.registerBlock(block_light_8, "BlockLight8");
		GameRegistry.registerBlock(block_light_9, "BlockLight9");
		GameRegistry.registerBlock(block_light_10, "BlockLight10");
		GameRegistry.registerBlock(block_light_11, "BlockLight11");
		GameRegistry.registerBlock(block_light_12, "BlockLight12");
		GameRegistry.registerBlock(block_light_13, "BlockLight13");
		GameRegistry.registerBlock(block_light_14, "BlockLight14");
		GameRegistry.registerBlock(block_light_15, "BlockLight15");
		GameRegistry.registerBlock(block_light_16, "BlockLight16");

		GameRegistry.registerBlock(block_lamps_click_on, "BlockLampsClickOn");
		GameRegistry.registerBlock(block_lamps_click_off, "BlockLampsClickOff");
		GameRegistry.registerBlock(block_lamps_on, "BlockLampsOn");
		GameRegistry.registerBlock(block_lamps_off, "BlockLampsOff");
		GameRegistry.registerBlock(block_lamps_on_invert, "BlockLampsOnInvert");
		GameRegistry.registerBlock(block_lamps_off_invert, "BlockLampsOffInvert");
		GameRegistry.registerBlock(block_candle,"BlockCandle");
		GameRegistry.registerBlock(block_candle_light,"BlockCandleLight");
		GameRegistry.registerBlock(block_crystals, ItemBlockCrystals.class, "BlockCrystals");
		GameRegistry.registerBlock(block_barrels, ItemBlockBarrels.class, "BlockBarrels");
		GameRegistry.registerBlock(block_bookshelf, ItemBlockBookshelf.class, "BlockBookshelf");
		GameRegistry.registerBlock(block_table, ItemBlockTable.class, "BlockTable");
		GameRegistry.registerBlock(block_chair, ItemBlockChair.class, "BlockChair");
		GameRegistry.registerBlock(block_wardrobe, ItemBlockWardrobe.class, "BlockWardrobe");
		GameRegistry.registerBlock(block_mincer, "BlockMincer");
		GameRegistry.registerBlock(block_arm_chair, ItemBlockArmChair.class, "BlockArmChair");
		GameRegistry.registerBlock(block_blender, ItemBlockBlender.class, "BlockBlender");
		GameRegistry.registerBlock(block_grills, ItemBlockGrills.class, "BlockGrills");
		GameRegistry.registerBlock(block_box_particles, ItemBlockBoxParticles.class, "BlockBoxParticles");
		GameRegistry.registerBlock(block_bonfires, "BlockBonfires");
		GameRegistry.registerBlock(block_bonfires_burning, "BlockBonfiresBurning");
		GameRegistry.registerBlock(block_jar01, "BlockJar01");
		GameRegistry.registerBlock(block_pipes, "BlockPipes");
		GameRegistry.registerBlock(block_mashine_waiter, "BlockMashineWater");
		GameRegistry.registerBlock(block_rock_blocks, ItemBlockRockBlocks.class, "BlockRockBlocks");
		GameRegistry.registerBlock(block_glass_blocks, ItemBlockGlassBlocks.class, "BlockGlassBlocks");
		GameRegistry.registerBlock(block_wood_blocks, ItemBlockWoodBlocks.class, "BlockWoodBlocks");
		GameRegistry.registerBlock(block_ground_blocks, ItemBlockGroundBlocks.class, "BlockGroundBlocks");
		GameRegistry.registerBlock(block_sand_blocks, ItemBlockSandBlocks.class, "BlockSandBlocks");
		GameRegistry.registerBlock(block_cloth_blocks, ItemBlockClothBlocks.class, "BlockClothBlocks");
		GameRegistry.registerBlock(block_metal_blocks, ItemBlockMetalBlocks.class, "BlockMetalBlocks");
		GameRegistry.registerBlock(block_vegetable_face, "BlockVegetableFace");
		GameRegistry.registerBlock(block_furniture_chest, "BlockFurnitureChest");

		//Items
		GameRegistry.registerItem(items_for_furniture, "ItemsFurniture");
		GameRegistry.registerItem(armor_wool_colors_helmet, "ArmorWoolColorsHelmet");
		GameRegistry.registerItem(armor_wool_colors_chest, "ArmorWoolColorsChest");
		GameRegistry.registerItem(armor_wool_colors_leggin, "ArmorWoolColorsLeggin");
		GameRegistry.registerItem(armor_wool_colors_boot, "ArmorWoolColorsBoot");
		GameRegistry.registerItem(item_colored, "ItemColored");
		GameRegistry.registerItem(tool_brush, "IoolBrush");
		GameRegistry.registerItem(tool_airbrush, "ToolAirBrush");
		GameRegistry.registerItem(item_paint_can, "ItemPaintCan");
		GameRegistry.registerItem(item_backpack, "ItemBackpack");
		GameRegistry.registerItem(item_filter_charcoal, "ItemFilterCharcoal");
		GameRegistry.registerItem(item_kitchenware, "ItemKitchenware");
		GameRegistry.registerItem(armor_costumes_helmet, "ArmorCostumesHelmet");
		GameRegistry.registerItem(armor_costumes_chest, "ArmorCostumesChest");
		GameRegistry.registerItem(armor_costumes_leggin, "ArmorCostumesLeggin");
		GameRegistry.registerItem(armor_costumes_boot, "ArmorCostumesBoot");
		GameRegistry.registerItem(armor_masks, "ArmorMasks");
		GameRegistry.registerItem(armor_backpacks, "ArmorBackpacks");
		GameRegistry.registerItem(item_particles_gun, "ItemParticlesGun");
		GameRegistry.registerItem(armor_medieval_helmet, "ArmorMedievalHelmet");
		GameRegistry.registerItem(armor_medieval_chest, "ArmorMedievalChest");
		GameRegistry.registerItem(armor_medieval_leggin, "ArmorMedievalLeggin");
		GameRegistry.registerItem(armor_medieval_boot, "ArmorMedievalBoot");
		GameRegistry.registerItem(armor_new_helmet, "ArmorNewHelmet");
		GameRegistry.registerItem(armor_new_chest, "ArmorNewChest");
		GameRegistry.registerItem(armor_new_leggin, "ArmorNewLeggin");
		GameRegistry.registerItem(armor_new_boot, "ArmorNewBoot");

		GameRegistry.registerTileEntity(TileEntityFurnitureMachines.class, "TileEntityFurnitureMachines");
		GameRegistry.registerTileEntity(TileEntityCnstorBlock.class, "TileEntityCnstorBlock");
		GameRegistry.registerTileEntity(TileEntityAngleMod.class, "TileEntityAngleMod");
		GameRegistry.registerTileEntity(TileEntityCnstorFence.class, "TileEntityCnstorFence");
		GameRegistry.registerTileEntity(TileEntityCnstorDoors.class, "TileEntityCnstorDoors");
		GameRegistry.registerTileEntity(TileEntityLights.class, "TileEntityLights");
		GameRegistry.registerTileEntity(TileEntityCandle.class, "TileEntityCandle");
		GameRegistry.registerTileEntity(TileEntityCrystals.class, "TileEntityCrystals");
		GameRegistry.registerTileEntity(TileEntityBarrels.class, "TileEntityBarrels");
		GameRegistry.registerTileEntity(TileEntityBookshelf.class, "TileEntityBookshelf");
		GameRegistry.registerTileEntity(TileEntityTable.class, "TileEntityTable");
		GameRegistry.registerTileEntity(TileEntityChair.class, "TileEntityChair");
		GameRegistry.registerTileEntity(TileEntityWardrobe.class, "TileEntityWardrobe");
		GameRegistry.registerTileEntity(TileEntityMincer.class, "TileEntityMincer");
		GameRegistry.registerTileEntity(TileEntityArmChair.class, "TileEntityArmChair");
		GameRegistry.registerTileEntity(TileEntityBlender.class, "TileEntityBlender");
		GameRegistry.registerTileEntity(TileEntityGrills.class, "TileEntityGrills");
		GameRegistry.registerTileEntity(TileEntityBoxParticles.class, "TileEntityBoxParticles");
		GameRegistry.registerTileEntity(TileEntityJar01.class, "TileEntityJar01");
		GameRegistry.registerTileEntity(TileEntityPipes.class, "TileEntityPipes");
		GameRegistry.registerTileEntity(TileEntityMashineWater.class, "TileEntityMashineWater");
		GameRegistry.registerTileEntity(TileEntityBlockBlocks.class, "TileEntityBlockBlocks");
		GameRegistry.registerTileEntity(TileEntityRockBlocks.class, "TileEntityRockBlocks");
		GameRegistry.registerTileEntity(TileEntityGlassBlocks.class, "TileEntityGlassBlocks");
		GameRegistry.registerTileEntity(TileEntityWoodBlocks.class, "TileEntityWoodBlocks");
		GameRegistry.registerTileEntity(TileEntityGroundBlocks.class, "TileEntityGroundBlocks");
		GameRegistry.registerTileEntity(TileEntitySandBlocks.class, "TileEntitySandBlocks");
		GameRegistry.registerTileEntity(TileEntityClothBlocks.class, "TileEntityClothBlocks");
		GameRegistry.registerTileEntity(TileEntityMetalBlocks.class, "TileEntityMetalBlocks");
		GameRegistry.registerTileEntity(TileEntityVegetableFace.class, "TileEntityVegetableFace");
		GameRegistry.registerTileEntity(TileEntityFurnitureChest.class, "TileEntityFurnitureChest");

		OreDictionary.registerOre("dyeBlack", new ItemStack(item_colored, 1, 0));
		OreDictionary.registerOre("dyeBlue", new ItemStack(item_colored, 1, 1));
		OreDictionary.registerOre("dyeBrown", new ItemStack(item_colored, 1, 2));
		OreDictionary.registerOre("dyeCyan", new ItemStack(item_colored, 1, 3));
		OreDictionary.registerOre("dyeGray", new ItemStack(item_colored, 1, 4));
		OreDictionary.registerOre("dyeGreen", new ItemStack(item_colored, 1, 5));
		OreDictionary.registerOre("dyeLightBlue", new ItemStack(item_colored, 1, 6));
		OreDictionary.registerOre("dyeLightGray", new ItemStack(item_colored, 1, 7));
		OreDictionary.registerOre("dyeLightGreen", new ItemStack(item_colored, 1, 8));
		OreDictionary.registerOre("dyeLime", new ItemStack(item_colored, 1, 8));
		OreDictionary.registerOre("dyeMagenta", new ItemStack(item_colored, 1, 9));
		OreDictionary.registerOre("dyeOrange", new ItemStack(item_colored, 1, 10));
		OreDictionary.registerOre("dyePink", new ItemStack(item_colored, 1, 11));
		OreDictionary.registerOre("dyePurple", new ItemStack(item_colored, 1, 12));
		OreDictionary.registerOre("dyeRed", new ItemStack(item_colored, 1, 13));
		OreDictionary.registerOre("dyeWhite", new ItemStack(item_colored, 1, 14));
		OreDictionary.registerOre("dyeYellow", new ItemStack(item_colored, 1, 15));

		OreDictionary.registerOre("dyeBlack", new ItemStack(item_colored, 1, 16));
		OreDictionary.registerOre("dyeBlue", new ItemStack(item_colored, 1, 17));
		OreDictionary.registerOre("dyeBrown", new ItemStack(item_colored, 1, 18));
		OreDictionary.registerOre("dyeCyan", new ItemStack(item_colored, 1, 19));
		OreDictionary.registerOre("dyeGray", new ItemStack(item_colored, 1, 20));
		OreDictionary.registerOre("dyeGreen", new ItemStack(item_colored, 1, 21));
		OreDictionary.registerOre("dyeLightBlue", new ItemStack(item_colored, 1, 22));
		OreDictionary.registerOre("dyeLightGray", new ItemStack(item_colored, 1, 23));
		OreDictionary.registerOre("dyeLightGreen", new ItemStack(item_colored, 1, 24));
		OreDictionary.registerOre("dyeLime", new ItemStack(item_colored, 1, 24));
		OreDictionary.registerOre("dyeMagenta", new ItemStack(item_colored, 1, 25));
		OreDictionary.registerOre("dyeOrange", new ItemStack(item_colored, 1, 26));
		OreDictionary.registerOre("dyePink", new ItemStack(item_colored, 1, 27));
		OreDictionary.registerOre("dyePurple", new ItemStack(item_colored, 1, 28));
		OreDictionary.registerOre("dyeRed", new ItemStack(item_colored, 1, 29));
		OreDictionary.registerOre("dyeWhite", new ItemStack(item_colored, 1, 30));
		OreDictionary.registerOre("dyeYellow", new ItemStack(item_colored, 1, 31));

		GameRegistry.addRecipe(new RecipeCnstorBlockColors());
		GameRegistry.addRecipe(new RecipeArmorColor());
		//GameRegistry.registerCraftingHandler(new CraftFurnitureHandler());

		GameRegistry.registerFuelHandler(new FuelHandlerFurniture());

		/*
		TickRegistry.registerTickHandler(new TickClientHandler(), Side.CLIENT);
		TickRegistry.registerTickHandler(new TickServerHandler(), Side.SERVER);
		 */
		Recipes_Furniture.list();
		Recipes_Armor.list();

		MinecraftForge.EVENT_BUS.register(new EventFurniture());

	}

	public void init() {

		NetworkRegistry.INSTANCE.registerGuiHandler(PackFurniture.MODID, new HandlerGuiFurniture());

	}

}
