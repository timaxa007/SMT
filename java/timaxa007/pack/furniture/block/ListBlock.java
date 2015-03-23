package timaxa007.pack.furniture.block;

import timaxa007.pack.furniture.PackFurniture;
import timaxa007.pack.furniture.tile.*;
import timaxa007.tms.util.UtilTMS;
import net.minecraft.block.Block;

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

	public static Class
	te_furniture_machines, 
	te_furniture_rock_blocks, 
	te_furniture_glass_blocks, 
	te_furniture_wood_blocks, 
	te_furniture_ground_blocks, 
	te_furniture_sand_blocks, 
	te_furniture_cloth_blocks, 
	te_furniture_metal_blocks, 
	te_cnstor_block, 
	te_angle_mod, 
	te_cnstor_fence, 
	te_cnstor_doors, 
	te_lights, 
	te_candle, 
	te_crystals, 
	te_barrels, 
	te_bookshelf, 
	te_table, 
	te_chair, 
	te_wardrobe, 
	te_mincer, 
	te_arm_chair, 
	te_blender, 
	te_grills, 
	te_box_particles, 
	te_jar01, 
	te_pipes, 
	te_mashine_water, 
	te_block_blocks, 
	te_rock_blocks, 
	te_glass_blocks, 
	te_wood_blocks, 
	te_ground_blocks, 
	te_sand_blocks, 
	te_cloth_blocks, 
	te_metal_blocks, 
	te_vegetable_face, 
	te_furniture_chest
	;

	public static Block[] list_block;

	public static Class[] list_te;

	public static void preInit() {

		if (furniture_machines_be) {
			furniture_machines = new BlockFurnitureMachines("furniture_machines");
			te_furniture_machines = TileEntityFurnitureMachines.class;
		}

		if (furniture_rock_blocks_be) {
			furniture_rock_blocks = new BlockFurnitureRockBlocks("furniture_rock_blocks");
			te_furniture_rock_blocks = TileEntityFurnitureRockBlocks.class;
		}

		if (furniture_glass_blocks_be) {
			furniture_glass_blocks = new BlockFurnitureGlassBlocks("furniture_glass_blocks");
			te_furniture_glass_blocks = TileEntityFurnitureGlassBlocks.class;
		}

		if (furniture_wood_blocks_be) {
			furniture_wood_blocks = new BlockFurnitureWoodBlocks("furniture_wood_blocks");
			te_furniture_wood_blocks = TileEntityFurnitureWoodBlocks.class;
		}

		if (furniture_ground_blocks_be) {
			furniture_ground_blocks = new BlockFurnitureGroundBlocks("furniture_ground_blocks");
			te_furniture_ground_blocks = TileEntityFurnitureGroundBlocks.class;
		}

		if (furniture_sand_blocks_be) {
			furniture_sand_blocks = new BlockFurnitureSandBlocks("furniture_sand_blocks");
			te_furniture_sand_blocks = TileEntityFurnitureSandBlocks.class;
		}

		if (furniture_cloth_blocks_be) {
			furniture_cloth_blocks = new BlockFurnitureClothBlocks("furniture_cloth_blocks");
			te_furniture_cloth_blocks = TileEntityFurnitureClothBlocks.class;
		}

		if (furniture_metal_blocks_be) {
			furniture_metal_blocks = new BlockFurnitureMetalBlocks("furniture_metal_blocks");
			te_furniture_metal_blocks = TileEntityFurnitureMetalBlocks.class;
		}

		if (cnstor_block_be) {
			cnstor_block = new BlockCnstorBlock("cnstor_block");
			te_cnstor_block = TileEntityCnstorBlock.class;
		}
		if (cnstor_angle_be) {
			cnstor_angle = new BlockCnstorAngle("cnstor_angle");
			te_angle_mod = TileEntityAngleMod.class;
		}
		if (cnstor_half_be) {cnstor_half = new BlockCnstorHalf("cnstor_half");}

		if (cnstor_button_be) {cnstor_button = new BlockCnstorButton("cnstor_button");}

		if (cnstor_lever_be) {cnstor_lever = new BlockCnstorLever("cnstor_lever");}

		if (cnstor_stairs_be) {cnstor_stairs = new BlockCnstorStairs("cnstor_stairs");}

		if (cnstor_fence_be) {
			cnstor_fence = new BlockCnstorFence("cnstor_fence");
			te_cnstor_fence = TileEntityCnstorFence.class;
		}

		if (cnstor_wall_be) {cnstor_wall = new BlockCnstorWall("cnstor_wall");}

		if (cnstor_door_be) {
			cnstor_door = new BlockCnstorDoor("cnstor_door");
			te_cnstor_doors = TileEntityCnstorDoors.class;
		}

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
		if (air_light_0_be || air_light_1_be || air_light_2_be || air_light_3_be || air_light_4_be || 
				air_light_5_be || air_light_6_be || air_light_7_be || air_light_8_be || 
				air_light_9_be || air_light_10_be || air_light_11_be || air_light_12_be || 
				air_light_13_be || air_light_14_be || air_light_15_be || air_light_16_be) ;

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
		if (light_0_be || light_1_be || light_2_be || light_3_be || light_4_be || 
				light_5_be || light_6_be || light_7_be || light_8_be || 
				light_9_be || light_10_be || light_11_be || light_12_be || 
				light_13_be || light_14_be || light_15_be || light_16_be) 
			te_lights = TileEntityLights.class;

		if (candle_be) candle = new BlockCandle("candle").setLightLevel(0.0F);
		if (candle_light_be) candle_light = new BlockCandle("candle_light").setLightLevel(0.5F);
		if (candle_be || candle_light_be) te_candle = TileEntityCandle.class;

		if (crystals_be) {
			crystals = new BlockCrystals("crystals");
			te_crystals = TileEntityCrystals.class;
		}

		if (barrels_be) {
			barrels = new BlockBarrels("barrels");
			te_barrels = TileEntityBarrels.class;
		}

		if (bookshelf_be) {
			bookshelf = new BlockBookshelf("bookshelf");
			te_bookshelf = TileEntityBookshelf.class;
		}

		if (table_be) {
			table = new BlockTable("table");
			te_table = TileEntityTable.class;
		}

		if (chair_be) {
			chair = new BlockChair("chair");
			te_chair = TileEntityChair.class;
		}

		if (wardrobe_be) {
			wardrobe = new BlockWardrobe("wardrobe");
			te_wardrobe = TileEntityWardrobe.class;
		}

		if (mincer_be) {
			mincer = new BlockMincer("mincer");
			te_mincer = TileEntityMincer.class;
		}

		if (arm_chair_be) {
			arm_chair = new BlockArmChair("arm_chair");
			te_arm_chair = TileEntityArmChair.class;
		}

		if (blender_be) {
			blender = new BlockBlender("blender");
			te_blender = TileEntityBlender.class;
		}

		if (grills_be) {
			grills = new BlockGrills("grills");
			te_grills = TileEntityGrills.class;
		}

		if (box_particles_be) {
			box_particles = new BlockBoxParticles("box_particles");
			te_box_particles = TileEntityBoxParticles.class;
		}

		if (bonfires_be) {bonfires = new BlockBonfires("bonfires").setLightLevel(0.0F);}
		if (bonfires_burning_be) {bonfires_burning = new BlockBonfires("bonfires_burning").setLightLevel(0.75F);}

		if (jar01_be) {
			jar01 = new BlockJar01("jar01");
			te_jar01 = TileEntityJar01.class;}

		if (pipes_be) {
			pipes = new BlockPipes("pipes");
			te_pipes = TileEntityPipes.class;}

		if (mashine_waiter_be) {
			mashine_waiter = new BlockMashineWater("mashine_waiter");
			te_mashine_water = TileEntityMashineWater.class;
		}

		if (rock_blocks_be) {
			rock_blocks = new BlockRockBlocks("rock_blocks");
			te_rock_blocks = TileEntityRockBlocks.class;
		}

		if (glass_blocks_be) {
			glass_blocks = new BlockGlassBlocks("glass_blocks");
			te_glass_blocks = TileEntityGlassBlocks.class;
		}

		if (wood_blocks_be) {
			wood_blocks = new BlockWoodBlocks("wood_blocks");
			te_wood_blocks = TileEntityWoodBlocks.class;
		}

		if (ground_blocks_be) {
			ground_blocks = new BlockGroundBlocks("ground_blocks");
			te_ground_blocks = TileEntityGroundBlocks.class;
		}

		if (sand_blocks_be) {
			sand_blocks = new BlockSandBlocks("sand_blocks");
			te_sand_blocks = TileEntitySandBlocks.class;
		}

		if (cloth_blocks_be) {
			cloth_blocks = new BlockClothBlocks("cloth_blocks");
			te_cloth_blocks = TileEntityClothBlocks.class;
		}

		if (metal_blocks_be) {
			metal_blocks = new BlockMetalBlocks("metal_blocks");
			te_metal_blocks = TileEntityMetalBlocks.class;
		}

		if (vegetable_face_be) {
			vegetable_face = new BlockVegetableFace("vegetable_face");
			te_vegetable_face = TileEntityVegetableFace.class;
		}

		if (furniture_chest_be) {
			furniture_chest = new BlockFurnitureChest("furniture_chest");
			te_furniture_chest = TileEntityFurnitureChest.class;
		}

		te_block_blocks = TileEntityBlockBlocks.class;

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

		list_te = new Class[] {
				te_furniture_machines, 
				te_furniture_rock_blocks, 
				te_furniture_glass_blocks, 
				te_furniture_wood_blocks, 
				te_furniture_ground_blocks, 
				te_furniture_sand_blocks, 
				te_furniture_cloth_blocks, 
				te_furniture_metal_blocks, 
				te_cnstor_block, 
				te_angle_mod, 
				te_cnstor_fence, 
				te_cnstor_doors, 
				te_lights, 
				te_candle, 
				te_crystals, 
				te_barrels, 
				te_bookshelf, 
				te_table, 
				te_chair, 
				te_wardrobe, 
				te_mincer, 
				te_arm_chair, 
				te_blender, 
				te_grills, 
				te_box_particles, 
				te_jar01, 
				te_pipes, 
				te_mashine_water, 
				te_block_blocks, 
				te_rock_blocks, 
				te_glass_blocks, 
				te_wood_blocks, 
				te_ground_blocks, 
				te_sand_blocks, 
				te_cloth_blocks, 
				te_metal_blocks, 
				te_vegetable_face, 
				te_furniture_chest
		};

		UtilTMS.UtilBlock.RegTE(list_te);

	}

}
