package smt.pack.privacy.client.event;

public class EventsForgeClient {

	//private static Minecraft mc = Minecraft.getMinecraft();
	//FontRenderer fontRenderer = mc.fontRenderer;
	//ScaledResolution sr = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
	//int width = sr.getScaledWidth();
	//int heigh = sr.getScaledHeight();

	/*
	@SubscribeEvent
	public void renderOreX(RenderWorldLastEvent event) {

		//dot start
		double ax = -1.0D;
		double ay = 63.0D;
		double az = -1.0D;

		//dot end
		double bx = 1.0D;
		double by = 65.0D;
		double bz = 1.0D;

		int radius = 64;

		int x = (int)mc.thePlayer.posX;
		int y = (int)mc.thePlayer.posY;
		int z = (int)mc.thePlayer.posZ;

		double x_fix = -(mc.thePlayer.lastTickPosX + (mc.thePlayer.posX - mc.thePlayer.lastTickPosX) * event.partialTicks);
		double y_fix = -(mc.thePlayer.lastTickPosY + (mc.thePlayer.posY - mc.thePlayer.lastTickPosY) * event.partialTicks);
		double z_fix = -(mc.thePlayer.lastTickPosZ + (mc.thePlayer.posZ - mc.thePlayer.lastTickPosZ) * event.partialTicks);

		GL11.glPushMatrix();
		GL11.glTranslated(x_fix, y_fix, z_fix);
		//GL11.glDisable(GL11.GL_LIGHTING);
		//GL11.glEnable(GL11.GL_BLEND);
		//GL11.glEnable(GL11.GL_DEPTH_TEST);
		for (int x_p = x - radius; x_p < x + radius; ++x_p) {
			for (int y_p = y - radius; y_p < y + radius; ++y_p) {
				for (int z_p = z - radius; z_p < z + radius; ++z_p) {
					if (!mc.theWorld.isAirBlock(x_p, y_p, z_p)) {

						if (y_p < 0) y_p = 0;
						else if (y_p > mc.theWorld.getHeight()) mc.theWorld.getHeight();

						for (Block isTrue : XRay.renderBlocks) {
							Block block = mc.theWorld.getBlock(x_p, y_p, z_p);
							if (block == isTrue) {
								int metadata = mc.theWorld.getBlockMetadata(x_p, y_p, z_p);
								GL11.glPushMatrix();
								GL11.glTranslated(x_p, y_p, z_p);
								GL11.glDisable(GL11.GL_DEPTH_TEST);
								mc.renderEngine.bindTexture(XRay.textureBlocks.get(block));
								XRay.addBox(1.002D, 1.002D, 1.002D, -0.002D, -0.002D, -0.002D, block, metadata);
								GL11.glEnable(GL11.GL_DEPTH_TEST);
								GL11.glPopMatrix();
							}
						}
					}
				}
			}
		}
		//addBox(x, y, z, x + 1, y + 1, z + 1);
		//GL11.glDisable(GL11.GL_DEPTH_TEST);
		//GL11.glDisable(GL11.GL_BLEND);
		//GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glPopMatrix();
	}
	 */
	/*
	@SubscribeEvent
	public void renderTextV(RenderWorldLastEvent event) {
		MovingObjectPosition target = EntityLook.block(mc.thePlayer, 1.0F, 4.0D, true);
		if (target != null && target.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {

			double x_fix = -(mc.thePlayer.lastTickPosX + (mc.thePlayer.posX - mc.thePlayer.lastTickPosX) * event.partialTicks);
			double y_fix = -(mc.thePlayer.lastTickPosY + (mc.thePlayer.posY - mc.thePlayer.lastTickPosY) * event.partialTicks);
			double z_fix = -(mc.thePlayer.lastTickPosZ + (mc.thePlayer.posZ - mc.thePlayer.lastTickPosZ) * event.partialTicks);

			GL11.glPushMatrix();
			GL11.glTranslated(x_fix, y_fix, z_fix);
			GL11.glEnable(GL11.GL_BLEND);

			if (mc.theWorld.getBlock(target.blockX, target.blockY, target.blockZ) == Blocks.wooden_door) {

				GL11.glPushMatrix();
				//float f4 = MathHelper.sin(mc.thePlayer.rotationYaw * (float)Math.PI / 180.0F);
				//float f5 = -MathHelper.cos(mc.thePlayer.rotationYaw * (float)Math.PI / 180.0F);
				GL11.glTranslated((double)target.blockX + 0.5D,
						(double)target.blockY + 0.7D,
						(double)target.blockZ + 0.5D);
				GL11.glScalef(0.01F, -0.01F, -0.01F);

				GL11.glRotatef(-180.0F + mc.thePlayer.rotationYaw, 0.0F, 1.0F, 0.0F);
				GL11.glRotatef(-mc.thePlayer.rotationPitch, 1.0F, 0.0F, 0.0F);

				//RendererLivingEntity.passSpecialRender
				GL11.glDisable(GL11.GL_LIGHTING);
				GL11.glDepthMask(false);
				GL11.glEnable(GL11.GL_BLEND);
				OpenGlHelper.glBlendFunc(770, 771, 1, 0);
				FontRenderer fontrenderer = mc.fontRenderer;
				Tessellator tessellator = Tessellator.instance;
				GL11.glDisable(GL11.GL_TEXTURE_2D);
				tessellator.startDrawingQuads();
				int i2 = 38;
				tessellator.setColorRGBA_F(0.0F, 0.0F, 0.0F, 0.75F);
				tessellator.addVertex((double)(-i2 - 1), -1.0D, 0.0D);
				tessellator.addVertex((double)(-i2 - 1), 22.0D, 0.0D);
				tessellator.addVertex((double)(i2 + 1), 22.0D, 0.0D);
				tessellator.addVertex((double)(i2 + 1), -1.0D, 0.0D);
				tessellator.draw();
				GL11.glEnable(GL11.GL_TEXTURE_2D);
				GL11.glDepthMask(true);

				//GL11.glEnable(GL11.GL_DEPTH_TEST);
				String[] names = {
						"Чтобы открыть дверь",
						"нажмите ПКМ."
				};
				for (int i = 0; i < names.length; ++i) {
					fontrenderer.drawString(names[i], -fontrenderer.getStringWidth(names[i]) / 2, 0 + i * 13, 0xAFAFAF, true);
				}
				//GL11.glDisable(GL11.GL_DEPTH_TEST);
				GL11.glEnable(GL11.GL_LIGHTING);
				GL11.glDisable(GL11.GL_BLEND);
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

				GL11.glPopMatrix();



			}

			GL11.glDisable(GL11.GL_BLEND);
			GL11.glPopMatrix();

		}
	}
	 */
	/*
	@SubscribeEvent
	public void renderTextForEntity(RenderWorldLastEvent event) {
		MovingObjectPosition target = mc.objectMouseOver;
		if (target != null && target.typeOfHit == MovingObjectPosition.MovingObjectType.ENTITY && target.entityHit != null) {
			//System.out.println("renderTextForEntity");

			double x_fix = -(mc.thePlayer.lastTickPosX + (mc.thePlayer.posX - mc.thePlayer.lastTickPosX) * event.partialTicks);
			double y_fix = -(mc.thePlayer.lastTickPosY + (mc.thePlayer.posY - mc.thePlayer.lastTickPosY) * event.partialTicks);
			double z_fix = -(mc.thePlayer.lastTickPosZ + (mc.thePlayer.posZ - mc.thePlayer.lastTickPosZ) * event.partialTicks);

			//if (target.entityHit instanceof EntityCorp) {

			double xTarget_fix = (target.entityHit.lastTickPosX + (target.entityHit.posX - target.entityHit.lastTickPosX) * event.partialTicks);
			double yTarget_fix = (target.entityHit.lastTickPosY + (target.entityHit.posY - target.entityHit.lastTickPosY) * event.partialTicks);
			double zTarget_fix = (target.entityHit.lastTickPosZ + (target.entityHit.posZ - target.entityHit.lastTickPosZ) * event.partialTicks);

			GL11.glPushMatrix();
			GL11.glTranslated(x_fix, y_fix, z_fix);
			GL11.glEnable(GL11.GL_BLEND);
			//

			String[] names = {
					"Test text 1.",
					//"Test text 2.",
					"Test text 3."
			};

			GL11.glPushMatrix();
			GL11.glDisable(GL11.GL_CULL_FACE);
			GL11.glTranslated(xTarget_fix, yTarget_fix, zTarget_fix);
			GL11.glTranslatef(0F, target.entityHit.getEyeHeight() + ((float)names.length * 0.5F), 0F);
			GL11.glScalef(0.025F, -0.025F, -0.025F);
			GL11.glRotatef(-180.0F + mc.thePlayer.rotationYaw, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(-mc.thePlayer.rotationPitch, 1.0F, 0.0F, 0.0F);
			FontRenderer fontrenderer = mc.fontRenderer;
			for (int i = 0; i < names.length; ++i) {
				fontrenderer.drawString(names[i], -fontrenderer.getStringWidth(names[i]) / 2, 0 + i * 13, 0xFFFF00);
			}
			GL11.glEnable(GL11.GL_CULL_FACE);
			GL11.glPopMatrix();
			//
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glPopMatrix();
			//}
		}
	}
	 */
	/*
	@SubscribeEvent
	public void renderTextForEntity2(RenderGameOverlayEvent.Text event) {
		MovingObjectPosition target = mc.objectMouseOver;
		if (target != null) {

			switch(target.typeOfHit) {
			case BLOCK:{
				EntityPlayer player = mc.thePlayer;
				World world = mc.theWorld;

				int x = target.blockX;
				int y = target.blockY;
				int z = target.blockZ;

				if (world.getBlock(x, y, z) == Blocks.iron_ore) {
					fontRenderer.drawStringWithShadow("§fTest", width/2, heigh/2, 0);
				}
				break;
			}
			case ENTITY:{
				if (target.entityHit != null) {
					//if (target.entityHit instanceof EntityCorp) {
					ScaledResolution scaledresolution = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
					int i = scaledresolution.getScaledWidth();
					int j = scaledresolution.getScaledHeight();
					int k = i / 2;
					int l = j / 2;

					String text = "Обыскать труп.";
					int i2 = mc.fontRenderer.getStringWidth(text) / 2;

					Tessellator tessellator = Tessellator.instance;
					GL11.glDisable(GL11.GL_TEXTURE_2D);
					tessellator.startDrawingQuads();
					tessellator.setColorRGBA_F(0.0F, 0.0F, 0.0F, 0.75F);
					tessellator.addVertex((double)(-i2 - 2 + k), -1.0D + (double)(-(8 * 2) + l), 0.0D);
					tessellator.addVertex((double)(-i2 - 2 + k), 11.0D + (double)(-(8 * 2) + l), 0.0D);
					tessellator.addVertex((double)(i2 + 2 + k), 11.0D + (double)(-(8 * 2) + l), 0.0D);
					tessellator.addVertex((double)(i2 + 2 + k), -1.0D + (double)(-(8 * 2) + l), 0.0D);
					tessellator.draw();
					GL11.glEnable(GL11.GL_TEXTURE_2D);

					//mc.fontRenderer.drawStringWithShadow("Обыскать труп.", 8, 8 , 16777215);
					mc.fontRenderer.drawStringWithShadow(text, (i / 2) - i2, (j / 2) - 8 * 2, 16777215);
					//}
				}
				break;
			}
			default:break;
			}
		}
	}
	 */
	/*
	@SubscribeEvent
	public void renderText(RenderWorldLastEvent event) {

		double x_fix = -(mc.thePlayer.lastTickPosX + (mc.thePlayer.posX - mc.thePlayer.lastTickPosX) * event.partialTicks);
		double y_fix = -(mc.thePlayer.lastTickPosY + (mc.thePlayer.posY - mc.thePlayer.lastTickPosY) * event.partialTicks);
		double z_fix = -(mc.thePlayer.lastTickPosZ + (mc.thePlayer.posZ - mc.thePlayer.lastTickPosZ) * event.partialTicks);

		GL11.glPushMatrix();
		GL11.glTranslated(x_fix, y_fix, z_fix);
		GL11.glEnable(GL11.GL_BLEND);
		//
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glTranslated(0.0D, 66.0D, 0.0D);
		GL11.glScalef(0.025F, -0.025F, -0.025F);
		GL11.glRotatef(-180.0F + mc.thePlayer.rotationYaw, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(-mc.thePlayer.rotationPitch, 1.0F, 0.0F, 0.0F);
		FontRenderer fontrenderer = mc.fontRenderer;
		String[] names = {
				"Test text 1.",
				"Test text 2.",
				"Test text 3."
		};
		for (int i = 0; i < names.length; ++i) {
			fontrenderer.drawString(names[i], -fontrenderer.getStringWidth(names[i]) / 2, 0 + i * 13, 0xFFFF00);
		}
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glPopMatrix();
		//
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glPopMatrix();

	}
	 */
	/*
	@SubscribeEvent
	public void renderBox(RenderWorldLastEvent event) {

		//dot start
		double ax = -1.0D;
		double ay = 63.0D;
		double az = -1.0D;

		//dot end
		double bx = 1.0D;
		double by = 65.0D;
		double bz = 1.0D;

		AxisAlignedBB aabb = AxisAlignedBB.getBoundingBox(ax, ay, az, bx, by, bz).expand(0.01D, 0.01D, 0.01D);

		double x_fix = -(mc.thePlayer.lastTickPosX + (mc.thePlayer.posX - mc.thePlayer.lastTickPosX) * event.partialTicks);
		double y_fix = -(mc.thePlayer.lastTickPosY + (mc.thePlayer.posY - mc.thePlayer.lastTickPosY) * event.partialTicks);
		double z_fix = -(mc.thePlayer.lastTickPosZ + (mc.thePlayer.posZ - mc.thePlayer.lastTickPosZ) * event.partialTicks);

		GL11.glPushMatrix();
		GL11.glTranslated(x_fix, y_fix, z_fix);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		//
		GL11.glColor4f(0.75F, 0.25F, 0.25F, 0.25F);
		box(aabb);
		GL11.glColor4f(0.75F, 0.25F, 0.25F, 0.75F);
		lines(aabb);
		GL11.glColor4f(1F, 1F, 1F, 0F);
		//
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glPopMatrix();
	}
	 */
	/*
	public static void box(AxisAlignedBB aabb) {
		Tessellator tessellator = Tessellator.instance;

		tessellator.startDrawingQuads();

		//top
		tessellator.addVertex(aabb.maxX, aabb.maxY, aabb.minZ);
		tessellator.addVertex(aabb.minX, aabb.maxY, aabb.minZ);
		tessellator.addVertex(aabb.minX, aabb.maxY, aabb.maxZ);
		tessellator.addVertex(aabb.maxX, aabb.maxY, aabb.maxZ);

		//bottom
		tessellator.addVertex(aabb.maxX, aabb.minY, aabb.maxZ);
		tessellator.addVertex(aabb.minX, aabb.minY, aabb.maxZ);
		tessellator.addVertex(aabb.minX, aabb.minY, aabb.minZ);
		tessellator.addVertex(aabb.maxX, aabb.minY, aabb.minZ);

		//north
		tessellator.addVertex(aabb.maxX, aabb.minY, aabb.minZ);
		tessellator.addVertex(aabb.minX, aabb.minY, aabb.minZ);
		tessellator.addVertex(aabb.minX, aabb.maxY, aabb.minZ);
		tessellator.addVertex(aabb.maxX, aabb.maxY, aabb.minZ);

		//south
		tessellator.addVertex(aabb.maxX, aabb.maxY, aabb.maxZ);
		tessellator.addVertex(aabb.minX, aabb.maxY, aabb.maxZ);
		tessellator.addVertex(aabb.minX, aabb.minY, aabb.maxZ);
		tessellator.addVertex(aabb.maxX, aabb.minY, aabb.maxZ);

		//west
		tessellator.addVertex(aabb.minX, aabb.maxY, aabb.maxZ);
		tessellator.addVertex(aabb.minX, aabb.maxY, aabb.minZ);
		tessellator.addVertex(aabb.minX, aabb.minY, aabb.minZ);
		tessellator.addVertex(aabb.minX, aabb.minY, aabb.maxZ);

		//east
		tessellator.addVertex(aabb.maxX, aabb.minY, aabb.maxZ);
		tessellator.addVertex(aabb.maxX, aabb.minY, aabb.minZ);
		tessellator.addVertex(aabb.maxX, aabb.maxY, aabb.minZ);
		tessellator.addVertex(aabb.maxX, aabb.maxY, aabb.maxZ);

		tessellator.draw();
	}
	 */
	/*
	public static void lines(AxisAlignedBB aabb) {
		GL11.glBegin(GL11.GL_LINES);

		//top
		GL11.glVertex3d(aabb.minX, aabb.maxY, aabb.minZ);//a - 1
		GL11.glVertex3d(aabb.maxX, aabb.maxY, aabb.minZ);//b - 2

		GL11.glVertex3d(aabb.maxX, aabb.maxY, aabb.minZ);//a - 2
		GL11.glVertex3d(aabb.maxX, aabb.maxY, aabb.maxZ);//b - 3

		GL11.glVertex3d(aabb.maxX, aabb.maxY, aabb.maxZ);//a - 3
		GL11.glVertex3d(aabb.minX, aabb.maxY, aabb.maxZ);//b - 4

		GL11.glVertex3d(aabb.minX, aabb.maxY, aabb.maxZ);//a - 4
		GL11.glVertex3d(aabb.minX, aabb.maxY, aabb.minZ);//b - 1

		//bottom
		GL11.glVertex3d(aabb.minX, aabb.minY, aabb.minZ);//a - 1
		GL11.glVertex3d(aabb.maxX, aabb.minY, aabb.minZ);//b - 2

		GL11.glVertex3d(aabb.maxX, aabb.minY, aabb.minZ);//a - 2
		GL11.glVertex3d(aabb.maxX, aabb.minY, aabb.maxZ);//b - 3

		GL11.glVertex3d(aabb.maxX, aabb.minY, aabb.maxZ);//a - 3
		GL11.glVertex3d(aabb.minX, aabb.minY, aabb.maxZ);//b - 4

		GL11.glVertex3d(aabb.minX, aabb.minY, aabb.maxZ);//a - 4
		GL11.glVertex3d(aabb.minX, aabb.minY, aabb.minZ);//b - 1

		//side-/-edge
		GL11.glVertex3d(aabb.minX, aabb.maxY, aabb.minZ);//a
		GL11.glVertex3d(aabb.minX, aabb.minY, aabb.minZ);//b

		GL11.glVertex3d(aabb.maxX, aabb.maxY, aabb.maxZ);//a
		GL11.glVertex3d(aabb.maxX, aabb.minY, aabb.maxZ);//b

		GL11.glVertex3d(aabb.maxX, aabb.maxY, aabb.minZ);//a
		GL11.glVertex3d(aabb.maxX, aabb.minY, aabb.minZ);//b

		GL11.glVertex3d(aabb.minX, aabb.maxY, aabb.maxZ);//a
		GL11.glVertex3d(aabb.minX, aabb.minY, aabb.maxZ);//b

		GL11.glEnd();
	}
	 */
	/*
	public static Set<String> friend_list = Sets.newHashSet();

	static {
		friend_list.add("timaxa007");
		friend_list.add("timaxa001");
	}

	@SubscribeEvent
	public void nameFormat(RenderLivingEvent.Specials.Pre event) {
		if (event.entity != null && event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)event.entity;
			boolean isFriend = friend_list.contains(player.getCommandSenderName());
			if (!isFriend) {event.setCanceled(true);return;}
		}
	}
	 */
}
