package mods.timaxa007.pack.furniture.ri;

import mods.timaxa007.lib.TileTexture;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class ItemRenderBarrels implements IItemRenderer{
private IModelCustom mdlB;
private IModelCustom mdlP;
private IModelCustom mdlCD;

public ItemRenderBarrels() {
mdlB=AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/barrel_cone.obj"));
mdlP=AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/barrel_top.obj"));
mdlCD=AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/barrel_cap_down.obj"));
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
/*
//int rot=tileEntity.getRotation();
int texB=tileEntity.getTypeB();
int texP=tileEntity.getTypeP();
int texCD=tileEntity.getTypeCD();
boolean lie=tileEntity.getLie();
*/
int rot=2;
int texB=tag.getInteger("TypeB");
int texP=tag.getInteger("TypeP");
int texCD=tag.getInteger("TypeCD");
boolean lie=tag.getBoolean("Lie");

GL11.glPushMatrix();
if(lie) {
GL11.glTranslatef(0.5F, 0.5F, 1.0F);
GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
}else{
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
}
GL11.glRotatef(-180F+((float)((4-rot)*90F)), 0.0F, 0.0F, 1.0F);
Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", TileTexture.tt));
mdlB.renderAll();
GL11.glPopMatrix();

if(texP>0) {
GL11.glPushMatrix();
if(lie) {
GL11.glTranslatef(0.5F, 0.5F, 1.0F-0.9375F);
GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
}else{
GL11.glTranslatef(0.5F, 0.9375F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
}
GL11.glRotatef(-180F+((float)((4-rot)*90F)), 0.0F, 0.0F, 1.0F);
Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", TileTexture.tt));
mdlP.renderAll();
GL11.glPopMatrix();
}

GL11.glPushMatrix();
if(lie) {
GL11.glTranslatef(0.5F, 0.5F, 1.0F);
GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
}else{
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
}
GL11.glRotatef(-180F+((float)((4-rot)*90F)), 0.0F, 0.0F, 1.0F);
Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", TileTexture.tt));
mdlCD.renderAll();
GL11.glPopMatrix();

}

}