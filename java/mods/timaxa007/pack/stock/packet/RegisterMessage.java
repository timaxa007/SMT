package mods.timaxa007.pack.stock.packet;

import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class RegisterMessage {

	private static int id = 0;

	public static void init(SimpleNetworkWrapper network) {
		network.registerMessage(MessagePackStockServer.Handler.class, MessagePackStockServer.class, id++, Side.SERVER);
		network.registerMessage(MessagePackStockClient.Handler.class, MessagePackStockClient.class, id++, Side.CLIENT);
	}

}
