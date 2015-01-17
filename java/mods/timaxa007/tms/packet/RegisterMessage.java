package mods.timaxa007.tms.packet;

import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class RegisterMessage {

	private static int id = 0;

	public static void init(SimpleNetworkWrapper network) {
		network.registerMessage(MessageMouseKey.Handler.class, MessageMouseKey.class, id++, Side.SERVER);
		network.registerMessage(MessagePrimaryKey.Handler.class, MessagePrimaryKey.class, id++, Side.SERVER);
		network.registerMessage(MessageSecondaryKey.Handler.class, MessageSecondaryKey.class, id++, Side.SERVER);
		network.registerMessage(MessageSpawnParticle.Handler.class, MessageSpawnParticle.class, id++, Side.CLIENT);
		network.registerMessage(MessagePlayer.Handler.class, MessagePlayer.class, id++, Side.SERVER);
	}

}
