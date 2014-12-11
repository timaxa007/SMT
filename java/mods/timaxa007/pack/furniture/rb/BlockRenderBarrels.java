package mods.timaxa007.pack.furniture.rb;

import mods.timaxa007.lib.TileTexture;
import mods.timaxa007.pack.furniture.te.TEBarrels;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class BlockRenderBarrels extends TileEntitySpecialRenderer{
private IModelCustom mdlB;
private IModelCustom mdlP;
private IModelCustom mdlCD;

public BlockRenderBarrels() {
mdlB=AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/barrel_cone.obj"));
mdlP=AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/barrel_top.obj"));
mdlCD=AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/barrel_cap_down.obj"));
}

public void renderTileEntityAt(TileEntity tileEntity, double d1, double d2, double d3, float f) {
this.renderTE((TEBarrels)tileEntity, d1, d2, d3, f);
}

public void renderTE(TEBarrels tileEntity, double d1, double d2, double d3, float f) {
//int meta=tileEntity.getBlockMetadata();
//int rot=tileEntity.getRotation();
int texB=tileEntity.getTypeB();
int texP=tileEntity.getTypeP();
int texCD=tileEntity.getTypeCD();
boolean lie=tileEntity.getLie();
int rot=2;

GL11.glPushMatrix();
if(lie) {
GL11.glTranslatef((float)d1+0.5F, (float)d2+0.5F, (float)d3+1.0F);
GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
}else{
GL11.glTranslatef((float)d1+0.5F, (float)d2, (float)d3+0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
}
GL11.glRotatef(-180F+((float)((4-rot)*90F)), 0.0F, 0.0F, 1.0F);
this.bindTexture(new ResourceLocation("timaxa007", TileTexture.tt));
mdlB.renderAll();
GL11.glPopMatrix();

if(texP>0) {
GL11.glPushMatrix();
if(lie) {
GL11.glTranslatef((float)d1+0.5F, (float)d2+0.5F, (float)d3+(1.0F-0.9375F));
GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
}else{
GL11.glTranslatef((float)d1+0.5F, (float)d2+0.9375F, (float)d3+0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
}
GL11.glRotatef(-180F+((float)((4-rot)*90F)), 0.0F, 0.0F, 1.0F);
this.bindTexture(new ResourceLocation("timaxa007", TileTexture.tt));
mdlP.renderAll();
GL11.glPopMatrix();
}

GL11.glPushMatrix();
if(lie) {
GL11.glTranslatef((float)d1+0.5F, (float)d2+0.5F, (float)d3+1.0F);
GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
}else{
GL11.glTranslatef((float)d1+0.5F, (float)d2, (float)d3+0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
}
GL11.glRotatef(-180F+((float)((4-rot)*90F)), 0.0F, 0.0F, 1.0F);
this.bindTexture(new ResourceLocation("timaxa007", TileTexture.tt));
mdlCD.renderAll();
GL11.glPopMatrix();

}

}
