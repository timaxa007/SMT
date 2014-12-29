package mods.timaxa007.tms.util;

import mods.timaxa007.tms.Core;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;

public class EventKey {
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onReload(KeyInputEvent k) {//0
		if (RegKey.reload.isPressed()) {
			//if (Core.show_tip_info_testing) System.out.println("onReload");
			Core.network.sendToServer(new KeyPacket(0, RegKey.reload.isPressed()));
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onCharge(KeyInputEvent k) {//1
		if (RegKey.charge.isPressed()) {
			//if (Core.show_tip_info_testing) System.out.println("onCharge");
			Core.network.sendToServer(new KeyPacket(1, RegKey.charge.isPressed()));
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onMode(KeyInputEvent k) {//2
		if (RegKey.mode.isPressed()) {
			//if (Core.show_tip_info_testing) System.out.println("onMode");
			Core.network.sendToServer(new KeyPacket(2, RegKey.mode.isPressed()));
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onUse(KeyInputEvent k) {//3
		if (RegKey.use.isPressed()) {
			if (Core.show_tip_info_testing) System.out.println("onUse");
			Core.network.sendToServer(new KeyPacket(3, RegKey.use.isPressed()));
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onYawRight(KeyInputEvent k) {//4
		if (RegKey.yaw_right.isPressed()) {
			if (Core.show_tip_info_testing) System.out.println("onYawRight");
			Core.network.sendToServer(new KeyPacket(4, RegKey.yaw_right.isPressed()));
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onUp(KeyInputEvent k) {//5
		if (RegKey.up.isPressed()) {
			if (Core.show_tip_info_testing) System.out.println("onUp");
			Core.network.sendToServer(new KeyPacket(5, RegKey.up.isPressed()));
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onYawLeft(KeyInputEvent k) {//6
		if (RegKey.yaw_left.isPressed()) {
			if (Core.show_tip_info_testing) System.out.println("onYawLeft");
			Core.network.sendToServer(new KeyPacket(6, RegKey.yaw_left.isPressed()));
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onMoveRight(KeyInputEvent k) {//7
		if (RegKey.move_right.isPressed()) {
			if (Core.show_tip_info_testing) System.out.println("onMoveRight");
			Core.network.sendToServer(new KeyPacket(7, RegKey.move_right.isPressed()));
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onStop(KeyInputEvent k) {//8
		if (RegKey.stop.isPressed()) {
			if (Core.show_tip_info_testing) System.out.println("onStop");
			Core.network.sendToServer(new KeyPacket(8, RegKey.stop.isPressed()));
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onMoveLeft(KeyInputEvent k) {//9
		if (RegKey.move_left.isPressed()) {
			if (Core.show_tip_info_testing) System.out.println("onMoveLeft");
			Core.network.sendToServer(new KeyPacket(9, RegKey.move_left.isPressed()));
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onUse2(KeyInputEvent k) {//10
		if (RegKey.use2.isPressed()) {
			if (Core.show_tip_info_testing) System.out.println("onUse2");
			Core.network.sendToServer(new KeyPacket(10, RegKey.use2.isPressed()));
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onDown(KeyInputEvent k) {//11
		if (RegKey.down.isPressed()) {
			if (Core.show_tip_info_testing) System.out.println("onDown");
			Core.network.sendToServer(new KeyPacket(11, RegKey.down.isPressed()));
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onUse1(KeyInputEvent k) {//12
		if (RegKey.use1.isPressed()) {
			if (Core.show_tip_info_testing) System.out.println("onUse1");
			Core.network.sendToServer(new KeyPacket(12, RegKey.use1.isPressed()));
		}
	}
	//--------------------------------------------------------------------------------------------------------------
}
