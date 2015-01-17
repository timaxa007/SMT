package mods.timaxa007.tms.event;

import mods.timaxa007.tms.Core;
import mods.timaxa007.tms.packet.MessageMouseKey;
import net.minecraft.client.Minecraft;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;

public class EventActionMouse_old {

	boolean rc, rc_last = false;
	boolean lc, lc_last = false;
	//--------------------------------------------------------------------------------------------------------------
	/*@SubscribeEvent
	public void onLeftClick(InputEvent.MouseInputEvent m) {//1
		if (Minecraft.getMinecraft().gameSettings.keyBindAttack.getIsKeyPressed())
			Core.network.sendToServer(new MessageMouseKey(1, true));
			//It is triggered when any button is pressed, and not after it was released the button.
		//else Core.network.sendToServer(new MessageMouseKey(1, false));//very bad
	}*/
	//--------------------------------------------------------------------------------------------------------------
	/*@SubscribeEvent
	public void onRightClick(InputEvent.MouseInputEvent m) {//2
		if (Minecraft.getMinecraft().gameSettings.keyBindUseItem.getIsKeyPressed())
			Core.network.sendToServer(new MessageMouseKey(2, true));
			//It is triggered when any button is pressed, and not after it was released the button.
		//else Core.network.sendToServer(new MessageMouseKey(2, false));//very bad
	}*/
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void /*onLeftClickTick*/actionBindAttack(TickEvent.PlayerTickEvent event) {//3
		if (event.phase == TickEvent.Phase.START && event.side == Side.CLIENT) {
			if (Minecraft.getMinecraft().gameSettings.keyBindAttack.getIsKeyPressed()) {
				Core.network.sendToServer(new MessageMouseKey(-1, true));//Tick
				lc = true;
				sendChangedStateMouse(lc_last, lc, 1);//press down
				lc_last = lc;
			} else {
				lc = false;
				sendChangedStateMouse(lc_last, lc, 1);//unpress down
				lc_last = lc;
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void /*onRightClickTick*/actionBindUseItem(TickEvent.PlayerTickEvent event) {//4
		if (event.phase == TickEvent.Phase.START && event.side == Side.CLIENT) {
			if (Minecraft.getMinecraft().gameSettings.keyBindUseItem.getIsKeyPressed()) {
				Core.network.sendToServer(new MessageMouseKey(-2, true));//Tick
				rc = true;
				sendChangedStateMouse(rc_last, rc, 2);//press down
				rc_last = rc;
			} else {
				rc = false;
				sendChangedStateMouse(rc_last, rc, 2);//unpress down
				rc_last = rc;
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	public static void sendChangedStateMouse(boolean last, boolean now, int pack) {
		//System.out.println("sendChangedStateMouse");
		if (!last && now) Core.network.sendToServer(new MessageMouseKey(pack, true));
		if (last && !now) Core.network.sendToServer(new MessageMouseKey(pack, false));
	}
	//--------------------------------------------------------------------------------------------------------------
}
