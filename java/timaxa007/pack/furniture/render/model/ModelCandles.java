package timaxa007.pack.furniture.render.model;

import net.minecraft.client.renderer.Tessellator;

public class ModelCandles {

	public static void addSliceCake(Tessellator t, double x,  double y,  double z, int h, int w) {

		double p = 0.0625D;
		double dh = (p * (double)w) / 2.0D;

		//Up
		t.startDrawingQuads();
		t.addVertexWithUV(0.5D - dh, (double)p * h, 0.5D + dh, 0.0D + (dh * 2), 0.0D);//forwad-right
		t.addVertexWithUV(0.5D + dh, (double)p * h, 0.5D + dh, 0.0D, 0.0D);//forwad-left
		t.addVertexWithUV(0.5D + dh, (double)p * h, 0.5D - dh, 0.0D, 0.0D + (dh * 2));//back-left
		t.addVertexWithUV(0.5D - dh, (double)p * h, 0.5D - dh, 0.0D + (dh * 2), 0.0D + (dh * 2));//back-right
		t.draw();

		//Down
		t.startDrawingQuads();
		t.addVertexWithUV(0.5D + dh, 0.0D, 0.5D + dh, 1.0D, 1.0D);//forwad-left
		t.addVertexWithUV(0.5D - dh, 0.0D, 0.5D + dh, 0.0D, 1.0D);//forwad-right
		t.addVertexWithUV(0.5D - dh, 0.0D, 0.5D - dh, 0.0D, 0.0D);//back-right
		t.addVertexWithUV(0.5D + dh, 0.0D, 0.5D - dh, 1.0D, 0.0D);//back-left
		t.draw();

	}

}
