package smt.pack.player.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageActionInventory implements IMessage {

	private static int actionID;

	public MessageActionInventory() {}

	public MessageActionInventory(int actionID) {
		this.actionID = actionID;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(actionID);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		actionID = buf.readInt();
	}

	public static class Handler implements IMessageHandler<MessageActionInventory, IMessage> {

		@Override
		public IMessage onMessage(MessageActionInventory packet, MessageContext message) {
			int actionID = packet.actionID;
			EntityPlayerMP player = message.getServerHandler().playerEntity;

			//ActionInteractionEntity.act1(player, entity);

			return null;
		}

	}

}
