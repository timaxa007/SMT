package mods.timaxa007.pack.furniture.block;

import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.pack.furniture.tile.*;
import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockList {

	public static Block furniture_machines;
	public static Block furniture_rock_blocks;
	public static Block furniture_glass_blocks;
	public static Block furniture_wood_blocks;
	public static Block furniture_ground_blocks;
	public static Block furniture_sand_blocks;
	public static Block furniture_cloth_blocks;
	public static Block furniture_metal_blocks;
	public static Block cnstor_block;
	public static Block cnstor_angle;
	public static Block cnstor_half;
	public static Block cnstor_button;
	public static Block cnstor_lever;
	public static Block cnstor_stairs;
	public static Block cnstor_fence;
	public static Block cnstor_wall;
	public static Block cnstor_door;
	public static Block cnstor_bed;

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

	public static Block light_0;
	public static Block light_1;
	public static Block light_2;
	public static Block light_3;
	public static Block light_4;
	public static Block light_5;
	public static Block light_6;
	public static Block light_7;
	public static Block light_8;
	public static Block light_9;
	public static Block light_10;
	public static Block light_11;
	public static Block light_12;
	public static Block light_13;
	public static Block light_14;
	public static Block light_15;
	public static Block light_16;

	public static Block stone_colona1_colors;
	public static Block candle;
	public static Block candle_light;
	public static Block crystals;
	public static Block barrels;
	public static Block bookshelf;
	public static Block table;
	public static Block chair;
	public static Block wardrobe;
	public static Block mincer;
	public static Block arm_chair;
	public static Block blender;
	public static Block grills;
	public static Block box_particles;
	public static Block bonfires;
	public static Block bonfires_burning;
	public static Block jar01;
	public static Block pipes;
	public static Block mashine_waiter;
	public static Block rock_blocks;
	public static Block glass_blocks;
	public static Block wood_blocks;
	public static Block ground_blocks;
	public static Block sand_blocks;
	public static Block cloth_blocks;
	public static Block metal_blocks;
	public static Block vegetable_face;
	public static Block furniture_chest;

	public static void list() {

		furniture_machines = new BlockFurnitureMachines();
		furniture_rock_blocks = new BlockFurnitureRockBlocks();
		furniture_glass_blocks = new BlockFurnitureGlassBlocks();
		furniture_wood_blocks = new BlockFurnitureWoodBlocks();
		furniture_ground_blocks = new BlockFurnitureGroundBlocks();
		furniture_sand_blocks = new BlockFurnitureSandBlocks();
		furniture_cloth_blocks = new BlockFurnitureClothBlocks();
		furniture_metal_blocks = new BlockFurnitureMetalBlocks();
		cnstor_block = new BlockCnstorBlock();
		cnstor_angle = new BlockCnstorAngle();
		cnstor_half = new BlockCnstorHalf();
		cnstor_button = new BlockCnstorButton();
		cnstor_lever = new BlockCnstorLever();
		cnstor_stairs = new BlockCnstorStairs();
		cnstor_fence = new BlockCnstorFence();
		cnstor_wall = new BlockCnstorWall();
		cnstor_door = new BlockCnstorDoor();
		cnstor_bed = new BlockCnstorBed();

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

		light_0 = new BlockLight().setLightLevel(0.0F).setCreativeTab(PackFurniture.tab_furniture);
		light_1 = new BlockLight().setLightLevel(0.0625F);
		light_2 = new BlockLight().setLightLevel(0.125F);
		light_3 = new BlockLight().setLightLevel(0.1875F);
		light_4 = new BlockLight().setLightLevel(0.25F);
		light_5 = new BlockLight().setLightLevel(0.3125F);
		light_6 = new BlockLight().setLightLevel(0.375F);
		light_7 = new BlockLight().setLightLevel(0.4375F);
		light_8 = new BlockLight().setLightLevel(0.5F);
		light_9 = new BlockLight().setLightLevel(0.5625F);
		light_10 = new BlockLight().setLightLevel(0.625F);
		light_11 = new BlockLight().setLightLevel(0.6875F);
		light_12 = new BlockLight().setLightLevel(0.75F);
		light_13 = new BlockLight().setLightLevel(0.8125F);
		light_14 = new BlockLight().setLightLevel(0.875F);
		light_15 = new BlockLight().setLightLevel(0.9375F);
		light_16 = new BlockLight().setLightLevel(1.0F);

		candle = new BlockCandle().setLightLevel(0.0F);
		candle_light = new BlockCandle().setLightLevel(0.5F);
		crystals = new BlockCrystals();
		barrels = new BlockBarrels();
		bookshelf = new BlockBookshelf();
		table = new BlockTable();
		chair = new BlockChair();
		wardrobe = new BlockWardrobe();
		mincer = new BlockMincer();
		arm_chair = new BlockArmChair();
		blender = new BlockBlender();
		grills = new BlockGrills();
		box_particles = new BlockBoxParticles();
		bonfires = new BlockBonfires().setLightLevel(0.0F);
		bonfires_burning = new BlockBonfires().setLightLevel(0.75F);
		jar01 = new BlockJar01();
		pipes = new BlockPipes();
		mashine_waiter = new BlockMashineWater();
		rock_blocks = new BlockRockBlocks();
		glass_blocks = new BlockGlassBlocks();
		wood_blocks = new BlockWoodBlocks();
		ground_blocks = new BlockGroundBlocks();
		sand_blocks = new BlockSandBlocks();
		cloth_blocks = new BlockClothBlocks();
		metal_blocks = new BlockMetalBlocks();
		vegetable_face = new BlockVegetableFace();
		furniture_chest = new BlockFurnitureChest();

		GameRegistry.registerBlock(furniture_machines, "BlockMachines");
		GameRegistry.registerBlock(furniture_rock_blocks, "BlockFurnitureRockBlocks");
		GameRegistry.registerBlock(furniture_glass_blocks, "BlockFurnitureGlassBlocks");
		GameRegistry.registerBlock(furniture_wood_blocks, "BlockFurnitureWoodBlocks");
		GameRegistry.registerBlock(furniture_ground_blocks, "BlockFurnitureGroundBlocks");
		GameRegistry.registerBlock(furniture_sand_blocks, "BlockFurnitureSandBlocks");
		GameRegistry.registerBlock(furniture_cloth_blocks, "BlockFurnitureClothBlocks");
		GameRegistry.registerBlock(furniture_metal_blocks, "BlockFurnitureMetalBlocks");
		GameRegistry.registerBlock(cnstor_block, ItemBlockCnstorBlock.class, "BlockCnstorBlock");
		GameRegistry.registerBlock(cnstor_angle, ItemBlockCnstorAngle.class, "BlockCnstorAngle");
		GameRegistry.registerBlock(cnstor_half, ItemBlockCnstorHalf.class, "BlockCnstorHalf");
		GameRegistry.registerBlock(cnstor_button, ItemBlockCnstorButton.class, "BlockCnstorButton");
		GameRegistry.registerBlock(cnstor_lever, ItemBlockCnstorLever.class, "BlockCnstorLever");
		GameRegistry.registerBlock(cnstor_stairs, ItemBlockCnstorStairs.class, "BlockCnstorStairs");
		GameRegistry.registerBlock(cnstor_fence, ItemBlockCnstorFence.class, "BlockCnstorFence");
		GameRegistry.registerBlock(cnstor_wall, ItemBlockCnstorWall.class, "BlockCnstorWall");
		GameRegistry.registerBlock(cnstor_door, ItemBlockCnstorDoor.class, "BlockCnstorDoor");
		GameRegistry.registerBlock(cnstor_bed, ItemBlockCnstorBed.class, "BlockCnstorBed");

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

		GameRegistry.registerBlock(light_0, "BlockLight0");
		GameRegistry.registerBlock(light_1, "BlockLight1");
		GameRegistry.registerBlock(light_2, "BlockLight2");
		GameRegistry.registerBlock(light_3, "BlockLight3");
		GameRegistry.registerBlock(light_4, "BlockLight4");
		GameRegistry.registerBlock(light_5, "BlockLight5");
		GameRegistry.registerBlock(light_6, "BlockLight6");
		GameRegistry.registerBlock(light_7, "BlockLight7");
		GameRegistry.registerBlock(light_8, "BlockLight8");
		GameRegistry.registerBlock(light_9, "BlockLight9");
		GameRegistry.registerBlock(light_10, "BlockLight10");
		GameRegistry.registerBlock(light_11, "BlockLight11");
		GameRegistry.registerBlock(light_12, "BlockLight12");
		GameRegistry.registerBlock(light_13, "BlockLight13");
		GameRegistry.registerBlock(light_14, "BlockLight14");
		GameRegistry.registerBlock(light_15, "BlockLight15");
		GameRegistry.registerBlock(light_16, "BlockLight16");

		GameRegistry.registerBlock(candle,"BlockCandle");
		GameRegistry.registerBlock(candle_light,"BlockCandleLight");
		GameRegistry.registerBlock(crystals, ItemBlockCrystals.class, "BlockCrystals");
		GameRegistry.registerBlock(barrels, ItemBlockBarrels.class, "BlockBarrels");
		GameRegistry.registerBlock(bookshelf, ItemBlockBookshelf.class, "BlockBookshelf");
		GameRegistry.registerBlock(table, ItemBlockTable.class, "BlockTable");
		GameRegistry.registerBlock(chair, ItemBlockChair.class, "BlockChair");
		GameRegistry.registerBlock(wardrobe, ItemBlockWardrobe.class, "BlockWardrobe");
		GameRegistry.registerBlock(mincer, "BlockMincer");
		GameRegistry.registerBlock(arm_chair, ItemBlockArmChair.class, "BlockArmChair");
		GameRegistry.registerBlock(blender, ItemBlockBlender.class, "BlockBlender");
		GameRegistry.registerBlock(grills, ItemBlockGrills.class, "BlockGrills");
		GameRegistry.registerBlock(box_particles, ItemBlockBoxParticles.class, "BlockBoxParticles");
		GameRegistry.registerBlock(bonfires, "BlockBonfires");
		GameRegistry.registerBlock(bonfires_burning, "BlockBonfiresBurning");
		GameRegistry.registerBlock(jar01, "BlockJar01");
		GameRegistry.registerBlock(pipes, "BlockPipes");
		GameRegistry.registerBlock(mashine_waiter, "BlockMashineWater");
		GameRegistry.registerBlock(rock_blocks, ItemBlockRockBlocks.class, "BlockRockBlocks");
		GameRegistry.registerBlock(glass_blocks, ItemBlockGlassBlocks.class, "BlockGlassBlocks");
		GameRegistry.registerBlock(wood_blocks, ItemBlockWoodBlocks.class, "BlockWoodBlocks");
		GameRegistry.registerBlock(ground_blocks, ItemBlockGroundBlocks.class, "BlockGroundBlocks");
		GameRegistry.registerBlock(sand_blocks, ItemBlockSandBlocks.class, "BlockSandBlocks");
		GameRegistry.registerBlock(cloth_blocks, ItemBlockClothBlocks.class, "BlockClothBlocks");
		GameRegistry.registerBlock(metal_blocks, ItemBlockMetalBlocks.class, "BlockMetalBlocks");
		GameRegistry.registerBlock(vegetable_face, "BlockVegetableFace");
		GameRegistry.registerBlock(furniture_chest, "BlockFurnitureChest");

		GameRegistry.registerTileEntity(TileEntityFurnitureMachines.class, "TileEntityFurnitureMachines");
		GameRegistry.registerTileEntity(TileEntityFurnitureRockBlocks.class, "TileEntityFurnitureRockBlocks");
		GameRegistry.registerTileEntity(TileEntityFurnitureGlassBlocks.class, "TileEntityFurnitureGlassBlocks");
		GameRegistry.registerTileEntity(TileEntityFurnitureWoodBlocks.class, "TileEntityFurnitureWoodBlocks");
		GameRegistry.registerTileEntity(TileEntityFurnitureGroundBlocks.class, "TileEntityFurnitureGroundBlocks");
		GameRegistry.registerTileEntity(TileEntityFurnitureSandBlocks.class, "TileEntityFurnitureSandBlocks");
		GameRegistry.registerTileEntity(TileEntityFurnitureClothBlocks.class, "TileEntityFurnitureClothBlocks");
		GameRegistry.registerTileEntity(TileEntityFurnitureMetalBlocks.class, "TileEntityFurnitureMetalBlocks");
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

	}

}