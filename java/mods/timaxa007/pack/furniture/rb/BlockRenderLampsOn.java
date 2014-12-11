package mods.timaxa007.pack.furniture.rb;

import mods.timaxa007.lib.TileTexture;
import mods.timaxa007.pack.furniture.te.TELampsOn;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class BlockRenderLampsOn extends TileEntitySpecialRenderer{
private static IModelCustom mdlF;
private static IModelCustom mdlB;

public BlockRenderLampsOn() {
mdlF=AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/block_light_frame.obj"));
mdlB=AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/block_light_base.obj"));
}

public void renderTileEntityAt(TileEntity tileEntity, double d1, double d2, double d3, float f) {
this.renderTE((TELampsOn)tileEntity, d1, d2, d3, f);
}

public void renderTE(TELampsOn tileEntity, double d1, double d2, double d3, float f) {
//int meta=tileEntity.getBlockMetadata();
//int tex=tileEntity.getType();
//int rot=tileEntity.getRotation();
int tex=0;
int rot=2;

GL11.glPushMatrix();
GL11.glTranslatef((float)d1+0.5F, (float)d2, (float)d3+0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
GL11.glRotatef(-180F+((float)((4-rot)*90F)), 0.0F, 0.0F, 1.0F);
this.bindTexture(new ResourceLocation("timaxa007", TileTexture.tt));
mdlF.renderAll();
GL11.glPopMatrix();

GL11.glPushMatrix();
GL11.glTranslatef((float)d1+0.5F, (float)d2, (float)d3+0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
GL11.glRotatef(-180F+((float)((4-rot)*90F)), 0.0F, 0.0F, 1.0F);
switch(tileEntity.getBlockMetadata()) {
case 0:this.bindTexture(new ResourceLocation("timaxa007", "textures/"+"lamps/"+"lamp_black_on.png"));
case 1:this.bindTexture(new ResourceLocation("timaxa007", "textures/"+"lamps/"+"lamp_blue_on.png"));
case 2:this.bindTexture(new ResourceLocation("timaxa007", "textures/"+"lamps/"+"lamp_brown_on.png"));
case 3:this.bindTexture(new ResourceLocation("timaxa007", "textures/"+"lamps/"+"lamp_cyan_on.png"));
case 4:this.bindTexture(new ResourceLocation("timaxa007", "textures/"+"lamps/"+"lamp_gray_on.png"));
case 5:this.bindTexture(new ResourceLocation("timaxa007", "textures/"+"lamps/"+"lamp_green_on.png"));
case 6:this.bindTexture(new ResourceLocation("timaxa007", "textures/"+"lamps/"+"lamp_light_blue_on.png"));
case 7:this.bindTexture(new ResourceLocation("timaxa007", "textures/"+"lamps/"+"lamp_light_gray_on.png"));
case 8:this.bindTexture(new ResourceLocation("timaxa007", "textures/"+"lamps/"+"lamp_light_green_on.png"));
case 9:this.bindTexture(new ResourceLocation("timaxa007", "textures/"+"lamps/"+"lamp_magenta_on.png"));
case 10:this.bindTexture(new ResourceLocation("timaxa007", "textures/"+"lamps/"+"lamp_orange_on.png"));
case 11:this.bindTexture(new ResourceLocation("timaxa007", "textures/"+"lamps/"+"lamp_pink_on.png"));
case 12:this.bindTexture(new ResourceLocation("timaxa007", "textures/"+"lamps/"+"lamp_purple_on.png"));
case 13:this.bindTexture(new ResourceLocation("timaxa007", "textures/"+"lamps/"+"lamp_red_on.png"));
case 14:this.bindTexture(new ResourceLocation("timaxa007", "textures/"+"lamps/"+"lamp_white_on.png"));
case 15:this.bindTexture(new ResourceLocation("timaxa007", "textures/"+"lamps/"+"lamp_yellow_on.png"));
default:this.bindTexture(new ResourceLocation("timaxa007", "textures/"+"lamps/"+"lamp_red_on.png"));
}
mdlB.renderAll();
GL11.glPopMatrix();
}

}
