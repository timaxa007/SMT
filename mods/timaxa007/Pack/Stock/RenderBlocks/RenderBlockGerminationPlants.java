package mods.timaxa007.Pack.Stock.RenderBlocks;

import org.lwjgl.opengl.GL11;

import mods.timaxa007.Lib.ModelT;
import mods.timaxa007.Pack.Stock.Lib.GerminationPlants;
import mods.timaxa007.Pack.Stock.TE.TEGerminationPlants;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderBlockGerminationPlants extends TileEntitySpecialRenderer {

@Override
public void renderTileEntityAt(TileEntity te, double dx, double dy, double dz, float f) {
renderTE((TEGerminationPlants)te, dx, dy, dz, f);
}

private void renderTE(TEGerminationPlants te, double dx, double dy, double dz, float f) {
int plant_id = 0;
String plant_type = "";
int width = 0;
int height = 0;

double slc = (double)1/16;

if (te != null) {
plant_id = te.getPlantID();
plant_type = te.getPlantType();
width = te.getWidth();
height = te.getHeight();
}

//------------------------------------------------------------------------------------------------------
GL11.glPushMatrix();
GL11.glDisable(GL11.GL_LIGHTING);
GL11.glTranslated(dx, dy, dz);
GL11.glRotatef(-90.0F, 1, 0, 0);
GL11.glTranslatef(0.0F, -1.0F, 0.0F - (float)slc);
bindTexture(new ResourceLocation("textures/blocks/planks_oak.png"));
ModelT.addBox(1.0D - (slc * 11) - 0.01D, 1.0D - (slc * 4) - 0.01D, 1.0D, 0.0D + (slc * 4) + 0.01D, 0.0D + (slc * 11) + 0.01D, 0.0D);
ModelT.addBox(1.0D - (slc * 4) - 0.01D, 1.0D - (slc * 4) - 0.01D, 1.0D, 0.0D + (slc * 11) + 0.01D, 0.0D + (slc * 11) + 0.01D, 0.0D);
ModelT.addBox(1.0D - (slc * 11) - 0.01D, 1.0D - (slc * 11) - 0.01D, 1.0D, 0.0D + (slc * 4) + 0.01D, 0.0D + (slc * 4) + 0.01D, 0.0D);
ModelT.addBox(1.0D - (slc * 4) - 0.01D, 1.0D - (slc * 11) - 0.01D, 1.0D, 0.0D + (slc * 11) + 0.01D, 0.0D + (slc * 4) + 0.01D, 0.0D);
GL11.glEnable(GL11.GL_LIGHTING);
GL11.glPopMatrix();
//------------------------------------------------------------------------------------------------------
if (GerminationPlants.plant_list[plant_id].getType() == "Crop" || GerminationPlants.plant_list[plant_id].getType() == "Mushroom") {
GL11.glPushMatrix();
GL11.glEnable(GL11.GL_BLEND);
GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
GL11.glDisable(GL11.GL_LIGHTING);
GL11.glTranslated(dx, dy, dz);/*
GL11.glRotatef(-90.0F, 1, 0, 0);
GL11.glTranslatef(0.0F, -1.0F, 0.0F);*/
if (plant_id != 0) {
bindTexture(new ResourceLocation("timaxa007", 
"textures/blocks/germination/" + 
plant_type.toLowerCase() + "/" + 
GerminationPlants.plant_list[plant_id].getTexture().toLowerCase() + "_" + height + ".png"));
} else {
bindTexture(new ResourceLocation("timaxa007", "textures/blocks/germination/0.png"));
}
Tessellator tessellator = Tessellator.instance;
tessellator.startDrawingQuads();
/*
//Up
tessellator.addVertexWithUV(1.0D, 0.5D, 0.0D, 1.0D, 0.0D);
tessellator.addVertexWithUV(0.0D, 0.5D, 0.0D, 0.0D, 0.0D);
tessellator.addVertexWithUV(0.0D, 0.5D, 1.0D, 0.0D, 1.0D);
tessellator.addVertexWithUV(1.0D, 0.5D, 1.0D, 1.0D, 1.0D);
//Down
tessellator.addVertexWithUV(1.0D, 0.5D, 1.0D, 1.0D, 1.0D);
tessellator.addVertexWithUV(0.0D, 0.5D, 1.0D, 0.0D, 1.0D);
tessellator.addVertexWithUV(0.0D, 0.5D, 0.0D, 0.0D, 0.0D);
tessellator.addVertexWithUV(1.0D, 0.5D, 0.0D, 1.0D, 0.0D);
*/
//-----
tessellator.addVertexWithUV(1.0D, 0.0D, 0.0D + (slc * 4), 0.0D, 1.0D);
tessellator.addVertexWithUV(0.0D, 0.0D, 0.0D + (slc * 4), 1.0D, 1.0D);
tessellator.addVertexWithUV(0.0D, 1.0D, 0.0D + (slc * 4), 1.0D, 0.0D);
tessellator.addVertexWithUV(1.0D, 1.0D, 0.0D + (slc * 4), 0.0D, 0.0D);

tessellator.addVertexWithUV(1.0D, 1.0D, 0.0D + (slc * 4), 1.0D, 0.0D);
tessellator.addVertexWithUV(0.0D, 1.0D, 0.0D + (slc * 4), 0.0D, 0.0D);
tessellator.addVertexWithUV(0.0D, 0.0D, 0.0D + (slc * 4), 0.0D, 1.0D);
tessellator.addVertexWithUV(1.0D, 0.0D, 0.0D + (slc * 4), 1.0D, 1.0D);
//---
tessellator.addVertexWithUV(1.0D, 0.0D, 1.0D - (slc * 4), 0.0D, 1.0D);
tessellator.addVertexWithUV(0.0D, 0.0D, 1.0D - (slc * 4), 1.0D, 1.0D);
tessellator.addVertexWithUV(0.0D, 1.0D, 1.0D - (slc * 4), 1.0D, 0.0D);
tessellator.addVertexWithUV(1.0D, 1.0D, 1.0D - (slc * 4), 0.0D, 0.0D);

tessellator.addVertexWithUV(1.0D, 1.0D, 1.0D - (slc * 4), 1.0D, 0.0D);
tessellator.addVertexWithUV(0.0D, 1.0D, 1.0D - (slc * 4), 0.0D, 0.0D);
tessellator.addVertexWithUV(0.0D, 0.0D, 1.0D - (slc * 4), 0.0D, 1.0D);
tessellator.addVertexWithUV(1.0D, 0.0D, 1.0D - (slc * 4), 1.0D, 1.0D);
//-----
tessellator.addVertexWithUV(0.0D + (slc * 4), 1.0D, 1.0D, 1.0D, 0.0D);
tessellator.addVertexWithUV(0.0D + (slc * 4), 1.0D, 0.0D, 0.0D, 0.0D);
tessellator.addVertexWithUV(0.0D + (slc * 4), 0.0D, 0.0D, 0.0D, 1.0D);
tessellator.addVertexWithUV(0.0D + (slc * 4), 0.0D, 1.0D, 1.0D, 1.0D);

tessellator.addVertexWithUV(0.0D + (slc * 4), 0.0D, 1.0D, 0.0D, 1.0D);
tessellator.addVertexWithUV(0.0D + (slc * 4), 0.0D, 0.0D, 1.0D, 1.0D);
tessellator.addVertexWithUV(0.0D + (slc * 4), 1.0D, 0.0D, 1.0D, 0.0D);
tessellator.addVertexWithUV(0.0D + (slc * 4), 1.0D, 1.0D, 0.0D, 0.0D);
//---
tessellator.addVertexWithUV(1.0D - (slc * 4), 1.0D, 1.0D, 1.0D, 0.0D);
tessellator.addVertexWithUV(1.0D - (slc * 4), 1.0D, 0.0D, 0.0D, 0.0D);
tessellator.addVertexWithUV(1.0D - (slc * 4), 0.0D, 0.0D, 0.0D, 1.0D);
tessellator.addVertexWithUV(1.0D - (slc * 4), 0.0D, 1.0D, 1.0D, 1.0D);

tessellator.addVertexWithUV(1.0D - (slc * 4), 0.0D, 1.0D, 0.0D, 1.0D);
tessellator.addVertexWithUV(1.0D - (slc * 4), 0.0D, 0.0D, 1.0D, 1.0D);
tessellator.addVertexWithUV(1.0D - (slc * 4), 1.0D, 0.0D, 1.0D, 0.0D);
tessellator.addVertexWithUV(1.0D - (slc * 4), 1.0D, 1.0D, 0.0D, 0.0D);

tessellator.draw();

GL11.glEnable(GL11.GL_LIGHTING);
GL11.glDisable(GL11.GL_BLEND);
GL11.glPopMatrix();
}
//------------------------------------------------------------------------------------------------------
if (GerminationPlants.plant_list[plant_id].getType() == "Tree") {

GL11.glPushMatrix();
GL11.glEnable(GL11.GL_BLEND);
GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
GL11.glDisable(GL11.GL_LIGHTING);
GL11.glTranslated(dx, dy, dz);

//if (stk) {GL11.glRotatef(-90.0F, 1, 0, 0);}

bindTexture(new ResourceLocation("timaxa007", "textures/blocks/log_" + GerminationPlants.plant_list[plant_id].getTexture()));

double pr = 0.0625D;
double prr = (double)pr * width;
double prt1 = 0.5D + prr;
double prt2 = 0.5D - prr;
double het = 0.0D + (double)pr * height;

Tessellator tessellator = Tessellator.instance;
tessellator.startDrawingQuads();
//tessellator.setColorOpaque_I(clr);

//Down
tessellator.addVertexWithUV(prt1, 0.0D, prt1, prt1, prt1);
tessellator.addVertexWithUV(prt2, 0.0D, prt1, prt2, prt1);
tessellator.addVertexWithUV(prt2, 0.0D, prt2, prt2, prt2);
tessellator.addVertexWithUV(prt1, 0.0D, prt2, prt1, prt2);
//Up
tessellator.addVertexWithUV(prt1, het, prt2, prt1, prt2);
tessellator.addVertexWithUV(prt2, het, prt2, prt2, prt2);
tessellator.addVertexWithUV(prt2, het, prt1, prt2, prt1);
tessellator.addVertexWithUV(prt1, het, prt1, prt1, prt1);
//North
tessellator.addVertexWithUV(prt1, 0.0D, prt2, prt2, het);
tessellator.addVertexWithUV(prt2, 0.0D, prt2, prt1, het);
tessellator.addVertexWithUV(prt2, het, prt2, prt1, 0.0D);
tessellator.addVertexWithUV(prt1, het, prt2, prt2, 0.0D);
//South
tessellator.addVertexWithUV(prt1, het, prt1, prt1, 0.0D);
tessellator.addVertexWithUV(prt2, het, prt1, prt2, 0.0D);
tessellator.addVertexWithUV(prt2, 0.0D, prt1, prt2, het);
tessellator.addVertexWithUV(prt1, 0.0D, prt1, prt1, het);
//West
tessellator.addVertexWithUV(prt2, het, prt1, prt1, 0.0D);
tessellator.addVertexWithUV(prt2, het, prt2, prt2, 0.0D);
tessellator.addVertexWithUV(prt2, 0.0D, prt2, prt2, het);
tessellator.addVertexWithUV(prt2, 0.0D, prt1, prt1, het);
//East
tessellator.addVertexWithUV(prt1, 0.0D, prt1, prt2, het);
tessellator.addVertexWithUV(prt1, 0.0D, prt2, prt1, het);
tessellator.addVertexWithUV(prt1, het, prt2, prt1, 0.0D);
tessellator.addVertexWithUV(prt1, het, prt1, prt2, 0.0D);

tessellator.draw();

GL11.glEnable(GL11.GL_LIGHTING);
GL11.glDisable(GL11.GL_BLEND);
GL11.glPopMatrix();
}
//------------------------------------------------------------------------------------------------------
}

}
