package smt.pack.clan.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import smt.pack.clan.Clan;
import smt.pack.clan.SMTClan;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MessageSyncClans implements IMessage {

	public NBTTagCompound nbt;

	public MessageSyncClans() {}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeTag(buf, nbt);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		nbt = ByteBufUtils.readTag(buf);
	}

	public static class Handler implements IMessageHandler<MessageSyncClans, IMessage> {

		@Override
		public IMessage onMessage(MessageSyncClans packet, MessageContext message) {
			if (message.side.isClient())
				act(packet);
			else
				act(message.getServerHandler().playerEntity, packet);
			return null;
		}

		@SideOnly(Side.CLIENT)
		private void act(MessageSyncClans packet) {
			Minecraft mc = Minecraft.getMinecraft();
			if (packet.nbt != null)
				Clan.INSTANCE.readFromNBT(packet.nbt);
			else SMTClan.network.sendToServer(new MessageSyncClans());
		}

		private void act(EntityPlayerMP player, MessageSyncClans packet) {
			MessageSyncClans mess = new MessageSyncClans();
			NBTTagCompound nbt = new NBTTagCompound();
			Clan.INSTANCE.writeToNBT(nbt);
			if (nbt != null) {
				mess.nbt = nbt;
				SMTClan.network.sendTo(mess, player);
			}
		}

	}

}
