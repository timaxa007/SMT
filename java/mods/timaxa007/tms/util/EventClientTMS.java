package mods.timaxa007.tms.util;

import mods.timaxa007.tms.Core;
import net.minecraftforge.client.event.MouseEvent;
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
	@SubscribeEvent
	public void onLeftClick(MouseEvent m) {
		if (m.buttonstate && m.button == 0) {
			//if (Core.show_tip_info_testing) System.out.println("onLeftClick");
			Core.network.sendToServer(new KeyPacket(-2));
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onRightClick(MouseEvent m) {
		if (m.buttonstate && m.button == 1) {
			//if (Core.show_tip_info_testing) System.out.println("onRightClick");
			Core.network.sendToServer(new KeyPacket(-1));
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void offLeftClick(MouseEvent m) {
		if (!m.buttonstate && m.button == 0) {
			//if (Core.show_tip_info_testing) System.out.println("onLeftClick");
			Core.network.sendToServer(new KeyPacket(-4));
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void offRightClick(MouseEvent m) {
		if (!m.buttonstate && m.button == 1) {
			//if (Core.show_tip_info_testing) System.out.println("onRightClick");
			Core.network.sendToServer(new KeyPacket(-3));
		}
	}
	//--------------------------------------------------------------------------------------------------------------
}
