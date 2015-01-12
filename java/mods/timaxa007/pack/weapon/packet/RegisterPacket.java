package mods.timaxa007.pack.weapon.packet;

import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class RegisterPacket {

	private static int id = 0;

	public static void init(SimpleNetworkWrapper network) {
		network.registerMessage(PacketPackWeaponsServer.Handler.class, PacketPackWeaponsServer.class, id++, Side.SERVER);
		network.registerMessage(PacketPackWeaponsClient.Handler.class, PacketPackWeaponsClient.class, id++, Side.CLIENT);
		network.registerMessage(PacketOpenGui.Handler.class, PacketOpenGui.class, id++, Side.CLIENT);
	}

}
