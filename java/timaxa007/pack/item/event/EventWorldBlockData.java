package timaxa007.pack.item.event;

import net.minecraftforge.event.world.WorldEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventWorldBlockData {

	@SubscribeEvent
	public void handleWorldLoad(WorldEvent.Load event) {
		/*for (ISaveEventHandler handler : PluginManager.saveEventHandlers) {
			handler.onWorldLoad(event.world);
		}*/
	}

	@SubscribeEvent
	public void handleWorldSave(WorldEvent.Save event) {
		/*for (ISaveEventHandler handler : PluginManager.saveEventHandlers) {
			handler.onWorldSave(event.world);
		}*/
	}

	@SubscribeEvent
	public void handleWorldUnload(WorldEvent.Unload event) {
		/*for (ISaveEventHandler handler : PluginManager.saveEventHandlers) {
			handler.onWorldUnload(event.world);
		}*/
	}

}
