package timaxa007.pack.conjoint.packet;

import io.netty.buffer.ByteBuf;
import timaxa007.smt.util.UtilSMT;
import timaxa007.smt.util.Vex;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageSetBiome implements IMessage {

	public int biomeID;
	public int x;
	public int z;

	public MessageSetBiome() {}

	public MessageSetBiome(int biomeID, int x, int z) {
		this.biomeID = biomeID;
		this.x = x;
		this.z = z;
	}

	public MessageSetBiome(int biomeID, Vex.Integer2 vex) {
		this.biomeID = biomeID;
		this.x = vex.x;
		this.z = vex.z;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(biomeID);
		buf.writeInt(x);
		buf.writeInt(z);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		biomeID = buf.readInt();
		x = buf.readInt();
		z = buf.readInt();
	}
	//----------------------------------------------------------------------------------
	public static class Handler implements IMessageHandler<MessageSetBiome, IMessage> {

		@Override
		public IMessage onMessage(MessageSetBiome packet, MessageContext message) {
			int biomeID = packet.biomeID;
			int x = packet.x;
			int z = packet.z;
			UtilSMT.UtilWorld.setBiome(biomeID, null, x, z);
			return null;
		}

	}
	//----------------------------------------------------------------------------------
}
