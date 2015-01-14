package mods.timaxa007.pack.item.packet;

import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class RegisterPacket {

	private static int id = 0;

	public static void init(SimpleNetworkWrapper network) {
		network.registerMessage(PacketPackItemsServer.Handler.class, PacketPackItemsServer.class, id++, Side.SERVER);
		network.registerMessage(PacketPackItemsClient.Handler.class, PacketPackItemsClient.class, id++, Side.CLIENT);
	}

}
