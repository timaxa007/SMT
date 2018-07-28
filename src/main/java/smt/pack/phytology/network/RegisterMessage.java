package smt.pack.phytology.network;

import cpw.mods.fml.relauncher.Side;

public final class RegisterMessage {

	public static void init(final cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper network) {
		int id = 0;
		network.registerMessage(MessageFlowerPotClient.Handler.class, MessageFlowerPotClient.class, id++, Side.CLIENT);
	}

}
