package mods.timaxa007.tms.packet;

import io.netty.buffer.ByteBuf;
import mods.timaxa007.tms.util.ActionMouseKey;
import net.minecraft.entity.player.EntityPlayerMP;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageMouseKey implements IMessage {

	public int button;
	public boolean buttonstate;

	public MessageMouseKey() {}

	public MessageMouseKey(int button, boolean buttonstate) {
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
	public static class Handler implements IMessageHandler<MessageMouseKey, IMessage> {

		@Override
		public IMessage onMessage(MessageMouseKey packet, MessageContext context) {
			int button = packet.button;
			boolean buttonstate = packet.buttonstate;
			EntityPlayerMP player = context.getServerHandler().playerEntity;

			switch(button) {/*
			case -2:ActionMouseKey.actionRightClickTick(player);break;
			case -1:ActionMouseKey.actionLeftClickTick(player);break;*/
			case 1:ActionMouseKey.actionLeftClick(player, buttonstate);break;
			case 2:ActionMouseKey.actionRightClick(player, buttonstate);break;
			}

			return null;
		}

	}
	//----------------------------------------------------------------------------------
}
