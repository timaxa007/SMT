package mods.timaxa007.tms.packet;

import io.netty.buffer.ByteBuf;
import mods.timaxa007.tms.util.ActionPrimaryKey;
import net.minecraft.entity.player.EntityPlayerMP;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessagePrimaryKey implements IMessage {

	public int button;
	public boolean buttonstate;

	public MessagePrimaryKey() {}

	public MessagePrimaryKey(int button, boolean buttonstate) {
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
	public static class Handler implements IMessageHandler<MessagePrimaryKey, IMessage> {

		@Override
		public IMessage onMessage(MessagePrimaryKey packet, MessageContext context) {
			int button = packet.button;
			boolean buttonstate = packet.buttonstate;
			EntityPlayerMP player = context.getServerHandler().playerEntity;

			switch(button) {/*
			case -6:ActionPrimaryKey.actionModeOutTick(player);break;
			case -5:ActionPrimaryKey.actionModeInTick(player);break;
			case -4:ActionPrimaryKey.actionActionTick(player);break;
			case -3:ActionPrimaryKey.actionModeTick(player);break;
			case -2:ActionPrimaryKey.actionChargeTick(player);break;
			case -1:ActionPrimaryKey.actionReloadTick(player);break;*/
			case 1:ActionPrimaryKey.actionReload(player, buttonstate);break;
			case 2:ActionPrimaryKey.actionCharge(player, buttonstate);break;
			case 3:ActionPrimaryKey.actionMode(player, buttonstate);break;
			case 4:ActionPrimaryKey.actionAction(player, buttonstate);break;
			case 5:ActionPrimaryKey.actionModeIn(player, buttonstate);break;
			case 6:ActionPrimaryKey.actionModeOut(player, buttonstate);break;
			}

			return null;
		}

	}
	//----------------------------------------------------------------------------------
}
