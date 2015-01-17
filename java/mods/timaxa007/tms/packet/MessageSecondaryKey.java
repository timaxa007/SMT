package mods.timaxa007.tms.packet;

import io.netty.buffer.ByteBuf;
import mods.timaxa007.tms.util.ActionSecondaryKey;
import net.minecraft.entity.player.EntityPlayerMP;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageSecondaryKey implements IMessage {

	public int button;
	public boolean buttonstate;

	public MessageSecondaryKey() {}

	public MessageSecondaryKey(int button, boolean buttonstate) {
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
	public static class Handler implements IMessageHandler<MessageSecondaryKey, IMessage> {

		@Override
		public IMessage onMessage(MessageSecondaryKey packet, MessageContext context) {
			int button = packet.button;
			boolean buttonstate = packet.buttonstate;
			EntityPlayerMP player = context.getServerHandler().playerEntity;

			switch(button) {
			case -10:ActionSecondaryKey.onNumpad1Tick(player);break;
			case -9:ActionSecondaryKey.onNumpad2Tick(player);break;
			case -8:ActionSecondaryKey.onNumpad3Tick(player);break;
			case -7:ActionSecondaryKey.onNumpad4Tick(player);break;
			case -6:ActionSecondaryKey.onNumpad5Tick(player);break;
			case -5:ActionSecondaryKey.onNumpad6Tick(player);break;
			case -4:ActionSecondaryKey.onNumpad7Tick(player);break;
			case -3:ActionSecondaryKey.onNumpad8Tick(player);break;
			case -2:ActionSecondaryKey.onNumpad9Tick(player);break;
			case -1:ActionSecondaryKey.onNumpad0Tick(player);break;
			
			case 1:ActionSecondaryKey.onNumpad0(player, buttonstate);break;
			case 2:ActionSecondaryKey.onNumpad9(player, buttonstate);break;
			case 3:ActionSecondaryKey.onNumpad8(player, buttonstate);break;
			case 4:ActionSecondaryKey.onNumpad7(player, buttonstate);break;
			case 5:ActionSecondaryKey.onNumpad6(player, buttonstate);break;
			case 6:ActionSecondaryKey.onNumpad5(player, buttonstate);break;
			case 7:ActionSecondaryKey.onNumpad4(player, buttonstate);break;
			case 8:ActionSecondaryKey.onNumpad3(player, buttonstate);break;
			case 9:ActionSecondaryKey.onNumpad2(player, buttonstate);break;
			case 10:ActionSecondaryKey.onNumpad1(player, buttonstate);break;
			}

			return null;
		}

	}
	//----------------------------------------------------------------------------------
}
