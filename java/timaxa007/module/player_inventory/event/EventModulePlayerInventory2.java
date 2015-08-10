package timaxa007.module.player_inventory.event;

import net.minecraftforge.event.entity.player.PlayerOpenContainerEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventModulePlayerInventory2 {
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void actiCon(PlayerOpenContainerEvent e) {
		//ModulePlayerInventory.log.info("Container:" + e.entityPlayer.openContainer.toString() + ", " + e.canInteractWith + ".");
	}
	//--------------------------------------------------------------------------------------------------------------
}
