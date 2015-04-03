package timaxa007.module.control_button.event;

import net.minecraft.client.Minecraft;
import timaxa007.module.control_button.ModuleControlButton;
import timaxa007.module.control_button.util.ActionMouseKey;
import timaxa007.module.control_button.util.RegKey;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;

public class EventActionMouse {
	//--------------------------------------------------------------------------------------------------------------
	boolean lc, lc_last = false;
	int tick_lc = 0;

	boolean rc, rc_last = false;
	int tick_rc = 0;
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void actionBindAttack(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.START && event.side == Side.CLIENT) {
			//------------------------------------------------------------------------------------------------------
			if (ModuleControlButton.button_left) {//------------------------------------------------------------------
				//--------------------------------------------------------------------------------------------------
				if (RegKey.button_left.getIsKeyPressed()) {
					ActionMouseKey.actionLeftClickTickClient(event.player, tick_lc);
					tick_lc += 1;
					lc = true;
					if (!lc_last && lc) ActionMouseKey.actionLeftClickClient(event.player, true);//press down
					lc_last = lc;
				} else {
					tick_lc = 0;
					lc = false;
					if (lc_last && !lc) ActionMouseKey.actionLeftClickClient(event.player, false);//unpress down
					lc_last = lc;
				}
				//--------------------------------------------------------------------------------------------------
			} else {//----------------------------------------------------------------------------------------------
				//--------------------------------------------------------------------------------------------------
				if (Minecraft.getMinecraft().gameSettings.keyBindAttack.getIsKeyPressed()) {
					ActionMouseKey.actionLeftClickTickClient(event.player, tick_lc);
					tick_lc += 1;
					lc = true;
					if (!lc_last && lc) ActionMouseKey.actionLeftClickClient(event.player, true);//press down
					lc_last = lc;
				} else {
					tick_lc = 0;
					lc = false;
					if (lc_last && !lc) ActionMouseKey.actionLeftClickClient(event.player, false);//unpress down
					lc_last = lc;
				}
				//--------------------------------------------------------------------------------------------------
			}//-----------------------------------------------------------------------------------------------------
			//------------------------------------------------------------------------------------------------------
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void actionBindUseItem(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.START && event.side == Side.CLIENT) {
			//-------------------------------------------------------------------------------------------------------
			if (ModuleControlButton.button_right) {//------------------------------------------------------------------
				//---------------------------------------------------------------------------------------------------
				if (RegKey.button_right.getIsKeyPressed()) {
					ActionMouseKey.actionRightClickTickClient(event.player, tick_rc);
					tick_rc += 1;
					rc = true;
					if (!rc_last && rc) ActionMouseKey.actionRightClickClient(event.player, true);//press down
					rc_last = rc;
				} else {
					tick_rc = 0;
					rc = false;
					if (rc_last && !rc) ActionMouseKey.actionRightClickClient(event.player, false);//unpress down
					rc_last = rc;
				}
				//--------------------------------------------------------------------------------------------------
			} else {//----------------------------------------------------------------------------------------------
				//--------------------------------------------------------------------------------------------------
				if (Minecraft.getMinecraft().gameSettings.keyBindUseItem.getIsKeyPressed()) {
					ActionMouseKey.actionRightClickTickClient(event.player, tick_rc);
					tick_rc += 1;
					rc = true;
					if (!rc_last && rc) ActionMouseKey.actionRightClickClient(event.player, true);//press down
					rc_last = rc;
				} else {
					tick_rc = 0;
					rc = false;
					if (rc_last && !rc) ActionMouseKey.actionRightClickClient(event.player, false);//unpress down
					rc_last = rc;
				}
				//--------------------------------------------------------------------------------------------------
			}//-----------------------------------------------------------------------------------------------------
			//------------------------------------------------------------------------------------------------------
		}
	}
	//--------------------------------------------------------------------------------------------------------------
}
