package mods.timaxa007.pack.weapon.render.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelClaymoreStick extends ModelBase {

	ModelRenderer box;
	ModelRenderer stick1;
	ModelRenderer stick2;
	ModelRenderer stick3;
	ModelRenderer stick4;

	public ModelClaymoreStick() {
		textureWidth=32;
		textureHeight=16;

		box = new ModelRenderer(this, 0, 0);
		box.addBox(-5F, -5F, -1F, 10, 5, 3);
		box.setRotationPoint(0F, 20F, 0F);
		box.setTextureSize(32, 16);
		box.mirror = true;
		setRotation(box, 0F, 0F, 0F);

		stick1 = new ModelRenderer(this, 26, 0);
		stick1.addBox(0F, 0F, 0F, 1, 5, 1);
		stick1.setRotationPoint(3F, 20F, 0.75F);
		stick1.setTextureSize(32, 16);
		stick1.mirror = true;
		setRotation(stick1, 0.4363323F, 0F, 0F);

		stick2 = new ModelRenderer(this, 26, 0);
		stick2.addBox(-1F, 0F, 0F, 1, 5, 1);
		stick2.setRotationPoint(-3F, 20F, 0.75F);
		stick2.setTextureSize(32, 16);
		stick2.mirror = true;
		setRotation(stick2, 0.4363323F, 0F, 0F);

		stick3 = new ModelRenderer(this, 26, 0);
		stick3.addBox(0F, 0F, -1F, 1, 5, 1);
		stick3.setRotationPoint(3F, 20F, 0.25F);
		stick3.setTextureSize(32, 16);
		stick3.mirror = true;
		setRotation(stick3, -0.4363323F, 0F, 0F);

		stick4 = new ModelRenderer(this, 26, 0);
		stick4.addBox(-1F, 0F, -1F, 1, 5, 1);
		stick4.setRotationPoint(-3F, 20F, 0.25F);
		stick4.setTextureSize(32, 16);
		stick4.mirror = true;
		setRotation(stick4, -0.4363323F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		box.render(f5);
		stick1.render(f5);
		stick2.render(f5);
		stick3.render(f5);
		stick4.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
		setRotationAngles(f, f1, f2, f3, f4, f5);
	}

	public void render() {
		box.render(0.0625F);
		stick1.render(0.0625F);
		stick2.render(0.0625F);
		stick3.render(0.0625F);
		stick4.render(0.0625F);
	}

}
