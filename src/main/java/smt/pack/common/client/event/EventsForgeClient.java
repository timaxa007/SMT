package smt.pack.common.client.event;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import smt.pack.common.api.object.ItemCustomArmorDummy;
import smt.pack.common.client.UtilModel;
import smt.pack.common.client.render.armor.ArmorCustomModel;


public class EventsForgeClient {
	/*
	Minecraft mc = Minecraft.getMinecraft();

	@SubscribeEvent
	public void addEffectEntitySplashFX(LivingUpdateEvent event) {
		if (!(event.entityLiving instanceof EntityClientPlayerMP)) {
			if (event.entityLiving.getEquipmentInSlot(0) != null && 
					event.entityLiving.getEquipmentInSlot(0).getItem() == Items.golden_sword) {
				//System.out.println(event.entityLiving);
				double radius = 0.37D;

				for (float l = 0F; l < 2 * Math.PI; l += Math.PI / 6) {
					double px = event.entityLiving.posX + radius * Math.cos(l);
					double py = event.entityLiving.posZ + radius * Math.sin(l);
					EntitySplashFX eFX = new EntitySplashFX(mc.theWorld, px, event.entityLiving.posY + 1.5D, py, 0F, 0.4F, 0F);
					eFX.setRBGColorF(1F, 0.5F, 0F);
					mc.effectRenderer.addEffect(eFX);
				}
			}
		}
	}
	 */
	/*
	@SubscribeEvent
	public void mouse(MouseEvent event) {
		EntityClientPlayerMP player = Minecraft.getMinecraft().thePlayer;
		ItemStack item = player.getCurrentEquippedItem();
		if (item != null && item.getItem() == Items.stick) {
			System.out.println(MathHelper.abs_int(event.dwheel) / 120);
			event.setCanceled(true);
		}
	}
	 */
	static final Minecraft mc = Minecraft.getMinecraft();
	static final Tessellator tessellator = Tessellator.instance;
	static final ResourceLocation texture = new ResourceLocation("modid", "textures/texture.png");

	@SubscribeEvent
	public void onRenderArmomForPlayer(RenderPlayerEvent.SetArmorModel event) {
		if (event.stack == null || !(event.stack.getItem() instanceof ItemCustomArmorDummy)) return;
		ItemCustomArmorDummy ivcad = (ItemCustomArmorDummy)event.stack.getItem();
		ArmorCustomModel acm = ivcad.getModel(event.entityPlayer, event.stack, event.slot);
		if (acm != null) {
			acm.partHead.set(event.renderer.modelBipedMain.bipedHead);
			acm.partBody.set(event.renderer.modelBipedMain.bipedBody);
			acm.partRightArm.set(event.renderer.modelBipedMain.bipedRightArm);
			acm.partLeftArm.set(event.renderer.modelBipedMain.bipedLeftArm);
			acm.partRightLeg.set(event.renderer.modelBipedMain.bipedRightLeg);
			acm.partLeftLeg.set(event.renderer.modelBipedMain.bipedLeftLeg);
			acm.render(event.entityPlayer);
		}
	}

	@SubscribeEvent
	public void onRenderArmomForEntity(RenderLivingEvent.Pre event) {
		if (!(event.entity instanceof EntityLiving)) return;
		EntityLiving el = (EntityLiving)event.entity;
		for (int i = 1; i <= 4; ++i) {
			ItemStack armor = el.getEquipmentInSlot(i);
			if (armor == null || !(armor.getItem() instanceof ItemCustomArmorDummy)) continue;
			ItemCustomArmorDummy ivcad = (ItemCustomArmorDummy)armor.getItem();
			ArmorCustomModel acm = ivcad.getModel(event.entity, armor, i - 1);
			if (acm != null && event.renderer instanceof RenderBiped) {
				RenderBiped rb = (RenderBiped)event.renderer;
				acm.partHead.set(rb.modelBipedMain.bipedHead);
				acm.partBody.set(rb.modelBipedMain.bipedBody);
				acm.partRightArm.set(rb.modelBipedMain.bipedRightArm);
				acm.partLeftArm.set(rb.modelBipedMain.bipedLeftArm);
				acm.partRightLeg.set(rb.modelBipedMain.bipedRightLeg);
				acm.partLeftLeg.set(rb.modelBipedMain.bipedLeftLeg);
				acm.render(event.entity);
			}
		}
	}

