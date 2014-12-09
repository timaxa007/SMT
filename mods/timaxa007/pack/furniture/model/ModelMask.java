package mods.timaxa007.pack.furniture.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class ModelMask extends ModelBiped {

ModelRenderer mask;
ModelRenderer armor;
IModelCustom model;
int r_t;

public ModelMask(int i) {
textureWidth = 64;
textureHeight = 32;
r_t = i;

if (i == 1) {
mask = new ModelRenderer(this, 0, 0);
mask.addBox(-4F, -8F, -5F, 8, 8, 1);
mask.setRotationPoint(0F, 0F, 0F);
mask.setTextureSize(64, 32);
mask.mirror = true;
setRotation(mask, 0F, 0F, 0F);
}

if (i == 2) {
armor = new ModelRenderer(this, 16, 16);
armor.addBox(-4F, 1F, -3F, 8, 10, 1);
armor.setRotationPoint(0F, 0F, 0F);
armor.setTextureSize(64, 32);
armor.mirror = true;
setRotation(armor, 0F, 0F, 0F);
}

if (i == 3) {
model = AdvancedModelLoader.loadModel("/assets/timaxa007/obj/jar01.obj");
}

}

public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
super.render(entity, f, f1, f2, f3, f4, f5);
setRotationAngles(f, f1, f2, f3, f4, f5, entity);

if (r_t == 1) {
mask.render(f5);
}

if (r_t == 2) {
armor.render(f5);
}

if (r_t == 3) {
int crl_w = 0xFF0088;

//--------------------------------------------------
GL11.glPushMatrix();
GL11.glEnable(GL11.GL_BLEND);
GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
GL11.glTranslatef(-0.0F, 0.7F, 0.5F);
GL11.glRotatef(90F, 1.0F, 0.0F, 0.0F);
float red = (float)(crl_w >> 16 & 255) / 255.0F;
float green = (float)(crl_w >> 8 & 255) / 255.0F;
float blue = (float)(crl_w >> 0 & 255) / 255.0F;
GL11.glColor3f(red, green, blue);
Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/obj/water.png"));
model.renderPart("water");
GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
GL11.glDisable(GL11.GL_BLEND);
GL11.glPopMatrix();
//--------------------------------------------------
GL11.glPushMatrix();
GL11.glEnable(GL11.GL_BLEND);
GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
GL11.glTranslatef(-0.0F, 0.7F, 0.5F);
GL11.glRotatef(90F, 1.0F, 0.0F, 0.0F);
Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/obj/glass.png"));
model.renderPart("glass");
GL11.glDisable(GL11.GL_BLEND);
GL11.glPopMatrix();
//--------------------------------------------------
GL11.glPushMatrix();
GL11.glTranslatef(-0.0F, 0.7F, 0.5F);
GL11.glRotatef(90F, 1.0F, 0.0F, 0.0F);
Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("minecraft", "textures/blocks/planks_oak.png"));
model.renderPart("wood");
GL11.glPopMatrix();
}

}

private void setRotation(ModelRenderer model, float x, float y, float z) {
model.rotateAngleX = x;
model.rotateAngleY = y;
model.rotateAngleZ = z;
}

public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);

if (r_t == 1) {
mask.rotateAngleY = f3 / (180F / (float)Math.PI);
mask.rotateAngleX = f4 / (180F / (float)Math.PI);
if (isSneak) {
mask.rotationPointY = 1.0F;
} else {
mask.rotationPointY = 0.0F;
}
}

if (r_t == 2) {
float f6;
if (onGround > -9990.0F) {
f6 = onGround;
armor.rotateAngleY = MathHelper.sin(MathHelper.sqrt_float(f6) * (float)Math.PI * 2.0F) * 0.2F;
}
if (isSneak) {
armor.rotateAngleX = 0.5F;
} else {
armor.rotateAngleX = 0.0F;
}
}

}

}
