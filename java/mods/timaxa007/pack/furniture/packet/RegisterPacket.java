package mods.timaxa007.pack.furniture.packet;

import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class RegisterPacket {

	public static void init(SimpleNetworkWrapper network) {
		network.registerMessage(PacketBackpack.Handler.class, PacketBackpack.class, 0, Side.SERVER);
	}

}
