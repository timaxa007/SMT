package smt.pack.magic.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import smt.pack.magic.mana.ManaEntity;
import smt.pack.magic.mana.Util;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MessageManaMax implements IMessage {

	private int mana_max;

	public MessageManaMax() {}

	public MessageManaMax(int mana_max) {
		this.mana_max = mana_max;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(mana_max);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		mana_max = buf.readInt();
	}

	public static class Handler implements IMessageHandler<MessageManaMax, IMessage> {

		@Override
		public IMessage onMessage(MessageManaMax packet, MessageContext message) {
			if (message.side.isClient())
				act(packet.mana_max);
			else
				act(message.getServerHandler().playerEntity, packet.mana_max);
			return null;
		}

		@SideOnly(Side.CLIENT)
		private void act(int mana_max) {
			Minecraft mc = Minecraft.getMinecraft();
			ManaEntity mana_entity = Util.getManaEntity(mc.thePlayer);
			if (mana_entity != null) mana_entity.setManaMax(mana_max);
		}

		private void act(EntityPlayerMP player, int mana_max) {
			ManaEntity mana_entity = Util.getManaEntity(player);
			if (mana_entity != null) mana_entity.setManaMax(mana_max);
		}

	}

}
