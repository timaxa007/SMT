package timaxa007.pack.item.render.model;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

@Deprecated
public class ModelNewArmor extends ModelBiped {
	private static ModelRenderer helmUp;
	private static ModelRenderer helmLeft;
	private static ModelRenderer helmRight;
	private static ModelRenderer helmBack;

	private static ModelRenderer bodyBack;
	private static ModelRenderer bodyFront;

	private static ModelRenderer legginLeft;
	private static ModelRenderer legginRight;

	private static ModelRenderer bootLeft;
	private static ModelRenderer bootRight;

	private int r_t;

	public ModelNewArmor(int i) {
		textureWidth = 64;
		textureHeight = 32;
		r_t = i;

		if (i == 0) {
			helmUp = new ModelRenderer(this, 0, 0);
			helmUp.addBox(-5F, 0F, -5F, 10, 1, 10);
			helmUp.setRotationPoint(0F, -9F, 0F);
			helmUp.setTextureSize(64, 32);
			helmUp.mirror = true;
			setRotation(helmUp, 0F, 0F, 0F);
			helmLeft = new ModelRenderer(this, 0, 0);
			helmLeft.addBox(0F, 0F, -5F, 1, 8, 10);
			helmLeft.setRotationPoint(4F, -8F, 0F);
			helmLeft.setTextureSize(64, 32);
			helmLeft.mirror = true;
			setRotation(helmLeft, 0F, 0F, 0F);
			helmRight = new ModelRenderer(this, 0, 0);
			helmRight.addBox(-1F, 0F, -5F, 1, 8, 10);
			helmRight.setRotationPoint(-4F, -8F, 0F);
			helmRight.setTextureSize(64, 32);
			helmRight.mirror = true;
			setRotation(helmRight, 0F, 0F, 0F);
			helmBack = new ModelRenderer(this, 0, 0);
			helmBack.addBox(-4F, 0F, 0F, 8, 8, 1);
			helmBack.setRotationPoint(0F, -8F, 4F);
			helmBack.setTextureSize(64, 32);
			helmBack.mirror = true;
			setRotation(helmBack, 0F, 0F, 0F);

			//helmUp.addChild(bipedHead);
			//helmLeft.addChild(bipedHead);
			//helmRight.addChild(bipedHead);
			//helmBack.addChild(bipedHead);
		}

		if (i == 1) {
			bodyBack = new ModelRenderer(this, 0, 0);
			bodyBack.addBox(-4F, 0F, 0F, 8, 12, 1);
			bodyBack.setRotationPoint(0F, 0F, 2F);
			bodyBack.setTextureSize(64, 32);
			bodyBack.mirror = true;
			setRotation(bodyBack, 0F, 0F, 0F);
			bodyFront = new ModelRenderer(this, 0, 0);
			bodyFront.addBox(-4F, 0F, -1F, 8, 12, 1);
			bodyFront.setRotationPoint(0F, 0F, -2F);
			bodyFront.setTextureSize(64, 32);
			bodyFront.mirror = true;
			setRotation(bodyFront, 0F, 0F, 0F);

			//bodyBack.addChild(bipedBody);
			//bodyFront.addChild(bipedBody);

		}

		if (i == 2) {
			legginLeft = new ModelRenderer(this, 0, 0);
			legginLeft.addBox(-2F, 0F, -1F, 4, 8, 1);
			legginLeft.setRotationPoint(2F, 12F, -2F);
			legginLeft.setTextureSize(64, 32);
			legginLeft.mirror = true;
			setRotation(legginLeft, 0F, 0F, 0F);
			legginRight = new ModelRenderer(this, 0, 0);
			legginRight.addBox(-2F, 0F, -1F, 4, 8, 1);
			legginRight.setRotationPoint(-2F, 12F, -2F);
			legginRight.setTextureSize(64, 32);
			legginRight.mirror = true;
			setRotation(legginRight, 0F, 0F, 0F);

			//legginLeft.addChild(bipedLeftLeg);
			//legginRight.addChild(bipedRightLeg);

		}

		if (i == 3) {
			bootLeft = new ModelRenderer(this, 0, 0);
			bootLeft.addBox(-2F, 0F, -2F, 4, 4, 4);
			bootLeft.setRotationPoint(2F, 20F, 0F);
			bootLeft.setTextureSize(64, 32);
			bootLeft.mirror = true;
			setRotation(bootLeft, 0F, 0F, 0F);
			bootRight = new ModelRenderer(this, 0, 0);
			bootRight.addBox(-2F, 0F, -2F, 4, 4, 4);
			bootRight.setRotationPoint(-2F, 20F, 0F);
			bootRight.setTextureSize(64, 32);
			bootRight.mirror = true;
			setRotation(bootRight, 0F, 0F, 0F);

			//bootLeft.addChild(bipedLeftLeg);
			//bootRight.addChild(bipedRightLeg);

		}

	}

