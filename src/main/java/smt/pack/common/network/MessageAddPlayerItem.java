package smt.pack.common.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageAddPlayerItem implements IMessage {

	private ItemStack itemStack;

	public MessageAddPlayerItem() {}

	public MessageAddPlayerItem(ItemStack itemStack) {
		this.itemStack = itemStack;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeItemStack(buf, itemStack);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		itemStack = ByteBufUtils.readItemStack(buf);
	}

	public static class Handler implements IMessageHandler<MessageAddPlayerItem, IMessage> {

		@Override
		public IMessage onMessage(MessageAddPlayerItem packet, MessageContext message) {
			ItemStack itemStack = packet.itemStack;
			if (itemStack != null)
				message.getServerHandler().playerEntity.inventory.addItemStackToInventory(itemStack);
			return null;
		}

	}

}
