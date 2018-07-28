package smt.module.craft;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MessageOpenGui implements IMessage {

	public int id;

	public MessageOpenGui() {}

	public MessageOpenGui(int id) {
		this.id = id;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(id);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		id = buf.readInt();
	}

	public static class Handler implements IMessageHandler<MessageOpenGui, IMessage> {

		@Override
		public IMessage onMessage(MessageOpenGui packet, MessageContext message) {
			if (message.side.isClient())
				act(packet.id);
			else
				act(message.getServerHandler().playerEntity, packet.id);
			return null;
		}

		@SideOnly(Side.CLIENT)
		private void act(int id) {
			Minecraft mc = Minecraft.getMinecraft();
			switch(id) {
			case 0:{
				//mc.displayGuiScreen(new CraftingGui(mc.thePlayer));break;
			}
			}
		}

		private void act(EntityPlayerMP player, int id) {
			boolean submit = true;
			switch(id) {
			case 0:{
				//openContainer(player, new CraftingContainer(player), id);
				//player.openContainer = new CraftingContainer(player);
				break;
			}
			}
			if (submit) ModuleCraft.network.sendTo(new MessageOpenGui(id), player);
		}

	}

}
