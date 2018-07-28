package smt.pack.magic.network;

import cpw.mods.fml.relauncher.Side;

public final class RegisterMessage {

	public static void init(final cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper network) {
		int id = 0;
		network.registerMessage(MessageMana.Handler.class, MessageMana.class, id, Side.CLIENT);
		network.registerMessage(MessageMana.Handler.class, MessageMana.class, id++, Side.SERVER);
		network.registerMessage(MessageManaMax.Handler.class, MessageManaMax.class, id, Side.CLIENT);
		network.registerMessage(MessageManaMax.Handler.class, MessageManaMax.class, id++, Side.SERVER);
		network.registerMessage(MessageSyncNbtEntityMagicChest.Handler.class, MessageSyncNbtEntityMagicChest.class, id++, Side.CLIENT);
		network.registerMessage(MessageOpenGuiEntityMagicChest.Handler.class, MessageOpenGuiEntityMagicChest.class, id, Side.CLIENT);
		network.registerMessage(MessageOpenGuiEntityMagicChest.Handler.class, MessageOpenGuiEntityMagicChest.class, id++, Side.SERVER);
		network.registerMessage(MessageActionDisench.Handler.class, MessageActionDisench.class, id++, Side.SERVER);
		network.registerMessage(MessageSpell.Handler.class, MessageSpell.class, id, Side.CLIENT);
		network.registerMessage(MessageSpell.Handler.class, MessageSpell.class, id++, Side.SERVER);
	}

}
