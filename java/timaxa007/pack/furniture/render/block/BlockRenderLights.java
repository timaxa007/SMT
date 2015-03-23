package timaxa007.pack.furniture.render.block;

import timaxa007.pack.furniture.tile.TileEntityLights;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class BlockRenderLights extends TileEntitySpecialRenderer {

	@Override
	public void renderTileEntityAt(TileEntity te, double dx, double dy, double dz, float f) {
		renderTileEntity((TileEntityLights)te, dx, dy, dz,f);
	}

	private void renderTileEntity(TileEntityLights te, double dx, double dy, double dz, float f) {

	}

}
