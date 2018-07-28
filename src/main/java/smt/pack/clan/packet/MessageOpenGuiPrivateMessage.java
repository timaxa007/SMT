package smt.pack.clan.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import smt.pack.clan.client.gui.GuiPriavteMassage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MessageOpenGuiPrivateMessage implements IMessage {

	public MessageOpenGuiPrivateMessage() {}

	@Override
	public void toBytes(ByteBuf buf) {

	}

	@Override
	public void fromBytes(ByteBuf buf) {

	}

	public static class Handler implements IMessageHandler<MessageOpenGuiPrivateMessage, IMessage> {

		@Override
		public IMessage onMessage(MessageOpenGuiPrivateMessage packet, MessageContext message) {
			if (message.side.isClient())
				act(packet);
			else
				act(message.getServerHandler().playerEntity, packet);
			return null;
		}

		@SideOnly(Side.CLIENT)
		private void act(MessageOpenGuiPrivateMessage packet) {
			Minecraft mc = Minecraft.getMinecraft();
			mc.displayGuiScreen(new GuiPriavteMassage());
		}

		private void act(EntityPlayerMP player, MessageOpenGuiPrivateMessage packet) {

		}

	}

}
