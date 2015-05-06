package timaxa007.pack.magic.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import timaxa007.pack.magic.util.ActionStuff;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageStuff implements IMessage {

	public int button;
	public boolean buttonstate;

	public MessageStuff() {}

	public MessageStuff(int button, boolean buttonstate) {
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
	//----------------------------------------------------------------------------------
	public static class Handler implements IMessageHandler<MessageStuff, IMessage> {

		@Override
		public IMessage onMessage(MessageStuff packet, MessageContext message) {
			int button = packet.button;
			boolean buttonstate = packet.buttonstate;
			EntityPlayerMP player = message.getServerHandler().playerEntity;

			switch(button) {
			case 1:ActionStuff.left(player, buttonstate);break;
			case 2:ActionStuff.right(player, buttonstate);break;
			}

			return null;
		}

	}
	//----------------------------------------------------------------------------------
}
