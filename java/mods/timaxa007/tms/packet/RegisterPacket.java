package mods.timaxa007.tms.packet;

import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class RegisterPacket {

	private static int id = 0;

	public static void init(SimpleNetworkWrapper network) {
		network.registerMessage(PacketKey.Handler.class, PacketKey.class, id++, Side.SERVER);
		network.registerMessage(PacketKeyPrimary.Handler.class, PacketKeyPrimary.class, id++, Side.SERVER);
		network.registerMessage(PacketKeySecondary.Handler.class, PacketKeySecondary.class, id++, Side.SERVER);
		network.registerMessage(PacketMouseKey.Handler.class, PacketMouseKey.class, id++, Side.SERVER);
		network.registerMessage(PacketSpawnParticle.Handler.class, PacketSpawnParticle.class, id++, Side.CLIENT);
		network.registerMessage(PacketPlayer.Handler.class, PacketPlayer.class, id++, Side.SERVER);
	}

}
