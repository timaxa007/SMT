package mods.timaxa007.pack.stock.render.blocks;

import mods.timaxa007.pack.stock.tile.TileEntityFoods;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class RenderBlockFoods extends TileEntitySpecialRenderer {

	@Override
	public void renderTileEntityAt(TileEntity te, double dx, double dy, double dz, float f) {
		renderTileEntity((TileEntityFoods)te, dx, dy, dz, f);
	}

	private void renderTileEntity(TileEntityFoods te, double dx, double dy, double dz, float f) {

	}

}
