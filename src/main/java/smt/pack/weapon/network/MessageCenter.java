package smt.pack.weapon.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import smt.pack.weapon.SMTWeapon;

public class MessageCenter implements IMessage {

	public byte id;

	public MessageCenter() {}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeByte(id);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		id = buf.readByte();
	}

	public static class Handler implements IMessageHandler<MessageCenter, IMessage> {

		@Override
		public IMessage onMessage(MessageCenter packet, MessageContext message) {
			if (message.side.isClient())
				act(packet);
			else
				act(message.getServerHandler().playerEntity, packet);
			return null;
		}

		@SideOnly(Side.CLIENT)
		private void act(MessageCenter packet) {

		}

		private void act(EntityPlayerMP player, MessageCenter packet) {
			SMTWeapon.proxy.wpn_sys.get(player).centerClick(packet.id);
		}

	}

}
