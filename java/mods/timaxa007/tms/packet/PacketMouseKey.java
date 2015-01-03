package mods.timaxa007.tms.packet;

import io.netty.buffer.ByteBuf;
import mods.timaxa007.tms.util.ActionKey;
import mods.timaxa007.tms.util.ActionMouseKey;
import net.minecraft.entity.player.EntityPlayerMP;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class PacketMouseKey implements IMessage {

	public int button;
	public boolean buttonstate;

	public PacketMouseKey() {}

	public PacketMouseKey(int button, boolean buttonstate) {
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
	public static class Handler implements IMessageHandler<PacketMouseKey, IMessage> {

		@Override
		public IMessage onMessage(PacketMouseKey packet, MessageContext context) {
			int button = packet.button;
			boolean buttonstate = packet.buttonstate;
			EntityPlayerMP player = context.getServerHandler().playerEntity;

			switch(button) {
			case 1:ActionMouseKey.onLeftClick(player, buttonstate);break;
			case 2:ActionMouseKey.onRightClick(player, buttonstate);break;
			case 3:ActionMouseKey.onLeftClickTick(player);break;
			case 4:ActionMouseKey.onRightClickTick(player);break;
			}

			return null;
		}

	}
	//----------------------------------------------------------------------------------
}
