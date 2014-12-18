package mods.timaxa007.pack.furniture.model;

import mods.timaxa007.pack.stock.rb.RenderBlockApiary;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class ModelBackpacks extends ModelBiped {

	public ModelBackpacks(int i) {
	}

	public void render(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		super.render(entity, par2, par3, par4, par5, par6, par7);

		double s_p = (double) 1 / 16;
		int i_x = 4;
		int i_y = 4;
		double s_x = (double)(1.0D / i_x);
		double s_y = (double)(1.0D / i_y);

		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_LIGHTING);
		//GL11.glTranslated(dx, dy, dz);

		GL11.glTranslated(-0.5F, 0.8F, 1.125F);
		GL11.glRotatef(180.0F, 1, 0, 0);

		GL11.glTranslated(0.0F, isSneak?0.5F:0.0F, isSneak?-0.3F:0.0F);
		GL11.glRotatef(isSneak?25.0F:0.0F, 1, 0, 0);

		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("timaxa007", "textures/obj/apiary.png"));
		RenderBlockApiary.renderApiary(s_x, s_y);

		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glPopMatrix();

	}

}
