package timaxa007.pack.stock.render.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

@Deprecated
public class ModelPiePar extends ModelBase {

	ModelRenderer part1;

	@Deprecated
	public ModelPiePar() {
		textureWidth = 32;
		textureHeight = 16;

		part1 = new ModelRenderer(this, 0, 0);
		part1.addBox(0F, 0F, 0F, 5, 3, 5);
		part1.setRotationPoint(0F, 21F, 0F);
		part1.setTextureSize(32, 16);
		part1.mirror = true;
		setRotation(part1, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		part1.render(f5);
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
		part1.render(0.0625F);
	}

}