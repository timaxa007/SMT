package smt.pack.decorative.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;


public class ModelArmorTest extends ModelBase {

	ModelRenderer
	head,
	body,
	rightarm,
	leftarm,
	rightleg,
	leftleg,
	bacjpack,
	left_e,
	right_e;

	public ModelArmorTest() {
		textureWidth = 64;
		textureHeight = 32;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4F, -8F, -4F, 8, 8, 8);
		head.setRotationPoint(0F, 0F, 0F);
		head.setTextureSize(64, 32);
		head.mirror = true;
		setRotation(head, 0F, 0F, 0F);
		body = new ModelRenderer(this, 16, 16);
		body.addBox(-4F, 0F, -2F, 8, 12, 4);
		body.setRotationPoint(0F, 0F, 0F);
		body.setTextureSize(64, 32);
		body.mirror = true;
		setRotation(body, 0F, 0F, 0F);
		rightarm = new ModelRenderer(this, 40, 16);
		rightarm.addBox(-3F, -2F, -2F, 4, 12, 4);
		rightarm.setRotationPoint(-5F, 2F, 0F);
		rightarm.setTextureSize(64, 32);
		rightarm.mirror = true;
		setRotation(rightarm, 0F, 0F, 0F);
		leftarm = new ModelRenderer(this, 40, 16);
		leftarm.addBox(-1F, -2F, -2F, 4, 12, 4);
		leftarm.setRotationPoint(5F, 2F, 0F);
		leftarm.setTextureSize(64, 32);
		leftarm.mirror = true;
		setRotation(leftarm, 0F, 0F, 0F);
		rightleg = new ModelRenderer(this, 0, 16);
		rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
		rightleg.setRotationPoint(-2F, 12F, 0F);
		rightleg.setTextureSize(64, 32);
		rightleg.mirror = true;
		setRotation(rightleg, 0F, 0F, 0F);
		leftleg = new ModelRenderer(this, 0, 16);
		leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
		leftleg.setRotationPoint(2F, 12F, 0F);
		leftleg.setTextureSize(64, 32);
		leftleg.mirror = true;
		setRotation(leftleg, 0F, 0F, 0F);
		bacjpack = new ModelRenderer(this, 0, 0);
		bacjpack.addBox(-4F, -4F, 0F, 8, 8, 8);
		bacjpack.setRotationPoint(0F, 6F, 2F);
		bacjpack.setTextureSize(64, 32);
		bacjpack.mirror = true;
		setRotation(bacjpack, 0F, 0F, 0F);
		left_e = new ModelRenderer(this, 32, 0);
		left_e.addBox(-1F, -1F, -1F, 2, 2, 2);
		left_e.setRotationPoint(4F, -8F, -4F);
		left_e.setTextureSize(64, 32);
		left_e.mirror = true;
		setRotation(left_e, 0F, 0F, 0F);
		right_e.mirror = true;
		right_e = new ModelRenderer(this, 32, 0);
		right_e.addBox(-1F, -1F, -1F, 2, 2, 2);
		right_e.setRotationPoint(-4F, -8F, -4F);
		right_e.setTextureSize(64, 32);
		right_e.mirror = true;
		setRotation(right_e, 0F, 0F, 0F);
		right_e.mirror = false;
	}

	public void render(Entity entity, float x, float y, float z, float yaw, float pitch, float parTicks) {
		super.render(entity, x, y, z, yaw, pitch, parTicks);
		setRotationAngles(x, y, z, yaw, pitch, parTicks, entity);
		head.render(parTicks);
		body.render(parTicks);
		rightarm.render(parTicks);
		leftarm.render(parTicks);
		rightleg.render(parTicks);
		leftleg.render(parTicks);
		bacjpack.render(parTicks);
		left_e.render(parTicks);
		right_e.render(parTicks);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

}
