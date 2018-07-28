package smt.pack.weapon.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import smt.pack.weapon.SMTWeapon;

public class MessageLeft implements IMessage {

	public boolean press;

	public MessageLeft() {}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeBoolean(press);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		press = buf.readBoolean();
	}

	public static class Handler implements IMessageHandler<MessageLeft, IMessage> {

		@Override
		public IMessage onMessage(MessageLeft packet, MessageContext message) {
			if (message.side.isClient())
				act(packet);
			else
				act(message.getServerHandler().playerEntity, packet);
			return null;
		}

		@SideOnly(Side.CLIENT)
		private void act(MessageLeft packet) {

		}

		private void act(EntityPlayerMP player, MessageLeft packet) {
			SMTWeapon.proxy.wpn_sys.get(player).leftClick(packet.press);
		}

	}

}
