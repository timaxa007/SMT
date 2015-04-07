package timaxa007.pack.magic.packet;

import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class RegisterMessage {

	private static int id = 0;

	public static void init(SimpleNetworkWrapper network) {
		network.registerMessage(MessagePackMagicServer.Handler.class, MessagePackMagicServer.class, id++, Side.SERVER);
		network.registerMessage(MessagePackMagicClient.Handler.class, MessagePackMagicClient.class, id++, Side.CLIENT);
		network.registerMessage(MessageStuff.Handler.class, MessageStuff.class, id++, Side.SERVER);
		network.registerMessage(MessageInteractionEntity.Handler.class, MessageInteractionEntity.class, id++, Side.SERVER);
	}

}
