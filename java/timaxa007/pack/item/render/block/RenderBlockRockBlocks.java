package timaxa007.pack.item.render.block;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.world.IBlockAccess;
import timaxa007.pack.item.PackItems;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderBlockRockBlocks implements ISimpleBlockRenderingHandler {

	private static int renderID;

	public RenderBlockRockBlocks() {
		this.renderID = PackItems.render.rock_blocks_renderID;
	}

	public RenderBlockRockBlocks(int renderID) {
		this.renderID = renderID;
	}

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {

	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		//TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityCristals(), (double)x, (double)y, (double)z, 1.0F);

		renderer.overrideBlockTexture = Blocks.iron_bars.getIcon(0, 0);
		renderer.renderStandardBlock(block, x, y, z);
		renderer.clearOverrideBlockTexture();

		renderer.renderStandardBlock(block, x, y, z);

		return false;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return false;
	}

	@Override
	public int getRenderId() {return renderID;}

}
