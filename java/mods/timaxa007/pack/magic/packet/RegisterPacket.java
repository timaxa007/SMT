package mods.timaxa007.pack.magic.packet;

import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class RegisterPacket {

	private static int id = 0;

	public static void init(SimpleNetworkWrapper network) {
		network.registerMessage(PacketPackMagicServer.Handler.class, PacketPackMagicServer.class, id++, Side.SERVER);
		network.registerMessage(PacketPackMagicClient.Handler.class, PacketPackMagicClient.class, id++, Side.CLIENT);
	}

}
