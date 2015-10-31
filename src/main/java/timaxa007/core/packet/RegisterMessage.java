package timaxa007.core.packet;

import cpw.mods.fml.relauncher.Side;

public class RegisterMessage {

	private static int id = 0;

	public static void init(cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper network) {
		network.registerMessage(MessageOpenContainer.Handler.class, MessageOpenContainer.class, id++, Side.SERVER);
		network.registerMessage(MessageOpenGui.Handler.class, MessageOpenGui.class, id++, Side.CLIENT);
	}

}
