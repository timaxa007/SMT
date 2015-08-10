package timaxa007.smt.packet;

import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class RegisterMessage {

	private static int id = 0;

	public static void init(SimpleNetworkWrapper network) {
		network.registerMessage(MessageSetBiome.Handler.class, MessageSetBiome.class, id++, Side.CLIENT);
		network.registerMessage(MessageInteractionEntity.Handler.class, MessageInteractionEntity.class, id++, Side.SERVER);
		network.registerMessage(MessageInteractionBlock.Handler.class, MessageInteractionBlock.class, id++, Side.SERVER);
		network.registerMessage(MessageOpenContainer.Handler.class, MessageOpenContainer.class, id++, Side.SERVER);
		network.registerMessage(MessageOpenGui.Handler.class, MessageOpenGui.class, id++, Side.CLIENT);
	}

}
