package mods.timaxa007.tms.util;

import mods.timaxa007.tms.Core;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

import org.lwjgl.input.Mouse;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventClientTMS {
	//--------------------------------------------------------------------------------------------------------------
	/*@SubscribeEvent
	public void onFire(LivingUpdateEvent p) {
		if (Mouse.isButtonDown(0)) {
			ItemStack actHBI = ((EntityPlayer)p.entityLiving).getCurrentEquippedItem();
			if (actHBI != null && actHBI.getItem() instanceof ItemWeapons) {
				//System.out.println("onFire");
			}
		}
	}*/
	//--------------------------------------------------------------------------------------------------------------
	/*@SubscribeEvent
	public void onScope(LivingUpdateEvent p) {
		if (Mouse.isButtonDown(1)) {
			ItemStack actHBI = ((EntityPlayer)p.entityLiving).getCurrentEquippedItem();
			if (actHBI != null && actHBI.getItem() instanceof ItemWeapons) {
				//System.out.println("onScope");
			}
		}
	}*/
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent(priority = EventPriority.LOW)
	public void onLeftClickTick(LivingUpdateEvent p) {
		if (Mouse.isButtonDown(0) && 
				(!(Minecraft.getMinecraft().currentScreen instanceof GuiScreen)) && 
				p.entityLiving instanceof EntityPlayer) {
			//if (Core.show_tip_info_testing) System.out.println("onLeftClickTick");
			Core.network.sendToServer(new KeyPacket(-4, true));
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent(priority = EventPriority.LOW)
	public void onRightClickTick(LivingUpdateEvent p) {
		if (Mouse.isButtonDown(1) && 
				(!(Minecraft.getMinecraft().currentScreen instanceof GuiScreen)) && 
				p.entityLiving instanceof EntityPlayer) {
			//if (Core.show_tip_info_testing) System.out.println("onRightClick");
			Core.network.sendToServer(new KeyPacket(-3, true));
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onLeftClick(MouseEvent m) {
		if (m.button == 0) {
			//if (Core.show_tip_info_testing) System.out.println("onLeftClick");
			Core.network.sendToServer(new KeyPacket(-2, m.buttonstate));
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onRightClick(MouseEvent m) {
		if (m.button == 1) {
			//if (Core.show_tip_info_testing) System.out.println("onRightClick");
			Core.network.sendToServer(new KeyPacket(-1, m.buttonstate));
		}
	}
	//--------------------------------------------------------------------------------------------------------------
}
