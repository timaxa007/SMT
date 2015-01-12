package mods.timaxa007.pack.techno.packet;

import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class RegisterPacket {

	private static int id = 0;

	public static void init(SimpleNetworkWrapper network) {
		network.registerMessage(PacketPackTechnoServer.Handler.class, PacketPackTechnoServer.class, id++, Side.SERVER);
		network.registerMessage(PacketPackTechnoClient.Handler.class, PacketPackTechnoClient.class, id++, Side.CLIENT);
	}

}
