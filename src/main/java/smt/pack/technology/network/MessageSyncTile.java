package smt.pack.technology.network;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.Constants.NBT;
import smt.pack.technology.tile.TileEntityBlocksTechnology;

public class MessageSyncTile implements IMessage {

	public int x, y, z;
	public NBTTagCompound nbt;

	public MessageSyncTile() {}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(x);
		buf.writeInt(y);
		buf.writeInt(z);
		ByteBufUtils.writeTag(buf, nbt);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		x = buf.readInt();
		y = buf.readInt();
		z = buf.readInt();
		nbt = ByteBufUtils.readTag(buf);
	}

	public static class Handler implements IMessageHandler<MessageSyncTile, IMessage> {

		@Override
		public IMessage onMessage(MessageSyncTile packet, MessageContext message) {
			if (message.side.isClient())
				act(packet);
			else
				act(message.getServerHandler().playerEntity, packet);
			return null;
		}

		@SideOnly(Side.CLIENT)
		private void act(MessageSyncTile packet) {
			TileEntityBlocksTechnology tile = (TileEntityBlocksTechnology)Minecraft.getMinecraft().theWorld.getTileEntity(packet.x, packet.y, packet.z);
			if (packet.nbt.hasKey("posX", NBT.TAG_INT)) tile.posX = packet.nbt.getInteger("posX");
			if (packet.nbt.hasKey("posY", NBT.TAG_INT)) tile.posY = packet.nbt.getInteger("posY");
			if (packet.nbt.hasKey("posZ", NBT.TAG_INT)) tile.posZ = packet.nbt.getInteger("posZ");
		}

		private void act(EntityPlayerMP player, MessageSyncTile packet) {
			TileEntityBlocksTechnology tile = (TileEntityBlocksTechnology)player.worldObj.getTileEntity(packet.x, packet.y, packet.z);
			if (packet.nbt.hasKey("posX", NBT.TAG_INT)) tile.posX = packet.nbt.getInteger("posX");
			if (packet.nbt.hasKey("posY", NBT.TAG_INT)) tile.posY = packet.nbt.getInteger("posY");
			if (packet.nbt.hasKey("posZ", NBT.TAG_INT)) tile.posZ = packet.nbt.getInteger("posZ");
		}

	}

}
