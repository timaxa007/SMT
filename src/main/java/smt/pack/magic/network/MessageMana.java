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

public class MessageMana implements IMessage {

	private int mana;

	public MessageMana() {}

	public MessageMana(int mana) {
		this.mana = mana;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(mana);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		mana = buf.readInt();
	}

	public static class Handler implements IMessageHandler<MessageMana, IMessage> {

		@Override
		public IMessage onMessage(MessageMana packet, MessageContext message) {
			if (message.side.isClient())
				act(packet.mana);
			else
				act(message.getServerHandler().playerEntity, packet.mana);
			return null;
		}

		@SideOnly(Side.CLIENT)
		private void act(int mana) {
			Minecraft mc = Minecraft.getMinecraft();
			ManaEntity mana_entity = Util.getManaEntity(mc.thePlayer);
			if (mana_entity != null) mana_entity.setMana(mana);
		}

		private void act(EntityPlayerMP player, int mana) {
			ManaEntity mana_entity = Util.getManaEntity(player);
			if (mana_entity != null) mana_entity.setMana(mana);
		}

	}

}
