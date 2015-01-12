package mods.timaxa007.tms.event;

import mods.timaxa007.tms.Core;
import mods.timaxa007.tms.packet.PacketKey;
import mods.timaxa007.tms.packet.PacketKeyPrimary;
import mods.timaxa007.tms.packet.PacketKeySecondary;
import mods.timaxa007.tms.util.RegKey;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;

public class EventActionKey {
	//--------------------------------------------------------------------------------------------------------------
	boolean 
	k_reload, k_reload_last, 
	k_charge, k_charge_last, 
	k_mode, k_mode_last, 
	k_hook, k_hook_last, 
	k_zoom_in, k_zoom_in_last, 
	k_zoom_out, k_zoom_out_last, 
	k_booster, k_booster_last, 
	k_grab, k_grab_last, 
	k_lie, k_lie_last
	= false;
	boolean 
	k_use, k_use_last, 
	k_yaw_right, k_yaw_right_last, 
	k_up, k_up_last, 
	k_yaw_left, k_yaw_left_last, 
	k_move_right, k_move_right_last, 
	k_stop, k_stop_last, 
	k_move_left, k_move_left_last, 
	k_use2, k_use2_last, 
	k_down, k_down_last, 
	k_use1, k_use1_last
	= false;
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void actionReload(TickEvent.PlayerTickEvent event) {//1
		if (event.phase == TickEvent.Phase.START && event.side == Side.CLIENT) {
			if (RegKey.reload.getIsKeyPressed()) {
				Core.network.sendToServer(new PacketKeyPrimary(-1, true));
				k_reload = true;
				sendChangedStateKeyPrimary(k_reload_last, k_reload, 1);
				k_reload_last = k_reload;
			} else {
				k_reload = false;
				sendChangedStateKeyPrimary(k_reload_last, k_reload, 1);
				k_reload_last = k_reload;
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void actionCharge(TickEvent.PlayerTickEvent event) {//2
		if (event.phase == TickEvent.Phase.START && event.side == Side.CLIENT) {
			if (RegKey.charge.getIsKeyPressed()) {
				Core.network.sendToServer(new PacketKeyPrimary(-2, true));
				k_charge = true;
				sendChangedStateKeyPrimary(k_charge_last, k_charge, 2);
				k_charge_last = k_charge;
			} else {
				k_charge = false;
				sendChangedStateKeyPrimary(k_charge_last, k_charge, 2);
				k_charge_last = k_charge;
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void actionMode(TickEvent.PlayerTickEvent event) {//3
		if (event.phase == TickEvent.Phase.START && event.side == Side.CLIENT) {
			if (RegKey.mode.getIsKeyPressed()) {
				Core.network.sendToServer(new PacketKeyPrimary(-3, true));
				k_mode = true;
				sendChangedStateKeyPrimary(k_mode_last, k_mode, 3);
				k_mode_last = k_mode;
			} else {
				k_mode = false;
				sendChangedStateKeyPrimary(k_mode_last, k_mode, 3);
				k_mode_last = k_mode;
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void actionHook(TickEvent.PlayerTickEvent event) {//4
		if (event.phase == TickEvent.Phase.START && event.side == Side.CLIENT) {
			if (RegKey.hook.getIsKeyPressed()) {
				Core.network.sendToServer(new PacketKeyPrimary(-4, true));
				k_hook = true;
				sendChangedStateKeyPrimary(k_hook_last, k_hook, 4);
				k_hook_last = k_hook;
			} else {
				k_hook = false;
				sendChangedStateKeyPrimary(k_hook_last, k_hook, 4);
				k_hook_last = k_hook;
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void actionZoomIn(TickEvent.PlayerTickEvent event) {//5
		if (event.phase == TickEvent.Phase.START && event.side == Side.CLIENT) {
			if (RegKey.zoom_in.getIsKeyPressed()) {
				Core.network.sendToServer(new PacketKeyPrimary(-5, true));
				k_zoom_in = true;
				sendChangedStateKeyPrimary(k_zoom_in_last, k_zoom_in, 5);
				k_zoom_in_last = k_zoom_in;
			} else {
				k_zoom_in = false;
				sendChangedStateKeyPrimary(k_zoom_in_last, k_zoom_in, 5);
				k_zoom_in_last = k_zoom_in;
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void actionZoomOut(TickEvent.PlayerTickEvent event) {//6
		if (event.phase == TickEvent.Phase.START && event.side == Side.CLIENT) {
			if (RegKey.zoom_out.getIsKeyPressed()) {
				Core.network.sendToServer(new PacketKeyPrimary(-6, true));
				k_zoom_out = true;
				sendChangedStateKeyPrimary(k_zoom_out_last, k_zoom_out, 6);
				k_zoom_out_last = k_zoom_out;
			} else {
				k_zoom_out = false;
				sendChangedStateKeyPrimary(k_zoom_out_last, k_zoom_out, 6);
				k_zoom_out_last = k_zoom_out;
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void actionBooster(TickEvent.PlayerTickEvent event) {//13
		if (event.phase == TickEvent.Phase.START && event.side == Side.CLIENT) {
			if (RegKey.booster.getIsKeyPressed()) {
				Core.network.sendToServer(new PacketKey(-13, true));
				k_booster = true;
				sendChangedStateKey(k_booster_last, k_booster, 13);
				k_booster_last = k_booster;
			} else {
				k_booster = false;
				sendChangedStateKey(k_booster_last, k_booster, 13);
				k_booster_last = k_booster;
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void actionGrab(TickEvent.PlayerTickEvent event) {//14
		if (event.phase == TickEvent.Phase.START && event.side == Side.CLIENT) {
			if (RegKey.grab.getIsKeyPressed()) {
				Core.network.sendToServer(new PacketKey(-14, true));
				k_grab = true;
				sendChangedStateKey(k_grab_last, k_grab, 14);
				k_grab_last = k_grab;
			} else {
				k_grab = false;
				sendChangedStateKey(k_grab_last, k_grab, 14);
				k_grab_last = k_grab;
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void actionLie(TickEvent.PlayerTickEvent event) {//15
		if (event.phase == TickEvent.Phase.START && event.side == Side.CLIENT) {
			if (RegKey.lie.getIsKeyPressed()) {
				Core.network.sendToServer(new PacketKey(-15, true));
				k_lie = true;
				sendChangedStateKey(k_lie_last, k_lie, 15);
				k_lie_last = k_lie;
			} else {
				k_lie = false;
				sendChangedStateKey(k_lie_last, k_lie, 15);
				k_lie_last = k_lie;
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void actionUse(TickEvent.PlayerTickEvent event) {//1
		if (event.phase == TickEvent.Phase.START && event.side == Side.CLIENT) {
			if (RegKey.use.getIsKeyPressed()) {
				Core.network.sendToServer(new PacketKeySecondary(-1, true));
				k_use = true;
				sendChangedStateKeySecondary(k_use_last, k_use, 1);
				k_use_last = k_use;
			} else {
				k_use = false;
				sendChangedStateKeySecondary(k_use_last, k_use, 1);
				k_use_last = k_use;
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void actionYawRight(TickEvent.PlayerTickEvent event) {//2
		if (event.phase == TickEvent.Phase.START && event.side == Side.CLIENT) {
			if (RegKey.yaw_right.getIsKeyPressed()) {
				Core.network.sendToServer(new PacketKeySecondary(-2, true));
				k_yaw_right = true;
				sendChangedStateKeySecondary(k_yaw_right_last, k_yaw_right, 2);
				k_yaw_right_last = k_yaw_right;
			} else {
				k_yaw_right = false;
				sendChangedStateKeySecondary(k_yaw_right_last, k_yaw_right, 2);
				k_yaw_right_last = k_yaw_right;
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void actionUp(TickEvent.PlayerTickEvent event) {//3
		if (event.phase == TickEvent.Phase.START && event.side == Side.CLIENT) {
			if (RegKey.up.getIsKeyPressed()) {
				Core.network.sendToServer(new PacketKeySecondary(-3, true));
				k_up = true;
				sendChangedStateKeySecondary(k_up_last, k_up, 3);
				k_up_last = k_up;
			} else {
				k_up = false;
				sendChangedStateKeySecondary(k_up_last, k_up, 3);
				k_up_last = k_up;
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void actionYawLeft(TickEvent.PlayerTickEvent event) {//4
		if (event.phase == TickEvent.Phase.START && event.side == Side.CLIENT) {
			if (RegKey.yaw_left.getIsKeyPressed()) {
				Core.network.sendToServer(new PacketKeySecondary(-4, true));
				k_yaw_left = true;
				sendChangedStateKeySecondary(k_yaw_left_last, k_yaw_left, 4);
				k_yaw_left_last = k_yaw_left;
			} else {
				k_yaw_left = false;
				sendChangedStateKeySecondary(k_yaw_left_last, k_yaw_left, 4);
				k_yaw_left_last = k_yaw_left;
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void actionMoveRight(TickEvent.PlayerTickEvent event) {//5
		if (event.phase == TickEvent.Phase.START && event.side == Side.CLIENT) {
			if (RegKey.move_right.getIsKeyPressed()) {
				Core.network.sendToServer(new PacketKeySecondary(-5, true));
				k_move_right = true;
				sendChangedStateKeySecondary(k_move_right_last, k_move_right, 5);
				k_move_right_last = k_move_right;
			} else {
				k_move_right = false;
				sendChangedStateKeySecondary(k_move_right_last, k_move_right, 5);
				k_move_right_last = k_move_right;
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void actionStop(TickEvent.PlayerTickEvent event) {//6
		if (event.phase == TickEvent.Phase.START && event.side == Side.CLIENT) {
			if (RegKey.stop.getIsKeyPressed()) {
				Core.network.sendToServer(new PacketKeySecondary(-6, true));
				k_stop = true;
				sendChangedStateKeySecondary(k_stop_last, k_stop, 6);
				k_stop_last = k_stop;
			} else {
				k_stop = false;
				sendChangedStateKeySecondary(k_stop_last, k_stop, 6);
				k_stop_last = k_stop;
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void actionMoveLeft(TickEvent.PlayerTickEvent event) {//7
		if (event.phase == TickEvent.Phase.START && event.side == Side.CLIENT) {
			if (RegKey.move_left.getIsKeyPressed()) {
				Core.network.sendToServer(new PacketKeySecondary(-7, true));
				k_move_left = true;
				sendChangedStateKeySecondary(k_move_left_last, k_move_left, 7);
				k_move_left_last = k_move_left;
			} else {
				k_move_left = false;
				sendChangedStateKeySecondary(k_move_left_last, k_move_left, 7);
				k_move_left_last = k_move_left;
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void actionUse2(TickEvent.PlayerTickEvent event) {//8
		if (event.phase == TickEvent.Phase.START && event.side == Side.CLIENT) {
			if (RegKey.use2.getIsKeyPressed()) {
				Core.network.sendToServer(new PacketKeySecondary(-8, true));
				k_use2 = true;
				sendChangedStateKeySecondary(k_use2_last, k_use2, 8);
				k_use2_last = k_use2;
			} else {
				k_use2 = false;
				sendChangedStateKeySecondary(k_use2_last, k_use2, 8);
				k_use2_last = k_use2;
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void actionDown(TickEvent.PlayerTickEvent event) {//9
		if (event.phase == TickEvent.Phase.START && event.side == Side.CLIENT) {
			if (RegKey.down.getIsKeyPressed()) {
				Core.network.sendToServer(new PacketKeySecondary(-9, true));
				k_down = true;
				sendChangedStateKeySecondary(k_down_last, k_down, 9);
				k_down_last = k_down;
			} else {
				k_down = false;
				sendChangedStateKeySecondary(k_down_last, k_down, 9);
				k_down_last = k_down;
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void actionUse1(TickEvent.PlayerTickEvent event) {//10
		if (event.phase == TickEvent.Phase.START && event.side == Side.CLIENT) {
			if (RegKey.use1.getIsKeyPressed()) {
				Core.network.sendToServer(new PacketKeySecondary(-10, true));
				k_use1 = true;
				sendChangedStateKeySecondary(k_use1_last, k_use1, 10);
				k_use1_last = k_use1;
			} else {
				k_use1 = false;
				sendChangedStateKeySecondary(k_use1_last, k_use1, 10);
				k_use1_last = k_use1;
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	public static void sendChangedStateKeyPrimary(boolean last, boolean now, int pack) {
		//System.out.println("sendChangedStateKeyPrimary");
		if (!last && now) Core.network.sendToServer(new PacketKeyPrimary(pack, true));
		if (last && !now) Core.network.sendToServer(new PacketKeyPrimary(pack, false));
	}
	//--------------------------------------------------------------------------------------------------------------
	public static void sendChangedStateKeySecondary(boolean last, boolean now, int pack) {
		//System.out.println("sendChangedStateKeySecondary");
		if (!last && now) Core.network.sendToServer(new PacketKeySecondary(pack, true));
		if (last && !now) Core.network.sendToServer(new PacketKeySecondary(pack, false));
	}
	//--------------------------------------------------------------------------------------------------------------
	public static void sendChangedStateKey(boolean last, boolean now, int pack) {
		//System.out.println("sendChangedStateKey");
		if (!last && now) Core.network.sendToServer(new PacketKey(pack, true));
		if (last && !now) Core.network.sendToServer(new PacketKey(pack, false));
	}
	//--------------------------------------------------------------------------------------------------------------
}
