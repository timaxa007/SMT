package mods.timaxa007.pack.furniture.block;

import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.pack.furniture.tile.*;
import mods.timaxa007.tms.util.UtilTMS;
import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;

public class ListBlock {

	public static Block 
	furniture_machines, 
	furniture_rock_blocks, 
	furniture_glass_blocks, 
	furniture_wood_blocks, 
	furniture_ground_blocks, 
	furniture_sand_blocks, 
	furniture_cloth_blocks, 
	furniture_metal_blocks, 
	cnstor_block, 
	cnstor_angle, 
	cnstor_half, 
	cnstor_button, 
	cnstor_lever, 
	cnstor_stairs, 
	cnstor_fence, 
	cnstor_wall, 
	cnstor_door, 
	cnstor_bed, 

	fluid_fake_water, 
	fluid_fake_water_flowing, 
	fluid_fake_lava, 
	fluid_fake_lava_flowing, 

	air_light_0, 
	air_light_1, 
	air_light_2, 
	air_light_3, 
	air_light_4, 
	air_light_5, 
	air_light_6, 
	air_light_7, 
	air_light_8, 
	air_light_9, 
	air_light_10, 
	air_light_11, 
	air_light_12, 
	air_light_13, 
	air_light_14, 
	air_light_15, 
	air_light_16, 

	light_0, 
	light_1, 
	light_2, 
	light_3, 
	light_4, 
	light_5, 
	light_6, 
	light_7, 
	light_8, 
	light_9, 
	light_10, 
	light_11, 
	light_12, 
	light_13, 
	light_14, 
	light_15, 
	light_16, 

	stone_colona1_colors, 
	candle, 
	candle_light, 
	crystals, 
	barrels, 
	bookshelf, 
	table, 
	chair, 
	wardrobe, 
	mincer, 
	arm_chair, 
	blender, 
	grills, 
	box_particles, 
	bonfires, 
	bonfires_burning, 
	jar01, 
	pipes, 
	mashine_waiter, 
	rock_blocks, 
	glass_blocks, 
	wood_blocks, 
	ground_blocks, 
	sand_blocks, 
	cloth_blocks, 
	metal_blocks, 
	vegetable_face, 
	furniture_chest;

	public static Block[] list_block;

