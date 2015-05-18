package timaxa007.pack.furniture.render;

import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import timaxa007.pack.furniture.PackFurniture;
import timaxa007.pack.furniture.render.block.*;
import timaxa007.pack.furniture.render.item.*;
import timaxa007.pack.furniture.tile.*;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RenderMain {

	public static int
	block_cnstor_block_modelID,
	block_cnstor_angle_modelID,
	block_cnstor_fence_modelID,
	block_lights_modelID,
	block_candle_modelID,
	block_crystals_modelID,
	block_barrels_modelID,
	block_bookshelf_modelID,
	block_table_modelID,
	block_chair_modelID,
	block_wardrobe_modelID,
	block_mincer_modelID,
	block_armchair_modelID,
	block_blender_modelID,
	block_grills_modelID,
	block_box_particles_modelID,
	block_jar01_modelID,
	block_pipes_modelID,
	block_mashine_waiter_modelID,
	block_furniture_chest_modelID,
	block_storage_modelID
	;

	public static int[] list_render_id;

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
		block_storage_modelID = -1;

		list_render_id = new int[] {
				block_cnstor_block_modelID,
				block_cnstor_angle_modelID,
				block_cnstor_fence_modelID,
				block_lights_modelID,
				block_candle_modelID,
				block_crystals_modelID,
				block_barrels_modelID,
				block_bookshelf_modelID,
				block_table_modelID,
				block_chair_modelID,
				block_wardrobe_modelID,
				block_mincer_modelID,
				block_armchair_modelID,
				block_blender_modelID,
				block_grills_modelID,
				block_box_particles_modelID,
				block_jar01_modelID,
				block_pipes_modelID,
				block_mashine_waiter_modelID,
				block_furniture_chest_modelID,
				block_storage_modelID
		};

	}

	@SideOnly(Side.CLIENT)
	public static void init() {

		/**Useless. Need for RenderingRegistry.registerBlockHandler**/
		//for (int id : list_render_id) id = RenderingRegistry.getNextAvailableRenderId();

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
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityStorage.class, new RenderBlockStorage());

		//Blocks
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.block.cnstor_block), new ItemRenderCnstorBlock());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.block.cnstor_angle), new ItemRenderAngles());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.block.cnstor_fence), new ItemRenderCnstorFence());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.block.light_0), new ItemRenderLights());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.block.light_1), new ItemRenderLights());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.block.light_2), new ItemRenderLights());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.block.light_3), new ItemRenderLights());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.block.light_4), new ItemRenderLights());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.block.light_5), new ItemRenderLights());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.block.light_6), new ItemRenderLights());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.block.light_7), new ItemRenderLights());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.block.light_8), new ItemRenderLights());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.block.light_9), new ItemRenderLights());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.block.light_10), new ItemRenderLights());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.block.light_11), new ItemRenderLights());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.block.light_12), new ItemRenderLights());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.block.light_13), new ItemRenderLights());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.block.light_14), new ItemRenderLights());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.block.light_15), new ItemRenderLights());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.block.candle), new ItemRenderCandle());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.block.candle_light), new ItemRenderCandle());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.block.crystals), new ItemRenderCrystal());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.block.barrels), new ItemRenderBarrels());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.block.bookshelf), new ItemRenderBookshelf());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.block.table), new ItemRenderTables());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.block.chair), new ItemRenderChairs());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.block.wardrobe), new ItemRenderWardrobes());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.block.mincer), new ItemRenderMincer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.block.arm_chair), new ItemRenderArmChair());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.block.blender), new ItemRenderBlender());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.block.grills), new ItemRenderGrills());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.block.box_particles), new ItemRenderBoxParticles());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.block.jar01), new ItemRenderBlockJar01());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.block.pipes), new ItemRenderBlockPipes());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.block.mashine_waiter), new ItemRenderBlockMashineWater());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.block.storage), new ItemRenderBlockStorage());

		//Items

		//Entity

	}

}
