package timaxa007.pack.furniture.event;

import timaxa007.pack.furniture.PackFurniture;
import timaxa007.pack.furniture.packet.MessageBackpack;

public class EventBackpackClient {
/*
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
	}*/
	//--------------------------------------------------------------------------------------------------------------
	public static void sendChangedStateGui(boolean last, boolean now, int pack) {
		//System.out.println("sendChangedStateMouse");
		if (!last && now) PackFurniture.network.sendToServer(new MessageBackpack(pack, true));
		if (last && !now) PackFurniture.network.sendToServer(new MessageBackpack(pack, false));
	}
	//--------------------------------------------------------------------------------------------------------------
}
