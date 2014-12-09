package mods.timaxa007.pack.furniture.rb;

import mods.timaxa007.lib.TileTexture;
import mods.timaxa007.pack.furniture.te.TETable;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class BlockRenderTable extends TileEntitySpecialRenderer{
private IModelCustom mdl1;

public BlockRenderTable() {
mdl1=AdvancedModelLoader.loadModel("/assets/timaxa007/obj/table01.obj");
}

public void renderTileEntityAt(TileEntity tileEntity, double d1, double d2, double d3, float f) {
this.renderTE((TETable)tileEntity, d1, d2, d3, f);
}

public void renderTE(TETable tileEntity, double d1, double d2, double d3, float f) {
//int meta=tileEntity.getBlockMetadata();
int tex=tileEntity.getType();
int tpt=tileEntity.getSize();
int rot=tileEntity.getRotation();
//int rot=2;
boolean tbm=true;

//--------------------------------
GL11.glPushMatrix();
GL11.glTranslated(d1, d2, d3);
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);

GL11.glTranslatef(0.0F, 0.0F, ((float)tpt*0.125F));

switch(rot) {
case 0:GL11.glRotatef(-180F, 0F, 0F, 1F);break;
case 3:GL11.glRotatef(-90F, 0F, 0F, 1F);break;
case 2:GL11.glRotatef(0F, 0F, 0F, 1F);break;
case 1:GL11.glRotatef(90F, 0F, 0F, 1F);break;
default:GL11.glRotatef(0F, 0F, 0F, 1F);break;
}

this.bindTexture(new ResourceLocation(TileTexture.getTexTest01_1(tex), TileTexture.getTexTest01_2(tex)));
mdl1.renderPart("table");
GL11.glPopMatrix();
//--------------------------------
if(tpt==7) {
GL11.glPushMatrix();
GL11.glTranslated(d1, d2, d3);
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);

switch(rot) {
case 0:GL11.glRotatef(-180F, 0F, 0F, 1F);break;
case 3:GL11.glRotatef(-90F, 0F, 0F, 1F);break;
case 2:GL11.glRotatef(0F, 0F, 0F, 1F);break;
case 1:GL11.glRotatef(90F, 0F, 0F, 1F);break;
default:GL11.glRotatef(0F, 0F, 0F, 1F);break;
}

this.bindTexture(new ResourceLocation(TileTexture.getTexTest01_1(tex), TileTexture.getTexTest01_2(tex)));
if(tbm) {
mdl1.renderPart("stickG1_1");
mdl1.renderPart("stickG1_2");
mdl1.renderPart("stickG1_3");
mdl1.renderPart("stickG1_4");
}else{
mdl1.renderPart("stickG0_7");
}
GL11.glPopMatrix();
}
//--------------------------------
if(tpt==6) {
GL11.glPushMatrix();
GL11.glTranslated(d1, d2, d3);
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);

switch(rot) {
case 0:GL11.glRotatef(-180F, 0F, 0F, 1F);break;
case 3:GL11.glRotatef(-90F, 0F, 0F, 1F);break;
case 2:GL11.glRotatef(0F, 0F, 0F, 1F);break;
case 1:GL11.glRotatef(90F, 0F, 0F, 1F);break;
default:GL11.glRotatef(0F, 0F, 0F, 1F);break;
}

this.bindTexture(new ResourceLocation(TileTexture.getTexTest01_1(tex), TileTexture.getTexTest01_2(tex)));
if(tbm) {
mdl1.renderPart("stickG2_1");
mdl1.renderPart("stickG2_2");
mdl1.renderPart("stickG2_3");
mdl1.renderPart("stickG2_4");
}else{
mdl1.renderPart("stickG0_6");
}
GL11.glPopMatrix();
}
//--------------------------------
if(tpt==5) {
GL11.glPushMatrix();
GL11.glTranslated(d1, d2, d3);
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);

switch(rot) {
case 0:GL11.glRotatef(-180F, 0F, 0F, 1F);break;
case 3:GL11.glRotatef(-90F, 0F, 0F, 1F);break;
case 2:GL11.glRotatef(0F, 0F, 0F, 1F);break;
case 1:GL11.glRotatef(90F, 0F, 0F, 1F);break;
default:GL11.glRotatef(0F, 0F, 0F, 1F);break;
}

