package mods.timaxa007.pack.furniture.block;

import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.pack.furniture.tile.*;
import mods.timaxa007.tms.util.UtilTMS;
import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;

public class ListBlock {

	public static boolean 
	furniture_machines_be, 
	furniture_rock_blocks_be, 
	furniture_glass_blocks_be, 
	furniture_wood_blocks_be, 
	furniture_ground_blocks_be, 
	furniture_sand_blocks_be, 
	furniture_cloth_blocks_be, 
	furniture_metal_blocks_be, 
	cnstor_block_be, 
	cnstor_angle_be, 
	cnstor_half_be, 
	cnstor_button_be, 
	cnstor_lever_be, 
	cnstor_stairs_be, 
	cnstor_fence_be, 
	cnstor_wall_be, 
	cnstor_door_be, 
	cnstor_bed_be, 

	fluid_fake_water_be, 
	fluid_fake_water_flowing_be, 
	fluid_fake_lava_be, 
	fluid_fake_lava_flowing_be, 

	air_light_0_be, 
	air_light_1_be, 
	air_light_2_be, 
	air_light_3_be, 
	air_light_4_be, 
	air_light_5_be, 
	air_light_6_be, 
	air_light_7_be, 
	air_light_8_be, 
	air_light_9_be, 
	air_light_10_be, 
	air_light_11_be, 
	air_light_12_be, 
	air_light_13_be, 
	air_light_14_be, 
	air_light_15_be, 
	air_light_16_be, 

	light_0_be, 
	light_1_be, 
	light_2_be, 
	light_3_be, 
	light_4_be, 
	light_5_be, 
	light_6_be, 
	light_7_be, 
	light_8_be, 
	light_9_be, 
	light_10_be, 
	light_11_be, 
	light_12_be, 
	light_13_be, 
	light_14_be, 
	light_15_be, 
	light_16_be, 

	stone_colona1_colors_be, 
	candle_be, 
	candle_light_be, 
	crystals_be, 
	barrels_be, 
	bookshelf_be, 
	table_be, 
	chair_be, 
	wardrobe_be, 
	mincer_be, 
	arm_chair_be, 
	blender_be, 
	grills_be, 
	box_particles_be, 
	bonfires_be, 
	bonfires_burning_be, 
	jar01_be, 
	pipes_be, 
	mashine_waiter_be, 
	rock_blocks_be, 
	glass_blocks_be, 
	wood_blocks_be, 
	ground_blocks_be, 
	sand_blocks_be, 
	cloth_blocks_be, 
	metal_blocks_be, 
	vegetable_face_be, 
	furniture_chest_be;

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
	public static Class[] list_te;

