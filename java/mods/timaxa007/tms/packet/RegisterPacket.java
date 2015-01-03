package mods.timaxa007.tms.packet;

import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class RegisterPacket {

	public static void init(SimpleNetworkWrapper network) {
		network.registerMessage(PacketKey.Handler.class, PacketKey.class, 0, Side.SERVER);
		network.registerMessage(PacketKeyPrimary.Handler.class, PacketKeyPrimary.class, 1, Side.SERVER);
		network.registerMessage(PacketKeySecondary.Handler.class, PacketKeySecondary.class, 2, Side.SERVER);
		network.registerMessage(PacketMouseKey.Handler.class, PacketMouseKey.class, 3, Side.SERVER);
		network.registerMessage(PacketPlayer.Handler.class, PacketPlayer.class, 4, Side.SERVER);
	}

}
