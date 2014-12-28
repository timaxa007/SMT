package mods.timaxa007.tms.util;

import mods.timaxa007.tms.Core;
import mods.timaxa007.tms.ProxyClient;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;

public class EventKey {
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onReload(KeyInputEvent k) {//0
		if (ProxyClient.reload.isPressed()) {
			//if (Core.show_tip_info_testing) System.out.println("onReload");
			Core.network.sendToServer(new KeyPacket(0));
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onCharge(KeyInputEvent k) {//1
		if (ProxyClient.charge.isPressed()) {
			//if (Core.show_tip_info_testing) System.out.println("onCharge");
			Core.network.sendToServer(new KeyPacket(1));
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onMode(KeyInputEvent k) {//2
		if (ProxyClient.mode.isPressed()) {
			//if (Core.show_tip_info_testing) System.out.println("onMode");
			Core.network.sendToServer(new KeyPacket(2));
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onUse(KeyInputEvent k) {//3
		if (ProxyClient.use.isPressed()) {
			if (Core.show_tip_info_testing) System.out.println("onUse");
			Core.network.sendToServer(new KeyPacket(3));
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onYawRight(KeyInputEvent k) {//4
		if (ProxyClient.yaw_right.isPressed()) {
			if (Core.show_tip_info_testing) System.out.println("onYawRight");
			Core.network.sendToServer(new KeyPacket(4));
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onUp(KeyInputEvent k) {//5
		if (ProxyClient.up.isPressed()) {
			if (Core.show_tip_info_testing) System.out.println("onUp");
			Core.network.sendToServer(new KeyPacket(5));
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onYawLeft(KeyInputEvent k) {//6
		if (ProxyClient.yaw_left.isPressed()) {
			if (Core.show_tip_info_testing) System.out.println("onYawLeft");
			Core.network.sendToServer(new KeyPacket(6));
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onMoveRight(KeyInputEvent k) {//7
		if (ProxyClient.move_right.isPressed()) {
			if (Core.show_tip_info_testing) System.out.println("onMoveRight");
			Core.network.sendToServer(new KeyPacket(7));
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onStop(KeyInputEvent k) {//8
		if (ProxyClient.stop.isPressed()) {
			if (Core.show_tip_info_testing) System.out.println("onStop");
			Core.network.sendToServer(new KeyPacket(8));
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onMoveLeft(KeyInputEvent k) {//9
		if (ProxyClient.move_left.isPressed()) {
			if (Core.show_tip_info_testing) System.out.println("onMoveLeft");
			Core.network.sendToServer(new KeyPacket(9));
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onUse2(KeyInputEvent k) {//10
		if (ProxyClient.use2.isPressed()) {
			if (Core.show_tip_info_testing) System.out.println("onUse2");
			Core.network.sendToServer(new KeyPacket(10));
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onDown(KeyInputEvent k) {//11
		if (ProxyClient.down.isPressed()) {
			if (Core.show_tip_info_testing) System.out.println("onDown");
			Core.network.sendToServer(new KeyPacket(11));
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onUse1(KeyInputEvent k) {//12
		if (ProxyClient.use1.isPressed()) {
			if (Core.show_tip_info_testing) System.out.println("onUse1");
			Core.network.sendToServer(new KeyPacket(12));
		}
	}
	//--------------------------------------------------------------------------------------------------------------
}
