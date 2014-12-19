package mods.timaxa007.pack.stock;

import mods.timaxa007.pack.stock.PackStock;
import mods.timaxa007.pack.stock.ProxyServer;
import mods.timaxa007.pack.stock.render.blocks.*;
import mods.timaxa007.pack.stock.render.items.*;
import mods.timaxa007.pack.stock.event.EventStockClient;
import mods.timaxa007.pack.stock.tile.*;
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
		render_block_germination_plants_modelID = RenderingRegistry.getNextAvailableRenderId();
		render_block_foods_modelID = RenderingRegistry.getNextAvailableRenderId();
		render_block_apiary_modelID = RenderingRegistry.getNextAvailableRenderId();

		//Blocks
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGerminationPlants.class, new RenderBlockGerminationPlants());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFoods.class, new RenderBlockFoods());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityApiary.class, new RenderBlockApiary());

		//Blocks
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackStock.proxy.block_germination_plants), new ItemRenderBlockGerminationPlants());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackStock.proxy.block_foods), new ItemRenderFoods());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackStock.proxy.block_apiary), new ItemRenderBlockApiary());

		//Items

		//Entity

		MinecraftForge.EVENT_BUS.register(new EventStockClient());

	}

	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
	}

}
