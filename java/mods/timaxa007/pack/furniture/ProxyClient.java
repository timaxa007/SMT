package mods.timaxa007.pack.furniture;

import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.pack.furniture.ProxyServer;
import mods.timaxa007.pack.furniture.render.block.*;
import mods.timaxa007.pack.furniture.render.item.*;
import mods.timaxa007.pack.furniture.event.EventFurnitureClient;
import mods.timaxa007.pack.furniture.tile.*;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ProxyClient extends ProxyServer {

	@Override
	public void init() {
		super.init();

		//Blocks
		render_block_cnstor_block_modelID = RenderingRegistry.getNextAvailableRenderId();
		render_block_cnstor_angle_modelID = RenderingRegistry.getNextAvailableRenderId();
		render_block_cnstor_fence_modelID = RenderingRegistry.getNextAvailableRenderId();
		render_block_lights_modelID = RenderingRegistry.getNextAvailableRenderId();
		render_block_candle_modelID = RenderingRegistry.getNextAvailableRenderId();
		render_block_crystals_modelID = RenderingRegistry.getNextAvailableRenderId();
		render_block_barrels_modelID = RenderingRegistry.getNextAvailableRenderId();
		render_block_bookshelf_modelID = RenderingRegistry.getNextAvailableRenderId();
		render_block_table_modelID = RenderingRegistry.getNextAvailableRenderId();
		render_block_chair_modelID = RenderingRegistry.getNextAvailableRenderId();
		render_block_wardrobe_modelID = RenderingRegistry.getNextAvailableRenderId();
		render_block_mincer_modelID = RenderingRegistry.getNextAvailableRenderId();
		render_block_armchair_modelID = RenderingRegistry.getNextAvailableRenderId();
		render_block_blender_modelID = RenderingRegistry.getNextAvailableRenderId();
		render_block_grills_modelID = RenderingRegistry.getNextAvailableRenderId();
		render_block_box_particles_modelID = RenderingRegistry.getNextAvailableRenderId();
		render_block_jar01_modelID = RenderingRegistry.getNextAvailableRenderId();
		render_block_pipes_modelID = RenderingRegistry.getNextAvailableRenderId();
		render_block_mashine_waiter_modelID = RenderingRegistry.getNextAvailableRenderId();
		render_block_furniture_chest_modelID = RenderingRegistry.getNextAvailableRenderId();

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
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_cnstor_block), new ItemRenderCnstorBlock());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_cnstor_angle), new ItemRenderAngles());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_cnstor_fence), new ItemRenderCnstorFence());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_light_0), new ItemRenderLights());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_light_1), new ItemRenderLights());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_light_2), new ItemRenderLights());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_light_3), new ItemRenderLights());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_light_4), new ItemRenderLights());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_light_5), new ItemRenderLights());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_light_6), new ItemRenderLights());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_light_7), new ItemRenderLights());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_light_8), new ItemRenderLights());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_light_9), new ItemRenderLights());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_light_10), new ItemRenderLights());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_light_11), new ItemRenderLights());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_light_12), new ItemRenderLights());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_light_13), new ItemRenderLights());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_light_14), new ItemRenderLights());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_light_15), new ItemRenderLights());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_candle), new ItemRenderCandle());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_candle_light), new ItemRenderCandle());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_crystals), new ItemRenderCrystal());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_barrels), new ItemRenderBarrels());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_bookshelf), new ItemRenderBookshelf());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_table), new ItemRenderTables());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_chair), new ItemRenderChairs());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_wardrobe), new ItemRenderWardrobes());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_mincer), new ItemRenderMincer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_arm_chair), new ItemRenderArmChair());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_blender), new ItemRenderBlender());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_grills), new ItemRenderGrills());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_box_particles), new ItemRenderBoxParticles());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_jar01), new ItemRenderBlockJar01());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_pipes), new ItemRenderBlockPipes());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_mashine_waiter), new ItemRenderBlockMashineWater());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_rock_blocks), new ItemRenderBlockRockBlocks());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_glass_blocks), new ItemRenderBlockGlassBlocks());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_wood_blocks), new ItemRenderBlockWoodBlocks());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_ground_blocks), new ItemRenderBlockGroundBlocks());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_sand_blocks), new ItemRenderBlockSandBlocks());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_cloth_blocks), new ItemRenderBlockClothBlocks());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_metal_blocks), new ItemRenderBlockMetalBlocks());

		//Items

		//Entity

		MinecraftForge.EVENT_BUS.register(new EventFurnitureClient());

	}

	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
	}

}
