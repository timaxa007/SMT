package mods.timaxa007.pack.weapon.gui;

import mods.timaxa007.pack.weapon.item.ItemWeapons;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.GuiIngameForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

import org.lwjgl.opengl.GL11;

public class WeaponsIngameGUI extends GuiIngameForge {

	Minecraft mc = Minecraft.getMinecraft();
	EntityPlayer player = Minecraft.getMinecraft().thePlayer;

	private static final int WHITE = 0xFFFFFF;

	public WeaponsIngameGUI(Minecraft mc) {
		super(mc);
		this.mc = mc;
		player = mc.thePlayer;
	}
	/*
	public WeaponsIngameGUI(Minecraft mc, LivingUpdateEvent p) {
		super(mc);
		mc = mc;
		player = (EntityPlayer)p.entity;
	}
	 */
	private ScaledResolution res = null;
	private FontRenderer fontrenderer = null;
	private RenderGameOverlayEvent eventParent;

	public void renderGameOverlay(float partialTicks, boolean hasScreen, int mouseX, int mouseY) {
		super.renderGameOverlay(partialTicks, hasScreen, mouseX, mouseY);

		res = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
		eventParent = new RenderGameOverlayEvent(partialTicks, res, mouseX, mouseY);
		int width = res.getScaledWidth();
		int height = res.getScaledHeight();

		//renderScope(width, height);
		if (player != null && !player.capabilities.isCreativeMode) {
			renderNewHealth(width, height);
			renderAmmoAmt(width, height);
		}

	}

	public void renderScope(int width, int height) {
		ItemStack current = Minecraft.getMinecraft().thePlayer.getCurrentEquippedItem();

		if (current != null && current.getItem() instanceof ItemWeapons && current.getTagCompound() != null) {
			NBTTagCompound tag = current.getTagCompound();
			Tessellator tessellator = Tessellator.instance;

			if (tag.hasKey("Aim") && tag.getBoolean("Aim")) {

				GL11.glPushMatrix();
				GL11.glDisable(GL11.GL_DEPTH_TEST);
				GL11.glDepthMask(false);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				GL11.glDisable(GL11.GL_ALPHA_TEST);

				int w_min = 0;
				int w_max = width;
				int h_min = 0;
				int h_max = height;

				if (width > height) {
					w_min = (width / 2) - (height /2);
					w_max = (width / 2) + (height /2);
					//-------------------------------------------------------------
					mc.getTextureManager().bindTexture(new ResourceLocation("timaxa007", "textures/gui/scope_blank_null.png"));

					tessellator.startDrawingQuads();
					tessellator.addVertexWithUV((double)0, (double)h_max, -90.0D, 0.0D, 1.0D);
					tessellator.addVertexWithUV((double)w_min, (double)h_max, -90.0D, 1.0D, 1.0D);
					tessellator.addVertexWithUV((double)w_min, (double)h_min, -90.0D, 1.0D, 0.0D);
					tessellator.addVertexWithUV((double)0, (double)h_min, -90.0D, 0.0D, 0.0D);
					tessellator.draw();
					//-------------------------------------------------------------
					mc.getTextureManager().bindTexture(new ResourceLocation("timaxa007", "textures/gui/scope_blank_null.png"));

					tessellator.startDrawingQuads();
					tessellator.addVertexWithUV((double)w_max, (double)h_max, -90.0D, 0.0D, 1.0D);
					tessellator.addVertexWithUV((double)width, (double)h_max, -90.0D, 1.0D, 1.0D);
					tessellator.addVertexWithUV((double)width, (double)h_min, -90.0D, 1.0D, 0.0D);
					tessellator.addVertexWithUV((double)w_max, (double)h_min, -90.0D, 0.0D, 0.0D);
					tessellator.draw();
					//-------------------------------------------------------------
				} else if (height > width) {
					h_min = (height / 2) - (width /2);
					h_max = (height / 2) + (width /2);
					//-------------------------------------------------------------
					mc.getTextureManager().bindTexture(new ResourceLocation("timaxa007", "textures/gui/scope_blank_null.png"));

					tessellator.startDrawingQuads();
					tessellator.addVertexWithUV((double)w_min, (double)h_min, -90.0D, 0.0D, 1.0D);
					tessellator.addVertexWithUV((double)w_max, (double)h_min, -90.0D, 1.0D, 1.0D);
					tessellator.addVertexWithUV((double)w_max, (double)0, -90.0D, 1.0D, 0.0D);
					tessellator.addVertexWithUV((double)w_min, (double)0, -90.0D, 0.0D, 0.0D);
					tessellator.draw();
					//-------------------------------------------------------------
					mc.getTextureManager().bindTexture(new ResourceLocation("timaxa007", "textures/gui/scope_blank_null.png"));

					tessellator.startDrawingQuads();
					tessellator.addVertexWithUV((double)w_min, (double)height, -90.0D, 0.0D, 1.0D);
					tessellator.addVertexWithUV((double)w_max, (double)height, -90.0D, 1.0D, 1.0D);
					tessellator.addVertexWithUV((double)w_max, (double)h_max, -90.0D, 1.0D, 0.0D);
					tessellator.addVertexWithUV((double)w_min, (double)h_max, -90.0D, 0.0D, 0.0D);
					tessellator.draw();
					//-------------------------------------------------------------
				}

				//-------------------------------------------------------------
				mc.getTextureManager().bindTexture(new ResourceLocation("timaxa007", "textures/gui/scope_bino_2.png"));

				tessellator.startDrawingQuads();
				tessellator.addVertexWithUV((double)w_min, (double)h_max, -90.0D, 0.0D, 1.0D);
				tessellator.addVertexWithUV((double)w_max, (double)h_max, -90.0D, 1.0D, 1.0D);
				tessellator.addVertexWithUV((double)w_max, (double)h_min, -90.0D, 1.0D, 0.0D);
				tessellator.addVertexWithUV((double)w_min, (double)h_min, -90.0D, 0.0D, 0.0D);
				tessellator.draw();
				//-------------------------------------------------------------
				GL11.glDepthMask(true);
				GL11.glEnable(GL11.GL_DEPTH_TEST);
				GL11.glEnable(GL11.GL_ALPHA_TEST);
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				GL11.glPopMatrix();

			}
		}
	}

