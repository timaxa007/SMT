package smt.pack.player.client.event;

import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;

public final class EventsClient {

	public static final void init() {
		MinecraftForge.EVENT_BUS.register(new EventsForgeClient());
		FMLCommonHandler.instance().bus().register(new EventActionInventoryInitClient());
	}

}
