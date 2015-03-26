package timaxa007.pack.techno.packet;

import timaxa007.pack.techno.util.ActionDrill;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageDrill implements IMessage {

	public int button;
	public boolean buttonstate;

	public MessageDrill() {}

	public MessageDrill(int button, boolean buttonstate) {
		this.button = button;
		this.buttonstate = buttonstate;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(button);
		buf.writeBoolean(buttonstate);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		button = buf.readInt();
		buttonstate = buf.readBoolean();
	}

	public static class Handler implements IMessageHandler<MessageDrill, IMessage> {

		@Override
		public IMessage onMessage(MessageDrill packet, MessageContext message) {
			int button = packet.button;
			boolean buttonstate = packet.buttonstate;
			EntityPlayerMP player = message.getServerHandler().playerEntity;

			switch(button) {
			case 1:ActionDrill.mode(player);break;
			}

			return null;
		}

	}

}
