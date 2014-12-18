package mods.timaxa007.pack.furniture.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class ModelArmorMedieval extends ModelBiped {

	private static final IModelCustom model_armor_medieval = AdvancedModelLoader.loadModel(new ResourceLocation("timaxa007", "obj/armor_medieval.obj"));
	int render_type_id;
	int render_type_armor;
	int render_type_color;

	public ModelArmorMedieval() {
		textureWidth = 16;
		textureHeight = 16;
		render_type_id = -1;
		render_type_armor = 0;
		render_type_color = 0xFFFFFF;
	}

	public ModelArmorMedieval(int i) {
		textureWidth = 16;
		textureHeight = 16;
		render_type_id = -1;
		render_type_armor = i;
		render_type_color = 0xFFFFFF;
	}

	public ModelArmorMedieval(int i, int a) {
		textureWidth = 16;
		textureHeight = 16;
		render_type_id = i;
		render_type_armor = a;
		render_type_color = 0xFFFFFF;
	}

	public ModelArmorMedieval(int i, int a, int c) {
		textureWidth = 16;
		textureHeight = 16;
		render_type_id = i;
		render_type_armor = a;
		render_type_color = c;
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		/*
		float red = (float)(render_type_color >> 16 & 255) / 255.0F;
		float green = (float)(render_type_color >> 8 & 255) / 255.0F;
		float blue = (float)(render_type_color >> 0 & 255) / 255.0F;
		GL11.glColor3f(red, green, blue);
		 */
		//-----------------------------------------------------------------------------------------------------------------------
		if (render_type_armor == 0) {
			GL11.glPushMatrix();
			//GL11.glEnable(GL11.GL_BLEND);
			//GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			GL11.glTranslatef(0.0F, 1.5F, 0.0F);
			GL11.glRotatef(90F, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(bipedHead.rotateAngleY, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(bipedHead.rotateAngleX, 0.0F, 0.0F, 1.0F);
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("minecraft", "textures/blocks/planks_oak.png"));
			model_armor_medieval.renderPart("helm");
			model_armor_medieval.renderPart("shield_down");
			model_armor_medieval.renderPart("shield_up");
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			//GL11.glDisable(GL11.GL_BLEND);
			GL11.glPopMatrix();
		}
		//-----------------------------------------------------------------------------------------------------------------------
		if (render_type_armor == 1) {
			GL11.glPushMatrix();
			//GL11.glEnable(GL11.GL_BLEND);
			//GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			GL11.glTranslatef(0.0F, 1.5F, 0.0F);
			GL11.glRotatef(90F, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(0.0F, isSneak?0.65F:0.0F, isSneak?0.12F:0.0F);
			GL11.glRotatef(isSneak?25F:0F, 1.0F, 0.0F, 0.0F);
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("minecraft", "textures/blocks/planks_oak.png"));
			model_armor_medieval.renderPart("chest");
			model_armor_medieval.renderPart("chest_side");
			model_armor_medieval.renderPart("chest_up");
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			//GL11.glDisable(GL11.GL_BLEND);
			GL11.glPopMatrix();
			//-------------------------------------------------
			GL11.glPushMatrix();
			//GL11.glEnable(GL11.GL_BLEND);
			//GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			GL11.glTranslatef(0.0F, 1.5F, 0.0F);
			GL11.glRotatef(90F, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(0.0F, isSneak?0.55F:0.0F, isSneak?0.15F:0.0F);
			GL11.glRotatef(isSneak?25F:0F, 1.0F, 0.0F, 0.0F);
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("minecraft", "textures/blocks/planks_oak.png"));
			//model_armor_medieval.renderPart("left_shoulders");
			model_armor_medieval.renderPart("left_shoulders_big");
			model_armor_medieval.renderPart("left_sleeves");
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			//GL11.glDisable(GL11.GL_BLEND);
			GL11.glPopMatrix();
			//-------------------------------------------------
			GL11.glPushMatrix();
			//GL11.glEnable(GL11.GL_BLEND);
			//GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			GL11.glTranslatef(0.0F, 1.5F, 0.0F);
			GL11.glRotatef(90F, 1.0F, 0.0F, 0.0F);
			//GL11.glTranslatef(0.0F, isSneak?0.55F:0.0F, isSneak?0.15F:0.0F);
			//GL11.glRotatef(isSneak?25F:0F, 1.0F, 0.0F, 0.0F);
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("minecraft", "textures/blocks/planks_oak.png"));
			//model_armor_medieval.renderPart("right_shoulders");
			model_armor_medieval.renderPart("right_shoulders_big");
			model_armor_medieval.renderPart("right_sleeves");
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			//GL11.glDisable(GL11.GL_BLEND);
			GL11.glPopMatrix();
		}
		//-----------------------------------------------------------------------------------------------------------------------
		if (render_type_armor == 2) {
			GL11.glPushMatrix();
			//GL11.glEnable(GL11.GL_BLEND);
			//GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			GL11.glTranslatef(0.0F, 1.5F, 0.0F);
			GL11.glRotatef(90F, 1.0F, 0.0F, 0.0F);
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("minecraft", "textures/blocks/planks_oak.png"));
			model_armor_medieval.renderPart("left_leggin");
			model_armor_medieval.renderPart("right_leggin");
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			//GL11.glDisable(GL11.GL_BLEND);
			GL11.glPopMatrix();
		}
		//-----------------------------------------------------------------------------------------------------------------------
		if (render_type_armor == 3) {
			GL11.glPushMatrix();
			//GL11.glEnable(GL11.GL_BLEND);
			//GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			GL11.glTranslatef(0.0F, 1.5F, 0.0F);
			GL11.glRotatef(90F, 1.0F, 0.0F, 0.0F);
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("minecraft", "textures/blocks/planks_oak.png"));
			model_armor_medieval.renderPart("left_boot");
			model_armor_medieval.renderPart("right_boot");
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			//GL11.glDisable(GL11.GL_BLEND);
			GL11.glPopMatrix();
		}
		//-----------------------------------------------------------------------------------------------------------------------
	}

}
