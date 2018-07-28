package smt.pack.technology.network;

import cpw.mods.fml.relauncher.Side;

public final class RegisterMessage {

	public static void init(final cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper network) {
		int id = 0;
		network.registerMessage(MessageReplacementBlocksTechnologyServer.Handler.class, MessageReplacementBlocksTechnologyServer.class, id++, Side.SERVER);
		network.registerMessage(MessageReplacementBlocksTechnologyClient.Handler.class, MessageReplacementBlocksTechnologyClient.class, id++, Side.CLIENT);
		network.registerMessage(MessageOpenGui.Handler.class, MessageOpenGui.class, id, Side.SERVER);
		network.registerMessage(MessageOpenGui.Handler.class, MessageOpenGui.class, id++, Side.CLIENT);
		network.registerMessage(MessageSyncNbFurnaceMobile.Handler.class, MessageSyncNbFurnaceMobile.class, id, Side.SERVER);
		network.registerMessage(MessageSyncNbFurnaceMobile.Handler.class, MessageSyncNbFurnaceMobile.class, id++, Side.CLIENT);
		network.registerMessage(MessageTelephoneCall.Handler.class, MessageTelephoneCall.class, id, Side.SERVER);
		network.registerMessage(MessageTelephoneCall.Handler.class, MessageTelephoneCall.class, id++, Side.CLIENT);
		network.registerMessage(MessageTelephoneDrop.Handler.class, MessageTelephoneDrop.class, id, Side.SERVER);
		network.registerMessage(MessageTelephoneDrop.Handler.class, MessageTelephoneDrop.class, id++, Side.CLIENT);
		network.registerMessage(MessageSyncSize.Handler.class, MessageSyncSize.class, id++, Side.CLIENT);
		network.registerMessage(MessageSyncTile.Handler.class, MessageSyncTile.class, id, Side.SERVER);
		network.registerMessage(MessageSyncTile.Handler.class, MessageSyncTile.class, id++, Side.CLIENT);
	}

}
