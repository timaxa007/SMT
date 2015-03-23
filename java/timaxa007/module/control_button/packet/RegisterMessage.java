package timaxa007.module.control_button.packet;

import timaxa007.module.control_button.packet.MessageArmorKey;
import timaxa007.module.control_button.packet.MessageMouseKey;
import timaxa007.module.control_button.packet.MessagePrimaryKey;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class RegisterMessage {

	private static int id = 0;

	public static void init(SimpleNetworkWrapper network) {
		network.registerMessage(MessageMouseKey.Handler.class, MessageMouseKey.class, id++, Side.SERVER);
		network.registerMessage(MessagePrimaryKey.Handler.class, MessagePrimaryKey.class, id++, Side.SERVER);
		network.registerMessage(MessageArmorKey.Handler.class, MessageArmorKey.class, id++, Side.SERVER);
		network.registerMessage(MessageControlButton.Handler.class, MessageControlButton.class, id++, Side.CLIENT);
	}

}
