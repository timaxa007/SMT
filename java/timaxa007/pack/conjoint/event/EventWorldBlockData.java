package timaxa007.pack.conjoint.event;

import net.minecraftforge.event.world.WorldEvent;
import timaxa007.pack.conjoint.lib.ModelTile;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventWorldBlockData {

	@SubscribeEvent
	public void handleWorldLoad(WorldEvent.Load e) {
		ModelTile.get(e.world);
	}

	@SubscribeEvent
	public void handleWorldSave(WorldEvent.Save e) {

	}

	@SubscribeEvent
	public void handleWorldUnload(WorldEvent.Unload e) {

	}

}
