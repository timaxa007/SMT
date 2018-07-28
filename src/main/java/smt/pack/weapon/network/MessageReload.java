package smt.pack.weapon.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import smt.pack.weapon.SMTWeapon;

public class MessageReload implements IMessage {

	public byte slotID;

	public MessageReload() {}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeByte(slotID);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		slotID = buf.readByte();
	}

	public static class Handler implements IMessageHandler<MessageReload, IMessage> {

		@Override
		public IMessage onMessage(MessageReload packet, MessageContext message) {
			if (message.side.isClient())
				act(packet);
			else
				act(message.getServerHandler().playerEntity, packet);
			return null;
		}

		@SideOnly(Side.CLIENT)
		private void act(MessageReload packet) {

		}

		private void act(EntityPlayerMP player, MessageReload packet) {
			SMTWeapon.proxy.wpn_sys.get(player).reloadClick(packet.slotID);
		}

	}

}
