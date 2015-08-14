package timaxa007.pack.conjoint.packet;

import io.netty.buffer.ByteBuf;
import timaxa007.gui.HandlerGuiSMT;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

@Deprecated
public class MessageOpenContainer implements IMessage {

	public int id;

	@Deprecated
	public MessageOpenContainer() {}
	@Deprecated
	public MessageOpenContainer(int id) {this.id = id;}

	@Override public void toBytes(ByteBuf buf) {buf.writeInt(id);}
	@Override public void fromBytes(ByteBuf buf) {id = buf.readInt();}
	//----------------------------------------------------------------------------------
	public static class Handler implements IMessageHandler<MessageOpenContainer, IMessage> {
		@Override public IMessage onMessage(MessageOpenContainer packet, MessageContext message) {
			HandlerGuiSMT.openContainer(packet.id, message.getServerHandler().playerEntity);
			return null;
		}
	}
	//----------------------------------------------------------------------------------
}
