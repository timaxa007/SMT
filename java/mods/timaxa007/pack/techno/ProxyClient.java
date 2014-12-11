package mods.timaxa007.pack.techno;

import mods.timaxa007.pack.techno.rb.*;
import mods.timaxa007.pack.techno.ri.*;
import mods.timaxa007.pack.techno.te.*;
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
MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackTechno.proxy.block_electric_wires), new ItemRenderBlockElectricWires());
MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackTechno.proxy.block_chip), new ItemRenderBlockChip());
MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackTechno.proxy.block_module_movement), new ItemRenderBlockModuleMovement());

//Items

MinecraftForge.EVENT_BUS.register(new EventSoundTechno());

}

public void preInit(FMLPreInitializationEvent event) {
super.preInit(event);

}

}
