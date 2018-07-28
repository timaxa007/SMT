package smt.pack.magic.client;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class DragonEntityFX extends EntityFX {

	public DragonEntityFX(World world, double x, double y, double z) {
		super(world, x, y, z);
		particleMaxAge = 200;
	}

	public DragonEntityFX(World world, double x, double y, double z, double motionX, double motionY, double motionZ) {
		super(world, x, y, z, motionX, motionY, motionZ);
		particleMaxAge = 200;
	}

	public void renderParticle(Tessellator tessellator, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_) {
		tessellator.draw();

		float f11 = (float)(this.prevPosX + (this.posX - this.prevPosX) * (double)p_70539_2_ - interpPosX);
		float f12 = (float)(this.prevPosY + (this.posY - this.prevPosY) * (double)p_70539_2_ - interpPosY);
		float f13 = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * (double)p_70539_2_ - interpPosZ);


		RenderHelper.disableStandardItemLighting();
		float f1 = ((float)this.particleAge + p_70539_7_) / 200.0F;
		float f2 = 0.0F;

		if (f1 > 0.8F)
		{
			f2 = (f1 - 0.8F) / 0.2F;
		}

		Random random = new Random(432L);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glShadeModel(GL11.GL_SMOOTH);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
		GL11.glDisable(GL11.GL_ALPHA_TEST);
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glDepthMask(false);
		GL11.glPushMatrix();
		GL11.glTranslatef(f11 - (p_70539_3_ * p_70539_6_), f12 - (p_70539_4_ * p_70539_6_), f13 - (p_70539_5_ * p_70539_6_));
		GL11.glPushMatrix();
		GL11.glScalef(0.0625F, 0.0625F, 0.0625F);

		for (int i = 0; (float)i < (f1 + f1 * f1) / 2.0F * 60.0F; ++i) {
			GL11.glRotatef(random.nextFloat() * 360.0F, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(random.nextFloat() * 360.0F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(random.nextFloat() * 360.0F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(random.nextFloat() * 360.0F, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(random.nextFloat() * 360.0F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(random.nextFloat() * 360.0F + f1 * 90.0F, 0.0F, 0.0F, 1.0F);
			tessellator.startDrawing(6);
			float f3 = random.nextFloat() * 20.0F + 5.0F + f2 * 10.0F;
			float f4 = random.nextFloat() * 2.0F + 1.0F + f2 * 2.0F;
			tessellator.setColorRGBA_I(16777215, (int)(255.0F * (1.0F - f2)));
			tessellator.addVertex(0.0D, 0.0D, 0.0D);
			tessellator.setColorRGBA_I(16711935, 0);
			tessellator.addVertex(-0.866D * (double)f4, (double)f3, (double)(-0.5F * f4));
			tessellator.addVertex(0.866D * (double)f4, (double)f3, (double)(-0.5F * f4));
			tessellator.addVertex(0.0D, (double)f3, (double)(1.0F * f4));
			tessellator.addVertex(-0.866D * (double)f4, (double)f3, (double)(-0.5F * f4));
			tessellator.draw();
		}

		GL11.glPopMatrix();
		GL11.glPopMatrix();
		GL11.glDepthMask(true);
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glShadeModel(GL11.GL_FLAT);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_ALPHA_TEST);
		RenderHelper.enableStandardItemLighting();

		tessellator.startDrawingQuads();
	}

}
