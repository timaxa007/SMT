package mods.timaxa007.pack.magic.entity;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class RenderArrowMini extends Render {

private static final ResourceLocation arrowTextures = new ResourceLocation("textures/blocks/iron_block.png");
private static final IModelCustom model = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "/obj/arrow_mini.obj"));

@Override
public void doRender(Entity entity, double d0, double d1, double d2, float f, float f1) {
//renderArrow((EntityArrowMini)entity, d0, d1, d2, f, f1);
}

@Override
protected ResourceLocation getEntityTexture(Entity entity) {
return arrowTextures;
}
/*
public void renderArrow(EntityArrowMini entity, double d0, double d1, double d2, float f, float f1) {
this.bindEntityTexture(entity);
GL11.glPushMatrix();
GL11.glTranslated(d0, d1, d2);
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
GL11.glScalef(0.5F, 0.5F, 0.5F);
GL11.glRotatef(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * f1 - 90.0F, 0.0F, 1.0F, 0.0F);
GL11.glRotatef(entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * f1, 0.0F, 0.0F, 1.0F);
model.renderAll();
GL11.glDisable(GL12.GL_RESCALE_NORMAL);
GL11.glPopMatrix();
}
*/
}
