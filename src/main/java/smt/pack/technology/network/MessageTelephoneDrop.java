package smt.pack.technology.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import smt.pack.technology.registry.TelephoneCommunications;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MessageTelephoneDrop implements IMessage {

	public int id;

	public MessageTelephoneDrop() {}

	public MessageTelephoneDrop(int id) {
		this.id = id;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(id);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		id = buf.readInt();
	}

	public static class Handler implements IMessageHandler<MessageTelephoneDrop, IMessage> {

		@Override
		public IMessage onMessage(MessageTelephoneDrop packet, MessageContext message) {
			if (message.side.isClient())
				act(packet.id);
			else
				act(message.getServerHandler().playerEntity, packet.id);
			return null;
		}

		@SideOnly(Side.CLIENT)
		private void act(int id) {

		}

		private void act(EntityPlayerMP player, int id) {
			TelephoneCommunications.INSTANCE.call(player, id);
		}

	}

}
