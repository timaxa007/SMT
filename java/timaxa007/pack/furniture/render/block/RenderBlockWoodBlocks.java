package timaxa007.pack.furniture.render.block;

import timaxa007.pack.furniture.tile.TileEntityWoodBlocks;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderBlockWoodBlocks extends TileEntitySpecialRenderer {

	@Override
	public void renderTileEntityAt(TileEntity te, double dx, double dy, double dz, float f) {
		renderTileEntity((TileEntityWoodBlocks)te, dx, dy, dz, f);
	}

	private void renderTileEntity(TileEntityWoodBlocks te, double dx, double dy, double dz, float f) {
		int typ = 0;
		//int clr = 0x00AAFF;
		//int clr = 0xAA9999;
		//int clr = 0x88FF00;
		int clr = 0x00FF66;
		boolean light = false;
		/*
		if (te != null) {
		typ = te.getType();
		//clr = te.getColor();
		}		
		 */

		if (light) {
			/*char c0 = 61680;
			int j = c0 % 65536;
			int k = c0 / 65536;
			OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j / 1.0F, (float)k / 1.0F);*/
			OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 127.0F, 1.0F);
		}

		GL11.glPushMatrix();
		GL11.glColor3f(1.0F, 1.0F, 1.0F);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glTranslated(dx - 0.0025D, dy - 0.0025D, dz - 0.0025D);
		GL11.glScalef(1.005F, 1.005F, 1.005F);

		bindTexture(new ResourceLocation("timaxa007", "textures/blocks/ore/ore_dust_overlay.png"));

		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		tessellator.setColorOpaque_I(te.getWorldObj().getBiomeGenForCoords((int)dx, (int)dz).getBiomeGrassColor((int)dx, (int)dy, (int)dz));

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

		GL11.glDisable(GL11.GL_BLEND);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glColor3f(1.0F, 1.0F, 1.0F);
		GL11.glPopMatrix();

	}

}
