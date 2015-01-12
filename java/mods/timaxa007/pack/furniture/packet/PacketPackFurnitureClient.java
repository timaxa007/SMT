package mods.timaxa007.pack.furniture.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class PacketPackFurnitureClient implements IMessage {

	public int button;
	public boolean buttonstate;

	public PacketPackFurnitureClient() {}

	public PacketPackFurnitureClient(int button, boolean buttonstate) {
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

	public static class Handler implements IMessageHandler<PacketPackFurnitureClient, IMessage> {

		@Override
		public IMessage onMessage(PacketPackFurnitureClient packet, MessageContext message) {
			int button = packet.button;
			boolean buttonstate = packet.buttonstate;
			EntityPlayerMP player = message.getServerHandler().playerEntity;

			switch(button) {
			//case 0:ActionWeapons.onReload(player);break;
			}

			return null;
		}

	}

}
