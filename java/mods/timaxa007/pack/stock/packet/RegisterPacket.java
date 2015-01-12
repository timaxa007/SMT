package mods.timaxa007.pack.stock.packet;

import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class RegisterPacket {

	private static int id = 0;

	public static void init(SimpleNetworkWrapper network) {
		network.registerMessage(PacketPackStockServer.Handler.class, PacketPackStockServer.class, id++, Side.SERVER);
		network.registerMessage(PacketPackStockClient.Handler.class, PacketPackStockClient.class, id++, Side.CLIENT);
	}

}
