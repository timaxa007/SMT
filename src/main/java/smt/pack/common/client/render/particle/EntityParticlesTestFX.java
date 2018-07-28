package smt.pack.common.client.render.particle;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import smt.pack.common.SMTCommon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class EntityParticlesTestFX extends EntityFX {

	public EntityParticlesTestFX(World world, double x, double y, double z) {
		super(world, x, y, z);
		particleMaxAge = (int)(8.0D / (Math.random() * 0.8D + 0.2D));
		noClip = false;
	}

	@Override
	public void onUpdate() {
		prevPosX = posX;
		prevPosY = posY;
		prevPosZ = posZ;

		if (particleAge++ >= particleMaxAge) {
			setDead();
		}

		//setParticleTextureIndex(7 - particleAge * 8 / particleMaxAge);
		moveEntity(motionX, motionY, motionZ);

		if (posY == prevPosY) {
			motionX *= 1.1D;
			motionZ *= 1.1D;
		}

		motionX *= 0.9599999785423279D;
		motionY *= 0.9599999785423279D;
		motionZ *= 0.9599999785423279D;

		if (onGround) {
			motionX *= 0.699999988079071D;
			motionZ *= 0.699999988079071D;
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void renderParticle(Tessellator t, float par2, float x, float y, float z, float par6, float par7) {

		float f6 = 0;
		float f7 = 1;
		float f8 = 0;
		float f9 = 1;
		/*
		if (particleIcon != null) {
			f6 = particleIcon.getMinU();
			f7 = particleIcon.getMaxU();
			f8 = particleIcon.getMinV();
			f9 = particleIcon.getMaxV();
		}
		 */
		t.draw();
		Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(SMTCommon.MODID, "textures/particles/test.png"));
		//t.setTranslation(x, y, z);
		t.startDrawingQuads();
		t.setBrightness(200);
		t.setColorRGBA_F(particleRed, particleGreen, particleBlue, particleAlpha);
		t.addVertexWithUV(posX + 1D, posY, posZ + 1D, (double)f7, (double)f9);
		t.addVertexWithUV(posX + 1D, posY, posZ + 0D, (double)f7, (double)f8);
		t.addVertexWithUV(posX + 0D, posY, posZ + 0D, (double)f6, (double)f8);
		t.addVertexWithUV(posX + 0D, posY, posZ + 1D, (double)f6, (double)f9);
		t.draw();
		t.startDrawingQuads();
		//Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("textures/particle/particles.png"));
	}

}
