package smt.pack.technology.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import smt.pack.technology.tile.TileEntityElectricMachine;
import smt.pack.technology.tile.machine.ElectricBigBufferItem;

public class MessageSyncSize implements IMessage {

	public int x, y, z;
	public byte i;
	public short size;

	public MessageSyncSize() {}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(x);
		buf.writeInt(y);
		buf.writeInt(z);
		buf.writeByte(i);
		buf.writeShort(size);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		x = buf.readInt();
		y = buf.readInt();
		z = buf.readInt();
		i = buf.readByte();
		size = buf.readShort();
	}

	public static class Handler implements IMessageHandler<MessageSyncSize, IMessage> {

		@Override
		public IMessage onMessage(MessageSyncSize packet, MessageContext message) {
			if (message.side.isClient())
				act(packet);
			else
				act(message.getServerHandler().playerEntity, packet);
			return null;
		}

		@SideOnly(Side.CLIENT)
		private void act(MessageSyncSize packet) {
			TileEntityElectricMachine tile = (TileEntityElectricMachine)Minecraft.getMinecraft().theWorld.getTileEntity(packet.x, packet.y, packet.z);
			ElectricBigBufferItem ebbi = (ElectricBigBufferItem)tile.getElectricMachine();
			ebbi.stackSizeLarge[packet.i] = packet.size;
		}

		private void act(EntityPlayerMP player, MessageSyncSize packet) {

		}

	}

}
