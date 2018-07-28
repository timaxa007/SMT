package smt.pack.clan.packet;

import io.netty.buffer.ByteBuf;
import smt.pack.clan.Clan;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageClanCreate implements IMessage {

	public String clanName;

	public MessageClanCreate() {}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeUTF8String(buf, clanName);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		clanName = ByteBufUtils.readUTF8String(buf);
	}

	public static class Handler implements IMessageHandler<MessageClanCreate, IMessage> {

		@Override
		public IMessage onMessage(MessageClanCreate packet, MessageContext message) {
			String clanName = packet.clanName;
			if (clanName != null) {
				Clan.INSTANCE.createClan(clanName, message.getServerHandler().playerEntity);
			}
			return null;
		}

	}

}
