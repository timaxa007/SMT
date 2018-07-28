package smt.pack.decorative.client.model;

import java.util.ArrayList;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelHatWitch extends ModelBiped {

	ModelRenderer
	Shape1,
	Shape2,
	Shape3,
	Shape4,
	Shape5,
	Shape6,
	Shape7,
	Shape8,
	Shape9,
	Shape10,
	Shape11,
	Shape12,
	Shape13;

	private ArrayList<ModelRenderer> modelList = new ArrayList<ModelRenderer>();

	public ModelHatWitch() {

		textureWidth = 57;
		textureHeight = 41;

		Shape1 = new ModelRenderer(this, 0, 0);
		Shape1.addBox(-7F, -7F, -7F, 14, 1, 14);
		Shape1.setRotationPoint(0F, 0F, 0F);
		Shape1.setTextureSize(57, 41);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F);
		modelList.add(Shape1);

		Shape2 = new ModelRenderer(this, 0, 15);
		Shape2.addBox(-5F, -10F, -5F, 10, 3, 10);
		Shape2.setRotationPoint(0F, 0F, 0F);
		Shape2.setTextureSize(57, 41);
		Shape2.mirror = true;
		setRotation(Shape2, 0F, 0F, 0F);
		modelList.add(Shape2);

		Shape3 = new ModelRenderer(this, 0, 28);
		Shape3.addBox(-3F, -14F, 1F, 6, 6, 6);
		Shape3.setRotationPoint(0F, 0F, 0F);
		Shape3.setTextureSize(57, 41);
		Shape3.mirror = true;
		setRotation(Shape3, 0.4F, 0F, 0F);
		modelList.add(Shape3);

		Shape4 = new ModelRenderer(this, 40, 15);
		Shape4.addBox(-1.5F, -16F, 7F, 3, 5, 3);
		Shape4.setRotationPoint(0F, 0F, 0F);
		Shape4.setTextureSize(57, 41);
		Shape4.mirror = true;
		setRotation(Shape4, 0.7333333F, 0F, 0F);
		modelList.add(Shape4);

		Shape5 = new ModelRenderer(this, 43, 23);
		Shape5.addBox(-1.5F, -12F, 6.8F, 3, 4, 0);
		Shape5.setRotationPoint(0F, 0F, 0F);
		Shape5.setTextureSize(57, 41);
		Shape5.mirror = true;
		setRotation(Shape5, 0.35F, 0F, 0F);
		modelList.add(Shape5);

		Shape6 = new ModelRenderer(this, 27, 31);
		Shape6.addBox(-3.5F, -11F, 6.8F, 7, 2, 0);
		Shape6.setRotationPoint(0F, 0F, 0F);
		Shape6.setTextureSize(57, 41);
		Shape6.mirror = true;
		setRotation(Shape6, 0.35F, 0F, 0F);
		modelList.add(Shape6);

		Shape7 = new ModelRenderer(this, 27, 34);
		Shape7.addBox(-3.5F, -12.26667F, 0F, 7, 2, 0);
		Shape7.setRotationPoint(0F, 0F, 0F);
		Shape7.setTextureSize(57, 41);
		Shape7.mirror = true;
		setRotation(Shape7, 0.35F, 0F, 0F);
		modelList.add(Shape7);

		Shape8 = new ModelRenderer(this, 27, 31);
		Shape8.addBox(-3.5F, -12.3F, 0F, 0, 2, 3);
		Shape8.setRotationPoint(0F, 0F, 0F);
		Shape8.setTextureSize(57, 41);
		Shape8.mirror = true;
		setRotation(Shape8, 0.35F, 0F, 0F);
		modelList.add(Shape8);

		Shape9 = new ModelRenderer(this, 27, 31);
		Shape9.addBox(3.5F, -12.3F, 0F, 0, 2, 3);
		Shape9.setRotationPoint(0F, 0F, 0F);
		Shape9.setTextureSize(57, 41);
		Shape9.mirror = true;
		setRotation(Shape9, 0.35F, 0F, 0F);
		modelList.add(Shape9);

		Shape10 = new ModelRenderer(this, 28, 34);
		Shape10.addBox(-3.5F, -11F, 4.8F, 0, 2, 2);
		Shape10.setRotationPoint(0F, 0F, 0F);
		Shape10.setTextureSize(57, 41);
		Shape10.mirror = true;
		setRotation(Shape10, 0.35F, 0F, 0F);
		modelList.add(Shape10);

		Shape11 = new ModelRenderer(this, 28, 34);
		Shape11.addBox(3.5F, -11F, 4.8F, 0, 2, 2);
		Shape11.setRotationPoint(0F, 0F, 0F);
		Shape11.setTextureSize(57, 41);
		Shape11.mirror = true;
		setRotation(Shape11, 0.35F, 0F, 0F);
		modelList.add(Shape11);

		Shape12 = new ModelRenderer(this, 28, 34);
		Shape12.addBox(3.5F, -12.5F, -2.3F, 0, 2, 4);
		Shape12.setRotationPoint(0F, 0F, 0F);
		Shape12.setTextureSize(57, 41);
		Shape12.mirror = true;
		setRotation(Shape12, -0.05F, 0F, 0F);
		modelList.add(Shape12);

		Shape13 = new ModelRenderer(this, 28, 34);
		Shape13.addBox(-3.5F, -12.5F, -2.3F, 0, 2, 4);
		Shape13.setRotationPoint(0F, 0F, 0F);
		Shape13.setTextureSize(57, 41);
		Shape13.mirror = true;
		setRotation(Shape13, -0.05F, 0F, 0F);
		modelList.add(Shape13);

		bipedHead.addChild(Shape1);
		bipedHead.addChild(Shape2);
		bipedHead.addChild(Shape3);
		bipedHead.addChild(Shape4);
		bipedHead.addChild(Shape5);
		bipedHead.addChild(Shape6);
		bipedHead.addChild(Shape7);
		bipedHead.addChild(Shape8);
		bipedHead.addChild(Shape9);
		bipedHead.addChild(Shape10);
		bipedHead.addChild(Shape11);
		bipedHead.addChild(Shape12);
		bipedHead.addChild(Shape13);

	}

	public void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void render(Entity entity, float x, float y, float z, float yaw, float pitch, float parTicks) {
		super.render(entity, x, y, z, yaw, pitch, parTicks);
		setRotationAngles(x, y, z, yaw, pitch, parTicks, entity);
		Shape1.render(parTicks);
		Shape2.render(parTicks);
		Shape3.render(parTicks);
		Shape4.render(parTicks);
		Shape5.render(parTicks);
		Shape6.render(parTicks);
		Shape7.render(parTicks);
		Shape8.render(parTicks);
		Shape9.render(parTicks);
		Shape10.render(parTicks);
		Shape11.render(parTicks);
		Shape12.render(parTicks);
		Shape13.render(parTicks);
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);

		for (ModelRenderer modelRenderer : modelList)
			modelRenderer.rotationPointY += bipedHead.rotationPointY / 2F;

		for (ModelRenderer modelRenderer : modelList)
			modelRenderer.rotateAngleX += bipedHead.rotateAngleX / 2F;

		for (ModelRenderer modelRenderer : modelList)
			modelRenderer.rotateAngleY += bipedHead.rotateAngleY / 2F;

	}

}
