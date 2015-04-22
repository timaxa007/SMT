package timaxa007.pack.item.packet;

import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class RegisterMessage {

	private static int id = 0;

	public static void init(SimpleNetworkWrapper network) {
		network.registerMessage(MessagePackItemsServer.Handler.class, MessagePackItemsServer.class, id++, Side.SERVER);
		network.registerMessage(MessagePackItemsClient.Handler.class, MessagePackItemsClient.class, id++, Side.CLIENT);
		network.registerMessage(MessageOpenGui.Handler.class, MessageOpenGui.class, id++, Side.SERVER);
		network.registerMessage(MessageInteractionEntity.Handler.class, MessageInteractionEntity.class, id++, Side.SERVER);
		network.registerMessage(MessageInteractionBlock.Handler.class, MessageInteractionBlock.class, id++, Side.SERVER);
	}

}
