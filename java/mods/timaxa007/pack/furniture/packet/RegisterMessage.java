package mods.timaxa007.pack.furniture.packet;

import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class RegisterMessage {

	private static int id = 0;

	public static void init(SimpleNetworkWrapper network) {
		network.registerMessage(MessagePackFurnitureServer.Handler.class, MessagePackFurnitureServer.class, id++, Side.SERVER);
		network.registerMessage(MessagePackFurnitureClient.Handler.class, MessagePackFurnitureClient.class, id++, Side.CLIENT);
		network.registerMessage(MessageBackpack.Handler.class, MessageBackpack.class, id++, Side.SERVER);
		network.registerMessage(MessageBackpackGuiOpen.Handler.class, MessageBackpackGuiOpen.class, id++, Side.SERVER);
	}
	
}
