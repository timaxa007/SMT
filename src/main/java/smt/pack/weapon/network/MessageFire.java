package smt.pack.weapon.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import smt.pack.weapon.SMTWeapon;

public class MessageFire implements IMessage {

	public int id;

	public MessageFire() {}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(id);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		id = buf.readInt();
	}

	public static class Handler implements IMessageHandler<MessageFire, IMessage> {

		@Override
		public IMessage onMessage(MessageFire packet, MessageContext message) {
			if (message.side.isClient())
				act(packet);
			else
				act(message.getServerHandler().playerEntity, packet);
			return null;
		}

		@SideOnly(Side.CLIENT)
		private void act(MessageFire packet) {

		}

		private void act(EntityPlayerMP player, MessageFire packet) {
			boolean submit = false;
			if (submit) {
				MessageFire message = new MessageFire();
				message.id = packet.id;
				SMTWeapon.network.sendTo(message, player);
			}
		}

	}

}
