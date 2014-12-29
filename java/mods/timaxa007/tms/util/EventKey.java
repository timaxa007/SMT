package mods.timaxa007.tms.util;

import mods.timaxa007.tms.Core;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;

public class EventKey {
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onReload(InputEvent.KeyInputEvent k) {//0
		if (RegKey.reload.isPressed()) Core.network.sendToServer(new KeyPacket(0, true));
		//else if (!RegKey.reload.isPressed()) Core.network.sendToServer(new KeyPacket(0, false));
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onCharge(InputEvent.KeyInputEvent k) {//1
		if (RegKey.charge.isPressed()) Core.network.sendToServer(new KeyPacket(1, true));
		//else if (!RegKey.charge.isPressed()) Core.network.sendToServer(new KeyPacket(1, false));
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onMode(InputEvent.KeyInputEvent k) {//2
		if (RegKey.mode.isPressed()) Core.network.sendToServer(new KeyPacket(2, true));
		//else if (!RegKey.mode.isPressed()) Core.network.sendToServer(new KeyPacket(2, false));
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onUse(InputEvent.KeyInputEvent k) {//3
		if (RegKey.use.isPressed()) Core.network.sendToServer(new KeyPacket(3, true));
		//else if (!RegKey.use.isPressed()) Core.network.sendToServer(new KeyPacket(3, false));
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onYawRight(InputEvent.KeyInputEvent k) {//4
		if (RegKey.yaw_right.isPressed()) Core.network.sendToServer(new KeyPacket(4, true));
		//else if (!RegKey.yaw_right.isPressed()) Core.network.sendToServer(new KeyPacket(4, false));
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onUp(InputEvent.KeyInputEvent k) {//5
		if (RegKey.up.isPressed()) Core.network.sendToServer(new KeyPacket(5, true));
		//else if (!RegKey.up.isPressed()) Core.network.sendToServer(new KeyPacket(5, false));
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onYawLeft(InputEvent.KeyInputEvent k) {//6
		if (RegKey.yaw_left.isPressed()) Core.network.sendToServer(new KeyPacket(6, true));
		//else if (!RegKey.yaw_left.isPressed()) Core.network.sendToServer(new KeyPacket(6, false));
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onMoveRight(InputEvent.KeyInputEvent k) {//7
		if (RegKey.move_right.isPressed()) Core.network.sendToServer(new KeyPacket(7, true));
		//else if (!RegKey.move_right.isPressed()) Core.network.sendToServer(new KeyPacket(7, false));
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onStop(InputEvent.KeyInputEvent k) {//8
		if (RegKey.stop.isPressed()) Core.network.sendToServer(new KeyPacket(8, true));
		//else if (!RegKey.stop.isPressed()) Core.network.sendToServer(new KeyPacket(8, false));
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onMoveLeft(InputEvent.KeyInputEvent k) {//9
		if (RegKey.move_left.isPressed()) Core.network.sendToServer(new KeyPacket(9, true));
		//else if (!RegKey.move_left.isPressed()) Core.network.sendToServer(new KeyPacket(9, false));
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onUse2(InputEvent.KeyInputEvent k) {//10
		if (RegKey.use2.isPressed()) Core.network.sendToServer(new KeyPacket(10, true));
		//else if (!RegKey.use2.isPressed()) Core.network.sendToServer(new KeyPacket(10, false));
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onDown(InputEvent.KeyInputEvent k) {//11
		if (RegKey.down.isPressed()) Core.network.sendToServer(new KeyPacket(11, true));
		//else if (!RegKey.down.isPressed()) Core.network.sendToServer(new KeyPacket(11, false));
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onUse1(InputEvent.KeyInputEvent k) {//12
		if (RegKey.use1.isPressed()) Core.network.sendToServer(new KeyPacket(12, true));
		//else if (!RegKey.use1.isPressed()) Core.network.sendToServer(new KeyPacket(12, false));
	}
	//--------------------------------------------------------------------------------------------------------------
}
