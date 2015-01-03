package mods.timaxa007.tms.event;

import mods.timaxa007.tms.Core;
import mods.timaxa007.tms.packet.PacketKey;
import mods.timaxa007.tms.packet.PacketKeyPrimary;
import mods.timaxa007.tms.packet.PacketKeySecondary;
import mods.timaxa007.tms.util.RegKey;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;

public class EventKey {
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onReload(InputEvent.KeyInputEvent k) {//1
		if (RegKey.reload.getIsKeyPressed()) Core.network.sendToServer(new PacketKeyPrimary(1));
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onCharge(InputEvent.KeyInputEvent k) {//2
		if (RegKey.charge.getIsKeyPressed()) Core.network.sendToServer(new PacketKeyPrimary(2));
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onMode(InputEvent.KeyInputEvent k) {//3
		if (RegKey.mode.getIsKeyPressed()) Core.network.sendToServer(new PacketKeyPrimary(3));
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onHook(InputEvent.KeyInputEvent k) {//4
		if (RegKey.hook.getIsKeyPressed()) Core.network.sendToServer(new PacketKeyPrimary(4));
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onBooster(InputEvent.KeyInputEvent k) {//13
		if (RegKey.booster.getIsKeyPressed()) Core.network.sendToServer(new PacketKey(13, true));
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onGrab(InputEvent.KeyInputEvent k) {//14
		if (RegKey.grab.getIsKeyPressed()) Core.network.sendToServer(new PacketKey(14, true));
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onLie(InputEvent.KeyInputEvent k) {//15
		if (RegKey.lie.getIsKeyPressed()) Core.network.sendToServer(new PacketKey(15, true));
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onUse(InputEvent.KeyInputEvent k) {//1
		if (RegKey.use.getIsKeyPressed()) Core.network.sendToServer(new PacketKeySecondary(1, true));
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onYawRight(InputEvent.KeyInputEvent k) {//2
		if (RegKey.yaw_right.getIsKeyPressed()) Core.network.sendToServer(new PacketKeySecondary(2, true));
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onUp(InputEvent.KeyInputEvent k) {//3
		if (RegKey.up.getIsKeyPressed()) Core.network.sendToServer(new PacketKeySecondary(3, true));
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onYawLeft(InputEvent.KeyInputEvent k) {//4
		if (RegKey.yaw_left.getIsKeyPressed()) Core.network.sendToServer(new PacketKeySecondary(4, true));
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onMoveRight(InputEvent.KeyInputEvent k) {//5
		if (RegKey.move_right.getIsKeyPressed()) Core.network.sendToServer(new PacketKeySecondary(5, true));
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onStop(InputEvent.KeyInputEvent k) {//6
		if (RegKey.stop.getIsKeyPressed()) Core.network.sendToServer(new PacketKeySecondary(6, true));
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onMoveLeft(InputEvent.KeyInputEvent k) {//7
		if (RegKey.move_left.getIsKeyPressed()) Core.network.sendToServer(new PacketKeySecondary(7, true));
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onUse2(InputEvent.KeyInputEvent k) {//8
		if (RegKey.use2.getIsKeyPressed()) Core.network.sendToServer(new PacketKeySecondary(8, true));
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onDown(InputEvent.KeyInputEvent k) {//9
		if (RegKey.down.getIsKeyPressed()) Core.network.sendToServer(new PacketKeySecondary(9, true));
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onUse1(InputEvent.KeyInputEvent k) {//10
		if (RegKey.use1.getIsKeyPressed()) Core.network.sendToServer(new PacketKeySecondary(10, true));
	}
	//--------------------------------------------------------------------------------------------------------------
}