	//@SubscribeEvent
	public void drawText(RenderGameOverlayEvent.Post event) {
		switch(event.type) {
		case TEXT:
			String text = "Ping: ";
			if (mc.func_147104_D() != null)
				text += mc.func_147104_D().pingToServer;
			else
				text += "None";
			text += ".";
			mc.fontRenderer.drawStringWithShadow(text,
					event.resolution.getScaledWidth() - mc.fontRenderer.getStringWidth(text), 
					0, 0xFFFFFF);
			break;
		default:break;
		}
	}

	//@SubscribeEvent
	public void renderSide(DrawBlockHighlightEvent event) {
		if (event.target != null && event.target.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
			double x_fix = -(mc.thePlayer.lastTickPosX + (mc.thePlayer.posX - mc.thePlayer.lastTickPosX) * event.partialTicks);
			double y_fix = -(mc.thePlayer.lastTickPosY + (mc.thePlayer.posY - mc.thePlayer.lastTickPosY) * event.partialTicks);
			double z_fix = -(mc.thePlayer.lastTickPosZ + (mc.thePlayer.posZ - mc.thePlayer.lastTickPosZ) * event.partialTicks);
			GL11.glPushMatrix();
			GL11.glTranslated(
					(double)event.target.blockX + x_fix,
					(double)event.target.blockY + y_fix,
					(double)event.target.blockZ + z_fix
					);
			AxisAlignedBB aabb = AxisAlignedBB.getBoundingBox(
					0D - 0.005D,
					0D - 0.005D,
					0D - 0.005D,
					1D + 0.005D,
					1D + 0.005D,
					1D + 0.005D
					);
			double icon_minX = aabb.minX < 0D ? 0D : aabb.minX;
			double icon_minY = aabb.minY < 0D ? 0D : aabb.minY;
			double icon_minZ = aabb.minZ < 0D ? 0D : aabb.minZ;
			double icon_maxX = aabb.maxX > 1D ? 1D : aabb.maxX;
			double icon_maxY = aabb.maxY > 1D ? 1D : aabb.maxY;
			double icon_maxZ = aabb.maxZ > 1D ? 1D : aabb.maxZ;
			mc.getTextureManager().bindTexture(texture);
			tessellator.startDrawingQuads();
			switch(event.target.sideHit) {
			case 1:
				//Top
				tessellator.addVertexWithUV(aabb.maxX, aabb.maxY, aabb.minZ, icon_maxX, icon_minZ);
				tessellator.addVertexWithUV(aabb.minX, aabb.maxY, aabb.minZ, icon_minX, icon_minZ);
				tessellator.addVertexWithUV(aabb.minX, aabb.maxY, aabb.maxZ, icon_minX, icon_maxZ);
				tessellator.addVertexWithUV(aabb.maxX, aabb.maxY, aabb.maxZ, icon_maxX, icon_maxZ);
				break;
			case 0:
				//Bottom
				tessellator.addVertexWithUV(aabb.maxX, aabb.minY, aabb.maxZ, icon_maxX, icon_maxZ);
				tessellator.addVertexWithUV(aabb.minX, aabb.minY, aabb.maxZ, icon_minX, icon_maxZ);
				tessellator.addVertexWithUV(aabb.minX, aabb.minY, aabb.minZ, icon_minX, icon_minZ);
				tessellator.addVertexWithUV(aabb.maxX, aabb.minY, aabb.minZ, icon_maxX, icon_minZ);
				break;
			case 2:
				//North
				tessellator.addVertexWithUV(aabb.maxX, aabb.minY, aabb.minZ, icon_minX, icon_maxY);
				tessellator.addVertexWithUV(aabb.minX, aabb.minY, aabb.minZ, icon_maxX, icon_maxY);
				tessellator.addVertexWithUV(aabb.minX, aabb.maxY, aabb.minZ, icon_maxX, icon_minY);
				tessellator.addVertexWithUV(aabb.maxX, aabb.maxY, aabb.minZ, icon_minX, icon_minY);
				break;
			case 3:
				//South
				tessellator.addVertexWithUV(aabb.maxX, aabb.maxY, aabb.maxZ, icon_maxX, icon_minY);
				tessellator.addVertexWithUV(aabb.minX, aabb.maxY, aabb.maxZ, icon_minX, icon_minY);
				tessellator.addVertexWithUV(aabb.minX, aabb.minY, aabb.maxZ, icon_minX, icon_maxY);
				tessellator.addVertexWithUV(aabb.maxX, aabb.minY, aabb.maxZ, icon_maxX, icon_maxY);
				break;
			case 4:
				//West
				tessellator.addVertexWithUV(aabb.minX, aabb.maxY, aabb.maxZ, icon_maxY, icon_minZ);
				tessellator.addVertexWithUV(aabb.minX, aabb.maxY, aabb.minZ, icon_minY, icon_minZ);
				tessellator.addVertexWithUV(aabb.minX, aabb.minY, aabb.minZ, icon_minY, icon_maxZ);
				tessellator.addVertexWithUV(aabb.minX, aabb.minY, aabb.maxZ, icon_maxY, icon_maxZ);
				break;
			case 5:
				//East
				tessellator.addVertexWithUV(aabb.maxX, aabb.minY, aabb.maxZ, icon_minY, icon_maxZ);
				tessellator.addVertexWithUV(aabb.maxX, aabb.minY, aabb.minZ, icon_maxY, icon_maxZ);
				tessellator.addVertexWithUV(aabb.maxX, aabb.maxY, aabb.minZ, icon_maxY, icon_minZ);
				tessellator.addVertexWithUV(aabb.maxX, aabb.maxY, aabb.maxZ, icon_minY, icon_minZ);
				break;
			}
			tessellator.draw();
			GL11.glPopMatrix();
		}
	}
	//@SubscribeEvent
	public void renderBoxEntity(RenderWorldLastEvent event) {
		MovingObjectPosition target = mc.objectMouseOver;

		if (target != null && target.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
			double x_fix = -(mc.thePlayer.lastTickPosX + (mc.thePlayer.posX - mc.thePlayer.lastTickPosX) * event.partialTicks);
			double y_fix = -(mc.thePlayer.lastTickPosY + (mc.thePlayer.posY - mc.thePlayer.lastTickPosY) * event.partialTicks);
			double z_fix = -(mc.thePlayer.lastTickPosZ + (mc.thePlayer.posZ - mc.thePlayer.lastTickPosZ) * event.partialTicks);
			AxisAlignedBB aabb = AxisAlignedBB.getBoundingBox(
					(double)target.blockX, (double)target.blockY + 1D, (double)target.blockZ,
					(double)target.blockX + 1D, (double)target.blockY + 2D, (double)target.blockZ + 1D);

			GL11.glPushMatrix();
			GL11.glTranslated(x_fix, y_fix, z_fix);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glDisable(GL11.GL_TEXTURE_2D);
			if (target.sideHit == 1) {
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.25F);
				UtilModel.box(Tessellator.instance, aabb);
				/*UtilModel.box(Tessellator.instance, mc.theWorld.getBlock(target.blockX, target.blockY, target.blockZ)
						.getCollisionBoundingBoxFromPool(mc.theWorld, target.blockX, target.blockY, target.blockZ));*/
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.75F);
				UtilModel.lines(aabb);
				/*UtilModel.lines(mc.theWorld.getBlock(target.blockX, target.blockY, target.blockZ)
						.getCollisionBoundingBoxFromPool(mc.theWorld, target.blockX, target.blockY, target.blockZ));*/
				GL11.glColor4f(1F, 1F, 1F, 1F);
			}
			GL11.glEnable(GL11.GL_TEXTURE_2D);
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glPopMatrix();
		}

	}
	/*
	static RenderBlocks rb = RenderBlocks.getInstance();

	@SubscribeEvent
	public void renderDamage(RenderWorldLastEvent event) {
		double x_fix = -(mc.thePlayer.lastTickPosX + (mc.thePlayer.posX - mc.thePlayer.lastTickPosX) * event.partialTicks);
		double y_fix = -(mc.thePlayer.lastTickPosY + (mc.thePlayer.posY - mc.thePlayer.lastTickPosY) * event.partialTicks);
		double z_fix = -(mc.thePlayer.lastTickPosZ + (mc.thePlayer.posZ - mc.thePlayer.lastTickPosZ) * event.partialTicks);

		Map damagedBlocks = ReflectionHelper.getPrivateValue(RenderGlobal.class, Minecraft.getMinecraft().renderGlobal, "O", "field_72738_E", "damagedBlocks");
		IIcon[] destroyBlockIcons = ReflectionHelper.getPrivateValue(RenderGlobal.class, Minecraft.getMinecraft().renderGlobal, "Q", "field_94141_F", "destroyBlockIcons");

		if (!damagedBlocks.isEmpty()) {
			OpenGlHelper.glBlendFunc(774, 768, 1, 0);
			mc.renderEngine.bindTexture(TextureMap.locationBlocksTexture);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.5F);

			GL11.glPushMatrix();
			GL11.glPolygonOffset(-3.0F, -3.0F);
			GL11.glEnable(GL11.GL_POLYGON_OFFSET_FILL);
			GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);
			GL11.glEnable(GL11.GL_ALPHA_TEST);
			GL11.glTranslated(x_fix, y_fix, z_fix);
			Iterator iterator = damagedBlocks.values().iterator();

			while (iterator.hasNext()) {
				DestroyBlockProgress destroyblockprogress = (DestroyBlockProgress)iterator.next();
				double d3 = (double)destroyblockprogress.getPartialBlockX() - x_fix;
				double d4 = (double)destroyblockprogress.getPartialBlockY() - y_fix;
				double d5 = (double)destroyblockprogress.getPartialBlockZ() - z_fix;

				if (d3 * d3 + d4 * d4 + d5 * d5 > 1024.0D) {
					iterator.remove();
				} else {
					Block block = mc.theWorld.getBlock(destroyblockprogress.getPartialBlockX(), destroyblockprogress.getPartialBlockY(), destroyblockprogress.getPartialBlockZ());
					rb.renderBlockAsItem(block, mc.theWorld.getBlockMetadata(destroyblockprogress.getPartialBlockX(), destroyblockprogress.getPartialBlockY(), destroyblockprogress.getPartialBlockZ()), 1F);
					//this.renderBlocksRg.renderBlockUsingTexture(block, destroyblockprogress.getPartialBlockX(), destroyblockprogress.getPartialBlockY(), destroyblockprogress.getPartialBlockZ(),
					//this.destroyBlockIcons[destroyblockprogress.getPartialBlockDamage()]
					//);
				}
			}

			GL11.glDisable(GL11.GL_ALPHA_TEST);
			GL11.glPolygonOffset(0.0F, 0.0F);
			GL11.glDisable(GL11.GL_POLYGON_OFFSET_FILL);
			GL11.glEnable(GL11.GL_ALPHA_TEST);
			GL11.glDepthMask(true);
			GL11.glPopMatrix();
		}
	}
	 */
}