	public static void preInit() {

		furniture_machines = new BlockFurnitureMachines("furniture_machines");
		furniture_rock_blocks = new BlockFurnitureRockBlocks("furniture_rock_blocks");
		furniture_glass_blocks = new BlockFurnitureGlassBlocks("furniture_glass_blocks");
		furniture_wood_blocks = new BlockFurnitureWoodBlocks("furniture_wood_blocks");
		furniture_ground_blocks = new BlockFurnitureGroundBlocks("furniture_ground_blocks");
		furniture_sand_blocks = new BlockFurnitureSandBlocks("furniture_sand_blocks");
		furniture_cloth_blocks = new BlockFurnitureClothBlocks("furniture_cloth_blocks");
		furniture_metal_blocks = new BlockFurnitureMetalBlocks("furniture_metal_blocks");
		cnstor_block = new BlockCnstorBlock("cnstor_block");
		cnstor_angle = new BlockCnstorAngle("cnstor_angle");
		cnstor_half = new BlockCnstorHalf("cnstor_half");
		cnstor_button = new BlockCnstorButton("cnstor_button");
		cnstor_lever = new BlockCnstorLever("cnstor_lever");
		cnstor_stairs = new BlockCnstorStairs("cnstor_stairs");
		cnstor_fence = new BlockCnstorFence("cnstor_fence");
		cnstor_wall = new BlockCnstorWall("cnstor_wall");
		cnstor_door = new BlockCnstorDoor("cnstor_door");
		cnstor_bed = new BlockCnstorBed("cnstor_bed");

		fluid_fake_water = new BlockFluidFakeWaterStatic("fluid_fake_water").setLightOpacity(3).setBlockTextureName("water_still");
		fluid_fake_water_flowing = new BlockFluidFakeWaterDynamic("fluid_fake_water_flowing").setLightOpacity(3).setBlockTextureName("water_flow");
		fluid_fake_lava = new BlockFluidFakeLavaStatic("fluid_fake_lava").setLightLevel(1.0F).setBlockTextureName("lava_still");
		fluid_fake_lava_flowing = new BlockFluidFakeLavaDynamic("fluid_fake_lava_flowing").setLightLevel(1.0F).setBlockTextureName("lava_flow");

		air_light_0 = new AirLight("air_light_0").setLightLevel(0.0F);
		air_light_1 = new AirLight("air_light_1").setLightLevel(0.0625F);
		air_light_2 = new AirLight("air_light_2").setLightLevel(0.125F);
		air_light_3 = new AirLight("air_light_3").setLightLevel(0.1875F);
		air_light_4 = new AirLight("air_light_4").setLightLevel(0.25F);
		air_light_5 = new AirLight("air_light_5").setLightLevel(0.3125F);
		air_light_6 = new AirLight("air_light_6").setLightLevel(0.375F);
		air_light_7 = new AirLight("air_light_7").setLightLevel(0.4375F);
		air_light_8 = new AirLight("air_light_8").setLightLevel(0.5F);
		air_light_9 = new AirLight("air_light_9").setLightLevel(0.5625F);
		air_light_10 = new AirLight("air_light_10").setLightLevel(0.625F);
		air_light_11 = new AirLight("air_light_11").setLightLevel(0.6875F);
		air_light_12 = new AirLight("air_light_12").setLightLevel(0.75F);
		air_light_13 = new AirLight("air_light_13").setLightLevel(0.8125F);
		air_light_14 = new AirLight("air_light_14").setLightLevel(0.875F);
		air_light_15 = new AirLight("air_light_15").setLightLevel(0.9375F);
		air_light_16 = new AirLight("air_light_16").setLightLevel(1.0F);

		light_0 = new BlockLight("light_0").setLightLevel(0.0F).setCreativeTab(PackFurniture.tab_furniture);
		light_1 = new BlockLight("light_1").setLightLevel(0.0625F);
		light_2 = new BlockLight("light_2").setLightLevel(0.125F);
		light_3 = new BlockLight("light_3").setLightLevel(0.1875F);
		light_4 = new BlockLight("light_4").setLightLevel(0.25F);
		light_5 = new BlockLight("light_5").setLightLevel(0.3125F);
		light_6 = new BlockLight("light_6").setLightLevel(0.375F);
		light_7 = new BlockLight("light_7").setLightLevel(0.4375F);
		light_8 = new BlockLight("light_8").setLightLevel(0.5F);
		light_9 = new BlockLight("light_9").setLightLevel(0.5625F);
		light_10 = new BlockLight("light_10").setLightLevel(0.625F);
		light_11 = new BlockLight("light_11").setLightLevel(0.6875F);
		light_12 = new BlockLight("light_12").setLightLevel(0.75F);
		light_13 = new BlockLight("light_13").setLightLevel(0.8125F);
		light_14 = new BlockLight("light_14").setLightLevel(0.875F);
		light_15 = new BlockLight("light_15").setLightLevel(0.9375F);
		light_16 = new BlockLight("light_16").setLightLevel(1.0F);

		candle = new BlockCandle("candle").setLightLevel(0.0F);
		candle_light = new BlockCandle("candle_light").setLightLevel(0.5F);
		crystals = new BlockCrystals("crystals");
		barrels = new BlockBarrels("barrels");
		bookshelf = new BlockBookshelf("bookshelf");
		table = new BlockTable("table");
		chair = new BlockChair("chair");
		wardrobe = new BlockWardrobe("wardrobe");
		mincer = new BlockMincer("mincer");
		arm_chair = new BlockArmChair("arm_chair");
		blender = new BlockBlender("blender");
		grills = new BlockGrills("grills");
		box_particles = new BlockBoxParticles("box_particles");
		bonfires = new BlockBonfires("bonfires").setLightLevel(0.0F);
		bonfires_burning = new BlockBonfires("bonfires_burning").setLightLevel(0.75F);
		jar01 = new BlockJar01("jar01");
		pipes = new BlockPipes("pipes");
		mashine_waiter = new BlockMashineWater("mashine_waiter");
		rock_blocks = new BlockRockBlocks("rock_blocks");
		glass_blocks = new BlockGlassBlocks("glass_blocks");
		wood_blocks = new BlockWoodBlocks("wood_blocks");
		ground_blocks = new BlockGroundBlocks("ground_blocks");
		sand_blocks = new BlockSandBlocks("sand_blocks");
		cloth_blocks = new BlockClothBlocks("cloth_blocks");
		metal_blocks = new BlockMetalBlocks("metal_blocks");
		vegetable_face = new BlockVegetableFace("vegetable_face");
		furniture_chest = new BlockFurnitureChest("furniture_chest");

		list_block = new Block[] {
				furniture_machines, 
				furniture_rock_blocks, 
				furniture_glass_blocks, 
				furniture_wood_blocks, 
				furniture_ground_blocks, 
				furniture_sand_blocks, 
				furniture_cloth_blocks, 
				furniture_metal_blocks, 
				cnstor_block, 
				cnstor_angle, 
				cnstor_half, 
				cnstor_button, 
				cnstor_lever, 
				cnstor_stairs, 
				cnstor_fence, 
				cnstor_wall, 
				cnstor_door, 
				cnstor_bed, 

				fluid_fake_water, 
				fluid_fake_water_flowing, 
				fluid_fake_lava, 
				fluid_fake_lava_flowing, 

				air_light_0, 
				air_light_1, 
				air_light_2, 
				air_light_3, 
				air_light_4, 
				air_light_5, 
				air_light_6, 
				air_light_7, 
				air_light_8, 
				air_light_9, 
				air_light_10, 
				air_light_11, 
				air_light_12, 
				air_light_13, 
				air_light_14, 
				air_light_15, 
				air_light_16, 

				light_0, 
				light_1, 
				light_2, 
				light_3, 
				light_4, 
				light_5, 
				light_6, 
				light_7, 
				light_8, 
				light_9, 
				light_10, 
				light_11, 
				light_12, 
				light_13, 
				light_14, 
				light_15, 
				light_16, 

				stone_colona1_colors, 
				candle, 
				candle_light, 
				crystals, 
				barrels, 
				bookshelf, 
				table, 
				chair, 
				wardrobe, 
				mincer, 
				arm_chair, 
				blender, 
				grills, 
				box_particles, 
				bonfires, 
				bonfires_burning, 
				jar01, 
				pipes, 
				mashine_waiter, 
				rock_blocks, 
				glass_blocks, 
				wood_blocks, 
				ground_blocks, 
				sand_blocks, 
				cloth_blocks, 
				metal_blocks, 
				vegetable_face, 
				furniture_chest
		};

		for (int i = 0; i < list_block.length; i++) 
			UtilTMS.UtilBlock.RegBlock(list_block[i]);

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
