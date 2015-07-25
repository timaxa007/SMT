package timaxa007.module.player_inventory.event;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import timaxa007.gui.HelperGui;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class EventPlayerInventory {
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void playerLogged(PlayerEvent.PlayerLoggedInEvent e) {
		EntityPlayer player = e.player;
		if (player != null) {}

	}
	//--------------------------------------------------------------------------------------------------------------
}
