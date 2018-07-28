package smt.pack.clan.packet;

import io.netty.buffer.ByteBuf;
import smt.pack.clan.Clan;
import smt.pack.clan.PrivateMessage;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessagePriavteMassageSend implements IMessage {

	public String username, text;

	public MessagePriavteMassageSend() {}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeUTF8String(buf, username);
		ByteBufUtils.writeUTF8String(buf, text);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		username = ByteBufUtils.readUTF8String(buf);
		text = ByteBufUtils.readUTF8String(buf);
	}

	public static class Handler implements IMessageHandler<MessagePriavteMassageSend, IMessage> {

		@Override
		public IMessage onMessage(MessagePriavteMassageSend packet, MessageContext message) {
			String username = packet.username;
			String text = packet.text;
			if (username != null) {
				PrivateMessage.INSTANCE.createPM(username, text);
			}
			return null;
		}

	}

}
