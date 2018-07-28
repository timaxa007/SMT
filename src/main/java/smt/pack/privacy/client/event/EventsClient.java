package smt.pack.privacy.client.event;

import net.minecraftforge.common.MinecraftForge;

public final class EventsClient {

	public static final void init() {
		MinecraftForge.EVENT_BUS.register(new EventsForgeClient());
		//FMLCommonHandler.instance().bus().register(new EventItemStorage());
	}

}
