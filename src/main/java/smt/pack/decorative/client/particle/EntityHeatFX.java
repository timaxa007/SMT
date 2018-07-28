package smt.pack.decorative.client.particle;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import smt.pack.weapon.SMTWeapon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class EntityHeatFX extends EntityFX {

	Minecraft mc = Minecraft.getMinecraft();
	static ResourceLocation empty = new ResourceLocation(SMTWeapon.MODID, "textures/scope/scope_bino_2.png");
	float smokeparticleScale;

	public EntityHeatFX(World p_i1225_1_, double posX, double posY, double posZ, double motionX, double motionY, double motionZ) {
		this(p_i1225_1_, posX, posY, posZ, motionX, motionY, motionZ, 1.0F);
	}

	public EntityHeatFX(World p_i1226_1_, double posX, double posY, double posZ, double motionX, double motionY, double motionZ, float particleScale) {
		super(p_i1226_1_, posX, posY, posZ, 0.0D, 0.0D, 0.0D);
		this.motionX *= 0.10000000149011612D;
		this.motionY *= 0.10000000149011612D;
		this.motionZ *= 0.10000000149011612D;
		this.motionX += motionX;
		this.motionY += motionY;
		this.motionZ += motionZ;
		this.particleRed = this.particleGreen = this.particleBlue = (float)(Math.random() * 0.30000001192092896D);
		this.particleScale *= 0.75F;
		this.particleScale *= particleScale;
		this.smokeparticleScale = this.particleScale;
		this.particleMaxAge = (int)(8.0D / (Math.random() * 0.8D + 0.2D));
		this.particleMaxAge = (int)((float)this.particleMaxAge * particleScale);
		this.noClip = false;
	}

	public void renderParticle(Tessellator tessellator, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_) {
		/*
	float f6 = ((float)this.particleAge + p_70539_2_) / (float)this.particleMaxAge * 32.0F;

if (f6 < 0.0F) {
f6 = 0.0F;
}

if (f6 > 1.0F) {
f6 = 1.0F;
}

this.particleScale = this.smokeparticleScale * f6;
		 */
		float f6 = (float)this.particleTextureIndexX / 16.0F;
		float f7 = f6 + 0.0624375F;
		float f8 = (float)this.particleTextureIndexY / 16.0F;
		float f9 = f8 + 0.0624375F;
		float f10 = 0.1F * this.particleScale;

		if (this.particleIcon != null)
		{
			f6 = this.particleIcon.getMinU();
			f7 = this.particleIcon.getMaxU();
			f8 = this.particleIcon.getMinV();
			f9 = this.particleIcon.getMaxV();
		}

		double postX = (this.prevPosX + (this.posX - this.prevPosX) * (double)p_70539_2_ - interpPosX);
		double postY = (this.prevPosY + (this.posY - this.prevPosY) * (double)p_70539_2_ - interpPosY);
		double postZ = (this.prevPosZ + (this.posZ - this.prevPosZ) * (double)p_70539_2_ - interpPosZ);


		int width = mc.displayWidth;
		int height = mc.displayHeight;
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, 240.0F);
		GL11.glMatrixMode(GL11.GL_TEXTURE);
		GL11.glPushMatrix();
		mc.renderEngine.bindTexture(empty);
		int tex = mc.renderEngine.getTexture(empty).getGlTextureId();
		GL11.glViewport(0, 0, width, height);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, tex);
		float zoom = 7F;
		int size = (int) (Math.min(width, height) / zoom);
		GL11.glCopyTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGB, width / 2 - size / 2, height / 2 - size / 2, size, size, 0);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
		GL11.glPopMatrix();
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glDisable(GL11.GL_CULL_FACE);

		tessellator.setColorRGBA_F(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha);
		tessellator.addVertexWithUV(postX - 0.5D, postY - 0.5D, postZ + 0D, 0D, 0D);
		tessellator.addVertexWithUV(postX - 0.5D, postY + 0.5D, postZ + 0D, 0D, 1D);
		tessellator.addVertexWithUV(postX + 0.5D, postY + 0.5D, postZ + 0D, 1D, 1D);
		tessellator.addVertexWithUV(postX + 0.5D, postY - 0.5D, postZ + 0D, 1D, 0D);
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	public void onUpdate() {
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;

		if (this.particleAge++ >= this.particleMaxAge) {
			this.setDead();
		}

		this.setParticleTextureIndex(7 - this.particleAge * 8 / this.particleMaxAge);
		this.motionY += 0.004D;
		this.moveEntity(this.motionX, this.motionY, this.motionZ);

		if (this.posY == this.prevPosY) {
			this.motionX *= 1.1D;
			this.motionZ *= 1.1D;
		}

		this.motionX *= 0.9599999785423279D;
		this.motionY *= 0.9599999785423279D;
		this.motionZ *= 0.9599999785423279D;

		if (this.onGround) {
			this.motionX *= 0.699999988079071D;
			this.motionZ *= 0.699999988079071D;
		}

	}

}
