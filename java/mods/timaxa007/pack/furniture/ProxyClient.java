package mods.timaxa007.pack.furniture;

import mods.timaxa007.pack.furniture.rb.*;
import mods.timaxa007.pack.furniture.ri.*;
import mods.timaxa007.pack.furniture.te.*;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ProxyClient extends ProxyServer {

//Blocks

//Items


@Override
public void init() {
super.init();

//Blocks
render_block_cnstor_block_modelID = RenderingRegistry.getNextAvailableRenderId();
render_block_cnstor_angle_modelID = RenderingRegistry.getNextAvailableRenderId();
render_block_cnstor_fence_modelID = RenderingRegistry.getNextAvailableRenderId();
render_block_lights_modelID = RenderingRegistry.getNextAvailableRenderId();
render_block_lamps_on_modelID = RenderingRegistry.getNextAvailableRenderId();
render_block_lamps_off_modelID = RenderingRegistry.getNextAvailableRenderId();
render_block_lamps2_on_modelID = RenderingRegistry.getNextAvailableRenderId();
render_block_lamps2_off_modelID = RenderingRegistry.getNextAvailableRenderId();
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

//Blocks
ClientRegistry.bindTileEntitySpecialRenderer(TECnstorBlock.class, new BlockRenderCnstorBlock());
ClientRegistry.bindTileEntitySpecialRenderer(TEAngleMod.class, new BlockRenderAngleMod());
ClientRegistry.bindTileEntitySpecialRenderer(TECnstorFence.class, new BlockRenderCnstorFence());
ClientRegistry.bindTileEntitySpecialRenderer(TELights.class, new BlockRenderLights());
ClientRegistry.bindTileEntitySpecialRenderer(TELampsOn.class, new BlockRenderLampsOn());
ClientRegistry.bindTileEntitySpecialRenderer(TELampsOn.class, new BlockRenderLampsOn());
ClientRegistry.bindTileEntitySpecialRenderer(TELampsOff.class, new BlockRenderLampsOff());
ClientRegistry.bindTileEntitySpecialRenderer(TELamps2On.class, new BlockRenderLamps2On());
ClientRegistry.bindTileEntitySpecialRenderer(TELamps2Off.class, new BlockRenderLamps2Off());
ClientRegistry.bindTileEntitySpecialRenderer(TECrystals.class, new BlockRenderCrystals());
ClientRegistry.bindTileEntitySpecialRenderer(TECandle.class, new BlockRenderCandle());
ClientRegistry.bindTileEntitySpecialRenderer(TEBarrels.class, new BlockRenderBarrels());
ClientRegistry.bindTileEntitySpecialRenderer(TEBookshelf.class, new BlockRenderBookshelf());
ClientRegistry.bindTileEntitySpecialRenderer(TETable.class, new BlockRenderTable());
ClientRegistry.bindTileEntitySpecialRenderer(TEChair.class, new BlockRenderChair());
ClientRegistry.bindTileEntitySpecialRenderer(TEWardrobe.class, new BlockRenderWardrobe());
ClientRegistry.bindTileEntitySpecialRenderer(TEMincer.class, new BlockRenderMincer());
ClientRegistry.bindTileEntitySpecialRenderer(TEArmChair.class, new BlockRenderArmChair());
ClientRegistry.bindTileEntitySpecialRenderer(TEBlender.class, new BlockRenderBlender());
ClientRegistry.bindTileEntitySpecialRenderer(TEGrills.class, new BlockRenderGrills());
ClientRegistry.bindTileEntitySpecialRenderer(TEBoxParticles.class, new BlockRenderBoxParticles());
ClientRegistry.bindTileEntitySpecialRenderer(TEJar01.class, new RenderBlockJar01());
ClientRegistry.bindTileEntitySpecialRenderer(TEPipes.class, new RenderBlockPipes());
ClientRegistry.bindTileEntitySpecialRenderer(TEMashineWater.class, new RenderBlockMashineWater());
//ClientRegistry.bindTileEntitySpecialRenderer(TEWoodBlocks.class, new RenderBlockWoodBlocks());

//Items


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
MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_model_lamps_click_on), new ItemRenderLampsOn());
MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_model_lamps_on), new ItemRenderLampsOn());
MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_model_lamps_on_invert), new ItemRenderLampsOn());
MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_model_lamps_click_off), new ItemRenderLampsOff());
MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_model_lamps_off), new ItemRenderLampsOff());
MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_model_lamps_off_invert), new ItemRenderLampsOff());
MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_model_lamps2_click_on), new ItemRenderLamps2On());
MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_model_lamps2_on), new ItemRenderLamps2On());
MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_model_lamps2_on_invert), new ItemRenderLamps2On());
MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_model_lamps2_click_off), new ItemRenderLamps2Off());
MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_model_lamps2_off), new ItemRenderLamps2Off());
MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackFurniture.proxy.block_model_lamps2_off_invert), new ItemRenderLamps2Off());
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

MinecraftForge.EVENT_BUS.register(new EventSoundFurniture());

}

public void preInit(FMLPreInitializationEvent event) {
super.preInit(event);
}

}
