package mods.timaxa007.pack.furniture.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBlockLamps2 extends ModelBase{
ModelRenderer body;
ModelRenderer partlamp;

public ModelBlockLamps2() {
textureWidth=64;
textureHeight=64;

body=new ModelRenderer(this, 0, 0);
body.addBox(-8F, -8F, -8F, 16, 16, 16);
body.setRotationPoint(0F, 16F, 0F);
body.setTextureSize(64, 64);
body.mirror=true;
setRotation(body, 0F, 0F, 0F);
partlamp=new ModelRenderer(this, 0, 32);
partlamp.addBox(-6F, -6F, -6F, 12, 12, 12);
partlamp.setRotationPoint(0F, 16F, 0F);
partlamp.setTextureSize(64, 64);
partlamp.mirror=true;
setRotation(partlamp, 0F, 0F, 0F);
}

public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
super.render(entity, f, f1, f2, f3, f4, f5);
setRotationAngles(f, f1, f2, f3, f4, f5, entity);
body.render(f5);
partlamp.render(f5);
}

private void setRotation(ModelRenderer model, float x, float y, float z) {
model.rotateAngleX=x;
model.rotateAngleY=y;
model.rotateAngleZ=z;
}

public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
setRotationAngles(f, f1, f2, f3, f4, f5);
}

public void render() {
body.render(0.0625F);
partlamp.render(0.0625F);
}

}
