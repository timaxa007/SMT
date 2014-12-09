package mods.timaxa007.Pack.Furniture.Model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBlockLamps extends ModelBase{
ModelRenderer partlamp;
ModelRenderer part1;
ModelRenderer part2;
ModelRenderer part3;
ModelRenderer part4;
ModelRenderer part5;
ModelRenderer part6;
ModelRenderer part7;
ModelRenderer part8;
ModelRenderer part9;
ModelRenderer part10;
ModelRenderer part11;
ModelRenderer part12;

public ModelBlockLamps() {
textureWidth=64;
textureHeight=64;


partlamp=new ModelRenderer(this, 0, 32);
partlamp.addBox(-6F, -6F, -6F, 12, 12, 12);
partlamp.setRotationPoint(0F, 16F, 0F);
partlamp.setTextureSize(64, 64);
partlamp.mirror=true;
setRotation(partlamp, 0F, 0F, 0F);
part1=new ModelRenderer(this, 0, 0);
part1.addBox(-8F, -8F, -8F, 2, 16, 2);
part1.setRotationPoint(0F, 16F, 0F);
part1.setTextureSize(64, 64);
part1.mirror=true;
setRotation(part1, 0F, 0F, 0F);
part2=new ModelRenderer(this, 0, 0);
part2.addBox(-8F, -8F, 6F, 2, 16, 2);
part2.setRotationPoint(0F, 16F, 0F);
part2.setTextureSize(64, 64);
part2.mirror=true;
setRotation(part2, 0F, 0F, 0F);
part3=new ModelRenderer(this, 0, 0);
part3.addBox(6F, -8F, -8F, 2, 16, 2);
part3.setRotationPoint(0F, 16F, 0F);
part3.setTextureSize(64, 64);
part3.mirror=true;
setRotation(part3, 0F, 0F, 0F);
part4=new ModelRenderer(this, 0, 0);
part4.addBox(6F, -8F, 6F, 2, 16, 2);
part4.setRotationPoint(0F, 16F, 0F);
part4.setTextureSize(64, 64);
part4.mirror=true;
setRotation(part4, 0F, 0F, 0F);
part5=new ModelRenderer(this, 8, 0);
part5.addBox(6F, -8F, -6F, 2, 2, 12);
part5.setRotationPoint(0F, 16F, 0F);
part5.setTextureSize(64, 64);
part5.mirror=true;
setRotation(part5, 0F, 0F, 0F);
part6=new ModelRenderer(this, 8, 0);
part6.addBox(6F, 6F, -6F, 2, 2, 12);
part6.setRotationPoint(0F, 16F, 0F);
part6.setTextureSize(64, 64);
part6.mirror=true;
setRotation(part6, 0F, 0F, 0F);
part7=new ModelRenderer(this, 8, 0);
part7.addBox(-8F, -8F, 0F, 2, 2, 12);
part7.setRotationPoint(0F, 16F, -6F);
part7.setTextureSize(64, 64);
part7.mirror=true;
setRotation(part7, 0F, 0F, 0F);
part8=new ModelRenderer(this, 8, 0);
part8.addBox(-8F, 6F, -6F, 2, 2, 12);
part8.setRotationPoint(0F, 16F, 0F);
part8.setTextureSize(64, 64);
part8.mirror=true;
setRotation(part8, 0F, 0F, 0F);
part9=new ModelRenderer(this, 8, 14);
part9.addBox(-6F, 6F, -8F, 12, 2, 2);
part9.setRotationPoint(0F, 16F, 0F);
part9.setTextureSize(64, 64);
part9.mirror=true;
setRotation(part9, 0F, 0F, 0F);
part10=new ModelRenderer(this, 8, 14);
part10.addBox(-6F, -8F, -8F, 12, 2, 2);
part10.setRotationPoint(0F, 16F, 0F);
part10.setTextureSize(64, 64);
part10.mirror=true;
setRotation(part10, 0F, 0F, 0F);
part11=new ModelRenderer(this, 8, 14);
part11.addBox(-6F, 6F, 6F, 12, 2, 2);
part11.setRotationPoint(0F, 16F, 0F);
part11.setTextureSize(64, 64);
part11.mirror=true;
setRotation(part11, 0F, 0F, 0F);
part12=new ModelRenderer(this, 8, 14);
part12.addBox(-6F, -8F, 6F, 12, 2, 2);
part12.setRotationPoint(0F, 16F, 0F);
part12.setTextureSize(64, 64);
part12.mirror=true;
setRotation(part12, 0F, 0F, 0F);
}

public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
super.render(entity, f, f1, f2, f3, f4, f5);
setRotationAngles(f, f1, f2, f3, f4, f5, entity);
partlamp.render(f5);
part1.render(f5);
part2.render(f5);
part3.render(f5);
part4.render(f5);
part5.render(f5);
part6.render(f5);
part7.render(f5);
part8.render(f5);
part9.render(f5);
part10.render(f5);
part11.render(f5);
part12.render(f5);
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
partlamp.render(0.0625F);
part1.render(0.0625F);
part2.render(0.0625F);
part3.render(0.0625F);
part4.render(0.0625F);
part5.render(0.0625F);
part6.render(0.0625F);
part7.render(0.0625F);
part8.render(0.0625F);
part9.render(0.0625F);
part10.render(0.0625F);
part11.render(0.0625F);
part12.render(0.0625F);
}

}
