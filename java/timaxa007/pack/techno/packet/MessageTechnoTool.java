package timaxa007.pack.techno.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import timaxa007.pack.techno.util.ActionTechnoTool;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageTechnoTool implements IMessage {

	public int action;

	public MessageTechnoTool() {}

	public MessageTechnoTool(int action) {
		this.action = action;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(action);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		action = buf.readInt();
	}

	public static class Handler implements IMessageHandler<MessageTechnoTool, IMessage> {

		@Override
		public IMessage onMessage(MessageTechnoTool packet, MessageContext message) {
			int action = packet.action;
			EntityPlayerMP player = message.getServerHandler().playerEntity;

			switch(action) {
			case 1:ActionTechnoTool.mode(player);break;
			case 2:ActionTechnoTool.working(player);break;
			}

			return null;
		}

	}

}
