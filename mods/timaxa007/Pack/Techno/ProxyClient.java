package mods.timaxa007.Pack.Techno;

import mods.timaxa007.Lib.LangLib;
import mods.timaxa007.Pack.Techno.RenderBlocks.*;
import mods.timaxa007.Pack.Techno.RenderItems.*;
import mods.timaxa007.Pack.Techno.TE.*;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class ProxyClient extends ProxyServer {

@Override
public void init() {
super.init();
TickRegistry.registerTickHandler(new TickHandlerPackTechnoClient(), Side.CLIENT);

//Blocks
render_block_electric_wires_modelID = RenderingRegistry.getNextAvailableRenderId();
render_block_chip_modelID = RenderingRegistry.getNextAvailableRenderId();
render_block_module_movement_modelID = RenderingRegistry.getNextAvailableRenderId();

//Items


//Blocks
ClientRegistry.bindTileEntitySpecialRenderer(TEElectricWires.class, new BlockRenderElectricWires());
ClientRegistry.bindTileEntitySpecialRenderer(TEChip.class, new BlockRenderChip());
ClientRegistry.bindTileEntitySpecialRenderer(TEModuleMovement.class, new BlockRenderModuleMovement());

//Items


//Blocks
MinecraftForgeClient.registerItemRenderer(PackTechno.proxy.block_electric_wires.blockID, new ItemRenderBlockElectricWires());
MinecraftForgeClient.registerItemRenderer(PackTechno.proxy.block_chip.blockID, new ItemRenderBlockChip());
MinecraftForgeClient.registerItemRenderer(PackTechno.proxy.block_module_movement.blockID, new ItemRenderBlockModuleMovement());

//Items

MinecraftForge.EVENT_BUS.register(new EventSoundTechno());

LangLib.registerLanguages();

}

public void preInit(FMLPreInitializationEvent event) {
super.preInit(event);

}

}
