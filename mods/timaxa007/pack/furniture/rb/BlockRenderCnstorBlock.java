package mods.timaxa007.pack.furniture.rb;

import mods.timaxa007.lib.TileTexture;
import mods.timaxa007.pack.furniture.te.TECnstorBlock;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class BlockRenderCnstorBlock extends TileEntitySpecialRenderer {

public BlockRenderCnstorBlock() {

}

public void renderTileEntityAt(TileEntity tileEntity, double dx, double dy, double dz, float f) {
renderTE((TECnstorBlock)tileEntity, dx, dy, dz, f);
}

private void renderTE(TECnstorBlock te, double dx, double dy, double dz, float f) {
//int meta = tileEntity.getBlockMetadata();
int tex = 0;
int clr = 0xFFFFFF;

if (te != null) {
tex = te.getType();
clr = te.getColor();
}
/*
float red = (float)(clr >> 16 & 255) / 255;
float green = (float)(clr >> 8 & 255) / 255;
float blue = (float)(clr & 255) / 255;
float alfa = 1.0F;
*/
//GL11.glColor4f(red , green , blue, alfa);

GL11.glPushMatrix();
GL11.glEnable(GL11.GL_BLEND);
GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
GL11.glShadeModel(GL11.GL_SMOOTH);

//GL11.glDisable(GL11.GL_CULL_FACE);

GL11.glDisable(GL11.GL_LIGHTING);
GL11.glTranslated(dx, dy, dz);
bindTexture(new ResourceLocation((String)TileTexture.texTest01[tex][0], (String)TileTexture.texTest01[tex][1]));

Tessellator tessellator = Tessellator.instance;
tessellator.startDrawingQuads();
tessellator.setColorOpaque_I(clr);

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

//GL11.glEnable(GL11.GL_CULL_FACE);

GL11.glEnable(GL11.GL_LIGHTING);
GL11.glDisable(GL11.GL_BLEND);
GL11.glPopMatrix();

//--------------------------------

}

}
