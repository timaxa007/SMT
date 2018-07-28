package smt.pack.weapon.network;

import cpw.mods.fml.relauncher.Side;

public final class RegisterMessage {

	public static void init(final cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper network) {
		int id = 0;
		//network.registerMessage(MessageServer.Handler.class, MessageServer.class, id, Side.SERVER);
		//network.registerMessage(MessageClient.Handler.class, MessageClient.class, id++, Side.CLIENT);
		//network.registerMessage(MessageFire.Handler.class, MessageFire.class, id, Side.SERVER);
		//network.registerMessage(MessageFire.Handler.class, MessageFire.class, id++, Side.CLIENT);
		network.registerMessage(MessageLeft.Handler.class, MessageLeft.class, id, Side.SERVER);
		network.registerMessage(MessageLeft.Handler.class, MessageLeft.class, id++, Side.CLIENT);
		network.registerMessage(MessageRight.Handler.class, MessageRight.class, id, Side.SERVER);
		network.registerMessage(MessageRight.Handler.class, MessageRight.class, id++, Side.CLIENT);
		network.registerMessage(MessageCenter.Handler.class, MessageCenter.class, id, Side.SERVER);
		network.registerMessage(MessageCenter.Handler.class, MessageCenter.class, id++, Side.CLIENT);
		network.registerMessage(MessageReload.Handler.class, MessageReload.class, id, Side.SERVER);
		network.registerMessage(MessageReload.Handler.class, MessageReload.class, id++, Side.CLIENT);
		network.registerMessage(MessageSpawnBullet.Handler.class, MessageSpawnBullet.class, id, Side.SERVER);
		network.registerMessage(MessageSpawnBullet.Handler.class, MessageSpawnBullet.class, id++, Side.CLIENT);
		network.registerMessage(MessageRefreshWeapon.Handler.class, MessageRefreshWeapon.class, id, Side.SERVER);
		network.registerMessage(MessageRefreshWeapon.Handler.class, MessageRefreshWeapon.class, id++, Side.CLIENT);

	}

}
