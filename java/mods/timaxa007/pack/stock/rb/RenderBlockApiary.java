package mods.timaxa007.pack.stock.rb;

import org.lwjgl.opengl.GL11;

import mods.timaxa007.lib.TileTexture;
import mods.timaxa007.pack.stock.te.TEApiary;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderBlockApiary extends TileEntitySpecialRenderer {

public RenderBlockApiary() {

}

@Override
public void renderTileEntityAt(TileEntity te, double dx, double dy, double dz, float f) {
renderTE((TEApiary)te, dx, dy, dz, f);
}

private void renderTE(TEApiary te, double dx, double dy, double dz, float f) {

//int meta = tileEntity.getBlockMetadata();
int tex = 0;
String name = "";
int clr = 0xFFFFFF;

if (te != null) {
tex = te.getType();
name = te.getName();
//clr = te.getColor();
}

double s_p = (double) 1 / 16;
int i_x = 4;
int i_y = 4;
double s_x = (double)(1.0D / i_x);
double s_y = (double)(1.0D / i_y);

GL11.glPushMatrix();
GL11.glEnable(GL11.GL_BLEND);
GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
GL11.glDisable(GL11.GL_LIGHTING);
GL11.glTranslated(dx, dy, dz);

//bindTexture(new ResourceLocation((String)TileTexture.texTest01[tex][0], (String)TileTexture.texTest01[tex][1]));
bindTexture(new ResourceLocation("timaxa007", "textures/obj/apiary.png"));
renderApiary(s_x, s_y);

GL11.glEnable(GL11.GL_LIGHTING);
GL11.glDisable(GL11.GL_BLEND);
GL11.glPopMatrix();
//--------------------------------------------------
}

public static void renderApiary(double s_x, double s_y) {
Tessellator tessellator = Tessellator.instance;
tessellator.startDrawingQuads();
//tessellator.setColorOpaque_I(clr);

//Up
tessellator.addVertexWithUV(1.0D, 1.0D, 0.0D, 3 * s_x, 1 * s_y);
tessellator.addVertexWithUV(0.0D, 1.0D, 0.0D, 4 * s_x, 1 * s_y);
tessellator.addVertexWithUV(0.0D, 1.0D, 1.0D, 4 * s_x, 0 * s_y);
tessellator.addVertexWithUV(1.0D, 1.0D, 1.0D, 3 * s_x, 0 * s_y);
//Down
tessellator.addVertexWithUV(1.0D, 0.0D, 1.0D, 3 * s_x, 2 * s_y);
tessellator.addVertexWithUV(0.0D, 0.0D, 1.0D, 4 * s_x, 2 * s_y);
tessellator.addVertexWithUV(0.0D, 0.0D, 0.0D, 4 * s_x, 1 * s_y);
tessellator.addVertexWithUV(1.0D, 0.0D, 0.0D, 3 * s_x, 1 * s_y);
//North
tessellator.addVertexWithUV(1.0D, 0.0D, 0.0D, 1 * s_x, 2 * s_y);
tessellator.addVertexWithUV(0.0D, 0.0D, 0.0D, 2 * s_x, 2 * s_y);
tessellator.addVertexWithUV(0.0D, 1.0D, 0.0D, 2 * s_x, 1 * s_y);
tessellator.addVertexWithUV(1.0D, 1.0D, 0.0D, 1 * s_x, 1 * s_y);
//South
tessellator.addVertexWithUV(1.0D, 1.0D, 1.0D, 2 * s_x, 1 * s_y);
tessellator.addVertexWithUV(0.0D, 1.0D, 1.0D, 1 * s_x, 1 * s_y);
tessellator.addVertexWithUV(0.0D, 0.0D, 1.0D, 1 * s_x, 2 * s_y);
tessellator.addVertexWithUV(1.0D, 0.0D, 1.0D, 2 * s_x, 2 * s_y);
//West
tessellator.addVertexWithUV(0.0D, 1.0D, 1.0D, 2 * s_x, 1 * s_y);
tessellator.addVertexWithUV(0.0D, 1.0D, 0.0D, 1 * s_x, 1 * s_y);
tessellator.addVertexWithUV(0.0D, 0.0D, 0.0D, 1 * s_x, 2 * s_y);
tessellator.addVertexWithUV(0.0D, 0.0D, 1.0D, 2 * s_x, 2 * s_y);
//East
tessellator.addVertexWithUV(1.0D, 0.0D, 1.0D, 1 * s_x, 2 * s_y);
tessellator.addVertexWithUV(1.0D, 0.0D, 0.0D, 2 * s_x, 2 * s_y);
tessellator.addVertexWithUV(1.0D, 1.0D, 0.0D, 2 * s_x, 1 * s_y);
tessellator.addVertexWithUV(1.0D, 1.0D, 1.0D, 1 * s_x, 1 * s_y);

tessellator.draw();

}

}
