package timaxa007.pack.furniture.render.block;

import timaxa007.pack.furniture.tile.TileEntityPipes;
import timaxa007.smt.lib.AddTextureModel;
import timaxa007.smt.lib.ModelT;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

public class RenderBlockPipes extends TileEntitySpecialRenderer {

	@Override
	public void renderTileEntityAt(TileEntity te, double dx, double dy, double dz, float f) {
		renderTileEntity((TileEntityPipes)te, dx, dy, dz, f);
	}

	private void renderTileEntity(TileEntityPipes te, double dx, double dy, double dz, float f) {
		//int meta = te.getBlockMetadata();
		String tex = "";
		int siz = 1;
		int clr = 0xFFFFFF;

		if (te != null) {
			tex = te.getStyle();
			siz = te.getSize();
			//clr = te.getColor();
		}

		double s_p = (double) 1 / 16;
		double ss_p = (double) s_p * siz;
		double ss_p_p = 0.5D + ss_p;
		double ss_p_m = 0.5D - ss_p;

		//--------------------------------------------------
		GL11.glPushMatrix();
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glTranslated(dx, dy, dz);
		GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
		GL11.glTranslatef(0.0F, 0.0F, -1.0F);

		bindTexture(AddTextureModel.get(tex).getTexture());

		Tessellator tessellator = Tessellator.instance;
		//-------------------------------------------------------------------
		//addBox(1.0D, 1.0D, 1.0D, 0.0D, 0.0D, 0.0D);
		ModelT.addBox(ss_p_p, ss_p_p, ss_p_p, ss_p_m, ss_p_m, ss_p_m);
		if (te != null) {
			/*
			if (te.up) {addBox(ss_p_p, 1.0D, ss_p_p, ss_p_m, ss_p_p, ss_p_m);}
			if (te.down) {addBox(ss_p_p, ss_p_m, ss_p_p, ss_p_m, 0.0D, ss_p_m);}
			if (te.north) {addBox(1.0D, ss_p_p, ss_p_p, ss_p_p, ss_p_m, ss_p_m);}
			if (te.south) {addBox(ss_p_p, ss_p_p, 1.0D, ss_p_m, ss_p_m, ss_p_p);}
			if (te.west) {addBox(ss_p_m, ss_p_p, ss_p_p, 0.0D, ss_p_m, ss_p_m);}
			if (te.east) {addBox(ss_p_p, ss_p_p, ss_p_m, ss_p_m, ss_p_m, 0.0D);}
			 */
			if (te.west) {ModelT.addBox(ss_p_p, 1.0D, ss_p_p, ss_p_m, ss_p_p, ss_p_m);}
			if (te.east) {ModelT.addBox(ss_p_p, ss_p_m, ss_p_p, ss_p_m, 0.0D, ss_p_m);}
			if (te.north) {ModelT.addBox(1.0D, ss_p_p, ss_p_p, ss_p_p, ss_p_m, ss_p_m);}
			if (te.down) {ModelT.addBox(ss_p_p, ss_p_p, 1.0D, ss_p_m, ss_p_m, ss_p_p);}
			if (te.south) {ModelT.addBox(ss_p_m, ss_p_p, ss_p_p, 0.0D, ss_p_m, ss_p_m);}
			if (te.up) {ModelT.addBox(ss_p_p, ss_p_p, ss_p_m, ss_p_m, ss_p_m, 0.0D);}
		}

		//addBox(1.0D, 1.0D, 1.0D, 0.5D, 0.5D, 0.5D);
		//-------------------------------------------------------------------
		//-------------------------------------------------------------------
		/*
		tessellator.startDrawingQuads();
		tessellator.setColorOpaque_I(clr);

		//Up
		tessellator.addVertexWithUV(1.0D, 1.0D, 0.0D, 1.0D, 0.0D);
		tessellator.addVertexWithUV(0.0D, 1.0D, 0.0D, 0.0D, 0.0D);
		tessellator.addVertexWithUV(0.0D, 1.0D, 1.0D, 0.0D, 1.0D);
		tessellator.addVertexWithUV(1.0D, 1.0D, 1.0D, 1.0D, 1.0D);
		//Down
		tessellator.addVertexWithUV(1.0D, 0.0D, 1.0D, 1.0D, 1.0D);
		tessellator.addVertexWithUV(0.0D, 0.0D, 1.0D, 0.0D, 1.0D);
		tessellator.addVertexWithUV(0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
		tessellator.addVertexWithUV(1.0D, 0.0D, 0.0D, 1.0D, 0.0D);
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
		 */

		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glPopMatrix();
		//--------------------------------------------------
	}

}
