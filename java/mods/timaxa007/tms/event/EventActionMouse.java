package mods.timaxa007.tms.event;

import mods.timaxa007.tms.util.ActionMouseKey;
import net.minecraft.client.Minecraft;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;

public class EventActionMouse {

	boolean rc, rc_last = false;
	boolean lc, lc_last = false;
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void actionBindAttack(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.START && event.side == Side.CLIENT) {
			if (Minecraft.getMinecraft().gameSettings.keyBindAttack.getIsKeyPressed()) {
				ActionMouseKey.onLeftClickTickClient(event.player);
				lc = true;
				if (!lc_last && lc) ActionMouseKey.onLeftClickClient(event.player, true);//press down
				lc_last = lc;
			} else {
				lc = false;
				if (lc_last && !lc) ActionMouseKey.onLeftClickClient(event.player, false);//unpress down
				lc_last = lc;
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void actionBindUseItem(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.START && event.side == Side.CLIENT) {
			if (Minecraft.getMinecraft().gameSettings.keyBindUseItem.getIsKeyPressed()) {
				ActionMouseKey.onRightClickTickClient(event.player);
				rc = true;
				if (!rc_last && rc) ActionMouseKey.onRightClickClient(event.player, true);//press down
				rc_last = rc;
			} else {
				rc = false;
				if (rc_last && !rc) ActionMouseKey.onRightClickClient(event.player, false);//unpress down
				rc_last = rc;
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
}