	public ModelNewArmor() {
		textureWidth = 64;
		textureHeight = 32;
		r_t = -1;

		helmUp = new ModelRenderer(this, 0, 0);
		helmUp.addBox(-5F, 0F, -5F, 10, 1, 10);
		helmUp.setRotationPoint(0F, -9F, 0F);
		helmUp.setTextureSize(64, 32);
		helmUp.mirror = true;
		setRotation(helmUp, 0F, 0F, 0F);
		helmLeft = new ModelRenderer(this, 0, 0);
		helmLeft.addBox(0F, 0F, -5F, 1, 8, 10);
		helmLeft.setRotationPoint(4F, -8F, 0F);
		helmLeft.setTextureSize(64, 32);
		helmLeft.mirror = true;
		setRotation(helmLeft, 0F, 0F, 0F);
		helmRight = new ModelRenderer(this, 0, 0);
		helmRight.addBox(-1F, 0F, -5F, 1, 8, 10);
		helmRight.setRotationPoint(-4F, -8F, 0F);
		helmRight.setTextureSize(64, 32);
		helmRight.mirror = true;
		setRotation(helmRight, 0F, 0F, 0F);
		helmBack = new ModelRenderer(this, 0, 0);
		helmBack.addBox(-4F, 0F, 0F, 8, 8, 1);
		helmBack.setRotationPoint(0F, -8F, 4F);
		helmBack.setTextureSize(64, 32);
		helmBack.mirror = true;
		setRotation(helmBack, 0F, 0F, 0F);

		bodyBack = new ModelRenderer(this, 0, 0);
		bodyBack.addBox(-4F, 0F, 0F, 8, 12, 1);
		bodyBack.setRotationPoint(0F, 0F, 2F);
		bodyBack.setTextureSize(64, 32);
		bodyBack.mirror = true;
		setRotation(bodyBack, 0F, 0F, 0F);
		bodyFront = new ModelRenderer(this, 0, 0);
		bodyFront.addBox(-4F, 0F, -1F, 8, 12, 1);
		bodyFront.setRotationPoint(0F, 0F, -2F);
		bodyFront.setTextureSize(64, 32);
		bodyFront.mirror = true;
		setRotation(bodyFront, 0F, 0F, 0F);

		legginLeft = new ModelRenderer(this, 0, 0);
		legginLeft.addBox(-2F, 0F, -1F, 4, 8, 1);
		legginLeft.setRotationPoint(2F, 12F, -2F);
		legginLeft.setTextureSize(64, 32);
		legginLeft.mirror = true;
		setRotation(legginLeft, 0F, 0F, 0F);
		legginRight = new ModelRenderer(this, 0, 0);
		legginRight.addBox(-2F, 0F, -1F, 4, 8, 1);
		legginRight.setRotationPoint(-2F, 12F, -2F);
		legginRight.setTextureSize(64, 32);
		legginRight.mirror = true;
		setRotation(legginRight, 0F, 0F, 0F);

		bootLeft = new ModelRenderer(this, 0, 0);
		bootLeft.addBox(-2F, 0F, -2F, 4, 4, 4);
		bootLeft.setRotationPoint(2F, 20F, 0F);
		bootLeft.setTextureSize(64, 32);
		bootLeft.mirror = true;
		setRotation(bootLeft, 0F, 0F, 0F);
		bootRight = new ModelRenderer(this, 0, 0);
		bootRight.addBox(-2F, 0F, -2F, 4, 4, 4);
		bootRight.setRotationPoint(-2F, 20F, 0F);
		bootRight.setTextureSize(64, 32);
		bootRight.mirror = true;
		setRotation(bootRight, 0F, 0F, 0F);
		/*
		helmUp.addChild(bipedHead);
		helmLeft.addChild(bipedHead);
		helmRight.addChild(bipedHead);
		helmBack.addChild(bipedHead);
		
		bodyBack.addChild(bipedBody);
		bodyFront.addChild(bipedBody);
		
		legginLeft.addChild(bipedLeftLeg);
		legginRight.addChild(bipedRightLeg);
		
		bootLeft.addChild(bipedLeftLeg);
		bootRight.addChild(bipedRightLeg);
		 */
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);

		if (r_t == 0 || r_t == -1) {
			helmUp.render(f5);
			helmLeft.render(f5);
			helmRight.render(f5);
			helmBack.render(f5);
		}

