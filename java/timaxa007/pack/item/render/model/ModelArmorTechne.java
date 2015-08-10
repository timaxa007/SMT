package timaxa007.pack.item.render.model;

import java.util.ArrayList;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

//‘ормы и размеры обычного игрока (без второго сло€)
public class ModelArmorTechne extends ModelBiped {

	private static ModelRenderer armor_helmet;
	private static ModelRenderer armor_chest;
	private static ModelRenderer armor_sleeve_right;
	private static ModelRenderer armor_sleeve_left;
	private static ModelRenderer armor_pants_right;
	private static ModelRenderer armor_pants_left;

	private static ArrayList<ModelRenderer> modelList;

	public ModelArmorTechne() {

		textureWidth = 64;
		textureHeight = 32;

		modelList = new ArrayList<ModelRenderer>();

		armor_helmet = new ModelRenderer(this, 0, 0);
		armor_helmet.addBox(-4F, -8F, -4F, 8, 8, 8);
		armor_helmet.setRotationPoint(0F, 0F, 0F);
		armor_helmet.setTextureSize(64, 32);
		armor_helmet.mirror = true;
		setRotation(armor_helmet, 0F, 0F, 0F);
		modelList.add(armor_helmet);

		armor_chest = new ModelRenderer(this, 16, 16);
		armor_chest.addBox(-4F, 0F, -2F, 8, 12, 4);
		armor_chest.setRotationPoint(0F, 0F, 0F);
		armor_chest.setTextureSize(64, 32);
		armor_chest.mirror = true;
		setRotation(armor_chest, 0F, 0F, 0F);
		modelList.add(armor_chest);

		armor_sleeve_right = new ModelRenderer(this, 40, 16);
		armor_sleeve_right.addBox(-3F, -2F, -2F, 4, 12, 4);
		armor_sleeve_right.setRotationPoint(-5F, 2F, 0F);
		armor_sleeve_right.setTextureSize(64, 32);
		armor_sleeve_right.mirror = true;
		setRotation(armor_sleeve_right, 0F, 0F, 0F);
		modelList.add(armor_sleeve_right);

		armor_sleeve_left = new ModelRenderer(this, 40, 16);
		armor_sleeve_left.addBox(-1F, -2F, -2F, 4, 12, 4);
		armor_sleeve_left.setRotationPoint(5F, 2F, 0F);
		armor_sleeve_left.setTextureSize(64, 32);
		armor_sleeve_left.mirror = true;
		setRotation(armor_sleeve_left, 0F, 0F, 0F);
		modelList.add(armor_sleeve_left);

		armor_pants_right = new ModelRenderer(this, 0, 16);
		armor_pants_right.addBox(-2F, 0F, -2F, 4, 12, 4);
		armor_pants_right.setRotationPoint(-2F, 12F, 0F);
		armor_pants_right.setTextureSize(64, 32);
		armor_pants_right.mirror = true;
		setRotation(armor_pants_right, 0F, 0F, 0F);
		modelList.add(armor_pants_right);

		armor_pants_left = new ModelRenderer(this, 0, 16);
		armor_pants_left.addBox(-2F, 0F, -2F, 4, 12, 4);
		armor_pants_left.setRotationPoint(2F, 12F, 0F);
		armor_pants_left.setTextureSize(64, 32);
		armor_pants_left.mirror = true;
		setRotation(armor_pants_left, 0F, 0F, 0F);
		modelList.add(armor_pants_left);

	}

	private static void setRotationAngleX(float angle) {
		for (ModelRenderer modelRenderer : modelList) modelRenderer.rotateAngleX = angle;
	}

	private static void setRotationAngleY(float angle) {
		for (ModelRenderer modelRenderer : modelList) modelRenderer.rotateAngleY = angle;
	}

	private static void setRotationPointY(float par) {
		for (ModelRenderer modelRenderer : modelList) modelRenderer.rotationPointY = par;
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		armor_helmet.render(f5);
		armor_chest.render(f5);
		armor_sleeve_right.render(f5);
		armor_sleeve_left.render(f5);
		armor_pants_right.render(f5);
		armor_pants_left.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);

		setRotationAngleY(f3 / (180F / (float)Math.PI));
		setRotationAngleX(f4 / (180F / (float)Math.PI));

		if (isSneak) setRotationPointY(1.0F); else setRotationPointY(0.0F);

	}

}
