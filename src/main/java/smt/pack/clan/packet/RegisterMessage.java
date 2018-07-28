package smt.pack.clan.packet;

import smt.pack.clan.packet.MessageOpenGuiClan;
import smt.pack.clan.packet.MessageSyncClans;
import cpw.mods.fml.relauncher.Side;

public final class RegisterMessage {

	public static void init(final cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper network) {
		int id = 0;
		network.registerMessage(MessageOpenGuiClan.Handler.class, MessageOpenGuiClan.class, id++, Side.CLIENT);
		network.registerMessage(MessageSyncClans.Handler.class, MessageSyncClans.class, id++, Side.CLIENT);
		network.registerMessage(MessageClanCreate.Handler.class, MessageClanCreate.class, id++, Side.SERVER);
		network.registerMessage(MessageClanRemove.Handler.class, MessageClanRemove.class, id++, Side.SERVER);
		network.registerMessage(MessageOpenGuiPrivateMessage.Handler.class, MessageOpenGuiPrivateMessage.class, id++, Side.CLIENT);
		network.registerMessage(MessagePriavteMassageSend.Handler.class, MessagePriavteMassageSend.class, id++, Side.SERVER);
	}

}
