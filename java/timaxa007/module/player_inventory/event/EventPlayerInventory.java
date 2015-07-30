package timaxa007.module.player_inventory.event;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class EventPlayerInventory {
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void playerLoggedIn(PlayerEvent.PlayerLoggedInEvent e) {
		EntityPlayer player = e.player;
		if (player != null) {}

	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void playerLoggedOut(PlayerEvent.PlayerLoggedOutEvent e) {
		//System.out.println("/***/ - " + e.player.getCommandSenderName());
	}
	//--------------------------------------------------------------------------------------------------------------
}
