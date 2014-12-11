package mods.timaxa007.pack.furniture.model;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;


public class ArmorTestModel extends ModelBiped{
ModelRenderer head2;
ModelRenderer body2;
ModelRenderer rightarm2;
ModelRenderer leftarm2;
ModelRenderer rightleg2;
ModelRenderer leftleg2;

public ArmorTestModel(float f) {
//super(0.0F, -14.0F, 64, 32);
//super(0.0F, 10.0F, 64, 32);
super(f);
textureWidth=128;
textureHeight=64;

head2=new ModelRenderer(this, 0, 0);
head2.addBox(-4F, -8F, -4F, 8, 8, 8);
head2.setRotationPoint(0F, 0F, 0F);
head2.setTextureSize(128, 64);
head2.mirror=true;
setRotation(head2, 0F, 0F, 0F);
body2=new ModelRenderer(this, 32, 0);
body2.addBox(-4F, 0F, -3F, 8, 12, 6);
body2.setRotationPoint(0F, 0F, 0F);
body2.setTextureSize(128, 64);
body2.mirror=true;
setRotation(body2, 0F, 0F, 0F);
rightarm2=new ModelRenderer(this, 0, 16);
rightarm2.addBox(-5F, -3F, -3F, 6, 14, 6);
rightarm2.setRotationPoint(-5F, 2F, 0F);
rightarm2.setTextureSize(128, 64);
rightarm2.mirror=true;
setRotation(rightarm2, 0F, 0F, 0F);
leftarm2=new ModelRenderer(this, 0, 16);
leftarm2.addBox(-1F, -3F, -3F, 6, 14, 6);
leftarm2.setRotationPoint(5F, 2F, 0F);
leftarm2.setTextureSize(128, 64);
leftarm2.mirror=true;
setRotation(leftarm2, 0F, 0F, 0F);
rightleg2=new ModelRenderer(this, 24, 18);
rightleg2.addBox(-4F, -1F, -3F, 6, 13, 6);
rightleg2.setRotationPoint(-2F, 12F, 0F);
rightleg2.setTextureSize(128, 64);
rightleg2.mirror=true;
setRotation(rightleg2, 0F, 0F, 0F);
leftleg2=new ModelRenderer(this, 24, 18);
leftleg2.addBox(-2F, -1F, -3F, 6, 13, 6);
leftleg2.setRotationPoint(2F, 12F, 0F);
leftleg2.setTextureSize(128, 64);
leftleg2.mirror=true;
setRotation(leftleg2, 0F, 0F, 0F);

this.bipedHead.addChild(head2);
this.bipedBody.addChild(body2);
this.bipedRightArm.addChild(rightarm2);
this.bipedLeftArm.addChild(leftarm2);
this.bipedRightLeg.addChild(rightleg2);
this.bipedLeftLeg.addChild(leftleg2);

}

public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
super.render(entity, f, f1, f2, f3, f4, f5);
setRotationAngles(f, f1, f2, f3, f4, f5, entity);
head2.render(f5);
body2.render(f5);
rightarm2.render(f5);
leftarm2.render(f5);
rightleg2.render(f5);
leftleg2.render(f5);
}

private void setRotation(ModelRenderer model, float x, float y, float z) {
model.rotateAngleX=x;
model.rotateAngleY=y;
model.rotateAngleZ=z;
}

public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
setRotationAngles(f, f1, f2, f3, f4, f5);
}
/*
public void render() {
head.render(0.0625F);
body.render(0.0625F);
rightarm.render(0.0625F);
leftarm.render(0.0625F);
rightleg.render(0.0625F);
leftleg.render(0.0625F);
}
*/
}
