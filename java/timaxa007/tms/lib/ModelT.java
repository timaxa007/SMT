package timaxa007.tms.lib;

import net.minecraft.client.renderer.Tessellator;

public class ModelT {

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

	public static void addBox1(double a_x, double a_y, double a_z, double b_x, double b_y, double b_z) {
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		//tessellator.setColorOpaque_I(clr);

		//Up
		tessellator.addVertexWithUV(b_x, b_y, a_z, b_x, a_z);
		tessellator.addVertexWithUV(a_x, b_y, a_z, a_x, a_z);
		tessellator.addVertexWithUV(a_x, b_y, b_z, a_x, b_z);
		tessellator.addVertexWithUV(b_x, b_y, b_z, b_x, b_z);
		//Down
		tessellator.addVertexWithUV(b_x, a_y, b_z, b_x, b_z);
		tessellator.addVertexWithUV(a_x, a_y, b_z, a_x, b_z);
		tessellator.addVertexWithUV(a_x, a_y, a_z, a_x, a_z);
		tessellator.addVertexWithUV(b_x, a_y, a_z, b_x, a_z);
		//North
		tessellator.addVertexWithUV(b_x, a_y, a_z, b_x, 1.0D - a_y);
		tessellator.addVertexWithUV(a_x, a_y, a_z, a_x, 1.0D - a_y);
		tessellator.addVertexWithUV(a_x, b_y, a_z, a_x, 0.0D + b_y);
		tessellator.addVertexWithUV(b_x, b_y, a_z, b_x, 0.0D + b_y);
		//South
		tessellator.addVertexWithUV(b_x, b_y, b_z, b_x, 0.0D + b_y);
		tessellator.addVertexWithUV(a_x, b_y, b_z, a_x, 0.0D + b_y);
		tessellator.addVertexWithUV(a_x, a_y, b_z, a_x, 1.0D - a_y);
		tessellator.addVertexWithUV(b_x, a_y, b_z, b_x, 1.0D - a_y);
		//West
		tessellator.addVertexWithUV(a_x, b_y, b_z, b_z, 0.0D + b_y);
		tessellator.addVertexWithUV(a_x, b_y, a_z, a_z, 0.0D + b_y);
		tessellator.addVertexWithUV(a_x, a_y, a_z, a_z, 1.0D - a_y);
		tessellator.addVertexWithUV(a_x, a_y, b_z, b_z, 1.0D - a_y);
		//East
		tessellator.addVertexWithUV(b_x, a_y, b_z, b_z, 1.0D - a_y);
		tessellator.addVertexWithUV(b_x, a_y, a_z, a_z, 1.0D - a_y);
		tessellator.addVertexWithUV(b_x, b_y, a_z, a_z, 0.0D + b_y);
		tessellator.addVertexWithUV(b_x, b_y, b_z, b_z, 0.0D + b_y);

		tessellator.draw();
	}

}
