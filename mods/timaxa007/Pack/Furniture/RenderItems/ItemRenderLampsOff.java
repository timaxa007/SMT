package mods.timaxa007.Pack.Furniture.RenderItems;

import mods.timaxa007.Lib.TileTexture;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class ItemRenderLampsOff implements IItemRenderer{
private static IModelCustom mdlF;
private static IModelCustom mdlB;

public ItemRenderLampsOff() {
mdlF=AdvancedModelLoader.loadModel("/assets/timaxa007/obj/block_light_frame.obj");
mdlB=AdvancedModelLoader.loadModel("/assets/timaxa007/obj/block_light_base.obj");
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
//int tex=is.getItemDamage();
int tex=0;
int rot=2;

GL11.glPushMatrix();
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
GL11.glRotatef(-180F+((float)((4-rot)*90F)), 0.0F, 0.0F, 1.0F);
Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", TileTexture.tt));
mdlF.renderAll();
GL11.glPopMatrix();

GL11.glPushMatrix();
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
GL11.glRotatef(-180F+((float)((4-rot)*90F)), 0.0F, 0.0F, 1.0F);

switch(is.getItemDamage()) {
case 0:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"blocks/"+"lamps/"+"lamp_black_off.png"));break;
case 1:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"blocks/"+"lamps/"+"lamp_blue_off.png"));break;
case 2:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"blocks/"+"lamps/"+"lamp_brown_off.png"));break;
case 3:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"blocks/"+"lamps/"+"lamp_cyan_off.png"));break;
case 4:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"blocks/"+"lamps/"+"lamp_gray_off.png"));break;
case 5:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"blocks/"+"lamps/"+"lamp_green_off.png"));break;
case 6:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"blocks/"+"lamps/"+"lamp_light_blue_off.png"));break;
case 7:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"blocks/"+"lamps/"+"lamp_light_gray_off.png"));break;
case 8:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"blocks/"+"lamps/"+"lamp_light_green_off.png"));break;
case 9:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"blocks/"+"lamps/"+"lamp_magenta_off.png"));break;
case 10:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"blocks/"+"lamps/"+"lamp_orange_off.png"));break;
case 11:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"blocks/"+"lamps/"+"lamp_pink_off.png"));break;
case 12:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"blocks/"+"lamps/"+"lamp_purple_off.png"));break;
case 13:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"blocks/"+"lamps/"+"lamp_red_off.png"));break;
case 14:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"blocks/"+"lamps/"+"lamp_white_off.png"));break;
case 15:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"blocks/"+"lamps/"+"lamp_yellow_off.png"));break;
default:Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/"+"blocks/"+"lamps/"+"lamp_red_off.png"));break;
}

mdlB.renderAll();
GL11.glPopMatrix();

}

}
