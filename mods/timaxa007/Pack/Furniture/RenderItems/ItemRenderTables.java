package mods.timaxa007.Pack.Furniture.RenderItems;

import mods.timaxa007.Lib.TileTexture;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class ItemRenderTables implements IItemRenderer{
private IModelCustom mdl1;

public ItemRenderTables() {
mdl1=AdvancedModelLoader.loadModel("/assets/timaxa007/obj/table01.obj");
}

@Override
public boolean handleRenderType(ItemStack is, ItemRenderType type) {
return true;
}

@Override
public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack is, ItemRendererHelper helper) {
return true;
}

@Override
public void renderItem(ItemRenderType type, ItemStack is, Object... data) {
NBTTagCompound tag = is.getTagCompound();
//int meta=tileEntity.getBlockMetadata();
int tex=0;
int tpt=0;
boolean tbm=true;

if(tag!=null) {
if(tag.hasKey("Type")) {tex=tag.getInteger("Type");}
if(tag.hasKey("Size")) {tpt=tag.getInteger("Size");}
}

//--------------------------------
GL11.glPushMatrix();
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
GL11.glTranslatef(0.0F, 0.0F, ((float)tpt*0.125F));
Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(TileTexture.getTexTest01_1(tex), TileTexture.getTexTest01_2(tex)));
mdl1.renderPart("table");
GL11.glPopMatrix();
//--------------------------------
if(tpt==7) {
GL11.glPushMatrix();
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(TileTexture.getTexTest01_1(tex), TileTexture.getTexTest01_2(tex)));
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
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(TileTexture.getTexTest01_1(tex), TileTexture.getTexTest01_2(tex)));
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
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(TileTexture.getTexTest01_1(tex), TileTexture.getTexTest01_2(tex)));
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
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(TileTexture.getTexTest01_1(tex), TileTexture.getTexTest01_2(tex)));
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
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(TileTexture.getTexTest01_1(tex), TileTexture.getTexTest01_2(tex)));
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
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(TileTexture.getTexTest01_1(tex), TileTexture.getTexTest01_2(tex)));
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
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(TileTexture.getTexTest01_1(tex), TileTexture.getTexTest01_2(tex)));
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
