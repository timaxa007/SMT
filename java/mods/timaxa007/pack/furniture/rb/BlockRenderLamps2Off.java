package mods.timaxa007.pack.furniture.rb;

import mods.timaxa007.pack.furniture.model.ModelBlockLamps2;
import mods.timaxa007.pack.furniture.te.TELamps2Off;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class BlockRenderLamps2Off extends TileEntitySpecialRenderer{
private static ModelBlockLamps2 model;

public BlockRenderLamps2Off() {
model=new ModelBlockLamps2();
}

public void renderTileEntityAt(TileEntity tileEntity, double d1, double d2, double d3, float f) {
this.renderTE((TELamps2Off)tileEntity, d1, d2, d3, f);
}

public void renderTE(TELamps2Off tileEntity, double d1, double d2, double d3, float f) {
GL11.glPushMatrix();
GL11.glTranslatef((float)d1+0.5F, (float)d2+1.5F, (float)d3+0.5F);
GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);

switch(tileEntity.getBlockMetadata()) {
case 0:this.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"lamps2/"+"lamp_black_off.png"));break;
case 1:this.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"lamps2/"+"lamp_blue_off.png"));break;
case 2:this.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"lamps2/"+"lamp_brown_off.png"));break;
case 3:this.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"lamps2/"+"lamp_cyan_off.png"));break;
case 4:this.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"lamps2/"+"lamp_gray_off.png"));break;
case 5:this.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"lamps2/"+"lamp_green_off.png"));break;
case 6:this.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"lamps2/"+"lamp_light_blue_off.png"));break;
case 7:this.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"lamps2/"+"lamp_light_gray_off.png"));break;
case 8:this.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"lamps2/"+"lamp_light_green_off.png"));break;
case 9:this.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"lamps2/"+"lamp_magenta_off.png"));break;
case 10:this.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"lamps2/"+"lamp_orange_off.png"));break;
case 11:this.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"lamps2/"+"lamp_pink_off.png"));break;
case 12:this.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"lamps2/"+"lamp_purple_off.png"));break;
case 13:this.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"lamps2/"+"lamp_red_off.png"));break;
case 14:this.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"lamps2/"+"lamp_white_off.png"));break;
case 15:this.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"lamps2/"+"lamp_yellow_off.png"));break;
default:this.bindTexture(new ResourceLocation("timaxa007", "textures/"+"obj/"+"lamps2/"+"lamp_red_off.png"));break;
}

this.model.render();
GL11.glPopMatrix();
}

}
