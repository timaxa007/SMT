package mods.timaxa007.tms.packet;

import io.netty.buffer.ByteBuf;
import mods.timaxa007.tms.util.ActionPrimaryKey;
import net.minecraft.entity.player.EntityPlayerMP;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class PacketKeyPrimary implements IMessage {

	public int button;

	public PacketKeyPrimary() {}

	public PacketKeyPrimary(int button) {
		this.button = button;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(button);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		button = buf.readInt();
	}
	//----------------------------------------------------------------------------------
	public static class Handler implements IMessageHandler<PacketKeyPrimary, IMessage> {

		@Override
		public IMessage onMessage(PacketKeyPrimary packet, MessageContext context) {
			int button = packet.button;
			EntityPlayerMP player = context.getServerHandler().playerEntity;

			switch(button) {
			case 1:ActionPrimaryKey.onReload(player);break;
			case 2:ActionPrimaryKey.onCharge(player);break;
			case 3:ActionPrimaryKey.onMode(player);break;
			case 4:ActionPrimaryKey.onHook(player);break;
			}

			return null;
		}

	}
	//----------------------------------------------------------------------------------
}
