package mods.timaxa007.pack.mining;

import mods.timaxa007.pack.mining.rb.*;
import mods.timaxa007.pack.mining.ri.*;
import mods.timaxa007.pack.mining.te.*;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ProxyClient extends ProxyServer{

	@Override
	public void init() {
		super.init();

		MinecraftForge.EVENT_BUS.register(new EventSoundMining());

		render_block_cristals_modelID = RenderingRegistry.getNextAvailableRenderId();

		ClientRegistry.bindTileEntitySpecialRenderer(TECristals.class, new RenderBlockCristals());
		ClientRegistry.bindTileEntitySpecialRenderer(TEOreOres.class, new RenderBlockOreOres());

		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackMining.proxy.block_cristals), new ItemRenderBlockCristals());

	}

	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);

	}

}
