package timaxa007.pack.furniture.render.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

@Deprecated
public class ModelCandle extends ModelBase {
	private static ModelRenderer g_main;
	private static ModelRenderer f_main;

@Deprecated
	public ModelCandle() {
		textureWidth = 16;
		textureHeight = 8;

		g_main = new ModelRenderer(this, 0, 0);
		g_main.addBox(-1F, 0F, -1F, 3, 5, 3);
		g_main.setRotationPoint(0F, 18.53333F, 0F);
		g_main.setTextureSize(16, 8);
		g_main.mirror = true;
		setRotation(g_main, 0F, 0F, 0F);
		f_main = new ModelRenderer(this, 12, 0);
		f_main.addBox(0F, -2F, 0F, 1, 2, 1);
		f_main.setRotationPoint(0F, 19F, 0F);
		f_main.setTextureSize(16, 8);
		f_main.mirror = true;
		setRotation(f_main, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		g_main.render(f5);
		f_main.render(f5);
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
		g_main.render(0.0625F);
		f_main.render(0.0625F);
	}

}