	public static void preInit() {

		if (furniture_machines_be) {furniture_machines = new BlockFurnitureMachines("furniture_machines");}
		if (furniture_rock_blocks_be) {furniture_rock_blocks = new BlockFurnitureRockBlocks("furniture_rock_blocks");}
		if (furniture_glass_blocks_be) {furniture_glass_blocks = new BlockFurnitureGlassBlocks("furniture_glass_blocks");}
		if (furniture_wood_blocks_be) {furniture_wood_blocks = new BlockFurnitureWoodBlocks("furniture_wood_blocks");}
		if (furniture_ground_blocks_be) {furniture_ground_blocks = new BlockFurnitureGroundBlocks("furniture_ground_blocks");}
		if (furniture_sand_blocks_be) {furniture_sand_blocks = new BlockFurnitureSandBlocks("furniture_sand_blocks");}
		if (furniture_cloth_blocks_be) {furniture_cloth_blocks = new BlockFurnitureClothBlocks("furniture_cloth_blocks");}
		if (furniture_metal_blocks_be) {furniture_metal_blocks = new BlockFurnitureMetalBlocks("furniture_metal_blocks");}
		if (cnstor_block_be) {cnstor_block = new BlockCnstorBlock("cnstor_block");}
		if (cnstor_angle_be) {cnstor_angle = new BlockCnstorAngle("cnstor_angle");}
		if (cnstor_half_be) {cnstor_half = new BlockCnstorHalf("cnstor_half");}
		if (cnstor_button_be) {cnstor_button = new BlockCnstorButton("cnstor_button");}
		if (cnstor_lever_be) {cnstor_lever = new BlockCnstorLever("cnstor_lever");}
		if (cnstor_stairs_be) {cnstor_stairs = new BlockCnstorStairs("cnstor_stairs");}
		if (cnstor_fence_be) {cnstor_fence = new BlockCnstorFence("cnstor_fence");}
		if (cnstor_wall_be) {cnstor_wall = new BlockCnstorWall("cnstor_wall");}
		if (cnstor_door_be) {cnstor_door = new BlockCnstorDoor("cnstor_door");}
		if (cnstor_bed_be) {cnstor_bed = new BlockCnstorBed("cnstor_bed");}

		if (fluid_fake_water_be) {
			fluid_fake_water = new BlockFluidFakeWaterStatic("fluid_fake_water").setLightOpacity(3).setBlockTextureName("water_still");
		}
		if (fluid_fake_water_flowing_be) {
			fluid_fake_water_flowing = new BlockFluidFakeWaterDynamic("fluid_fake_water_flowing").setLightOpacity(3).setBlockTextureName("water_flow");
		}
		if (fluid_fake_lava_be) {
			fluid_fake_lava = new BlockFluidFakeLavaStatic("fluid_fake_lava").setLightLevel(1.0F).setBlockTextureName("lava_still");
		}
		if (fluid_fake_lava_flowing_be) {
			fluid_fake_lava_flowing = new BlockFluidFakeLavaDynamic("fluid_fake_lava_flowing").setLightLevel(1.0F).setBlockTextureName("lava_flow");
		}

		if (air_light_0_be) air_light_0 = new AirLight("air_light_0").setLightLevel(0.0F);
		if (air_light_1_be) air_light_1 = new AirLight("air_light_1").setLightLevel(0.0625F);
		if (air_light_2_be) air_light_2 = new AirLight("air_light_2").setLightLevel(0.125F);
		if (air_light_3_be) air_light_3 = new AirLight("air_light_3").setLightLevel(0.1875F);
		if (air_light_4_be) air_light_4 = new AirLight("air_light_4").setLightLevel(0.25F);
		if (air_light_5_be) air_light_5 = new AirLight("air_light_5").setLightLevel(0.3125F);
		if (air_light_6_be) air_light_6 = new AirLight("air_light_6").setLightLevel(0.375F);
		if (air_light_7_be) air_light_7 = new AirLight("air_light_7").setLightLevel(0.4375F);
		if (air_light_8_be) air_light_8 = new AirLight("air_light_8").setLightLevel(0.5F);
		if (air_light_9_be) air_light_9 = new AirLight("air_light_9").setLightLevel(0.5625F);
		if (air_light_10_be) air_light_10 = new AirLight("air_light_10").setLightLevel(0.625F);
		if (air_light_11_be) air_light_11 = new AirLight("air_light_11").setLightLevel(0.6875F);
		if (air_light_12_be) air_light_12 = new AirLight("air_light_12").setLightLevel(0.75F);
		if (air_light_13_be) air_light_13 = new AirLight("air_light_13").setLightLevel(0.8125F);
		if (air_light_14_be) air_light_14 = new AirLight("air_light_14").setLightLevel(0.875F);
		if (air_light_15_be) air_light_15 = new AirLight("air_light_15").setLightLevel(0.9375F);
		if (air_light_16_be) air_light_16 = new AirLight("air_light_16").setLightLevel(1.0F);

		if (light_0_be) light_0 = new BlockLight("light_0").setLightLevel(0.0F).setCreativeTab(PackFurniture.tab_furniture);
		if (light_1_be) light_1 = new BlockLight("light_1").setLightLevel(0.0625F);
		if (light_2_be) light_2 = new BlockLight("light_2").setLightLevel(0.125F);
		if (light_3_be) light_3 = new BlockLight("light_3").setLightLevel(0.1875F);
		if (light_4_be) light_4 = new BlockLight("light_4").setLightLevel(0.25F);
		if (light_5_be) light_5 = new BlockLight("light_5").setLightLevel(0.3125F);
		if (light_6_be) light_6 = new BlockLight("light_6").setLightLevel(0.375F);
		if (light_7_be) light_7 = new BlockLight("light_7").setLightLevel(0.4375F);
		if (light_8_be) light_8 = new BlockLight("light_8").setLightLevel(0.5F);
		if (light_9_be) light_9 = new BlockLight("light_9").setLightLevel(0.5625F);
		if (light_10_be) light_10 = new BlockLight("light_10").setLightLevel(0.625F);
		if (light_11_be) light_11 = new BlockLight("light_11").setLightLevel(0.6875F);
		if (light_12_be) light_12 = new BlockLight("light_12").setLightLevel(0.75F);
		if (light_13_be) light_13 = new BlockLight("light_13").setLightLevel(0.8125F);
		if (light_14_be) light_14 = new BlockLight("light_14").setLightLevel(0.875F);
		if (light_15_be) light_15 = new BlockLight("light_15").setLightLevel(0.9375F);
		if (light_16_be) light_16 = new BlockLight("light_16").setLightLevel(1.0F);

		if (candle_be) candle = new BlockCandle("candle").setLightLevel(0.0F);
		if (candle_light_be) candle_light = new BlockCandle("candle_light").setLightLevel(0.5F);
		if (crystals_be) crystals = new BlockCrystals("crystals");
		if (barrels_be) barrels = new BlockBarrels("barrels");
		if (bookshelf_be) bookshelf = new BlockBookshelf("bookshelf");
		if (table_be) table = new BlockTable("table");
		if (chair_be) chair = new BlockChair("chair");
		if (wardrobe_be) wardrobe = new BlockWardrobe("wardrobe");
		if (mincer_be) mincer = new BlockMincer("mincer");
		if (arm_chair_be) arm_chair = new BlockArmChair("arm_chair");
		if (blender_be) blender = new BlockBlender("blender");
		if (grills_be) grills = new BlockGrills("grills");
		if (box_particles_be) box_particles = new BlockBoxParticles("box_particles");
		if (bonfires_be) bonfires = new BlockBonfires("bonfires").setLightLevel(0.0F);
		if (bonfires_burning_be) bonfires_burning = new BlockBonfires("bonfires_burning").setLightLevel(0.75F);
		if (jar01_be) jar01 = new BlockJar01("jar01");
		if (pipes_be) pipes = new BlockPipes("pipes");
		if (mashine_waiter_be) mashine_waiter = new BlockMashineWater("mashine_waiter");
		if (rock_blocks_be) rock_blocks = new BlockRockBlocks("rock_blocks");
		if (glass_blocks_be) glass_blocks = new BlockGlassBlocks("glass_blocks");
		if (wood_blocks_be) wood_blocks = new BlockWoodBlocks("wood_blocks");
		if (ground_blocks_be) ground_blocks = new BlockGroundBlocks("ground_blocks");
		if (sand_blocks_be) sand_blocks = new BlockSandBlocks("sand_blocks");
		if (cloth_blocks_be) cloth_blocks = new BlockClothBlocks("cloth_blocks");
		if (metal_blocks_be) metal_blocks = new BlockMetalBlocks("metal_blocks");
		if (vegetable_face_be) vegetable_face = new BlockVegetableFace("vegetable_face");
		if (furniture_chest_be) furniture_chest = new BlockFurnitureChest("furniture_chest");

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

		UtilTMS.UtilBlock.RegBlock(list_block);

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
