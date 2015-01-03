package mods.timaxa007.tms.packet;

import io.netty.buffer.ByteBuf;
import mods.timaxa007.tms.util.ActionKey;
import mods.timaxa007.tms.util.ActionSecondaryKey;
import net.minecraft.entity.player.EntityPlayerMP;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class PacketKeySecondary implements IMessage {

	public int button;
	public boolean buttonstate;

	public PacketKeySecondary() {}

	public PacketKeySecondary(int button, boolean buttonstate) {
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
	public static class Handler implements IMessageHandler<PacketKeySecondary, IMessage> {

		@Override
		public IMessage onMessage(PacketKeySecondary packet, MessageContext context) {
			int button = packet.button;
			boolean buttonstate = packet.buttonstate;
			EntityPlayerMP player = context.getServerHandler().playerEntity;

			switch(button) {
			case 1:ActionSecondaryKey.onUse(player);break;
			case 2:ActionSecondaryKey.onYawRight(player);break;
			case 3:ActionSecondaryKey.onUp(player);break;
			case 4:ActionSecondaryKey.onYawLeft(player);break;
			case 5:ActionSecondaryKey.onMoveRight(player);break;
			case 6:ActionSecondaryKey.onStop(player);break;
			case 7:ActionSecondaryKey.onMoveLeft(player);break;
			case 8:ActionSecondaryKey.onUse2(player);break;
			case 9:ActionSecondaryKey.onDown(player);break;
			case 10:ActionSecondaryKey.onUse1(player);break;
			}

			return null;
		}

	}
	//----------------------------------------------------------------------------------
}
