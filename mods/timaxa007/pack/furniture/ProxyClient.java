package mods.timaxa007.pack.furniture;

import mods.timaxa007.lib.LangLib;
import mods.timaxa007.pack.furniture.rb.*;
import mods.timaxa007.pack.furniture.ri.*;
import mods.timaxa007.pack.furniture.te.*;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class ProxyClient extends ProxyServer {

//Blocks

//Items


@Override
public void init() {
super.init();
TickRegistry.registerTickHandler(new TickHandlerPackFurnitureClient(), Side.CLIENT);

//Blocks
renderBlockCnstorBlockModelID = RenderingRegistry.getNextAvailableRenderId();
renderBlockCnstorAngleModelID = RenderingRegistry.getNextAvailableRenderId();
renderBlockCnstorFenceModelID = RenderingRegistry.getNextAvailableRenderId();
render_block_lights_modelID = RenderingRegistry.getNextAvailableRenderId();
renderBlockLampsOnModelID = RenderingRegistry.getNextAvailableRenderId();
renderBlockLampsOffModelID = RenderingRegistry.getNextAvailableRenderId();
renderBlockLamps2OnModelID = RenderingRegistry.getNextAvailableRenderId();
renderBlockLamps2OffModelID = RenderingRegistry.getNextAvailableRenderId();
renderBlockCandleModelID = RenderingRegistry.getNextAvailableRenderId();
renderBlockCrystalsModelID = RenderingRegistry.getNextAvailableRenderId();
renderBlockBarrelsModelID = RenderingRegistry.getNextAvailableRenderId();
renderBlockBookshelfModelID = RenderingRegistry.getNextAvailableRenderId();
renderBlockTableModelID = RenderingRegistry.getNextAvailableRenderId();
renderBlockChairModelID = RenderingRegistry.getNextAvailableRenderId();
renderBlockWardrobeModelID = RenderingRegistry.getNextAvailableRenderId();
renderBlockMincerModelID = RenderingRegistry.getNextAvailableRenderId();
renderBlockArmChairModelID = RenderingRegistry.getNextAvailableRenderId();
renderBlockBlenderModelID = RenderingRegistry.getNextAvailableRenderId();
renderBlockGrillsModelID = RenderingRegistry.getNextAvailableRenderId();
renderBlockBoxParticlesModelID = RenderingRegistry.getNextAvailableRenderId();
renderBlockBallsModelID = RenderingRegistry.getNextAvailableRenderId();
render_block_jar01_modelID = RenderingRegistry.getNextAvailableRenderId();
render_block_pipes_modelID = RenderingRegistry.getNextAvailableRenderId();
render_block_cylinder_modelID = RenderingRegistry.getNextAvailableRenderId();
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
ClientRegistry.bindTileEntitySpecialRenderer(TEBalls.class, new BlockRenderBalls());
ClientRegistry.bindTileEntitySpecialRenderer(TEJar01.class, new RenderBlockJar01());
ClientRegistry.bindTileEntitySpecialRenderer(TEPipes.class, new RenderBlockPipes());
ClientRegistry.bindTileEntitySpecialRenderer(TECylinder.class, new RenderBlockCylinder());
ClientRegistry.bindTileEntitySpecialRenderer(TEMashineWater.class, new RenderBlockMashineWater());
//ClientRegistry.bindTileEntitySpecialRenderer(TEBlockWoodBlocks.class, new RenderBlockWoodBlocks());

//Items


//Blocks
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_cnstor_block.blockID, new ItemRenderCnstorBlock());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_cnstor_angle.blockID, new ItemRenderAngles());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_cnstor_fence.blockID, new ItemRenderCnstorFence());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_light_0.blockID, new ItemRenderLights());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_light_1.blockID, new ItemRenderLights());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_light_2.blockID, new ItemRenderLights());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_light_3.blockID, new ItemRenderLights());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_light_4.blockID, new ItemRenderLights());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_light_5.blockID, new ItemRenderLights());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_light_6.blockID, new ItemRenderLights());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_light_7.blockID, new ItemRenderLights());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_light_8.blockID, new ItemRenderLights());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_light_9.blockID, new ItemRenderLights());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_light_10.blockID, new ItemRenderLights());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_light_11.blockID, new ItemRenderLights());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_light_12.blockID, new ItemRenderLights());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_light_13.blockID, new ItemRenderLights());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_light_14.blockID, new ItemRenderLights());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_light_15.blockID, new ItemRenderLights());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_model_lamps_click_on.blockID, new ItemRenderLampsOn());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_model_lamps_on.blockID, new ItemRenderLampsOn());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_model_lamps_on_invert.blockID, new ItemRenderLampsOn());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_model_lamps_click_off.blockID, new ItemRenderLampsOff());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_model_lamps_off.blockID, new ItemRenderLampsOff());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_model_lamps_off_invert.blockID, new ItemRenderLampsOff());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_model_lamps2_click_on.blockID, new ItemRenderLamps2On());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_model_lamps2_on.blockID, new ItemRenderLamps2On());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_model_lamps2_on_invert.blockID, new ItemRenderLamps2On());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_model_lamps2_click_off.blockID, new ItemRenderLamps2Off());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_model_lamps2_off.blockID, new ItemRenderLamps2Off());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_model_lamps2_off_invert.blockID, new ItemRenderLamps2Off());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_candle.blockID, new ItemRenderCandle());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_candle_light.blockID, new ItemRenderCandle());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_crystals.blockID, new ItemRenderCrystal());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_barrels.blockID, new ItemRenderBarrels());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_bookshelf.blockID, new ItemRenderBookshelf());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_table.blockID, new ItemRenderTables());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_chair.blockID, new ItemRenderChairs());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_wardrobe.blockID, new ItemRenderWardrobes());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_mincer.blockID, new ItemRenderMincer());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_arm_chair.blockID, new ItemRenderArmChair());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_blender.blockID, new ItemRenderBlender());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_grills.blockID, new ItemRenderGrills());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_box_particles.blockID, new ItemRenderBoxParticles());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_balls.blockID, new ItemRenderBalls());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_jar01.blockID, new ItemRenderBlockJar01());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_pipes.blockID, new ItemRenderBlockPipes());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_cylinder.blockID, new ItemRenderBlockCylinder());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_mashine_waiter.blockID, new ItemRenderBlockMashineWater());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_rock_blocks.blockID, new ItemRenderBlockRockBlocks());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_glass_blocks.blockID, new ItemRenderBlockGlassBlocks());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_wood_blocks.blockID, new ItemRenderBlockWoodBlocks());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_ground_blocks.blockID, new ItemRenderBlockGroundBlocks());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_sand_blocks.blockID, new ItemRenderBlockSandBlocks());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_cloth_blocks.blockID, new ItemRenderBlockClothBlocks());
MinecraftForgeClient.registerItemRenderer(PackFurniture.proxy.block_metal_blocks.blockID, new ItemRenderBlockMetalBlocks());

//Items

MinecraftForge.EVENT_BUS.register(new EventSoundFurniture());

LangLib.registerLanguages();

}

public void preInit(FMLPreInitializationEvent event) {
super.preInit(event);
}

}