	public void renderNewHealth(int width, int height) {
		Tessellator tessellator = Tessellator.instance;

		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(false);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(GL11.GL_ALPHA_TEST);
		//-------------------------------------------------------------
		/*
		mc.getTextureManager().bindTexture(new ResourceLocation("timaxa007", "textures/obj/dot_red.png"));
		tessellator.startDrawingQuads();
		tessellator.addVertexWithUV(0.0D, (double)height, -90.0D, 0.0D, 1.0D);
		tessellator.addVertexWithUV((double)width, (double)height, -90.0D, 1.0D, 1.0D);
		tessellator.addVertexWithUV((double)width, 0.0D, -90.0D, 1.0D, 0.0D);
		tessellator.addVertexWithUV(0.0D, 0.0D, -90.0D, 0.0D, 0.0D);
		tessellator.draw();
		 */
		//-------------------------------------------------------------
		mc.getTextureManager().bindTexture(new ResourceLocation("timaxa007", "textures/obj/dot_white.png"));

		tessellator.startDrawingQuads();
		tessellator.setColorOpaque_I(0xAAAAAA);
		tessellator.addVertexWithUV(5.0D, 35.0D, -90.0D, 0.0D, 1.0D);
		tessellator.addVertexWithUV(35.0D, 35.0D, -90.0D, 1.0D, 1.0D);
		tessellator.addVertexWithUV(35.0D, 5.0D, -90.0D, 1.0D, 0.0D);
		tessellator.addVertexWithUV(5.0D, 5.0D, -90.0D, 0.0D, 0.0D);
		tessellator.draw();
		//-------------------------------------------------------------
		mc.getTextureManager().bindTexture(new ResourceLocation("timaxa007", "textures/obj/load_bar.png"));

		tessellator.startDrawingQuads();
		tessellator.setColorOpaque_I(0xFF2222);
		tessellator.addVertexWithUV(35.0D, 15.0D, -90.0D, 0.0D, 1.0D);
		tessellator.addVertexWithUV((double)width/3, 15.0D, -90.0D, 1.0D, 1.0D);
		tessellator.addVertexWithUV((double)width/3, 5.0D, -90.0D, 1.0D, 0.0D);
		tessellator.addVertexWithUV(35.0D, 5.0D, -90.0D, 0.0D, 0.0D);
		tessellator.draw();
		//-------------------------------------------------------------
		mc.getTextureManager().bindTexture(new ResourceLocation("timaxa007", "textures/obj/load_bar.png"));

		tessellator.startDrawingQuads();
		tessellator.setColorOpaque_I(0x2288FF);
		tessellator.addVertexWithUV(35.0D, 25.0D, -90.0D, 0.0D, 1.0D);
		tessellator.addVertexWithUV((double)width/3, 25.0D, -90.0D, 1.0D, 1.0D);
		tessellator.addVertexWithUV((double)width/3, 15.0D, -90.0D, 1.0D, 0.0D);
		tessellator.addVertexWithUV(35.0D, 15.0D, -90.0D, 0.0D, 0.0D);
		tessellator.draw();
		//-------------------------------------------------------------
		mc.getTextureManager().bindTexture(new ResourceLocation("timaxa007", "textures/obj/load_bar.png"));

		tessellator.startDrawingQuads();
		tessellator.setColorOpaque_I(0xFF8800);
		tessellator.addVertexWithUV(35.0D, 35.0D, -90.0D, 0.0D, 1.0D);
		tessellator.addVertexWithUV((double)width/3, 35.0D, -90.0D, 1.0D, 1.0D);
		tessellator.addVertexWithUV((double)width/3, 25.0D, -90.0D, 1.0D, 0.0D);
		tessellator.addVertexWithUV(35.0D, 25.0D, -90.0D, 0.0D, 0.0D);
		tessellator.draw();
		//-------------------------------------------------------------
		GL11.glDepthMask(true);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glEnable(GL11.GL_ALPHA_TEST);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glPopMatrix();

	}

