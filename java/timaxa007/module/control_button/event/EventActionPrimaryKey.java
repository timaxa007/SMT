package timaxa007.module.control_button.event;

import timaxa007.module.control_button.util.ActionPrimaryKey;
import timaxa007.module.control_button.util.RegKey;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;

public class EventActionPrimaryKey {
	//--------------------------------------------------------------------------------------------------------------
	private static boolean
	k_reload, k_reload_last,
	k_charge, k_charge_last,
	k_mode, k_mode_last,
	k_action, k_action_last,
	k_mode_in, k_mode_in_last,
	k_mode_out, k_mode_out_last
	;

	private static int
	tick_reload,
	tick_charge,
	tick_mode,
	tick_action,
	tick_mode_in,
	tick_mode_out
	;

	static {
		k_reload = k_reload_last = 
				k_charge = k_charge_last = 
				k_mode = k_mode_last = 
				k_action = k_action_last = 
				k_mode_in = k_mode_in_last = 
				k_mode_out = k_mode_out_last = 
				false;

		tick_reload = 
				tick_charge = 
				tick_mode = 
				tick_action = 
				tick_mode_in = 
				tick_mode_out = 
				0;
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void actionReload(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.START && event.side == Side.CLIENT) {
			if (RegKey.reload.getIsKeyPressed()) {
				ActionPrimaryKey.actionReloadTickClient(event.player, tick_reload);
				tick_reload += 1;
				k_reload = true;
				if (!k_reload_last && k_reload) ActionPrimaryKey.actionReloadClient(event.player, true);//press down
				k_reload_last = k_reload;
			} else {
				tick_reload = 0;
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
				ActionPrimaryKey.actionChargeTickClient(event.player, tick_charge);
				tick_charge += 1;
				k_charge = true;
				if (!k_charge_last && k_charge) ActionPrimaryKey.actionChargeClient(event.player, true);//press down
				k_charge_last = k_charge;
			} else {
				tick_charge = 0;
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
				ActionPrimaryKey.actionModeTickClient(event.player, tick_mode);
				tick_mode += 1;
				k_mode = true;
				if (!k_mode_last && k_mode) ActionPrimaryKey.actionModeClient(event.player, true);//press down
				k_mode_last = k_mode;
			} else {
				tick_mode = 0;
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
				ActionPrimaryKey.actionActionTickClient(event.player, tick_action);
				tick_action += 1;
				k_action = true;
				if (!k_action_last && k_action) ActionPrimaryKey.actionActionClient(event.player, true);//press down
				k_action_last = k_action;
			} else {
				tick_action = 0;
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
				ActionPrimaryKey.actionModeInTickClient(event.player, tick_mode_in);
				tick_mode_in += 1;
				k_mode_in = true;
				if (!k_mode_in_last && k_mode_in) ActionPrimaryKey.actionModeInClient(event.player, true);//press down
				k_mode_in_last = k_mode_in;
			} else {
				tick_mode_in = 0;
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
				ActionPrimaryKey.actionModeOutTickClient(event.player, tick_mode_out);
				tick_mode_out += 1;
				k_mode_out = true;
				if (!k_mode_out_last && k_mode_out) ActionPrimaryKey.actionModeOutClient(event.player, true);//press down
				k_mode_out_last = k_mode_out;
			} else {
				tick_mode_out = 0;
				k_mode_out = false;
				if (k_mode_out_last && !k_mode_out) ActionPrimaryKey.actionModeOutClient(event.player, false);//unpress down
				k_mode_out_last = k_mode_out;
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
}
