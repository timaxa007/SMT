package timaxa007.pack.magic.render.block;

import timaxa007.pack.magic.tile.TileEntityMagicCauldron;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class BlockRenderMagicCauldron extends TileEntitySpecialRenderer {

	public BlockRenderMagicCauldron() {

	}

	@Override
	public void renderTileEntityAt(TileEntity te, double dx, double dy, double dz, float f) {
		renderTileEntity((TileEntityMagicCauldron)te, dx, dy, dz, f);
	}

	private void renderTileEntity(TileEntityMagicCauldron te, double dx, double dy, double dz, float f) {

	}

}
