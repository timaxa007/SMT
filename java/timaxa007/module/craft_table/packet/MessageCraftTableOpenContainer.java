package timaxa007.module.craft_table.packet;

import static timaxa007.core.CoreSMT.log;
import io.netty.buffer.ByteBuf;
import timaxa007.module.craft_table.ActionCraftTable;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageCraftTableOpenContainer implements IMessage {

	public int x;
	public int y;
	public int z;


	public MessageCraftTableOpenContainer() {}
	public MessageCraftTableOpenContainer(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override public void toBytes(ByteBuf buf) {
		buf.writeInt(x);
		buf.writeInt(y);
		buf.writeInt(z);
	}
	@Override public void fromBytes(ByteBuf buf) {
		x = buf.readInt();
		y = buf.readInt();
		z = buf.readInt();
	}
	//-----------------------------------------------------------------------------------------------
	public static class Handler implements IMessageHandler<MessageCraftTableOpenContainer, IMessage> {
		@Override public IMessage onMessage(MessageCraftTableOpenContainer packet, MessageContext message) {
			log.info("Receive MessageCraftTableOpenContainer");
			ActionCraftTable.common(message.getServerHandler().playerEntity, packet.x, packet.y, packet.z);
			return null;
		}
	}
	//-----------------------------------------------------------------------------------------------
}
