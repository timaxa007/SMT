package mods.timaxa007.pack.furniture.packet;

import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class RegisterPacket {

	private static int id = 0;

	public static void init(SimpleNetworkWrapper network) {
		network.registerMessage(PacketPackFurnitureServer.Handler.class, PacketPackFurnitureServer.class, id++, Side.SERVER);
		network.registerMessage(PacketPackFurnitureClient.Handler.class, PacketPackFurnitureClient.class, id++, Side.CLIENT);
		network.registerMessage(PacketBackpack.Handler.class, PacketBackpack.class, id++, Side.SERVER);
	}
	
}
