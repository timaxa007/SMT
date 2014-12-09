package mods.timaxa007.pack.furniture.rb;

import mods.timaxa007.lib.TileTexture;
import mods.timaxa007.pack.furniture.te.TEChair;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class BlockRenderChair extends TileEntitySpecialRenderer{
private IModelCustom mdlS;
private IModelCustom mdlT;
private IModelCustom mdlB;

public BlockRenderChair() {
mdlS=AdvancedModelLoader.loadModel("/assets/timaxa007/obj/square_side.obj");
mdlT=AdvancedModelLoader.loadModel("/assets/timaxa007/obj/square_top.obj");
mdlB=AdvancedModelLoader.loadModel("/assets/timaxa007/obj/square_bottom.obj");
}

public void renderTileEntityAt(TileEntity tileEntity, double d1, double d2, double d3, float f) {
this.renderTE((TEChair)tileEntity, d1, d2, d3, f);
}

public void renderTE(TEChair tileEntity, double d1, double d2, double d3, float f) {
//int meta=tileEntity.getBlockMetadata();
int tex=tileEntity.getType();
//int rot=tileEntity.getRotation();
int rot=2;

//front
GL11.glPushMatrix();
GL11.glTranslatef((float)d1+0.5F, (float)d2, (float)d3+0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
GL11.glRotatef(-180F+((float)((4-rot)*90F)), 0.0F, 0.0F, 1.0F);
this.bindTexture(new ResourceLocation("timaxa007", TileTexture.tt));
mdlS.renderAll();
GL11.glPopMatrix();
//right
GL11.glPushMatrix();
GL11.glTranslatef((float)d1+0.5F, (float)d2, (float)d3+0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
GL11.glRotatef(-90F+((float)((4-rot)*90F)), 0.0F, 0.0F, 1.0F);
this.bindTexture(new ResourceLocation("timaxa007", TileTexture.tt));
mdlS.renderAll();
GL11.glPopMatrix();
//back
GL11.glPushMatrix();
GL11.glTranslatef((float)d1+0.5F, (float)d2, (float)d3+0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
GL11.glRotatef(0F+((float)((4-rot)*90F)), 0.0F, 0.0F, 1.0F);
this.bindTexture(new ResourceLocation("timaxa007", TileTexture.tt));
mdlS.renderAll();
GL11.glPopMatrix();
//left
GL11.glPushMatrix();
GL11.glTranslatef((float)d1+0.5F, (float)d2, (float)d3+0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
GL11.glRotatef(90F+((float)((4-rot)*90F)), 0.0F, 0.0F, 1.0F);
this.bindTexture(new ResourceLocation("timaxa007", TileTexture.tt));
mdlS.renderAll();
GL11.glPopMatrix();
//top
GL11.glPushMatrix();
GL11.glTranslatef((float)d1+0.5F, (float)d2, (float)d3+0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
GL11.glRotatef(-180F+((float)((4-rot)*90F)), 0.0F, 0.0F, 1.0F);
this.bindTexture(new ResourceLocation("timaxa007", TileTexture.tt));
mdlT.renderAll();
GL11.glPopMatrix();
//bottom
GL11.glPushMatrix();
GL11.glTranslatef((float)d1+0.5F, (float)d2, (float)d3+0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
GL11.glRotatef(-180F+((float)((4-rot)*90F)), 0.0F, 0.0F, 1.0F);
this.bindTexture(new ResourceLocation("timaxa007", TileTexture.tt));
mdlB.renderAll();
GL11.glPopMatrix();

}

}
