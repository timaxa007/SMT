package mods.timaxa007.pack.mining.packet;

import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class RegisterPacket {

	private static int id = 0;

	public static void init(SimpleNetworkWrapper network) {
		network.registerMessage(PacketPackMiningServer.Handler.class, PacketPackMiningServer.class, id++, Side.SERVER);
		network.registerMessage(PacketPackMiningClient.Handler.class, PacketPackMiningClient.class, id++, Side.CLIENT);
	}

}
