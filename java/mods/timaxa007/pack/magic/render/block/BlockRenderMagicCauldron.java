package mods.timaxa007.pack.magic.render.block;

import mods.timaxa007.pack.magic.tile.TEMagicCauldron;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class BlockRenderMagicCauldron extends TileEntitySpecialRenderer {

	public BlockRenderMagicCauldron() {

	}

	@Override
	public void renderTileEntityAt(TileEntity te, double dx, double dy, double dz, float f) {
		renderTE((TEMagicCauldron)te, dx, dy, dz, f);
	}

	private void renderTE(TEMagicCauldron te, double dx, double dy, double dz, float f) {

	}

}
