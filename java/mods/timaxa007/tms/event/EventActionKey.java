package mods.timaxa007.tms.event;

import mods.timaxa007.tms.util.ActionPrimaryKey;
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
	k_action, k_action_last, 
	k_mode_in, k_mode_in_last, 
	k_mode_out, k_mode_out_last
	= false;
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void actionReload(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.START && event.side == Side.CLIENT) {
			if (RegKey.reload.getIsKeyPressed()) {
				ActionPrimaryKey.actionReloadTickClient(event.player);
				k_reload = true;
				if (!k_reload_last && k_reload) ActionPrimaryKey.actionReloadClient(event.player, true);//press down
				k_reload_last = k_reload;
			} else {
				k_reload = false;
				if (k_reload_last && !k_reload) ActionPrimaryKey.actionReloadClient(event.player, false);//unpress down
				k_reload_last = k_reload;
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void actionCharge(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.START && event.side == Side.CLIENT) {
			if (RegKey.charge.getIsKeyPressed()) {
				ActionPrimaryKey.actionChargeTickClient(event.player);
				k_charge = true;
				if (!k_charge_last && k_charge) ActionPrimaryKey.actionChargeClient(event.player, true);//press down
				k_charge_last = k_charge;
			} else {
				k_charge = false;
				if (k_charge_last && !k_charge) ActionPrimaryKey.actionChargeClient(event.player, false);//unpress down
				k_charge_last = k_charge;
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void actionMode(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.START && event.side == Side.CLIENT) {
			if (RegKey.mode.getIsKeyPressed()) {
				ActionPrimaryKey.actionModeTickClient(event.player);
				k_mode = true;
				if (!k_mode_last && k_mode) ActionPrimaryKey.actionModeClient(event.player, true);//press down
				k_mode_last = k_mode;
			} else {
				k_mode = false;
				if (k_mode_last && !k_mode) ActionPrimaryKey.actionModeClient(event.player, false);//unpress down
				k_mode_last = k_mode;
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void actionAction(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.START && event.side == Side.CLIENT) {
			if (RegKey.action.getIsKeyPressed()) {
				ActionPrimaryKey.actionActionTickClient(event.player);
				k_action = true;
				if (!k_action_last && k_action) ActionPrimaryKey.actionActionClient(event.player, true);//press down
				k_action_last = k_action;
			} else {
				k_action = false;
				if (k_action_last && !k_action) ActionPrimaryKey.actionActionClient(event.player, false);//unpress down
				k_action_last = k_action;
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void actionModeIn(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.START && event.side == Side.CLIENT) {
			if (RegKey.mode_in.getIsKeyPressed()) {
				ActionPrimaryKey.actionModeInTickClient(event.player);
				k_mode_in = true;
				if (!k_mode_in_last && k_mode_in) ActionPrimaryKey.actionModeInClient(event.player, true);//press down
				k_mode_in_last = k_mode_in;
			} else {
				k_mode_in = false;
				if (k_mode_in_last && !k_mode_in) ActionPrimaryKey.actionModeInClient(event.player, false);//unpress down
				k_mode_in_last = k_mode_in;
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void actionModeOut(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.START && event.side == Side.CLIENT) {
			if (RegKey.mode_out.getIsKeyPressed()) {
				ActionPrimaryKey.actionModeOutTickClient(event.player);
				k_mode_out = true;
				if (!k_mode_out_last && k_mode_out) ActionPrimaryKey.actionModeOutClient(event.player, true);//press down
				k_mode_out_last = k_mode_out;
			} else {
				k_mode_out = false;
				if (k_mode_out_last && !k_mode_out) ActionPrimaryKey.actionModeOutClient(event.player, false);//unpress down
				k_mode_out_last = k_mode_out;
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	boolean 
	k_numpad0, k_k_numpad0_last, 
	k_numpad9, k_k_numpad9_last, 
	k_numpad8, k_k_numpad8_last, 
	k_numpad7, k_k_numpad7_last, 
	k_numpad6, k_k_numpad6_last, 
	k_numpad5, k_k_numpad5_last, 
	k_numpad4, k_k_numpad4_last, 
	k_numpad3, k_k_numpad3_last, 
	k_numpad2, k_k_numpad2_last, 
	k_numpad1, k_k_numpad1_last
	= false;
	//--------------------------------------------------------------------------------------------------------------
}
