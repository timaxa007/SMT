package smt.pack.player.event;

import net.minecraftforge.common.MinecraftForge;

public final class Events {

	public static final void init() {
		MinecraftForge.EVENT_BUS.register(new EventsForge());
		//FMLCommonHandler.instance().bus().register(new EventItemStorage());
	}

}
