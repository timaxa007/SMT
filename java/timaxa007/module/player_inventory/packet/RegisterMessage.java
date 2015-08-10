package timaxa007.module.player_inventory.packet;

import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class RegisterMessage {
	
	private static int id = 0;

	public static void init(SimpleNetworkWrapper network) {
		network.registerMessage(MessageGui.Handler.class, MessageGui.class, id++, Side.SERVER);
	}

}
