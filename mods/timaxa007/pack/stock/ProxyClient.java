package mods.timaxa007.pack.stock;

import mods.timaxa007.pack.stock.rb.*;
import mods.timaxa007.pack.stock.ri.*;
import mods.timaxa007.pack.stock.te.*;
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
TickRegistry.registerTickHandler(new TickHandlerPackStockClient(), Side.CLIENT);

//Blocks
render_block_germination_plants_modelID = RenderingRegistry.getNextAvailableRenderId();
render_block_foods_modelID = RenderingRegistry.getNextAvailableRenderId();
render_block_pizza_modelID = RenderingRegistry.getNextAvailableRenderId();
render_block_cake_modelID = RenderingRegistry.getNextAvailableRenderId();
render_block_pie_modelID = RenderingRegistry.getNextAvailableRenderId();
render_block_apiary_modelID = RenderingRegistry.getNextAvailableRenderId();

//Items

//Blocks
ClientRegistry.bindTileEntitySpecialRenderer(TEGerminationPlants.class, new RenderBlockGerminationPlants());
ClientRegistry.bindTileEntitySpecialRenderer(TEFoods.class, new BlockRenderFoods());
ClientRegistry.bindTileEntitySpecialRenderer(TEPizza.class, new BlockRenderPizzas());
ClientRegistry.bindTileEntitySpecialRenderer(TECake.class, new BlockRenderCakes());
ClientRegistry.bindTileEntitySpecialRenderer(TEPie.class, new BlockRenderPies());
ClientRegistry.bindTileEntitySpecialRenderer(TEApiary.class, new RenderBlockApiary());

//Items

//Blocks
MinecraftForgeClient.registerItemRenderer(PackStock.proxy.block_germination_plants.blockID, new ItemRenderBlockGerminationPlants());
MinecraftForgeClient.registerItemRenderer(PackStock.proxy.block_pizzas.blockID, new ItemRenderPizzas());
MinecraftForgeClient.registerItemRenderer(PackStock.proxy.block_foods.blockID, new ItemRenderFoods());
MinecraftForgeClient.registerItemRenderer(PackStock.proxy.block_cakes.blockID, new ItemRenderCakes());
MinecraftForgeClient.registerItemRenderer(PackStock.proxy.block_pies.blockID, new ItemRenderPies());
MinecraftForgeClient.registerItemRenderer(PackStock.proxy.block_apiary.blockID, new ItemRenderBlockApiary());

//Items

MinecraftForge.EVENT_BUS.register(new EventSoundStock());

}

public void preInit(FMLPreInitializationEvent event) {
super.preInit(event);
}

}
