package timaxa007.tms.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.world.World;
import timaxa007.tms.CoreTMS;
import timaxa007.tms.util.ActionSetBiome;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageSetBiome implements IMessage {

	public int act;
	public int x;
	public int z;

	public MessageSetBiome() {}

	public MessageSetBiome(int act, int x, int z) {
		this.act = act;
		this.x = x;
		this.z = z;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(act);
		buf.writeInt(x);
		buf.writeInt(z);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		act = buf.readInt();
		x = buf.readInt();
		z = buf.readInt();
	}

	public static class Handler implements IMessageHandler<MessageSetBiome, IMessage> {

		@Override
		public IMessage onMessage(MessageSetBiome packet, MessageContext message) {
			int act = packet.act;
			int x = packet.x;
			int z = packet.z;
			ActionSetBiome.setBiome(act, null, x, z);
			return null;
		}

	}

}
