package timaxa007.core.packet;

import io.netty.buffer.ByteBuf;
import timaxa007.gui.HandlerGuiSMT;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageOpenGui implements IMessage {

	public int id;

	public MessageOpenGui() {}
	public MessageOpenGui(int id) {this.id = id;}

	@Override public void toBytes(ByteBuf buf) {buf.writeInt(id);}
	@Override public void fromBytes(ByteBuf buf) {id = buf.readInt();}
	//-----------------------------------------------------------------------------------------------
	public static class Handler implements IMessageHandler<MessageOpenGui, IMessage> {
		@Override public IMessage onMessage(MessageOpenGui packet, MessageContext message) {
			HandlerGuiSMT.openGui(packet.id, null);
			return null;
		}
	}
	//-----------------------------------------------------------------------------------------------
}
