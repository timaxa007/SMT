package mods.timaxa007.pack.techno;

import mods.timaxa007.pack.techno.rb.*;
import mods.timaxa007.pack.techno.ri.*;
import mods.timaxa007.pack.techno.te.*;
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

MinecraftForgeClient.registerItemRenderer(PackTechno.proxy.block_electric_wires.blockID, new ItemRenderBlockElectricWires());
MinecraftForgeClient.registerItemRenderer(PackTechno.proxy.block_chip.blockID, new ItemRenderBlockChip());
MinecraftForgeClient.registerItemRenderer(PackTechno.proxy.block_module_movement.blockID, new ItemRenderBlockModuleMovement());

//Items
MinecraftForge.EVENT_BUS.register(new EventSoundTechno());

}

public void preInit(FMLPreInitializationEvent event) {
super.preInit(event);

}

}
