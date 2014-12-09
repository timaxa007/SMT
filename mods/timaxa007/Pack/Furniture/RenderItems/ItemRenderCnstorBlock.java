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

public class ItemRenderCnstorBlock implements IItemRenderer {
private IModelCustom mdlS;
private IModelCustom mdlT;
private IModelCustom mdlB;

public ItemRenderCnstorBlock() {
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
NBTTagCompound tag = is.getTagCompound();
//int meta = is.getItemDamage();
int tex = 0;
int clr = 0xFFFFFF;

if (tag != null) {
if (tag.hasKey("Type")) {
tex = tag.getInteger("Type");
}
if (tag.hasKey("Color")) {
clr = tag.getInteger("Color");
}
}

float red = (float)(clr >> 16 & 255)/255;
float green = (float)(clr >> 8 & 255)/255;
float blue = (float)(clr & 255)/255;
float alfa = 1.0F;
//--------------------------------
GL11.glPushMatrix();
GL11.glEnable(GL11.GL_BLEND);
GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
GL11.glRotatef(-90F, 0.0F, 0.0F, 1.0F);
GL11.glColor4f(red , green , blue, alfa);
Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation((String)TileTexture.texTest01[tex][0], (String)TileTexture.texTest01[tex][1]));
mdlS.renderAll();
GL11.glDisable(GL11.GL_BLEND);
GL11.glPopMatrix();
//--------------------------------
GL11.glPushMatrix();
GL11.glEnable(GL11.GL_BLEND);
GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
GL11.glRotatef(0F, 0.0F, 0.0F, 1.0F);
GL11.glColor4f(red , green , blue, alfa);
Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation((String)TileTexture.texTest01[tex][0], (String)TileTexture.texTest01[tex][1]));
mdlS.renderAll();
GL11.glDisable(GL11.GL_BLEND);
GL11.glPopMatrix();
//--------------------------------
GL11.glPushMatrix();
GL11.glEnable(GL11.GL_BLEND);
GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
GL11.glRotatef(90F, 0.0F, 0.0F, 1.0F);
GL11.glColor4f(red , green , blue, alfa);
Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation((String)TileTexture.texTest01[tex][0], (String)TileTexture.texTest01[tex][1]));
mdlS.renderAll();
GL11.glDisable(GL11.GL_BLEND);
GL11.glPopMatrix();
//--------------------------------
GL11.glPushMatrix();
GL11.glEnable(GL11.GL_BLEND);
GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
GL11.glColor4f(red , green , blue, alfa);
Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation((String)TileTexture.texTest01[tex][0], (String)TileTexture.texTest01[tex][1]));
mdlS.renderAll();
GL11.glDisable(GL11.GL_BLEND);
GL11.glPopMatrix();
//--------------------------------
GL11.glPushMatrix();
GL11.glEnable(GL11.GL_BLEND);
GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
GL11.glColor4f(red , green , blue, alfa);
Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation((String)TileTexture.texTest01[tex][0], (String)TileTexture.texTest01[tex][1]));
mdlT.renderAll();
GL11.glDisable(GL11.GL_BLEND);
GL11.glPopMatrix();
//--------------------------------
GL11.glPushMatrix();
GL11.glEnable(GL11.GL_BLEND);
GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
GL11.glColor4f(red , green , blue, alfa);
Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation((String)TileTexture.texTest01[tex][0], (String)TileTexture.texTest01[tex][1]));
mdlB.renderAll();
GL11.glDisable(GL11.GL_BLEND);
GL11.glPopMatrix();
//--------------------------------


}

}
