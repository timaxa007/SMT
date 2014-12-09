package mods.timaxa007.Pack.Furniture.RenderBlocks;

import mods.timaxa007.Lib.TileTexture;
import mods.timaxa007.Pack.Furniture.TE.TEAngleMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class BlockRenderAngleMod extends TileEntitySpecialRenderer{
private IModelCustom mdl0_1;
private IModelCustom mdl1_l;
private IModelCustom mdl1_r;
private IModelCustom mdl1_1;
private IModelCustom mdlS;
private IModelCustom mdlT;
private IModelCustom mdlB;

public BlockRenderAngleMod() {
mdl0_1=AdvancedModelLoader.loadModel("/assets/timaxa007/obj/triangle01_1.obj");

mdl1_l=AdvancedModelLoader.loadModel("/assets/timaxa007/obj/triangle_left.obj");
mdl1_r=AdvancedModelLoader.loadModel("/assets/timaxa007/obj/triangle_right.obj");

mdl1_1=AdvancedModelLoader.loadModel("/assets/timaxa007/obj/angle_side.obj");

mdlS=AdvancedModelLoader.loadModel("/assets/timaxa007/obj/square_side.obj");

mdlT=AdvancedModelLoader.loadModel("/assets/timaxa007/obj/square_top.obj");
mdlB=AdvancedModelLoader.loadModel("/assets/timaxa007/obj/square_bottom.obj");
}

public void renderTileEntityAt(TileEntity tileEntity, double d1, double d2, double d3, float f) {
this.renderTE((TEAngleMod)tileEntity, d1, d2, d3, f);
}

public void renderTE(TEAngleMod tileEntity, double d1, double d2, double d3, float f) {
//int meta=tileEntity.getBlockMetadata();
int tex=tileEntity.getType();
int mdl=tileEntity.getSize();
int rot=tileEntity.getRotation();
boolean uper=tileEntity.getUPing();
//--------------------------------
GL11.glPushMatrix();
GL11.glTranslatef((float)d1+0.5F, (float)d2, (float)d3+0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
GL11.glRotatef(-180F+((float)((4-rot)*90F)), 0.0F, 0.0F, 1.0F);
this.bindTexture(new ResourceLocation("timaxa007", TileTexture.tt));
mdl1_l.renderAll();
GL11.glPopMatrix();
//--------------------------------
GL11.glPushMatrix();
GL11.glTranslatef((float)d1+0.5F, (float)d2, (float)d3+0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
GL11.glRotatef(-180F+((float)((4-rot)*90F)), 0.0F, 0.0F, 1.0F);
this.bindTexture(new ResourceLocation("timaxa007", TileTexture.tt));
mdl1_r.renderAll();
GL11.glPopMatrix();
//--------------------------------
GL11.glPushMatrix();
GL11.glTranslatef((float)d1+0.5F, (float)d2, (float)d3+0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
GL11.glRotatef(-180F+((float)((4-rot)*90F)), 0.0F, 0.0F, 1.0F);
this.bindTexture(new ResourceLocation("timaxa007", TileTexture.tt));
mdl1_1.renderAll();
GL11.glPopMatrix();
//--------------------------------
GL11.glPushMatrix();
GL11.glTranslatef((float)d1+0.5F, (float)d2, (float)d3+0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
GL11.glRotatef(0F+((float)((4-rot)*90F)), 0.0F, 0.0F, 1.0F);
this.bindTexture(new ResourceLocation("timaxa007", TileTexture.tt));
mdlS.renderAll();
GL11.glPopMatrix();
//--------------------------------
GL11.glPushMatrix();
GL11.glTranslatef((float)d1+0.5F, (float)d2, (float)d3+0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
//GL11.glRotatef(-180F+((float)((4-rot)*90F)), 0.0F, 0.0F, 1.0F);
this.bindTexture(new ResourceLocation("timaxa007", TileTexture.tt));
if(!uper) {mdlB.renderAll();}else{mdlT.renderAll();}
GL11.glPopMatrix();
//--------------------------------

}

}
