package smt.pack.player.client.event;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventsForgeClient {

	Minecraft mc = Minecraft.getMinecraft();
	/*
	static final ResourceLocation furnaceGuiTextures = new ResourceLocation("textures/gui/container/furnace.png");
	int xSize = 176;
	int ySize = 166;

	@SubscribeEvent
	public void render(RenderGameOverlayEvent event) {
		switch(event.type) {
		case ALL:{
			GL11.glPushMatrix();
			GL11.glTranslatef(0F, 0F, -250F);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			//System.out.println("2");
			mc.getTextureManager().bindTexture(furnaceGuiTextures);
			int posX = (event.resolution.getScaledWidth() - xSize) / 2;
			int posY = (event.resolution.getScaledHeight() - ySize) / 2;
			mc.ingameGUI.drawTexturedModalRect(posX, posY, 0, 0, xSize, ySize);
			GL11.glTranslatef(0F, 0F, 250F);

			GL11.glPopMatrix();
			break;
		}
		default:break;
		}
	}
	 */
	/*
	@SubscribeEvent
	public void renderHandEvent(RenderHandEvent event) {
		GL11.glPushMatrix();
		EntityClientPlayerMP entityclientplayermp = Minecraft.getMinecraft().thePlayer;
		RenderPlayer renderplayer = (RenderPlayer)RenderManager.instance.getEntityRenderObject(entityclientplayermp);
		Minecraft.getMinecraft().getTextureManager().bindTexture(entityclientplayermp.getLocationSkin());

		float f2 = entityclientplayermp.prevRotationPitch + (entityclientplayermp.rotationPitch - entityclientplayermp.prevRotationPitch) * event.parTicks;
		f2 += 90F;
		GL11.glRotatef(-f2, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(-(entityclientplayermp.prevRotationYaw + (entityclientplayermp.rotationYaw - entityclientplayermp.prevRotationYaw) * event.parTicks), 0.0F, 1.0F, 0.0F);
		//RenderHelper.enableStandardItemLighting();

		renderplayer.renderFirstPersonArm(entityclientplayermp);
		GL11.glPopMatrix();
	}
	 */
	@SubscribeEvent
	public void gui(GuiScreenEvent event) {
		if (event.gui != null) {
			//System.out.println("Open GUI = " + event.gui.toString() + ".");
		}
		else /*System.out.println("Not open GUI.")*/;
	}

	@SubscribeEvent
	public void guiOpen(GuiOpenEvent event) {
		//event.gui = new GuiInventoryTFC(Minecraft.getMinecraft().thePlayer);
		if (event.gui != null) {
			//System.out.println("Open GUI = " + event.gui.toString() + ".");
		}
	}
	/*
	public static ReplaceSound step_01 = new ReplaceSound(new ResourceLocation(SMTPlayer.MODID + ":step.01"));

	@SubscribeEvent
	public void getSound(PlaySoundEvent17 event) {
		if (event.sound != null) {
			if (event.name.equals("step.stone")) {
				step_01.setPosF(event.sound.getXPosF(), event.sound.getYPosF(), event.sound.getZPosF());
				step_01.setPitch(event.sound.getPitch());
				step_01.setVolume(event.sound.getVolume());
				ISound newSound = new PositionedSoundRecord(new ResourceLocation(SMTPlayer.MODID + ":step.01"), event.sound.getVolume(), event.sound.getPitch(), event.sound.getXPosF(), event.sound.getYPosF(), event.sound.getZPosF());
				event.manager.playSound(newSound);
				event.result = null;
			}
			System.out.println("getSound - " + event.name);
		}
	}
	 */
}
