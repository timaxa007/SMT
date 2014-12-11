package mods.timaxa007.pack.stock.rb;

import mods.timaxa007.pack.stock.model.ModelPiePar;
import mods.timaxa007.pack.stock.te.TEPie;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class BlockRenderPies extends TileEntitySpecialRenderer {
private static ModelPiePar model;

public BlockRenderPies() {
model = new ModelPiePar();
}

public void renderTileEntityAt(TileEntity te, double dx, double dy, double dz, float f) {
renderTE((TEPie)te, dx, dy, dz, f);
}

public void renderTE(TEPie te, double dx, double dy, double dz, float f) {
//int tex=te.getBlockMetadata();
int tex = te.getTypes();
int amt = te.getAmount();
int rot = te.getRot();

if (amt == 4) {
GL11.glPushMatrix();
GL11.glTranslated(dx, dy, dz);
GL11.glTranslatef(0.5F, 1.5F, 0.5F);
GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
GL11.glRotatef(0F + ((float)(90F*rot)) + 90F, 0.0F, 1.0F, 0.0F);
switch(tex) {
case 0:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie1.png"));break;
case 1:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie2.png"));break;
case 2:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie3.png"));break;
case 3:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie4.png"));break;
case 4:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie5.png"));break;
case 5:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie6.png"));break;
case 6:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie7.png"));break;
case 7:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie8.png"));break;
case 8:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie9.png"));break;
case 9:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie10.png"));break;
case 10:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie11.png"));break;
case 11:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie12.png"));break;
case 12:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie13.png"));break;
case 13:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie14.png"));break;
case 14:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie15.png"));break;
case 15:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie16.png"));break;
default:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie.png"));break;
}
model.render();
GL11.glPopMatrix();
}

if (amt >= 3) {
GL11.glPushMatrix();
GL11.glTranslated(dx, dy, dz);
GL11.glTranslatef(0.5F, 1.5F, 0.5F);
GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
GL11.glRotatef(90F + ((float)(90F*rot)) + 90F, 0.0F, 1.0F, 0.0F);
switch(tex) {
case 0:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie1.png"));break;
case 1:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie2.png"));break;
case 2:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie3.png"));break;
case 3:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie4.png"));break;
case 4:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie5.png"));break;
case 5:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie6.png"));break;
case 6:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie7.png"));break;
case 7:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie8.png"));break;
case 8:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie9.png"));break;
case 9:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie10.png"));break;
case 10:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie11.png"));break;
case 11:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie12.png"));break;
case 12:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie13.png"));break;
case 13:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie14.png"));break;
case 14:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie15.png"));break;
case 15:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie16.png"));break;
default:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie.png"));break;
}
model.render();
GL11.glPopMatrix();
}

if (amt >= 2) {
GL11.glPushMatrix();
GL11.glTranslated(dx, dy, dz);
GL11.glTranslatef(0.5F, 1.5F, 0.5F);
GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
GL11.glRotatef(180F + ((float)(90F*rot)) + 90F, 0.0F, 1.0F, 0.0F);
switch(tex) {
case 0:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie1.png"));break;
case 1:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie2.png"));break;
case 2:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie3.png"));break;
case 3:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie4.png"));break;
case 4:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie5.png"));break;
case 5:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie6.png"));break;
case 6:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie7.png"));break;
case 7:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie8.png"));break;
case 8:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie9.png"));break;
case 9:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie10.png"));break;
case 10:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie11.png"));break;
case 11:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie12.png"));break;
case 12:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie13.png"));break;
case 13:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie14.png"));break;
case 14:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie15.png"));break;
case 15:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie16.png"));break;
default:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie.png"));break;
}
model.render();
GL11.glPopMatrix();
}

if (amt >= 1) {
GL11.glPushMatrix();
GL11.glTranslated(dx, dy, dz);
GL11.glTranslatef(0.5F, 1.5F, 0.5F);
GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
GL11.glRotatef(270F + ((float)(90F*rot)) + 90F, 0.0F, 1.0F, 0.0F);
switch(tex) {
case 0:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie1.png"));break;
case 1:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie2.png"));break;
case 2:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie3.png"));break;
case 3:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie4.png"));break;
case 4:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie5.png"));break;
case 5:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie6.png"));break;
case 6:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie7.png"));break;
case 7:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie8.png"));break;
case 8:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie9.png"));break;
case 9:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie10.png"));break;
case 10:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie11.png"));break;
case 11:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie12.png"));break;
case 12:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie13.png"));break;
case 13:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie14.png"));break;
case 14:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie15.png"));break;
case 15:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie16.png"));break;
default:bindTexture(new ResourceLocation("timaxa007", "textures/obj/foods/pie.png"));break;
}
model.render();
GL11.glPopMatrix();
}

}

}
