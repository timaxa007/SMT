package mods.timaxa007.pack.weapon.packet;

import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class RegisterMessage {

	private static int id = 0;

	public static void init(SimpleNetworkWrapper network) {
		network.registerMessage(MessagePackWeaponsServer.Handler.class, MessagePackWeaponsServer.class, id++, Side.SERVER);
		network.registerMessage(MessagePackWeaponsClient.Handler.class, MessagePackWeaponsClient.class, id++, Side.CLIENT);
		network.registerMessage(MessageActionWeapons.Handler.class, MessageActionWeapons.class, id++, Side.SERVER);
		network.registerMessage(MessageOpenGui.Handler.class, MessageOpenGui.class, id++, Side.CLIENT);
	}

}
