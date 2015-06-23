package timaxa007.smt.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import timaxa007.smt.util.ActionPlaySound;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessagePlaySound implements IMessage {

	public String sound_name;
	public int x;
	public int y;
	public int z;

	public MessagePlaySound() {}

	public MessagePlaySound(String sound_name, int x, int y, int z) {
		this.sound_name = sound_name;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(sound_name.length());
		buf.writeBytes(sound_name.getBytes());
		buf.writeInt(x);
		buf.writeInt(y);
		buf.writeInt(z);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		int sound_name_length = buf.readInt();
		sound_name = new String(buf.readBytes(sound_name_length).array());
		x = buf.readInt();
		y = buf.readInt();
		z = buf.readInt();
	}
	//----------------------------------------------------------------------------------
	public static class Handler implements IMessageHandler<MessagePlaySound, IMessage> {

		@Override
		public IMessage onMessage(MessagePlaySound packet, MessageContext message) {
			EntityPlayerMP player = message.getServerHandler().playerEntity;
			String sound_name = packet.sound_name;
			int x = packet.x;
			int y = packet.y;
			int z = packet.z;
			ActionPlaySound.play(player, sound_name, x, y, z);
			return null;
		}

	}
	//----------------------------------------------------------------------------------
}
