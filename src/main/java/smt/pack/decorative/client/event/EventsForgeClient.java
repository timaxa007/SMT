package smt.pack.decorative.client.event;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import net.minecraftforge.client.model.obj.WavefrontObject;

import org.lwjgl.opengl.GL11;

import smt.pack.common.SMTCommon;
import smt.pack.common.client.UtilModel;
import smt.pack.decorative.SMTDecorative;
import smt.pack.geology.SMTGeology;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventsForgeClient {

	Minecraft mc = Minecraft.getMinecraft();
	/*
	public static final ResourceLocation march1 = new ResourceLocation("rcservmod", "sounds/records/march1.ogg");
	public static final ResourceLocation march2 = new ResourceLocation("rcservmod", "sounds/records/march2.ogg");
	public static final ResourceLocation march3 = new ResourceLocation("rcservmod", "sounds/records/march3.ogg");

	@SubscribeEvent
	public void getSound(PlaySoundEvent17 event) {
		if (event.name.equals(march1)) {

		}
		//mc.getSoundHandler().
		//System.out.println("getSound - " + event.name);
	}
	 */
	/*
	@SubscribeEvent
	public void onRenderPlayer(RenderPlayerEvent.Post event) {
		EntityPlayer player = event.entityPlayer;
		Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("textures/blocks/stone.png"));
		GL11.glPushMatrix();
		GL11.glTranslatef(0F, -0.265F, 0F);
		float p_77029_2_ = 1;
		double d3 = player.field_71091_bM + (player.field_71094_bP - player.field_71091_bM) * (double)p_77029_2_ - (player.prevPosX + (player.posX - player.prevPosX) * (double)p_77029_2_);
		double d4 = player.field_71096_bN + (player.field_71095_bQ - player.field_71096_bN) * (double)p_77029_2_ - (player.prevPosY + (player.posY - player.prevPosY) * (double)p_77029_2_);
		double d0 = player.field_71097_bO + (player.field_71085_bR - player.field_71097_bO) * (double)p_77029_2_ - (player.prevPosZ + (player.posZ - player.prevPosZ) * (double)p_77029_2_);
		float f4 = player.prevRenderYawOffset + (player.renderYawOffset - player.prevRenderYawOffset) * p_77029_2_;
		double d1 = (double)MathHelper.sin(f4 * (float)Math.PI / 180.0F);
		double d2 = (double)(-MathHelper.cos(f4 * (float)Math.PI / 180.0F));
		float f5 = (float)d4 * 10.0F;
		if (f5 < -6.0F) {
			f5 = -6.0F;
		}

		if (f5 > 32.0F) {
			f5 = 32.0F;
		}

		float f6 = (float)(d3 * d1 + d0 * d2) * 100.0F;
		float f7 = (float)(d3 * d2 - d0 * d1) * 100.0F;

		if (f6 < 0.0F) {
			f6 = 0.0F;
		}

		float f8 = player.prevCameraYaw + (player.cameraYaw - player.prevCameraYaw) * p_77029_2_;
		f5 += MathHelper.sin((player.prevDistanceWalkedModified + (player.distanceWalkedModified - player.prevDistanceWalkedModified) * p_77029_2_) * 6.0F) * 32.0F * f8;

		if (player.isSneaking()) {
			f5 += 25.0F;
		}

		GL11.glNormal3f(0.0F, 1.0F, 0.0F);
		GL11.glRotatef(-RenderManager.instance.playerViewY, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(-166.0F + f6*0.6f + f5, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(f7 / 2.0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(-f7 / 2.0F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(0F, 0F, (player.getCurrentArmor(2) != null ? -0.135F : -0.125F));
		event.renderer.modelBipedMain.renderCloak(0.0625F);
		GL11.glPopMatrix();
	}
	 */
	public static IIcon

	stone_overlay,
	rock_overlay,
	rock_hell_overlay,
	plywood_style_1_overlay,
	metal,
	metal2,
	metal3,
	metal4,

	rush,
	smooth_1,
	smooth_2,
	smooth_3,
	smooth_4,
	brick_1,
	brick_2,
	brick_3,
	br1,
	cr7_1,
	prick_1,
	pl8,

	appa_overlay,
	chunk_overlay,
	creg_overlay,
	dust_overlay,
	gem_large_overlay,
	gem_med1_overlay,
	gem_medium_2_overlay,
	gem_medium_3_overlay,
	gem_medium_4_overlay,
	gem_medium_overlay,
	gem_small_overlay,
	gem_smalled_4_overlay,
	lap_overlay,
	metal_overlay,
	metal_2_overlay,
	shard_overlay,

	test
	;

	@SubscribeEvent
	public void onTextureStitchEvent(TextureStitchEvent.Pre event) {
		//System.out.println("TextureStitchEvent - " + event.map.getTextureType());
		switch (event.map.getTextureType()) {
		case 0:

			stone_overlay = event.map.registerIcon(SMTDecorative.MODID + ":stone/stone_overlay");
			rock_overlay = event.map.registerIcon(SMTDecorative.MODID + ":stone/rock_overlay");
			rock_hell_overlay = event.map.registerIcon(SMTDecorative.MODID + ":stone/rock_hell_overlay");
			plywood_style_1_overlay = event.map.registerIcon(SMTDecorative.MODID + ":wood/plywood_style_1_overlay");
			metal = event.map.registerIcon(SMTDecorative.MODID + ":metal/metal");
			metal2 = event.map.registerIcon(SMTDecorative.MODID + ":metal/metal2");
			metal3 = event.map.registerIcon(SMTDecorative.MODID + ":metal/metal3");
			metal4 = event.map.registerIcon(SMTDecorative.MODID + ":metal/metal4");

			rush = event.map.registerIcon(SMTDecorative.MODID + ":carving/rush");
			smooth_1 = event.map.registerIcon(SMTDecorative.MODID + ":carving/smooth_1");
			smooth_2 = event.map.registerIcon(SMTDecorative.MODID + ":carving/smooth_2");
			smooth_3 = event.map.registerIcon(SMTDecorative.MODID + ":carving/smooth_3");
			smooth_4 = event.map.registerIcon(SMTDecorative.MODID + ":carving/smooth_4");
			brick_1 = event.map.registerIcon(SMTDecorative.MODID + ":carving/brick_1");
			brick_2 = event.map.registerIcon(SMTDecorative.MODID + ":carving/brick_2");
			brick_3 = event.map.registerIcon(SMTDecorative.MODID + ":carving/brick_3");
			br1 = event.map.registerIcon(SMTDecorative.MODID + ":carving/br1");
			cr7_1 = event.map.registerIcon(SMTDecorative.MODID + ":carving/cr7_1");
			prick_1 = event.map.registerIcon(SMTDecorative.MODID + ":carving/prick_1");
			pl8 = event.map.registerIcon(SMTDecorative.MODID + ":carving/pl8");

			appa_overlay = event.map.registerIcon(SMTGeology.MODID + ":ore/appa_overlay");
			chunk_overlay = event.map.registerIcon(SMTGeology.MODID + ":ore/chunk_overlay");
			creg_overlay = event.map.registerIcon(SMTGeology.MODID + ":ore/creg_overlay");
			dust_overlay = event.map.registerIcon(SMTGeology.MODID + ":ore/dust_overlay");
			gem_large_overlay = event.map.registerIcon(SMTGeology.MODID + ":ore/gem_large_overlay");
			gem_med1_overlay = event.map.registerIcon(SMTGeology.MODID + ":ore/gem_med1_overlay");
			gem_medium_2_overlay = event.map.registerIcon(SMTGeology.MODID + ":ore/gem_medium_2_overlay");
			gem_medium_3_overlay = event.map.registerIcon(SMTGeology.MODID + ":ore/gem_medium_3_overlay");
			gem_medium_4_overlay = event.map.registerIcon(SMTGeology.MODID + ":ore/gem_medium_4_overlay");
			gem_medium_overlay = event.map.registerIcon(SMTGeology.MODID + ":ore/gem_medium_overlay");
			gem_small_overlay = event.map.registerIcon(SMTGeology.MODID + ":ore/gem_small_overlay");
			gem_smalled_4_overlay = event.map.registerIcon(SMTGeology.MODID + ":ore/gem_smalled_4_overlay");
			lap_overlay = event.map.registerIcon(SMTGeology.MODID + ":ore/lap_overlay");
			metal_overlay = event.map.registerIcon(SMTGeology.MODID + ":ore/metal_overlay");
			metal_2_overlay = event.map.registerIcon(SMTGeology.MODID + ":ore/metal_2_overlay");
			shard_overlay = event.map.registerIcon(SMTGeology.MODID + ":ore/shard_overlay");

			test = event.map.registerIcon(SMTDecorative.MODID + ":carving/test");

			break;
		}
	}

	private float interpolateRotation(float p_77034_1_, float p_77034_2_, float p_77034_3_) {
		float f3;

		for (f3 = p_77034_2_ - p_77034_1_; f3 < -180.0F; f3 += 360.0F) {
			;
		}

		while (f3 >= 180.0F) {
			f3 -= 360.0F;
		}

		return p_77034_1_ + p_77034_3_ * f3;
	}

	public static final IModelCustom model = AdvancedModelLoader.loadModel(new ResourceLocation(SMTCommon.MODID, "model/armor/backpack.obj"));
	private static Tessellator tessellator = Tessellator.instance;

	//@SubscribeEvent
	public void renderItem(RenderPlayerEvent.Specials.Pre event) {
		EntityPlayer player = event.entityPlayer;

		double p_x = player.lastTickPosX + (player.posX - player.lastTickPosX);
		double p_y = player.lastTickPosY + (player.posY - player.lastTickPosY);
		double p_z = player.lastTickPosZ + (player.posZ - player.lastTickPosZ);

		double dx = player.posX - p_x;
		double dy = player.posY - p_y;
		double dz = player.posZ - p_z;

		GL11.glPushMatrix();
		GL11.glTranslated(dx, dy, dz);

		//GL11.glTranslatef(0F, 0.125F, 0F);
		GL11.glRotatef(180F, 1F, 0F, 0F);

		GL11.glTranslatef(
				event.renderer.modelBipedMain.bipedBody.rotationPointX * event.partialRenderTick,
				event.renderer.modelBipedMain.bipedBody.rotationPointY * event.partialRenderTick,
				event.renderer.modelBipedMain.bipedBody.rotationPointZ * event.partialRenderTick);
		GL11.glRotatef(event.renderer.modelBipedMain.bipedBody.rotateAngleZ * (180F / (float)Math.PI), 0F, 0F, 1F);
		GL11.glRotatef(event.renderer.modelBipedMain.bipedBody.rotateAngleY * (180F / (float)Math.PI), 0F, 1F, 0F);
		GL11.glRotatef(event.renderer.modelBipedMain.bipedBody.rotateAngleX * (180F / (float)Math.PI), 1F, 0F, 0F);
		GL11.glTranslatef(0F, -1.5F, 0F);

		Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.locationBlocksTexture);
		//model.renderAll();
		UtilModel.renderAllOnIcon((WavefrontObject)model, Blocks.wool.getIcon(2, 0), tessellator);
		//UtilModel.renderPartOnIcon((WavefrontObject)model, "plane", Blocks.planks.getIcon(2, 0), tessellator);

		GL11.glPopMatrix();
	}
	/*
	@SubscribeEvent
	public void onRenderPlayerEventPost(RenderPlayerEvent.Pre event) {

		double x_fix = -(event.entityPlayer.lastTickPosX + (event.entityPlayer.posX - event.entityPlayer.lastTickPosX) * event.partialRenderTick);
		double y_fix = -(event.entityPlayer.lastTickPosY + (event.entityPlayer.posY - event.entityPlayer.lastTickPosY) * event.partialRenderTick);
		double z_fix = -(event.entityPlayer.lastTickPosZ + (event.entityPlayer.posZ - event.entityPlayer.lastTickPosZ) * event.partialRenderTick);

		if (event.entityPlayer instanceof AbstractClientPlayer) {
			x_fix = -(event.entityPlayer.lastTickPosX + (event.entityPlayer.posX - event.entityPlayer.lastTickPosX));
			y_fix = -(event.entityPlayer.lastTickPosY + (event.entityPlayer.posY - event.entityPlayer.lastTickPosY));
			z_fix = -(event.entityPlayer.lastTickPosZ + (event.entityPlayer.posZ - event.entityPlayer.lastTickPosZ));
		}

		//float pitch_fix = event.entityPlayer.prevRotationPitch + (event.entityPlayer.rotationPitch - event.entityPlayer.prevRotationPitch) * event.partialRenderTick;
		//float yaw_fix = event.entityPlayer.prevRotationYaw + (event.entityPlayer.rotationYaw - event.entityPlayer.prevRotationYaw) * event.partialRenderTick;
		GL11.glPushMatrix();

		//GL11.glTranslated(x_fix, y_fix, z_fix);
		//GL11.glTranslated(event.entityPlayer.posX, event.entityPlayer.posY, event.entityPlayer.posZ);

		GL11.glTranslatef(0F, -0.375F, 0F);
		GL11.glRotatef(180F, 0F, 1F, 0F);

		float f2 = this.interpolateRotation(event.entityPlayer.prevRenderYawOffset, event.entityPlayer.renderYawOffset, event.partialRenderTick);
		float f3 = this.interpolateRotation(event.entityPlayer.prevRotationYawHead, event.entityPlayer.rotationYawHead, event.partialRenderTick);
		float f4;

		if (event.entityPlayer.isRiding() && event.entityPlayer.ridingEntity instanceof EntityLivingBase) {
			EntityLivingBase entitylivingbase1 = (EntityLivingBase)event.entityPlayer.ridingEntity;
			f2 = this.interpolateRotation(entitylivingbase1.prevRenderYawOffset, entitylivingbase1.renderYawOffset, event.partialRenderTick);
			f4 = MathHelper.wrapAngleTo180_float(f3 - f2);
			if (f4 < -85.0F) f4 = -85.0F;
			if (f4 >= 85.0F) f4 = 85.0F;
			f2 = f3 - f4;
			if (f4 * f4 > 2500.0F) f2 += f4 * 0.2F;
		}

		GL11.glRotatef(180.0F - f2, 0.0F, 1.0F, 0.0F);

		//GL11.glRotatef(-yaw_fix, 0.0F, 1.0F, 0.0F);
		//GL11.glRotatef(pitch_fix, 0.0F, 0.0F, 1.0F);
		//if (mc.thePlayer != event.entityPlayer)
		//else
		//	GL11.glTranslated(event.entityPlayer.posX, event.entityPlayer.posY, event.entityPlayer.posZ);


		GL11.glTranslatef(
				event.renderer.modelBipedMain.bipedBody.rotationPointX * event.partialRenderTick,
				event.renderer.modelBipedMain.bipedBody.rotationPointY * event.partialRenderTick,
				event.renderer.modelBipedMain.bipedBody.rotationPointZ * event.partialRenderTick);
		GL11.glRotatef(event.renderer.modelBipedMain.bipedBody.rotateAngleZ * (180F / (float)Math.PI), 0F, 0F, 1F);
		GL11.glRotatef(event.renderer.modelBipedMain.bipedBody.rotateAngleY * (180F / (float)Math.PI), 0F, 1F, 0F);
		GL11.glRotatef(event.renderer.modelBipedMain.bipedBody.rotateAngleX * (180F / (float)Math.PI), 1F, 0F, 0F);
		//GL11.glRotatef(180F, 1F, 0F, 0F);
		GL11.glTranslatef(0F, -1.375F, 0F);

		UtilModel.renderPartOnIcon((WavefrontObject)model, "body", Blocks.coal_block.getIcon(2, 0), tessellator);
		UtilModel.renderPartOnIcon((WavefrontObject)model, "plane", Blocks.planks.getIcon(2, 0), tessellator);
		GL11.glPopMatrix();
	}
	 */
}
