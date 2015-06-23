package timaxa007.pack.mining.render.block;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import timaxa007.pack.mining.tile.TileEntityOreOres;
import timaxa007.smt.util.UtilRender;

public class RenderBlockOreOres extends TileEntitySpecialRenderer {

	@Override
	public void renderTileEntityAt(TileEntity te, double dx, double dy, double dz, float f) {
		render((TileEntityOreOres)te, dx, dy, dz, f);
	}

	private void render(TileEntityOreOres te, double dx, double dy, double dz, float f) {
		int typ = 0;
		//int clr = 0x00AAFF;
		//int clr = 0xAA9999;
		//int clr = 0x88FF00;
		int clr = 0xFF0000;
		boolean light = false;
		//int brl = 0xFF/2;

		if (te != null) {
			typ = te.getType();
			//clr = te.getColor();
		}

		GL11.glPushMatrix();
		GL11.glColor3f(1.0F, 1.0F, 1.0F);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

		GL11.glDisable(GL11.GL_LIGHTING);
		//GL11.glTranslated(dx - 0.0025D, dy - 0.0025D, dz - 0.0025D);
		//GL11.glScalef(1.005F, 1.005F, 1.005F);
		/*
		if (light) {
			OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 127.0F, 1.0F);
		} else {
			int i = (int)(te.getWorldObj().getLightBrightness(te.xCoord, te.yCoord, te.zCoord) * 255.0F);
			//System.out.println(i);
			int j = i % 65536;
			int k = i / 65536;
			OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j / 1.0F, (float)k / 1.0F);
			//GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		}
		 */
		bindTexture(UtilRender.getImg("cb_mtl"));

		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		//tessellator.setColorOpaque_I(clr);
		//tessellator.setBrightness(brl);

		//Down
		tessellator.addVertexWithUV(1.0D, 0.0D, 1.0D, 1.0D, 1.0D);
		tessellator.addVertexWithUV(0.0D, 0.0D, 1.0D, 0.0D, 1.0D);
		tessellator.addVertexWithUV(0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
		tessellator.addVertexWithUV(1.0D, 0.0D, 0.0D, 1.0D, 0.0D);
		//Up
		tessellator.addVertexWithUV(1.0D, 1.0D, 0.0D, 1.0D, 0.0D);
		tessellator.addVertexWithUV(0.0D, 1.0D, 0.0D, 0.0D, 0.0D);
		tessellator.addVertexWithUV(0.0D, 1.0D, 1.0D, 0.0D, 1.0D);
		tessellator.addVertexWithUV(1.0D, 1.0D, 1.0D, 1.0D, 1.0D);
		//North
		tessellator.addVertexWithUV(1.0D, 0.0D, 0.0D, 0.0D, 1.0D);
		tessellator.addVertexWithUV(0.0D, 0.0D, 0.0D, 1.0D, 1.0D);
		tessellator.addVertexWithUV(0.0D, 1.0D, 0.0D, 1.0D, 0.0D);
		tessellator.addVertexWithUV(1.0D, 1.0D, 0.0D, 0.0D, 0.0D);
		//South
		tessellator.addVertexWithUV(1.0D, 1.0D, 1.0D, 1.0D, 0.0D);
		tessellator.addVertexWithUV(0.0D, 1.0D, 1.0D, 0.0D, 0.0D);
		tessellator.addVertexWithUV(0.0D, 0.0D, 1.0D, 0.0D, 1.0D);
		tessellator.addVertexWithUV(1.0D, 0.0D, 1.0D, 1.0D, 1.0D);
		//West
		tessellator.addVertexWithUV(0.0D, 1.0D, 1.0D, 1.0D, 0.0D);
		tessellator.addVertexWithUV(0.0D, 1.0D, 0.0D, 0.0D, 0.0D);
		tessellator.addVertexWithUV(0.0D, 0.0D, 0.0D, 0.0D, 1.0D);
		tessellator.addVertexWithUV(0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
		//East
		tessellator.addVertexWithUV(1.0D, 0.0D, 1.0D, 0.0D, 1.0D);
		tessellator.addVertexWithUV(1.0D, 0.0D, 0.0D, 1.0D, 1.0D);
		tessellator.addVertexWithUV(1.0D, 1.0D, 0.0D, 1.0D, 0.0D);
		tessellator.addVertexWithUV(1.0D, 1.0D, 1.0D, 0.0D, 0.0D);

		tessellator.draw();

		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glColor3f(1.0F, 1.0F, 1.0F);
		GL11.glPopMatrix();

	}

}
