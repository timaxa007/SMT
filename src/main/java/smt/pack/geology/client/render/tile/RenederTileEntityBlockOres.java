package smt.pack.geology.client.render.tile;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import smt.pack.geology.tile.TileEntityBlockOres;

public class RenederTileEntityBlockOres extends TileEntitySpecialRenderer {

	//private static MakeTexture tecv2 = new MakeTexture().set("smt_geology:opre");
	private boolean isLayer = true;

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float parTick) {
		render((TileEntityBlockOres)tile, x, y, z, parTick);
	}

	private void render(TileEntityBlockOres tile, double x, double y, double z, float parTick) {
		GL11.glPushMatrix();
		GL11.glTranslated(x, y, z);
		GL11.glDisable(GL11.GL_LIGHTING);

		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glPopMatrix();
	}

}