this.bindTexture(new ResourceLocation(TileTexture.getTexTest01_1(tex), TileTexture.getTexTest01_2(tex)));
if(tbm) {
mdl1.renderPart("stickG3_1");
mdl1.renderPart("stickG3_2");
mdl1.renderPart("stickG3_3");
mdl1.renderPart("stickG3_4");
}else{
mdl1.renderPart("stickG0_5");
}
GL11.glPopMatrix();
}
//--------------------------------
if(tpt==4) {
GL11.glPushMatrix();
GL11.glTranslated(d1, d2, d3);
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);

switch(rot) {
case 0:GL11.glRotatef(-180F, 0F, 0F, 1F);break;
case 3:GL11.glRotatef(-90F, 0F, 0F, 1F);break;
case 2:GL11.glRotatef(0F, 0F, 0F, 1F);break;
case 1:GL11.glRotatef(90F, 0F, 0F, 1F);break;
default:GL11.glRotatef(0F, 0F, 0F, 1F);break;
}

this.bindTexture(new ResourceLocation(TileTexture.getTexTest01_1(tex), TileTexture.getTexTest01_2(tex)));
if(tbm) {
mdl1.renderPart("stickG4_1");
mdl1.renderPart("stickG4_2");
mdl1.renderPart("stickG4_3");
mdl1.renderPart("stickG4_4");
}else{
mdl1.renderPart("stickG0_4");
}
GL11.glPopMatrix();
}
//--------------------------------
if(tpt==3) {
GL11.glPushMatrix();
GL11.glTranslated(d1, d2, d3);
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);

switch(rot) {
case 0:GL11.glRotatef(-180F, 0F, 0F, 1F);break;
case 3:GL11.glRotatef(-90F, 0F, 0F, 1F);break;
case 2:GL11.glRotatef(0F, 0F, 0F, 1F);break;
case 1:GL11.glRotatef(90F, 0F, 0F, 1F);break;
default:GL11.glRotatef(0F, 0F, 0F, 1F);break;
}

this.bindTexture(new ResourceLocation(TileTexture.getTexTest01_1(tex), TileTexture.getTexTest01_2(tex)));
if(tbm) {
mdl1.renderPart("stickG5_1");
mdl1.renderPart("stickG5_2");
mdl1.renderPart("stickG5_3");
mdl1.renderPart("stickG5_4");
}else{
mdl1.renderPart("stickG0_3");
}
GL11.glPopMatrix();
}
//--------------------------------
if(tpt==2) {
GL11.glPushMatrix();
GL11.glTranslated(d1, d2, d3);
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);

switch(rot) {
case 0:GL11.glRotatef(-180F, 0F, 0F, 1F);break;
case 3:GL11.glRotatef(-90F, 0F, 0F, 1F);break;
case 2:GL11.glRotatef(0F, 0F, 0F, 1F);break;
case 1:GL11.glRotatef(90F, 0F, 0F, 1F);break;
default:GL11.glRotatef(0F, 0F, 0F, 1F);break;
}

this.bindTexture(new ResourceLocation(TileTexture.getTexTest01_1(tex), TileTexture.getTexTest01_2(tex)));
if(tbm) {
mdl1.renderPart("stickG6_1");
mdl1.renderPart("stickG6_2");
mdl1.renderPart("stickG6_3");
mdl1.renderPart("stickG6_4");
}else{
mdl1.renderPart("stickG0_2");
}
GL11.glPopMatrix();
}
//--------------------------------
if(tpt==1) {
GL11.glPushMatrix();
GL11.glTranslated(d1, d2, d3);
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);

switch(rot) {
case 0:GL11.glRotatef(-180F, 0F, 0F, 1F);break;
case 3:GL11.glRotatef(-90F, 0F, 0F, 1F);break;
case 2:GL11.glRotatef(0F, 0F, 0F, 1F);break;
case 1:GL11.glRotatef(90F, 0F, 0F, 1F);break;
default:GL11.glRotatef(0F, 0F, 0F, 1F);break;
}

this.bindTexture(new ResourceLocation(TileTexture.getTexTest01_1(tex), TileTexture.getTexTest01_2(tex)));
if(tbm) {
mdl1.renderPart("stickG7_1");
mdl1.renderPart("stickG7_2");
mdl1.renderPart("stickG7_3");
mdl1.renderPart("stickG7_4");
}else{
mdl1.renderPart("stickG0_1");
}
GL11.glPopMatrix();
}
//--------------------------------

}

}
