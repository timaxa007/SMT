package mods.timaxa007.tms.packet;

import mods.timaxa007.tms.Core;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class RegisterPacket {

	public static void init(SimpleNetworkWrapper network) {
		network.registerMessage(PacketKey.Handler.class, PacketKey.class, 0, Side.SERVER);
		network.registerMessage(PacketPlayer.Handler.class, PacketPlayer.class, 0, Side.SERVER);
	}

}
