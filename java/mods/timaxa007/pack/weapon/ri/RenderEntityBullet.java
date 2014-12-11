package mods.timaxa007.pack.weapon.ri;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class RenderEntityBullet extends Render {
private static final ResourceLocation arrowTextures = new ResourceLocation("textures/blocks/iron_block.png");
private static final IModelCustom model = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/bullet_test.obj"));

@Override
public void doRender(Entity entity, double dx, double dy, double dz, float f, float f1) {
//renderBullet((EntityBullet)entity, dx, dy, dz, f, f1);
}

@Override
protected ResourceLocation getEntityTexture(Entity entity) {
return arrowTextures;
}
/*
private void renderBullet(EntityBullet entity, double dx, double dy, double dz, float f, float f1) {
this.bindEntityTexture(entity);
GL11.glPushMatrix();
GL11.glTranslated(dx, dy, dz);
GL11.glTranslatef(0.5F, 0.0F, 0.5F);
//GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
GL11.glRotatef(-180F, 0.0F, 1.0F, 0.0F);
GL11.glScalef(0.5F, 0.5F, 0.5F);
GL11.glRotatef(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * f1 - 90.0F, 0.0F, 1.0F, 0.0F);
GL11.glRotatef(entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * f1, 0.0F, 0.0F, 1.0F);
model.renderAll();
GL11.glDisable(GL12.GL_RESCALE_NORMAL);
GL11.glPopMatrix();
}
*/
}
