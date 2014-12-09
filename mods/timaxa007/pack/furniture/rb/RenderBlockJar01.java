package mods.timaxa007.pack.furniture.rb;

import org.lwjgl.opengl.GL11;

import mods.timaxa007.pack.furniture.te.TEJar01;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class RenderBlockJar01 extends TileEntitySpecialRenderer {
private IModelCustom model;

public RenderBlockJar01() {
model = AdvancedModelLoader.loadModel("/assets/timaxa007/obj/jar01.obj");
}

@Override
public void renderTileEntityAt(TileEntity te, double dx, double dy, double dz, float f) {
renderTE((TEJar01)te, dx, dy, dz, f);
}

private void renderTE(TEJar01 te, double dx, double dy, double dz, float f) {
//int tex = te.getBlockMetadata();
//int amt = te.getAmount();
//int rot = te.getRot();
int crl_w = 0xFFFFFF;
if (te != null) {
crl_w = te.getColorWater();
}

//--------------------------------------------------
GL11.glPushMatrix();
GL11.glEnable(GL11.GL_BLEND);
GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
GL11.glTranslated(dx, dy, dz);
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
float red = (float)(crl_w >> 16 & 255) / 255.0F;
float green = (float)(crl_w >> 8 & 255) / 255.0F;
float blue = (float)(crl_w >> 0 & 255) / 255.0F;
GL11.glColor3f(red, green, blue);
bindTexture(new ResourceLocation("timaxa007", "textures/obj/water.png"));
model.renderPart("water");
GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
GL11.glDisable(GL11.GL_BLEND);
GL11.glPopMatrix();
//--------------------------------------------------
GL11.glPushMatrix();
GL11.glEnable(GL11.GL_BLEND);
GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
GL11.glTranslated(dx, dy, dz);
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
bindTexture(new ResourceLocation("timaxa007", "textures/obj/glass.png"));
model.renderPart("glass");
GL11.glDisable(GL11.GL_BLEND);
GL11.glPopMatrix();
//--------------------------------------------------
GL11.glPushMatrix();
GL11.glTranslated(dx, dy, dz);
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
bindTexture(new ResourceLocation("minecraft", "textures/blocks/planks_oak.png"));
model.renderPart("wood");
GL11.glPopMatrix();
//--------------------------------------------------
}

}
