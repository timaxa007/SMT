package mods.timaxa007.pack.mining;

import mods.timaxa007.pack.mining.PackMining;
import mods.timaxa007.pack.mining.ProxyServer;
import mods.timaxa007.pack.mining.render.blocks.*;
import mods.timaxa007.pack.mining.render.items.*;
import mods.timaxa007.pack.mining.event.EventMiningClient;
import mods.timaxa007.pack.mining.tile.*;
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

		//Block
		render_block_cristals_modelID = RenderingRegistry.getNextAvailableRenderId();

		//Block
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCristals.class, new RenderBlockCristals());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityOreOres.class, new RenderBlockOreOres());

		//Block
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackMining.proxy.block_cristals), new ItemRenderBlockCristals());

		//Item

		//Entity

		MinecraftForge.EVENT_BUS.register(new EventMiningClient());

	}

	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);

	}

}
