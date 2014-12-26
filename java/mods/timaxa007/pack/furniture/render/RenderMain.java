package mods.timaxa007.pack.furniture.render;

import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.pack.furniture.render.block.*;
import mods.timaxa007.pack.furniture.render.item.*;
import mods.timaxa007.pack.furniture.tile.*;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RenderMain {

	public static int block_cnstor_block_modelID;
	public static int block_cnstor_angle_modelID;
	public static int block_cnstor_fence_modelID;
	public static int block_lights_modelID;
	public static int block_candle_modelID;
	public static int block_crystals_modelID;
	public static int block_barrels_modelID;
	public static int block_bookshelf_modelID;
	public static int block_table_modelID;
	public static int block_chair_modelID;
	public static int block_wardrobe_modelID;
	public static int block_mincer_modelID;
	public static int block_armchair_modelID;
	public static int block_blender_modelID;
	public static int block_grills_modelID;
	public static int block_box_particles_modelID;
	public static int block_jar01_modelID;
	public static int block_pipes_modelID;
	public static int block_mashine_waiter_modelID;
	public static int block_furniture_chest_modelID;

	public static void preInit() {

		block_cnstor_block_modelID = -1;
		block_cnstor_angle_modelID = -1;
		block_cnstor_fence_modelID = -1;
		block_lights_modelID = -1;
		block_candle_modelID = -1;
		block_crystals_modelID = -1;
		block_barrels_modelID = -1;
		block_bookshelf_modelID = -1;
		block_table_modelID = -1;
		block_chair_modelID = -1;
		block_wardrobe_modelID = -1;
		block_mincer_modelID = -1;
		block_armchair_modelID = -1;
		block_blender_modelID = -1;
		block_grills_modelID = -1;
		block_box_particles_modelID = -1;
		block_jar01_modelID = -1;
		block_pipes_modelID = -1;
		block_mashine_waiter_modelID = -1;
		block_furniture_chest_modelID = -1;

	}

	@SideOnly(Side.CLIENT)
	public static void init() {

		/**Useless. Need for RenderingRegistry.registerBlockHandler**/
		//Blocks
		/*block_cnstor_block_modelID = RenderingRegistry.getNextAvailableRenderId();
		block_cnstor_angle_modelID = RenderingRegistry.getNextAvailableRenderId();
		block_cnstor_fence_modelID = RenderingRegistry.getNextAvailableRenderId();
		block_lights_modelID = RenderingRegistry.getNextAvailableRenderId();
		block_candle_modelID = RenderingRegistry.getNextAvailableRenderId();
		block_crystals_modelID = RenderingRegistry.getNextAvailableRenderId();
		block_barrels_modelID = RenderingRegistry.getNextAvailableRenderId();
		block_bookshelf_modelID = RenderingRegistry.getNextAvailableRenderId();
		block_table_modelID = RenderingRegistry.getNextAvailableRenderId();
		block_chair_modelID = RenderingRegistry.getNextAvailableRenderId();
		block_wardrobe_modelID = RenderingRegistry.getNextAvailableRenderId();
		block_mincer_modelID = RenderingRegistry.getNextAvailableRenderId();
		block_armchair_modelID = RenderingRegistry.getNextAvailableRenderId();
		block_blender_modelID = RenderingRegistry.getNextAvailableRenderId();
		block_grills_modelID = RenderingRegistry.getNextAvailableRenderId();
		block_box_particles_modelID = RenderingRegistry.getNextAvailableRenderId();
		block_jar01_modelID = RenderingRegistry.getNextAvailableRenderId();
		block_pipes_modelID = RenderingRegistry.getNextAvailableRenderId();
		block_mashine_waiter_modelID = RenderingRegistry.getNextAvailableRenderId();
		block_furniture_chest_modelID = RenderingRegistry.getNextAvailableRenderId();*/

		/**Useless**/
		//RenderingRegistry.registerBlockHandler(block_cnstor_block_modelID, new HandlerBlockLampsOn());

		//Blocks
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCnstorBlock.class, new BlockRenderCnstorBlock());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAngleMod.class, new BlockRenderAngleMod());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCnstorFence.class, new BlockRenderCnstorFence());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLights.class, new BlockRenderLights());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCrystals.class, new BlockRenderCrystals());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCandle.class, new BlockRenderCandle());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBarrels.class, new BlockRenderBarrels());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBookshelf.class, new BlockRenderBookshelf());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTable.class, new BlockRenderTable());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityChair.class, new BlockRenderChair());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWardrobe.class, new BlockRenderWardrobe());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMincer.class, new BlockRenderMincer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityArmChair.class, new BlockRenderArmChair());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBlender.class, new BlockRenderBlender());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGrills.class, new BlockRenderGrills());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBoxParticles.class, new BlockRenderBoxParticles());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityJar01.class, new RenderBlockJar01());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPipes.class, new RenderBlockPipes());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMashineWater.class, new RenderBlockMashineWater());
		//ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWoodBlocks.class, new RenderBlockWoodBlocks());

		//Blocks
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block.cnstor_block), new ItemRenderCnstorBlock());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block.cnstor_angle), new ItemRenderAngles());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block.cnstor_fence), new ItemRenderCnstorFence());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block.light_0), new ItemRenderLights());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block.light_1), new ItemRenderLights());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block.light_2), new ItemRenderLights());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block.light_3), new ItemRenderLights());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block.light_4), new ItemRenderLights());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block.light_5), new ItemRenderLights());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block.light_6), new ItemRenderLights());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block.light_7), new ItemRenderLights());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block.light_8), new ItemRenderLights());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block.light_9), new ItemRenderLights());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block.light_10), new ItemRenderLights());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block.light_11), new ItemRenderLights());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block.light_12), new ItemRenderLights());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block.light_13), new ItemRenderLights());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block.light_14), new ItemRenderLights());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block.light_15), new ItemRenderLights());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block.candle), new ItemRenderCandle());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block.candle_light), new ItemRenderCandle());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block.crystals), new ItemRenderCrystal());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block.barrels), new ItemRenderBarrels());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block.bookshelf), new ItemRenderBookshelf());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block.table), new ItemRenderTables());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block.chair), new ItemRenderChairs());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block.wardrobe), new ItemRenderWardrobes());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block.mincer), new ItemRenderMincer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block.arm_chair), new ItemRenderArmChair());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block.blender), new ItemRenderBlender());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block.grills), new ItemRenderGrills());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block.box_particles), new ItemRenderBoxParticles());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block.jar01), new ItemRenderBlockJar01());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block.pipes), new ItemRenderBlockPipes());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block.mashine_waiter), new ItemRenderBlockMashineWater());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block.rock_blocks), new ItemRenderBlockRockBlocks());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block.glass_blocks), new ItemRenderBlockGlassBlocks());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block.wood_blocks), new ItemRenderBlockWoodBlocks());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block.ground_blocks), new ItemRenderBlockGroundBlocks());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block.sand_blocks), new ItemRenderBlockSandBlocks());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block.cloth_blocks), new ItemRenderBlockClothBlocks());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block.metal_blocks), new ItemRenderBlockMetalBlocks());

		//Items

		//Entity

	}

}
