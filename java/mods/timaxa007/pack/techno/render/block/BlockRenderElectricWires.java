package mods.timaxa007.pack.techno.render.block;

import mods.timaxa007.pack.techno.tile.TileEntityElectricWires;
import mods.timaxa007.tms.lib.AddTextureModel;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

public class BlockRenderElectricWires extends TileEntitySpecialRenderer {

	@Override
	public void renderTileEntityAt(TileEntity te, double dx, double dy, double dz, float f) {
		renderTileEntity((TileEntityElectricWires)te, dx, dy, dz, f);
	}

	private void renderTileEntity(TileEntityElectricWires te, double dx, double dy, double dz, float f) {
		//int meta = te.getBlockMetadata();
		//int tex = 0;
		String tex = null;
		int siz = 1;
		int clr = 0xFFFFFF;

		if (te != null) {
			//tex = te.getType();
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
		addBox(ss_p_p, ss_p_p, ss_p_p, ss_p_m, ss_p_m, ss_p_m);
		if (te != null) {
			/*
			if (te.up) {addBox(ss_p_p, 1.0D, ss_p_p, ss_p_m, ss_p_p, ss_p_m);}
			if (te.down) {addBox(ss_p_p, ss_p_m, ss_p_p, ss_p_m, 0.0D, ss_p_m);}
			if (te.north) {addBox(1.0D, ss_p_p, ss_p_p, ss_p_p, ss_p_m, ss_p_m);}
			if (te.south) {addBox(ss_p_p, ss_p_p, 1.0D, ss_p_m, ss_p_m, ss_p_p);}
			if (te.west) {addBox(ss_p_m, ss_p_p, ss_p_p, 0.0D, ss_p_m, ss_p_m);}
			if (te.east) {addBox(ss_p_p, ss_p_p, ss_p_m, ss_p_m, ss_p_m, 0.0D);}
			 */
			if (te.west) {addBox(ss_p_p, 1.0D, ss_p_p, ss_p_m, ss_p_p, ss_p_m);}
			if (te.east) {addBox(ss_p_p, ss_p_m, ss_p_p, ss_p_m, 0.0D, ss_p_m);}
			if (te.north) {addBox(1.0D, ss_p_p, ss_p_p, ss_p_p, ss_p_m, ss_p_m);}
			if (te.down) {addBox(ss_p_p, ss_p_p, 1.0D, ss_p_m, ss_p_m, ss_p_p);}
			if (te.south) {addBox(ss_p_m, ss_p_p, ss_p_p, 0.0D, ss_p_m, ss_p_m);}
			if (te.up) {addBox(ss_p_p, ss_p_p, ss_p_m, ss_p_m, ss_p_m, 0.0D);}
		}

		//addBox(1.0D, 1.0D, 1.0D, 0.5D, 0.5D, 0.5D);
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

	public static void addBox(double a_x, double a_y, double a_z, double b_x, double b_y, double b_z) {
		Tessellator tessellator = Tessellator.instance;

		tessellator.startDrawingQuads();
		//tessellator.setColorOpaque_I(clr);

		//Up
		tessellator.addVertexWithUV(a_x, a_y, b_z, a_x, b_z);
		tessellator.addVertexWithUV(b_x, a_y, b_z, b_x, b_z);
		tessellator.addVertexWithUV(b_x, a_y, a_z, b_x, a_z);
		tessellator.addVertexWithUV(a_x, a_y, a_z, a_x, a_z);
		//Down
		tessellator.addVertexWithUV(a_x, b_y, a_z, a_x, a_z);
		tessellator.addVertexWithUV(b_x, b_y, a_z, b_x, a_z);
		tessellator.addVertexWithUV(b_x, b_y, b_z, b_x, b_z);
		tessellator.addVertexWithUV(a_x, b_y, b_z, a_x, b_z);
		//North
		tessellator.addVertexWithUV(a_x, b_y, b_z, a_x, b_y);
		tessellator.addVertexWithUV(b_x, b_y, b_z, b_x, b_y);
		tessellator.addVertexWithUV(b_x, a_y, b_z, b_x, a_y);
		tessellator.addVertexWithUV(a_x, a_y, b_z, a_x, a_y);
		//South
		tessellator.addVertexWithUV(a_x, a_y, a_z, a_x, a_y);
		tessellator.addVertexWithUV(b_x, a_y, a_z, b_x, a_y);
		tessellator.addVertexWithUV(b_x, b_y, a_z, b_x, b_y);
		tessellator.addVertexWithUV(a_x, b_y, a_z, a_x, b_y);
		//West
		tessellator.addVertexWithUV(b_x, a_y, a_z, a_y, a_z);
		tessellator.addVertexWithUV(b_x, a_y, b_z, a_y, b_z);
		tessellator.addVertexWithUV(b_x, b_y, b_z, b_y, b_z);
		tessellator.addVertexWithUV(b_x, b_y, a_z, b_y, a_z);
		//East
		tessellator.addVertexWithUV(a_x, b_y, a_z, b_y, a_z);
		tessellator.addVertexWithUV(a_x, b_y, b_z, b_y, b_z);
		tessellator.addVertexWithUV(a_x, a_y, b_z, a_y, b_z);
		tessellator.addVertexWithUV(a_x, a_y, a_z, a_y, a_z);

		tessellator.draw();

	}

}