	public void renderAmmoAmt(int width, int height) {
		Tessellator tessellator = Tessellator.instance;

		ItemStack current = Minecraft.getMinecraft().thePlayer.getCurrentEquippedItem();

		if (current != null && current.getItem() instanceof ItemWeapons && current.getTagCompound() != null) {
			NBTTagCompound tag = current.getTagCompound();
			int var1 = tag.getInteger("AmmoAtm");
			int vara = 0;
			int varb = 0;
			vara = var1/10;
			varb = var1-(10*vara);
			/*
			if (var1 >= 40) {vara = 4;}
			else if (var1 >= 30) {vara = 3;}
			else if (var1 >= 20) {vara = 2;}
			else if (var1 >= 10) {vara = 1;}
			else {vara = 0;}*/
			/*
			if (varb >= 40) {varb = var1 - 40;}
			else if (varb >= 30) {varb = var1 - 30;}
			else if (varb >= 20) {varb = var1 - 20;}
			else if (var1 >= 10) {varb = var1 - 10;}
			else {varb = var1;}*/

			GL11.glPushMatrix();
			GL11.glDisable(GL11.GL_DEPTH_TEST);
			GL11.glDepthMask(false);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glDisable(GL11.GL_ALPHA_TEST);
			//-------------------------------------------------------------
			if (vara != 0) {
				mc.getTextureManager().bindTexture(new ResourceLocation("timaxa007", "textures/font/" + vara + ".png"));
				tessellator.startDrawingQuads();
				tessellator.setColorOpaque_I(0xAAAAAA);
				tessellator.addVertexWithUV(0.0D+10.0D + ((double)width/2), 8.0D + ((double)height/2), -90.0D, 0.0D, 1.0D);
				tessellator.addVertexWithUV(8.0D+10.0D + ((double)width/2), 8.0D + ((double)height/2), -90.0D, 1.0D, 1.0D);
				tessellator.addVertexWithUV(8.0D+10.0D + ((double)width/2), 0.0D + ((double)height/2), -90.0D, 1.0D, 0.0D);
				tessellator.addVertexWithUV(0.0D+10.0D + ((double)width/2), 0.0D + ((double)height/2), -90.0D, 0.0D, 0.0D);
				tessellator.draw();
			}
			//-------------------------------------------------------------
			mc.getTextureManager().bindTexture(new ResourceLocation("timaxa007", "textures/font/" + varb + ".png"));
			tessellator.startDrawingQuads();
			tessellator.setColorOpaque_I(0xAAAAAA);
			tessellator.addVertexWithUV(0.0D+15.0D + ((double)width/2), 8.0D + ((double)height/2), -90.0D, 0.0D, 1.0D);
			tessellator.addVertexWithUV(8.0D+15.0D + ((double)width/2), 8.0D + ((double)height/2), -90.0D, 1.0D, 1.0D);
			tessellator.addVertexWithUV(8.0D+15.0D + ((double)width/2), 0.0D + ((double)height/2), -90.0D, 1.0D, 0.0D);
			tessellator.addVertexWithUV(0.0D+15.0D + ((double)width/2), 0.0D + ((double)height/2), -90.0D, 0.0D, 0.0D);
			tessellator.draw();
			//-------------------------------------------------------------
			GL11.glDepthMask(true);
			GL11.glEnable(GL11.GL_DEPTH_TEST);
			GL11.glEnable(GL11.GL_ALPHA_TEST);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glPopMatrix();
		}
	}

}
