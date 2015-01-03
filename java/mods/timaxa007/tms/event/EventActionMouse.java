package mods.timaxa007.tms.event;

import mods.timaxa007.tms.Core;
import mods.timaxa007.tms.packet.PacketMouseKey;
import net.minecraft.client.Minecraft;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;

public class EventActionMouse {

	boolean rc = false;
	boolean rc_last = false;
	boolean lc = false;
	boolean lc_last = false;
	//--------------------------------------------------------------------------------------------------------------
	/*@SubscribeEvent
	public void onLeftClick(InputEvent.MouseInputEvent m) {//1
		if (Minecraft.getMinecraft().gameSettings.keyBindAttack.getIsKeyPressed())
			Core.network.sendToServer(new PacketMouseKey(1, true));
			//It is triggered when any button is pressed, and not after it was released the button.
		//else Core.network.sendToServer(new PacketMouseKey(1, false));//very bad
	}*/
	//--------------------------------------------------------------------------------------------------------------
	/*@SubscribeEvent
	public void onRightClick(InputEvent.MouseInputEvent m) {//2
		if (Minecraft.getMinecraft().gameSettings.keyBindUseItem.getIsKeyPressed())
			Core.network.sendToServer(new PacketMouseKey(2, true));
			//It is triggered when any button is pressed, and not after it was released the button.
		//else Core.network.sendToServer(new PacketMouseKey(2, false));//very bad
	}*/
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void /*onLeftClickTick*/actionBindAttack(TickEvent.PlayerTickEvent event) {//3
		if (event.phase == TickEvent.Phase.START && event.side == Side.CLIENT) {
			if (Minecraft.getMinecraft().gameSettings.keyBindAttack.getIsKeyPressed()) {
				Core.network.sendToServer(new PacketMouseKey(3, true));
				lc = true;
				sendChangedState(lc_last, lc, 1);
				lc_last = lc;
			} else {
				lc = false;
				sendChangedState(lc_last, lc, 1);
				lc_last = lc;
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void /*onRightClickTick*/actionBindUseItem(TickEvent.PlayerTickEvent event) {//4
		if (event.phase == TickEvent.Phase.START && event.side == Side.CLIENT) {
			if (Minecraft.getMinecraft().gameSettings.keyBindUseItem.getIsKeyPressed()) {
				Core.network.sendToServer(new PacketMouseKey(4, true));
				rc = true;
				sendChangedState(rc_last, rc, 2);
				rc_last = rc;
			} else {
				rc = false;
				sendChangedState(rc_last, rc, 2);
				rc_last = rc;
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	public static void sendChangedState(boolean last, boolean now, int pack) {
		//System.out.println("---");
		if (!last && now) Core.network.sendToServer(new PacketMouseKey(pack, true));
		if (last && !now) Core.network.sendToServer(new PacketMouseKey(pack, false));
	}
	//--------------------------------------------------------------------------------------------------------------
}
