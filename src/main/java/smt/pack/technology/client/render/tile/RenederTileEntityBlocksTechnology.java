package smt.pack.technology.client.render.tile;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import smt.pack.common.client.UtilModel;
import smt.pack.technology.tile.TileEntityBlocksTechnology;

public class RenederTileEntityBlocksTechnology extends TileEntitySpecialRenderer {

	static final Tessellator tessellator = Tessellator.instance;
	static final Minecraft mc = Minecraft.getMinecraft();

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float parTick) {
		render((TileEntityBlocksTechnology)tile, x, y, z, parTick);
	}

	private void render(TileEntityBlocksTechnology tile, double x, double y, double z, float parTick) {
		double x_fix = -(mc.thePlayer.lastTickPosX + (mc.thePlayer.posX - mc.thePlayer.lastTickPosX) * parTick);
		double y_fix = -(mc.thePlayer.lastTickPosY + (mc.thePlayer.posY - mc.thePlayer.lastTickPosY) * parTick);
		double z_fix = -(mc.thePlayer.lastTickPosZ + (mc.thePlayer.posZ - mc.thePlayer.lastTickPosZ) * parTick);

		GL11.glPushMatrix();
		GL11.glTranslated(x_fix, y_fix, z_fix);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glColor4f(0.25F, 0.65F, 0.9F, 0.25F);
		UtilModel.box(tessellator,
				tile.xCoord + tile.posX, tile.yCoord + tile.posY, tile.zCoord + tile.posZ,
				tile.xCoord + tile.posX + 1D, tile.yCoord + tile.posY + 1D, tile.zCoord + tile.posZ + 1D);
		GL11.glColor4f(0F, 0.25F, 1F, 0.5F);
		UtilModel.lines(tile.xCoord + tile.posX, tile.yCoord + tile.posY, tile.zCoord + tile.posZ,
				tile.xCoord + tile.posX + 1D, tile.yCoord + tile.posY + 1D, tile.zCoord + tile.posZ + 1D);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glPopMatrix();
	}

}
