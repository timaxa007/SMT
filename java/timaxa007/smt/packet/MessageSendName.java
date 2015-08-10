package timaxa007.smt.packet;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageSendName implements IMessage {

	public String name;

	public MessageSendName() {}

	public MessageSendName(String name) {
		this.name = name;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeUTF8String(buf, name);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		name = ByteBufUtils.readUTF8String(buf);
	}
	//----------------------------------------------------------------------------------
	public static class Handler implements IMessageHandler<MessageSendName, IMessage> {

		@Override
		public IMessage onMessage(MessageSendName packet, MessageContext message) {
			String name = packet.name;
			//
			return null;
		}

	}
	//----------------------------------------------------------------------------------
}
