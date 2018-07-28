package smt.pack.technology.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import smt.pack.technology.SMTTechnology;
import smt.pack.technology.registry.FurnaceMobile;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MessageSyncNbFurnaceMobile implements IMessage {

	public NBTTagCompound nbt;

	public MessageSyncNbFurnaceMobile() {}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeTag(buf, nbt);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		nbt = ByteBufUtils.readTag(buf);
	}

	public static class Handler implements IMessageHandler<MessageSyncNbFurnaceMobile, IMessage> {

		@Override
		public IMessage onMessage(MessageSyncNbFurnaceMobile packet, MessageContext message) {
			if (message.side.isClient())
				act(packet.nbt);
			else
				act(message.getServerHandler().playerEntity);
			return null;
		}

		@SideOnly(Side.CLIENT)
		private void act(NBTTagCompound nbt) {
			Minecraft mc = Minecraft.getMinecraft();
			FurnaceMobile fm = FurnaceMobile.get(mc.thePlayer);
			if (fm != null) {
				fm.loadNBTData(nbt);
			}
		}

		private void act(EntityPlayerMP player) {
			FurnaceMobile fm = FurnaceMobile.get(player);
			if (fm != null) {
				MessageSyncNbFurnaceMobile message = new MessageSyncNbFurnaceMobile();
				NBTTagCompound nbt = new NBTTagCompound();
				fm.saveNBTData(nbt);
				message.nbt = nbt;
				SMTTechnology.network.sendTo(message, player);
			}
		}

	}

}
