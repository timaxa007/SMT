package mods.timaxa007.pack.furniture.rb;

import mods.timaxa007.pack.furniture.model.ModelCandle;
import mods.timaxa007.pack.furniture.te.TECandle;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class BlockRenderCandle extends TileEntitySpecialRenderer {
private static ModelCandle model;

public BlockRenderCandle() {
model = new ModelCandle();
}

public void renderTileEntityAt(TileEntity te, double d1, double d2, double d3, float f) {
this.renderTE((TECandle)te, d1, d2, d3, f);
}

public void renderTE(TECandle te, double d1, double d2, double d3, float f) {
GL11.glPushMatrix();
GL11.glTranslated(d1, d2, d3);
GL11.glTranslatef(0.525F, 1.5F, 0.475F);
GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);

switch(te.getBlockMetadata()) {
case 0:this.bindTexture(new ResourceLocation("timaxa007", "textures/" + "obj/" + "candle/" + "candle_black.png"));break;
case 1:this.bindTexture(new ResourceLocation("timaxa007", "textures/" + "obj/" + "candle/" + "candle_blue.png"));break;
case 2:this.bindTexture(new ResourceLocation("timaxa007", "textures/" + "obj/" + "candle/" + "candle_brown.png"));break;
case 3:this.bindTexture(new ResourceLocation("timaxa007", "textures/" + "obj/" + "candle/" + "candle_cyan.png"));break;
case 4:this.bindTexture(new ResourceLocation("timaxa007", "textures/" + "obj/" + "candle/" + "candle_gray.png"));break;
case 5:this.bindTexture(new ResourceLocation("timaxa007", "textures/" + "obj/" + "candle/" + "candle_green.png"));break;
case 6:this.bindTexture(new ResourceLocation("timaxa007", "textures/" + "obj/" + "candle/" + "candle_light_blue.png"));break;
case 7:this.bindTexture(new ResourceLocation("timaxa007", "textures/" + "obj/" + "candle/" + "candle_light_gray.png"));break;
case 8:this.bindTexture(new ResourceLocation("timaxa007", "textures/" + "obj/" + "candle/" + "candle_light_green.png"));break;
case 9:this.bindTexture(new ResourceLocation("timaxa007", "textures/" + "obj/" + "candle/" + "candle_magenta.png"));break;
case 10:this.bindTexture(new ResourceLocation("timaxa007", "textures/" + "obj/" + "candle/" + "candle_orange.png"));break;
case 11:this.bindTexture(new ResourceLocation("timaxa007", "textures/" + "obj/" + "candle/" + "candle_pink.png"));break;
case 12:this.bindTexture(new ResourceLocation("timaxa007", "textures/" + "obj/" + "candle/" + "candle_purple.png"));break;
case 13:this.bindTexture(new ResourceLocation("timaxa007", "textures/" + "obj/" + "candle/" + "candle_red.png"));break;
case 14:this.bindTexture(new ResourceLocation("timaxa007", "textures/" + "obj/" + "candle/" + "candle_white.png"));break;
case 15:this.bindTexture(new ResourceLocation("timaxa007", "textures/" + "obj/" + "candle/" + "candle_yellow.png"));break;
default:this.bindTexture(new ResourceLocation("timaxa007", "textures/" + "obj/" + "candle/" + "candle_red.png"));break;
}

this.model.render();
GL11.glPopMatrix();
}

}
