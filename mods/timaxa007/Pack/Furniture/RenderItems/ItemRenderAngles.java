package mods.timaxa007.Pack.Furniture.RenderItems;

import mods.timaxa007.Lib.TileTexture;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class ItemRenderAngles implements IItemRenderer{
private IModelCustom mdl0_1;
private IModelCustom mdl1_l;
private IModelCustom mdl1_r;
private IModelCustom mdl1_1;
private IModelCustom mdlS;
private IModelCustom mdlT;
private IModelCustom mdlB;

public ItemRenderAngles() {
mdl0_1=AdvancedModelLoader.loadModel("/assets/timaxa007/obj/triangle01_1.obj");

mdl1_l=AdvancedModelLoader.loadModel("/assets/timaxa007/obj/triangle_left.obj");
mdl1_r=AdvancedModelLoader.loadModel("/assets/timaxa007/obj/triangle_right.obj");

mdl1_1=AdvancedModelLoader.loadModel("/assets/timaxa007/obj/angle_side.obj");

mdlS=AdvancedModelLoader.loadModel("/assets/timaxa007/obj/square_side.obj");

mdlT=AdvancedModelLoader.loadModel("/assets/timaxa007/obj/square_top.obj");
mdlB=AdvancedModelLoader.loadModel("/assets/timaxa007/obj/square_bottom.obj");
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
/*
int tex=tileEntity.getType();
int mdl=tileEntity.getSize();
int rot=tileEntity.getRotation();
boolean uper=tileEntity.getUPing();
*/
int tex=0;
int mdl=0;
int rot=2;
boolean uper=false;
//--------------------------------
GL11.glPushMatrix();
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
GL11.glRotatef(-180F+((float)((4-rot)*90F)), 0.0F, 0.0F, 1.0F);
Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(TileTexture.getTexTest01_1(tex), TileTexture.getTexTest01_2(tex)));
mdl1_l.renderAll();
GL11.glPopMatrix();
//--------------------------------
GL11.glPushMatrix();
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
GL11.glRotatef(-180F+((float)((4-rot)*90F)), 0.0F, 0.0F, 1.0F);
Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(TileTexture.getTexTest01_1(tex), TileTexture.getTexTest01_2(tex)));
mdl1_r.renderAll();
GL11.glPopMatrix();
//--------------------------------
GL11.glPushMatrix();
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
GL11.glRotatef(-180F+((float)((4-rot)*90F)), 0.0F, 0.0F, 1.0F);
Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(TileTexture.getTexTest01_1(tex), TileTexture.getTexTest01_2(tex)));
mdl1_1.renderAll();
GL11.glPopMatrix();
//--------------------------------
GL11.glPushMatrix();
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
GL11.glRotatef(0F+((float)((4-rot)*90F)), 0.0F, 0.0F, 1.0F);
Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(TileTexture.getTexTest01_1(tex), TileTexture.getTexTest01_2(tex)));
mdlS.renderAll();
GL11.glPopMatrix();
//--------------------------------
GL11.glPushMatrix();
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
//GL11.glRotatef(-180F+((float)((4-rot)*90F)), 0.0F, 0.0F, 1.0F);
Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(TileTexture.getTexTest01_1(tex), TileTexture.getTexTest01_2(tex)));
if(!uper) {mdlB.renderAll();}else{mdlT.renderAll();}
GL11.glPopMatrix();
//--------------------------------

}

}
