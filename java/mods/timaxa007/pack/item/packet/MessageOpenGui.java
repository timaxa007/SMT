package mods.timaxa007.pack.item.packet;

import io.netty.buffer.ByteBuf;
import mods.timaxa007.pack.item.PackItems;
import net.minecraft.entity.player.EntityPlayerMP;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageOpenGui implements IMessage {

	public int num;

	public MessageOpenGui() {}

	public MessageOpenGui(int num) {
		this.num = num;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(num);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		num = buf.readInt();
	}
	//----------------------------------------------------------------------------------------
	public static class Handler implements IMessageHandler<MessageOpenGui, IMessage> {

		@Override
		public IMessage onMessage(MessageOpenGui packet, MessageContext message) {
			int num = packet.num;
			EntityPlayerMP player = message.getServerHandler().playerEntity;
			num += 16;
			FMLNetworkHandler.openGui(player, PackItems.instance, num, 
					player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
			return null;
		}

	}
	//----------------------------------------------------------------------------------------
}
