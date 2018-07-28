package smt.pack.player.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerOpenContainerEvent;

public class EventsForge {

	@SubscribeEvent
	public void containerOpen(PlayerOpenContainerEvent event) {
		//event.entityPlayer.openContainer
		if (event.entityPlayer.openContainer != null) {
			//System.out.println("Open Container = " + event.entityPlayer.openContainer.toString() + ".");
		}
	}

}
