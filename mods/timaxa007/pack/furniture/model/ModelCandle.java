package mods.timaxa007.pack.furniture.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCandle extends ModelBase {
ModelRenderer Gmain;
ModelRenderer Fmain;

public ModelCandle() {
textureWidth = 16;
textureHeight = 8;

Gmain = new ModelRenderer(this, 0, 0);
Gmain.addBox(-1F, 0F, -1F, 3, 5, 3);
Gmain.setRotationPoint(0F, 18.53333F, 0F);
Gmain.setTextureSize(16, 8);
Gmain.mirror = true;
setRotation(Gmain, 0F, 0F, 0F);
Fmain = new ModelRenderer(this, 12, 0);
Fmain.addBox(0F, -2F, 0F, 1, 2, 1);
Fmain.setRotationPoint(0F, 19F, 0F);
Fmain.setTextureSize(16, 8);
Fmain.mirror = true;
setRotation(Fmain, 0F, 0F, 0F);
}

public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
super.render(entity, f, f1, f2, f3, f4, f5);
setRotationAngles(f, f1, f2, f3, f4, f5, entity);
Gmain.render(f5);
Fmain.render(f5);
}

private void setRotation(ModelRenderer model, float x, float y, float z) {
model.rotateAngleX = x;
model.rotateAngleY = y;
model.rotateAngleZ = z;
}

public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
setRotationAngles(f, f1, f2, f3, f4, f5, entity);
}

public void render() {
Gmain.render(0.0625F);
Fmain.render(0.0625F);
}

}
