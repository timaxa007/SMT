package timaxa007.pack.magic.packet;

import io.netty.buffer.ByteBuf;
import timaxa007.pack.magic.util.PlayerMana;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageMana implements IMessage {

	public int mana;
	public int mana_max;

	public MessageMana() {}

	public MessageMana(int mana, int mana_max) {
		this.mana = mana;
		this.mana_max = mana_max;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(mana);
		buf.writeInt(mana_max);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		mana = buf.readInt();
		mana_max = buf.readInt();
	}
	//----------------------------------------------------------------------------------
	public static class Handler implements IMessageHandler<MessageMana, IMessage> {

		@Override
		public IMessage onMessage(MessageMana packet, MessageContext message) {
			int mana = packet.mana;
			int mana_max = packet.mana_max;
			PlayerMana.setClientPlayer(mana, mana_max);
			return null;
		}

	}
	//----------------------------------------------------------------------------------
}
