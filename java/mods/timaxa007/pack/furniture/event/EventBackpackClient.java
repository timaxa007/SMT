package mods.timaxa007.pack.furniture.event;

import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.pack.furniture.gui.GuiBackpack;
import mods.timaxa007.pack.furniture.packet.MessageBackpack;
import net.minecraft.client.Minecraft;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;

public class EventBackpackClient {

	boolean og1, og1_last = false;
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void isGui(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.START) {
			if (Minecraft.getMinecraft().currentScreen instanceof GuiBackpack) {
				PackFurniture.network.sendToServer(new MessageBackpack(-1, true));
				og1 = true;
				sendChangedStateGui(og1_last, og1, 1);
				og1_last = og1;
			} else {
				og1 = false;
				sendChangedStateGui(og1_last, og1, 1);
				og1_last = og1;
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	public static void sendChangedStateGui(boolean last, boolean now, int pack) {
		//System.out.println("sendChangedStateMouse");
		if (!last && now) PackFurniture.network.sendToServer(new MessageBackpack(pack, true));
		if (last && !now) PackFurniture.network.sendToServer(new MessageBackpack(pack, false));
	}
	//--------------------------------------------------------------------------------------------------------------
}
