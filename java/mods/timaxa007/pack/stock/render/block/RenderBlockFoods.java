package mods.timaxa007.pack.stock.render.block;

import mods.timaxa007.pack.stock.tile.TileEntityFoods;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class RenderBlockFoods extends TileEntitySpecialRenderer {

	@Override
	public void renderTileEntityAt(TileEntity te, double dx, double dy, double dz, float f) {
		renderTileEntity((TileEntityFoods)te, dx, dy, dz, f);
	}

	private void renderTileEntity(TileEntityFoods te, double dx, double dy, double dz, float f) {
		String nameID = null;
		int color1 = 0xFFFFFF;
		int color2 = 0xFFFFFF;
		if (te !=null) {
			nameID = te.getTag();
			color1 = te.getColor1();
			color2 = te.getColor2();
		}

	}

}
