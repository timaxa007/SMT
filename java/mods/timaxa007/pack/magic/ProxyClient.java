package mods.timaxa007.pack.magic;

import mods.timaxa007.pack.magic.PackMagic;
import mods.timaxa007.pack.magic.ProxyServer;
import mods.timaxa007.pack.magic.render.block.*;
import mods.timaxa007.pack.magic.render.item.*;
import mods.timaxa007.pack.magic.event.EventMagicClient;
import mods.timaxa007.pack.magic.tile.*;
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
		render_block_magic_cauldron_modelID = RenderingRegistry.getNextAvailableRenderId();

		//Block
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMagicCauldron.class, new BlockRenderMagicCauldron());

		//Block
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(PackMagic.proxy.block.magic_cauldron), new ItemRenderMagicCauldron());

		//Item
		//MinecraftForgeClient.registerItemRenderer(PackMagic.proxy.toolMagicSword, new ItemRenderMagicSword());
		MinecraftForgeClient.registerItemRenderer(PackMagic.proxy.item.wands, new ItemRenderWands());
		MinecraftForgeClient.registerItemRenderer(PackMagic.proxy.item.stuffs, new ItemRenderStuffs());

		//RenderingRegistry.addNewArmourRendererPrefix("TestArmor");

		//Entity
		//RenderingRegistry.registerEntityRenderingHandler(EntityArrowMini.class, new RenderArrowMini());

		MinecraftForge.EVENT_BUS.register(new EventMagicClient());

	}

	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);

	}

}
