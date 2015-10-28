package timaxa007.module.craft_table.packet;

import static timaxa007.core.CoreSMT.log;
import io.netty.buffer.ByteBuf;
import timaxa007.module.craft_table.ActionCraftTable;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageCraftTableOpenGui implements IMessage {

	public int x;
	public int y;
	public int z;

	@Deprecated
	public MessageCraftTableOpenGui() {}
	public MessageCraftTableOpenGui(int x, int y, int z) {
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
	public static class Handler implements IMessageHandler<MessageCraftTableOpenGui, IMessage> {
		@Override public IMessage onMessage(MessageCraftTableOpenGui packet, MessageContext message) {
			log.info("Receive MessageCraftTableOpenGui");
			ActionCraftTable.client(packet.x, packet.y, packet.z);
			return null;
		}
	}
	//-----------------------------------------------------------------------------------------------
}
