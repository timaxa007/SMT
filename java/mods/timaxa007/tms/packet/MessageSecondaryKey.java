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

			switch(button) {/*
			case -10:ActionSecondaryKey.actionNumpad1Tick(player);break;
			case -9:ActionSecondaryKey.actionNumpad2Tick(player);break;
			case -8:ActionSecondaryKey.actionNumpad3Tick(player);break;
			case -7:ActionSecondaryKey.actionNumpad4Tick(player);break;
			case -6:ActionSecondaryKey.actionNumpad5Tick(player);break;
			case -5:ActionSecondaryKey.actionNumpad6Tick(player);break;
			case -4:ActionSecondaryKey.actionNumpad7Tick(player);break;
			case -3:ActionSecondaryKey.actionNumpad8Tick(player);break;
			case -2:ActionSecondaryKey.actionNumpad9Tick(player);break;
			case -1:ActionSecondaryKey.actionNumpad0Tick(player);break;*/
			case 1:ActionSecondaryKey.actionNumpad0(player, buttonstate);break;
			case 2:ActionSecondaryKey.actionNumpad9(player, buttonstate);break;
			case 3:ActionSecondaryKey.actionNumpad8(player, buttonstate);break;
			case 4:ActionSecondaryKey.actionNumpad7(player, buttonstate);break;
			case 5:ActionSecondaryKey.actionNumpad6(player, buttonstate);break;
			case 6:ActionSecondaryKey.actionNumpad5(player, buttonstate);break;
			case 7:ActionSecondaryKey.actionNumpad4(player, buttonstate);break;
			case 8:ActionSecondaryKey.actionNumpad3(player, buttonstate);break;
			case 9:ActionSecondaryKey.actionNumpad2(player, buttonstate);break;
			case 10:ActionSecondaryKey.actionNumpad1(player, buttonstate);break;
			}

			return null;
		}

	}
	//----------------------------------------------------------------------------------
}