		if (r_t == 1 || r_t == -1) {
			bodyBack.render(f5);
			bodyFront.render(f5);
		}

		if (r_t == 2 || r_t == -1) {
			legginLeft.render(f5);
			legginRight.render(f5);
		}

		if (r_t == 3 || r_t == -1) {
			bootLeft.render(f5);
			bootRight.render(f5);
		}

	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;model.rotateAngleY = y;model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {

		if (r_t == 0 || r_t == -1) {

			helmUp.rotateAngleY = f3 / (180F / (float)Math.PI);
			helmUp.rotateAngleX = f4 / (180F / (float)Math.PI);

			helmLeft.rotateAngleY = f3 / (180F / (float)Math.PI);
			helmLeft.rotateAngleX = f4 / (180F / (float)Math.PI);

			helmRight.rotateAngleY = f3 / (180F / (float)Math.PI);
			helmRight.rotateAngleX = f4 / (180F / (float)Math.PI);

			helmBack.rotateAngleY = f3 / (180F / (float)Math.PI);
			helmBack.rotateAngleX = f4 / (180F / (float)Math.PI);

			if (isSneak) {
				helmUp.rotationPointY = -5.0F;
				helmLeft.rotationPointY = -5.0F;
				helmRight.rotationPointY = -5.0F;
				helmBack.rotationPointY = -5.0F;
			} else {
				helmUp.rotationPointY = -8.0F;
				helmLeft.rotationPointY = -8.0F;
				helmRight.rotationPointY = -8.0F;
				helmBack.rotationPointY = -8.0F;
			}

		}

		if (r_t == 1 || r_t == -1) {
			float f6;
			float f7;

			if (onGround > -9990.0F) {
				f6 = onGround;
				bodyBack.rotateAngleY = MathHelper.sin(MathHelper.sqrt_float(f6) * (float)Math.PI * 2.0F) * 0.2F;
				bodyFront.rotateAngleY = MathHelper.sin(MathHelper.sqrt_float(f6) * (float)Math.PI * 2.0F) * 0.2F;
				f6 = 1.0F - onGround;
				f6 *= f6;
				f6 *= f6;
				f6 = 1.0F - f6;
				f7 = MathHelper.sin(f6 * (float)Math.PI);
			}

			if (isSneak) {
				bodyBack.rotateAngleX = 0.5F;
				bodyBack.rotateAngleX = 0.5F;
			} else {
				bodyFront.rotateAngleX = 0.0F;
				bodyFront.rotateAngleX = 0.0F;
			}

		}

		if (r_t == 2 || r_t == -1) {
			legginRight.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
			legginRight.rotateAngleY = 0.0F;
			legginLeft.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
			legginLeft.rotateAngleY = 0.0F;

			if (isRiding) {
				legginRight.rotateAngleX = -((float)Math.PI * 2F / 5F);
				legginRight.rotateAngleY = ((float)Math.PI / 10F);
				legginLeft.rotateAngleX = -((float)Math.PI * 2F / 5F);
				legginLeft.rotateAngleY = -((float)Math.PI / 10F);
			}

			if (isSneak) {
				legginRight.rotationPointZ = 4.0F;
				legginRight.rotationPointY = 9.0F;
				legginLeft.rotationPointZ = 4.0F;
				legginLeft.rotationPointY = 9.0F;
			} else {
				legginRight.rotationPointZ = 0.1F;
				legginRight.rotationPointY = 12.0F;
				legginLeft.rotationPointZ = 0.1F;
				legginLeft.rotationPointY = 12.0F;
			}

		}

		if (r_t == 3 || r_t == -1) {
			bootRight.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
			bootRight.rotateAngleY = 0.0F;
			bootLeft.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
			bootLeft.rotateAngleY = 0.0F;

			if (isRiding) {
				bootRight.rotateAngleX = -((float)Math.PI * 2F / 5F);
				bootRight.rotateAngleY = ((float)Math.PI / 10F);
				bootLeft.rotateAngleX = -((float)Math.PI * 2F / 5F);
				bootLeft.rotateAngleY = -((float)Math.PI / 10F);
			}

			if (isSneak) {
				bootRight.rotationPointZ = 4.0F;
				bootRight.rotationPointY = 9.0F;
				bootLeft.rotationPointZ = 4.0F;
				bootLeft.rotationPointY = 9.0F;
			} else {
				bootRight.rotationPointZ = 0.1F;
				bootRight.rotationPointY = 12.0F;
				bootLeft.rotationPointZ = 0.1F;
				bootLeft.rotationPointY = 12.0F;
			}

		}


	}

}
