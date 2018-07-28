package smt.pack.common.network;

import cpw.mods.fml.relauncher.Side;

public final class RegisterMessage {

	public static void init(final cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper network) {
		int id = 0;
		network.registerMessage(MessageAddPlayerItem.Handler.class, MessageAddPlayerItem.class, id++, Side.SERVER);
		network.registerMessage(MessageCropseSyncNBT.Handler.class, MessageCropseSyncNBT.class, id++, Side.CLIENT);
		network.registerMessage(MessageCropseSyncClass.Handler.class, MessageCropseSyncClass.class, id++, Side.CLIENT);
		network.registerMessage(MessageUpPickup.Handler.class, MessageUpPickup.class, id, Side.CLIENT);
		network.registerMessage(MessageUpPickup.Handler.class, MessageUpPickup.class, id++, Side.SERVER);
	}

}
