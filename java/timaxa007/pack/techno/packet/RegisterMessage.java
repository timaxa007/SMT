package timaxa007.pack.techno.packet;

import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class RegisterMessage {

	private static int id = 0;

	public static void init(SimpleNetworkWrapper network) {
		network.registerMessage(MessageTechnoTool.Handler.class, MessageTechnoTool.class, id++, Side.SERVER);
	}

}
