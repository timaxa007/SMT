package mods.timaxa007.pack.stock;

import mods.timaxa007.pack.stock.rb.*;
import mods.timaxa007.pack.stock.ri.*;
import mods.timaxa007.pack.stock.te.*;
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

		//Items

		//Blocks
		ClientRegistry.bindTileEntitySpecialRenderer(TEGerminationPlants.class, new RenderBlockGerminationPlants());
		ClientRegistry.bindTileEntitySpecialRenderer(TEFoods.class, new RenderBlockFoods());
		ClientRegistry.bindTileEntitySpecialRenderer(TEApiary.class, new RenderBlockApiary());

		//Items

		//Blocks
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackStock.proxy.block_germination_plants), new ItemRenderBlockGerminationPlants());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackStock.proxy.block_foods), new ItemRenderFoods());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackStock.proxy.block_apiary), new ItemRenderBlockApiary());

		//Items

		MinecraftForge.EVENT_BUS.register(new EventSoundStock());

	}

	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
	}

}
