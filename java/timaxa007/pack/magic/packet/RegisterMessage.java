package timaxa007.pack.magic.packet;

import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class RegisterMessage {

	private static int id = 0;

	public static void init(SimpleNetworkWrapper network) {
		network.registerMessage(MessageStuff.Handler.class, MessageStuff.class, id++, Side.SERVER);
		network.registerMessage(MessagePuff.Handler.class, MessagePuff.class, id++, Side.CLIENT);
	}

}
