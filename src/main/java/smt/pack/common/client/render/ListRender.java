package smt.pack.common.client.render;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.MinecraftForgeClient;
import smt.pack.common.api.RegisteredItems;
import smt.pack.common.client.render.entity.*;
import smt.pack.common.client.render.item.*;
import smt.pack.common.client.render.tile.*;
import smt.pack.common.entity.*;
import smt.pack.common.tile.*;

public class ListRender {

	public static int
	block_blocks_common_renderID
	;

	public static void preInit() {

	}

	public static final void init() {

		block_blocks_common_renderID = RenderingRegistry.getNextAvailableRenderId();
		//RenderingRegistry.registerBlockHandler(block_blocks_common_renderID, new RenederBlockBlocksCommon(block_blocks_common_renderID));

		ItemStack item = null;

		if ((item = RegisteredItems.get("block_blocks_common")) != null) {
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCommonTest.class, new RenederTileEntityCommonTest());
			MinecraftForgeClient.registerItemRenderer(item.getItem(), new RenederItemBlockBlocksCommon());
			item = null;
		}

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAnimation.class, new RenederTileEntityAnimation());

		if ((item = RegisteredItems.get("item_animation")) != null) {
			MinecraftForgeClient.registerItemRenderer(item.getItem(), new RenederItemAnimation());
			item = null;
		}

		if ((item = RegisteredItems.get("item_sword")) != null) {
			MinecraftForgeClient.registerItemRenderer(item.getItem(), new RenederItemSword());
			item = null;
		}

		RenderingRegistry.registerEntityRenderingHandler(EntityCorpse.class, new RenderEntityCorpse());

	}

	public static void postInit() {

	}

}
