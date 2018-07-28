package smt.pack.decorative.client.render;

import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import smt.pack.decorative.SMTDecorative;
import smt.pack.decorative.client.render.item.*;
import smt.pack.decorative.client.render.tile.*;
import smt.pack.decorative.tile.*;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ListRender {
	/*
	private static Minecraft mc = Minecraft.getMinecraft();
	private static TextureMap textureMapBlocks;
	 */
	//mc.getTextureManager().bindTexture(TextureMap.locationBlocksTexture);

	public static void preInit() {
		/*
		//Is big work, is need ASM.
		textureMapBlocks = new TextureMap(3, "textures/blocks3", true);
		//bar.step("Anisotropy and Mipmaps");
		textureMapBlocks.setAnisotropicFiltering(mc.gameSettings.anisotropicFiltering);
		textureMapBlocks.setMipmapLevels(mc.gameSettings.mipmapLevels);
		//bar.step("Loading Blocks Texture");
		mc.renderEngine.loadTextureMap(TextureMap.locationBlocksTexture, textureMapBlocks);
		 */
	}

	public static final void init() {

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBlocksDecorative.class, new RenederTileEntityBlocksDecorative());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySit.class, new RenederTileEntitySit());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityStand.class, new RenederTileEntityStand());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityChest.class, new RenederTileEntityChest());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityModelView.class, new RenederTileEntityModelView());

		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(SMTDecorative.block.sit), new RenederItemBlockSit());
		//RenderingRegistry.registerEntityRenderingHandler(EntitySit.class, new RenderEntitySit());

	}

	public static void postInit() {

	}

}
