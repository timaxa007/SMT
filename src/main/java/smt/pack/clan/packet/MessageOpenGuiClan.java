package smt.pack.clan.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import smt.pack.clan.client.gui.GuiClan;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MessageOpenGuiClan implements IMessage {

	public MessageOpenGuiClan() {}

	@Override
	public void toBytes(ByteBuf buf) {

	}

	@Override
	public void fromBytes(ByteBuf buf) {

	}

	public static class Handler implements IMessageHandler<MessageOpenGuiClan, IMessage> {

		@Override
		public IMessage onMessage(MessageOpenGuiClan packet, MessageContext message) {
			if (message.side.isClient())
				act(packet);
			else
				act(message.getServerHandler().playerEntity, packet);
			return null;
		}

		@SideOnly(Side.CLIENT)
		private void act(MessageOpenGuiClan packet) {
			Minecraft mc = Minecraft.getMinecraft();
			mc.displayGuiScreen(new GuiClan());
		}

		private void act(EntityPlayerMP player, MessageOpenGuiClan packet) {

		}

	}

}
