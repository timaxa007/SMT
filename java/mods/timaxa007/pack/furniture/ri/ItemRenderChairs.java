package mods.timaxa007.pack.furniture.ri;

import mods.timaxa007.lib.TileTexture;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class ItemRenderChairs implements IItemRenderer {
private IModelCustom mdlS;
private IModelCustom mdlT;
private IModelCustom mdlB;

public ItemRenderChairs() {
mdlS=AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/square_side.obj"));
mdlT=AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/square_top.obj"));
mdlB=AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/square_bottom.obj"));
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
//int tex=tileEntity.getType();
//int rot=tileEntity.getRotation();
int tex=is.getItemDamage();
int rot=2;

//front
GL11.glPushMatrix();
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
GL11.glRotatef(-180F+((float)((4-rot)*90F)), 0.0F, 0.0F, 1.0F);
Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", TileTexture.tt));
mdlS.renderAll();
GL11.glPopMatrix();
//right
GL11.glPushMatrix();
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
GL11.glRotatef(-90F+((float)((4-rot)*90F)), 0.0F, 0.0F, 1.0F);
Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", TileTexture.tt));
mdlS.renderAll();
GL11.glPopMatrix();
//back
GL11.glPushMatrix();
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
GL11.glRotatef(0F+((float)((4-rot)*90F)), 0.0F, 0.0F, 1.0F);
Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", TileTexture.tt));
mdlS.renderAll();
GL11.glPopMatrix();
//left
GL11.glPushMatrix();
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
GL11.glRotatef(90F+((float)((4-rot)*90F)), 0.0F, 0.0F, 1.0F);
Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", TileTexture.tt));
mdlS.renderAll();
GL11.glPopMatrix();
//top
GL11.glPushMatrix();
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
GL11.glRotatef(-180F+((float)((4-rot)*90F)), 0.0F, 0.0F, 1.0F);
Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", TileTexture.tt));
mdlT.renderAll();
GL11.glPopMatrix();
//bottom
GL11.glPushMatrix();
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
GL11.glRotatef(-180F+((float)((4-rot)*90F)), 0.0F, 0.0F, 1.0F);
Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", TileTexture.tt));
mdlB.renderAll();
GL11.glPopMatrix();

}

}
