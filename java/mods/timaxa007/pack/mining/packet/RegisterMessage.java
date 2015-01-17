package mods.timaxa007.pack.mining.packet;

import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class RegisterMessage {

	private static int id = 0;

	public static void init(SimpleNetworkWrapper network) {
		network.registerMessage(MessagePackMiningServer.Handler.class, MessagePackMiningServer.class, id++, Side.SERVER);
		network.registerMessage(MessagePackMiningClient.Handler.class, MessagePackMiningClient.class, id++, Side.CLIENT);
	}

}
