package mods.timaxa007.pack.weapon.event;

import mods.timaxa007.pack.weapon.gui.WeaponsIngameGUI;
import mods.timaxa007.tms.util.IScope;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventWeaponsClient {
	//--------------------------------------------------------------------------------------------------------------
	Minecraft mc = Minecraft.getMinecraft();
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void statusBullet(LivingUpdateEvent p) {
		if ((mc.ingameGUI != null) && (!(mc.ingameGUI instanceof WeaponsIngameGUI))) {
			mc.ingameGUI = new WeaponsIngameGUI(mc);
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onRenderCrosshairs(RenderGameOverlayEvent.Pre e) {
		ItemStack current = Minecraft.getMinecraft().thePlayer.getCurrentEquippedItem();

		if (current != null && current.getItem() instanceof IScope && current.getTagCompound() != null) {
			NBTTagCompound tag = current.getTagCompound();
			if (e.type.equals(ElementType.CROSSHAIRS) && tag.hasKey("Aim") && tag.getBoolean("Aim")) {

				Tessellator tessellator = Tessellator.instance;

				int width = e.resolution.getScaledWidth();
				int height = e.resolution.getScaledHeight();

				GL11.glPushMatrix();
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				
				int w_min = 0;
				int w_max = width;
				int h_min = 0;
				int h_max = height;

				if (width > height) {
					w_min = (width / 2) - (height /2);
					w_max = (width / 2) + (height /2);
					//-------------------------------------------------------------
					voidRender(tessellator, 0, w_min, h_min, h_max, new ResourceLocation("timaxa007", "textures/gui/scope_blank_null.png"));
					voidRender(tessellator, w_max, width, h_min, h_max, new ResourceLocation("timaxa007", "textures/gui/scope_blank_null.png"));
					//-------------------------------------------------------------
				} else if (height > width) {
					h_min = (height / 2) - (width /2);
					h_max = (height / 2) + (width /2);
					//-------------------------------------------------------------
					voidRender(tessellator, w_min, w_max, 0, h_min, new ResourceLocation("timaxa007", "textures/gui/scope_blank_null.png"));
					voidRender(tessellator, w_min, w_max, h_max, height, new ResourceLocation("timaxa007", "textures/gui/scope_blank_null.png"));
					//-------------------------------------------------------------
				}

				//-------------------------------------------------------------
				voidRender(tessellator, w_min, w_max, h_min, h_max, new ResourceLocation("timaxa007", "textures/gui/scope_blank_11.png"));
				//-------------------------------------------------------------
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				GL11.glPopMatrix();

				//Minecraft.getMinecraft().getTextureManager().bindTexture(resLoc);
				//Minecraft.getMinecraft().ingameGUI.drawTexturedModalRect(x, y, 0, 0, 32, 32); 

				e.setCanceled(true);
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	private static void voidRender(Tessellator tessellator, int w_min, int w_max, int h_min, int h_max, ResourceLocation texture) {
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		tessellator.startDrawingQuads();
		tessellator.addVertexWithUV((double)w_min, (double)h_max, -90.0D, 0.0D, 1.0D);
		tessellator.addVertexWithUV((double)w_max, (double)h_max, -90.0D, 1.0D, 1.0D);
		tessellator.addVertexWithUV((double)w_max, (double)h_min, -90.0D, 1.0D, 0.0D);
		tessellator.addVertexWithUV((double)w_min, (double)h_min, -90.0D, 0.0D, 0.0D);
		tessellator.draw();
	}
	//--------------------------------------------------------------------------------------------------------------
}
