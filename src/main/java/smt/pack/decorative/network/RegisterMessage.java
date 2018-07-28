package smt.pack.decorative.network;

import cpw.mods.fml.relauncher.Side;

public final class RegisterMessage {

	public static void init(final cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper network) {
		int id = 0;
		network.registerMessage(MessageSyncSit.Handler.class, MessageSyncSit.class, id++, Side.CLIENT);
		network.registerMessage(MessageSyncModelView.Handler.class, MessageSyncModelView.class, id++, Side.CLIENT);
		network.registerMessage(MessageSyncModelView.Handler.class, MessageSyncModelView.class, id, Side.SERVER);
		network.registerMessage(MessageSyncModelView2.Handler.class, MessageSyncModelView2.class, id++, Side.CLIENT);
		network.registerMessage(MessageSyncModelView2.Handler.class, MessageSyncModelView2.class, id, Side.SERVER);
	}

}
