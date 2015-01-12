package mods.timaxa007.pack.furniture.packet;

import io.netty.buffer.ByteBuf;
import mods.timaxa007.pack.furniture.util.ActionBackpack;
import net.minecraft.entity.player.EntityPlayerMP;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

@Deprecated
public class PacketBackpack implements IMessage {

	public int id_gui;
	public boolean open_gui;

	public PacketBackpack() {}

	public PacketBackpack(int id_gui, boolean open_gui) {
		this.id_gui = id_gui;
		this.open_gui = open_gui;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(id_gui);
		buf.writeBoolean(open_gui);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		id_gui = buf.readInt();
		open_gui = buf.readBoolean();
	}
	//----------------------------------------------------------------------------------
	public static class Handler implements IMessageHandler<PacketBackpack, IMessage> {

		@Override
		public IMessage onMessage(PacketBackpack packet, MessageContext context) {
			int id_gui = packet.id_gui;
			boolean open_gui = packet.open_gui;
			EntityPlayerMP player = context.getServerHandler().playerEntity;

			switch(id_gui) {
			case 1:ActionBackpack.isGui(player, open_gui);break;
			case -1:ActionBackpack.isGuiTick(player, open_gui);break;
			}

			return null;
		}

	}
	//----------------------------------------------------------------------------------
}
