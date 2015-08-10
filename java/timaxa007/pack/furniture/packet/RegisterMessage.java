package timaxa007.pack.furniture.packet;

import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class RegisterMessage {

	private static int id = 0;

	public static void init(SimpleNetworkWrapper network) {
		//network.registerMessage(MessageStorageGuiOpen.Handler.class, MessageStorageGuiOpen.class, id++, Side.SERVER);
	}
	
}
