package timaxa007.tms.packet;

import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class RegisterMessage {

	private static int id = 0;

	public static void init(SimpleNetworkWrapper network) {
		network.registerMessage(MessageSpawnParticle.Handler.class, MessageSpawnParticle.class, id++, Side.CLIENT);
		network.registerMessage(MessagePlayer.Handler.class, MessagePlayer.class, id++, Side.SERVER);
	}

}
