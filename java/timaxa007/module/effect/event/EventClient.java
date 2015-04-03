package timaxa007.module.effect.event;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.EntityViewRenderEvent;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventClient {
	/*
	@SubscribeEvent
	public void fogDistance(EntityViewRenderEvent.RenderFogEvent e) {
		float f1 = e.farPlaneDistance;
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		ItemStack current = player.getCurrentEquippedItem();

		if (current != null) {
			if (current.getItem() == Items.nether_star) {
				if (e.fogMode < 0) {
					GL11.glFogf(GL11.GL_FOG_START, f1);
					GL11.glFogf(GL11.GL_FOG_END, f1);
				} else {
					GL11.glFogf(GL11.GL_FOG_START, 0.7F);//Начало тумана
					GL11.glFogf(GL11.GL_FOG_END, 3.5F);//Конец (и далее) тумана
				}
			}
		}

	}
	 */
	@SubscribeEvent
	public void fogDistance(EntityViewRenderEvent.RenderFogEvent e) {
		float f1 = e.farPlaneDistance;
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		ItemStack current = player.getCurrentEquippedItem();

		if (current != null) {
			if (current.getItem() == Items.nether_star) {
				GL11.glFogf(GL11.GL_FOG_START, 0.7F);//Начало тумана
				GL11.glFogf(GL11.GL_FOG_END, 3.5F);//Конец (и далее) тумана
			}
		}

	}

	@SubscribeEvent
	public void fogColor(EntityViewRenderEvent.FogColors e) {
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		ItemStack current = player.getCurrentEquippedItem();

		if (current != null) {
			if (current.getItem() == Items.nether_star) {
				e.red = 0.00F;/*0.0F - 1.0F: по красному каналу цвета*/
				e.green = 0.01F;/*0.0F - 1.0F: по зелёному каналу цвета*/
				e.blue = 0.02F;/*0.0F - 1.0F: по синиму каналу цвета*/
			}
		}

	}

}
