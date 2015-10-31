package timaxa007.module.craft_table.packet;

import cpw.mods.fml.relauncher.Side;

public class RegisterMessage {

	private static int id = 0;

	public static void init(cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper network) {
		network.registerMessage(MessageCraftTableClient.Handler.class, MessageCraftTableClient.class, id++, Side.CLIENT);
		network.registerMessage(MessageCraftTableOpenContainer.Handler.class, MessageCraftTableOpenContainer.class, id++, Side.SERVER);
		network.registerMessage(MessageCraftTableOpenGui.Handler.class, MessageCraftTableOpenGui.class, id++, Side.CLIENT);
	}

}
