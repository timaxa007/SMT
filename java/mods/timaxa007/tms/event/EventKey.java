package mods.timaxa007.tms.event;

import mods.timaxa007.tms.Core;
import mods.timaxa007.tms.packet.PacketKey;
import mods.timaxa007.tms.util.RegKey;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;

public class EventKey {
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onReload(InputEvent.KeyInputEvent k) {//0
		if (RegKey.reload.isPressed()) Core.network.sendToServer(new PacketKey(0, true));
		//else if (!RegKey.reload.isPressed()) Core.network.sendToServer(new PacketKey(0, false));
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onCharge(InputEvent.KeyInputEvent k) {//1
		if (RegKey.charge.isPressed()) Core.network.sendToServer(new PacketKey(1, true));
		//else if (!RegKey.charge.isPressed()) Core.network.sendToServer(new PacketKey(1, false));
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onMode(InputEvent.KeyInputEvent k) {//2
		if (RegKey.mode.isPressed()) Core.network.sendToServer(new PacketKey(2, true));
		//else if (!RegKey.mode.isPressed()) Core.network.sendToServer(new PacketKey(2, false));
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onUse(InputEvent.KeyInputEvent k) {//3
		if (RegKey.use.isPressed()) Core.network.sendToServer(new PacketKey(3, true));
		//else if (!RegKey.use.isPressed()) Core.network.sendToServer(new PacketKey(3, false));
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onYawRight(InputEvent.KeyInputEvent k) {//4
		if (RegKey.yaw_right.isPressed()) Core.network.sendToServer(new PacketKey(4, true));
		//else if (!RegKey.yaw_right.isPressed()) Core.network.sendToServer(new PacketKey(4, false));
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onUp(InputEvent.KeyInputEvent k) {//5
		if (RegKey.up.isPressed()) Core.network.sendToServer(new PacketKey(5, true));
		//else if (!RegKey.up.isPressed()) Core.network.sendToServer(new PacketKey(5, false));
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onYawLeft(InputEvent.KeyInputEvent k) {//6
		if (RegKey.yaw_left.isPressed()) Core.network.sendToServer(new PacketKey(6, true));
		//else if (!RegKey.yaw_left.isPressed()) Core.network.sendToServer(new PacketKey(6, false));
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onMoveRight(InputEvent.KeyInputEvent k) {//7
		if (RegKey.move_right.isPressed()) Core.network.sendToServer(new PacketKey(7, true));
		//else if (!RegKey.move_right.isPressed()) Core.network.sendToServer(new PacketKey(7, false));
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onStop(InputEvent.KeyInputEvent k) {//8
		if (RegKey.stop.isPressed()) Core.network.sendToServer(new PacketKey(8, true));
		//else if (!RegKey.stop.isPressed()) Core.network.sendToServer(new PacketKey(8, false));
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onMoveLeft(InputEvent.KeyInputEvent k) {//9
		if (RegKey.move_left.isPressed()) Core.network.sendToServer(new PacketKey(9, true));
		//else if (!RegKey.move_left.isPressed()) Core.network.sendToServer(new PacketKey(9, false));
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onUse2(InputEvent.KeyInputEvent k) {//10
		if (RegKey.use2.isPressed()) Core.network.sendToServer(new PacketKey(10, true));
		//else if (!RegKey.use2.isPressed()) Core.network.sendToServer(new PacketKey(10, false));
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onDown(InputEvent.KeyInputEvent k) {//11
		if (RegKey.down.isPressed()) Core.network.sendToServer(new PacketKey(11, true));
		//else if (!RegKey.down.isPressed()) Core.network.sendToServer(new PacketKey(11, false));
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onUse1(InputEvent.KeyInputEvent k) {//12
		if (RegKey.use1.isPressed()) Core.network.sendToServer(new PacketKey(12, true));
		//else if (!RegKey.use1.isPressed()) Core.network.sendToServer(new PacketKey(12, false));
	}
	//--------------------------------------------------------------------------------------------------------------
}
