package mods.timaxa007.pack.techno;

import mods.timaxa007.pack.techno.PackTechno;
import mods.timaxa007.pack.techno.ProxyServer;
import mods.timaxa007.pack.techno.render.block.*;
import mods.timaxa007.pack.techno.render.item.*;
import mods.timaxa007.pack.techno.event.EventTechnoClient;
import mods.timaxa007.pack.techno.tile.*;
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

		//Blocks
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityElectricWires.class, new BlockRenderElectricWires());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityChip.class, new BlockRenderChip());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityModuleMovement.class, new BlockRenderModuleMovement());

		//Blocks
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackTechno.proxy.block_electric_wires), new ItemRenderBlockElectricWires());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackTechno.proxy.block_chip), new ItemRenderBlockChip());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackTechno.proxy.block_module_movement), new ItemRenderBlockModuleMovement());

		//Items

		//Entity

		MinecraftForge.EVENT_BUS.register(new EventTechnoClient());

	}

	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);

	}

}
