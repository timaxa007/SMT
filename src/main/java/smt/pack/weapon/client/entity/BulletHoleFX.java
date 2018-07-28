package smt.pack.weapon.client.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import smt.pack.weapon.SMTWeapon;

@SideOnly(Side.CLIENT)
public class BulletHoleFX extends EntityFX {

	static final ResourceLocation textureBulletHole = new ResourceLocation(SMTWeapon.MODID, "textures/bullet_hole.png");
	int side;

	public BulletHoleFX(World world, double x, double y, double z, int sideHit) {
		super(world, x, y, z);
		this.motionX = this.motionY = this.motionZ = 0.0D;
		this.side = sideHit;
		this.particleMaxAge = 600;
	}

	@Override
	public void renderParticle(Tessellator tessellator, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_) {
		float f6 = ((float)this.particleAge + p_70539_2_) / (float)this.particleMaxAge;
		f6 *= f6;
		float f7 = 2.0F - f6 * 2.0F;

		if (f7 > 1.0F) f7 = 1.0F;

		Entity player = Minecraft.getMinecraft().thePlayer;

		this.interpPosX = player.lastTickPosX + (player.posX - player.lastTickPosX) * (double)p_70539_2_;
		this.interpPosY = player.lastTickPosY + (player.posY - player.lastTickPosY) * (double)p_70539_2_;
		this.interpPosZ = player.lastTickPosZ + (player.posZ - player.lastTickPosZ) * (double)p_70539_2_;

		//f7 *= 0.2F;
		GL11.glPushMatrix();
		//GL11.glDisable(GL11.GL_LIGHTING);
		float f8 = 0.125F;
		float f9 = (float)(this.posX - interpPosX);
		float f10 = (float)(this.posY - interpPosY);
		float f11 = (float)(this.posZ - interpPosZ);
		float f12 = this.worldObj.getLightBrightness(
				MathHelper.floor_double(this.posX + (side == 4 ? -0.5 : (side == 5 ? 0.5 : 0))),
				MathHelper.floor_double(this.posY + (side == 0 ? -0.5 : (side == 1 ? 0.5 : 0))),
				MathHelper.floor_double(this.posZ + (side == 2 ? -0.5 : (side == 3 ? 0.5 : 0))));
		Minecraft.getMinecraft().getTextureManager().bindTexture(textureBulletHole);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		//GL11.glDisable(GL11.GL_TEXTURE_2D);
		//tessellator.draw();
		tessellator.startDrawingQuads();
		//tessellator.setBrightness(this.getBrightnessForRender(p_70539_2_));
		tessellator.setColorRGBA_F(f12, f12, f12, f7);

		switch(side) {
		case 0:
			tessellator.addVertexWithUV((double)(f9 - f8), (double)f10 - 0.01F, (double)(f11 - f8), 0.0D, 1.0D);
			tessellator.addVertexWithUV((double)(f9 + f8), (double)f10 - 0.01F, (double)(f11 - f8), 1.0D, 1.0D);
			tessellator.addVertexWithUV((double)(f9 + f8), (double)f10 - 0.01F, (double)(f11 + f8), 1.0D, 0.0D);
			tessellator.addVertexWithUV((double)(f9 - f8), (double)f10 - 0.01F, (double)(f11 + f8), 0.0D, 0.0D);
			break;
		case 1:
			tessellator.addVertexWithUV((double)(f9 - f8), (double)f10 + 0.01F, (double)(f11 + f8), 0.0D, 0.0D);
			tessellator.addVertexWithUV((double)(f9 + f8), (double)f10 + 0.01F, (double)(f11 + f8), 1.0D, 0.0D);
			tessellator.addVertexWithUV((double)(f9 + f8), (double)f10 + 0.01F, (double)(f11 - f8), 1.0D, 1.0D);
			tessellator.addVertexWithUV((double)(f9 - f8), (double)f10 + 0.01F, (double)(f11 - f8), 0.0D, 1.0D);
			break;
		case 2:
			tessellator.addVertexWithUV((double)(f9 - f8), (double)(f10 + f8), (double)(f11 - 0.01F), 0.0D, 1.0D);
			tessellator.addVertexWithUV((double)(f9 + f8), (double)(f10 + f8), (double)(f11 - 0.01F), 1.0D, 1.0D);
			tessellator.addVertexWithUV((double)(f9 + f8), (double)(f10 - f8), (double)(f11 - 0.01F), 1.0D, 0.0D);
			tessellator.addVertexWithUV((double)(f9 - f8), (double)(f10 - f8), (double)(f11 - 0.01F), 0.0D, 0.0D);
			break;
		case 3:
			tessellator.addVertexWithUV((double)(f9 - f8), (double)(f10 - f8), (double)(f11 + 0.01F), 0.0D, 0.0D);
			tessellator.addVertexWithUV((double)(f9 + f8), (double)(f10 - f8), (double)(f11 + 0.01F), 1.0D, 0.0D);
			tessellator.addVertexWithUV((double)(f9 + f8), (double)(f10 + f8), (double)(f11 + 0.01F), 1.0D, 1.0D);
			tessellator.addVertexWithUV((double)(f9 - f8), (double)(f10 + f8), (double)(f11 + 0.01F), 0.0D, 1.0D);
			break;
		case 4:
			tessellator.addVertexWithUV((double)(f9 - 0.01F), (double)(f10 + f8), (double)(f11 + f8), 1.0D, 1.0D);
			tessellator.addVertexWithUV((double)(f9 - 0.01F), (double)(f10 + f8), (double)(f11 - f8), 1.0D, 0.0D);
			tessellator.addVertexWithUV((double)(f9 - 0.01F), (double)(f10 - f8), (double)(f11 - f8), 0.0D, 0.0D);
			tessellator.addVertexWithUV((double)(f9 - 0.01F), (double)(f10 - f8), (double)(f11 + f8), 0.0D, 1.0D);
			break;
		case 5:
			tessellator.addVertexWithUV((double)(f9 + 0.01F), (double)(f10 - f8), (double)(f11 + f8), 0.0D, 1.0D);
			tessellator.addVertexWithUV((double)(f9 + 0.01F), (double)(f10 - f8), (double)(f11 - f8), 0.0D, 0.0D);
			tessellator.addVertexWithUV((double)(f9 + 0.01F), (double)(f10 + f8), (double)(f11 - f8), 1.0D, 0.0D);
			tessellator.addVertexWithUV((double)(f9 + 0.01F), (double)(f10 + f8), (double)(f11 + f8), 1.0D, 1.0D);
			break;
		default:break;
		}
		
		tessellator.draw();
		//tessellator.startDrawingQuads();
		//GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_BLEND);
		//GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glPopMatrix();
	}

	@Override
	public void onUpdate() {
        if (this.particleAge++ >= this.particleMaxAge) this.setDead();
	}

	@Override
	public int getFXLayer() {
		return 3;
	}

}
