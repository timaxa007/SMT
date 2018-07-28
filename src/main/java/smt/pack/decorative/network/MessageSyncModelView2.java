package smt.pack.decorative.network;

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
import smt.pack.decorative.tile.TileEntityModelView;

public class MessageSyncModelView2 implements IMessage {

	public int x, y, z;
	public NBTTagCompound nbt;

	public MessageSyncModelView2() {}

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

	public static class Handler implements IMessageHandler<MessageSyncModelView2, IMessage> {

		@Override
		public IMessage onMessage(MessageSyncModelView2 packet, MessageContext message) {
			if (message.side.isClient())
				act(packet);
			else
				act(packet, message.getServerHandler().playerEntity);
			return null;
		}

		@SideOnly(Side.CLIENT)
		private void act(MessageSyncModelView2 packet) {
			TileEntityModelView tile = (TileEntityModelView)Minecraft.getMinecraft().theWorld.getTileEntity(packet.x, packet.y, packet.z);
			//te.readFromNBT(packet.nbt);
			if (packet.nbt.hasKey("tX", NBT.TAG_FLOAT)) tile.translateX = packet.nbt.getFloat("tX");
			if (packet.nbt.hasKey("tY", NBT.TAG_FLOAT)) tile.translateY = packet.nbt.getFloat("tY");
			if (packet.nbt.hasKey("tZ", NBT.TAG_FLOAT)) tile.translateZ = packet.nbt.getFloat("tZ");
			if (packet.nbt.hasKey("rX", NBT.TAG_FLOAT)) tile.rotateX = packet.nbt.getFloat("rX");
			if (packet.nbt.hasKey("rY", NBT.TAG_FLOAT)) tile.rotateY = packet.nbt.getFloat("rY");
			if (packet.nbt.hasKey("rZ", NBT.TAG_FLOAT)) tile.rotateZ = packet.nbt.getFloat("rZ");
			if (packet.nbt.hasKey("sX", NBT.TAG_FLOAT)) tile.scaleX = packet.nbt.getFloat("sX");
			if (packet.nbt.hasKey("sY", NBT.TAG_FLOAT)) tile.scaleY = packet.nbt.getFloat("sY");
			if (packet.nbt.hasKey("sZ", NBT.TAG_FLOAT)) tile.scaleZ = packet.nbt.getFloat("sZ");
		}

		private void act(MessageSyncModelView2 packet, EntityPlayerMP player) {
			TileEntityModelView tile = (TileEntityModelView)player.worldObj.getTileEntity(packet.x, packet.y, packet.z);
			//te.readFromNBT(packet.nbt);
			if (packet.nbt.hasKey("tX", NBT.TAG_FLOAT)) tile.translateX = packet.nbt.getFloat("tX");
			if (packet.nbt.hasKey("tY", NBT.TAG_FLOAT)) tile.translateY = packet.nbt.getFloat("tY");
			if (packet.nbt.hasKey("tZ", NBT.TAG_FLOAT)) tile.translateZ = packet.nbt.getFloat("tZ");
			if (packet.nbt.hasKey("rX", NBT.TAG_FLOAT)) tile.rotateX = packet.nbt.getFloat("rX");
			if (packet.nbt.hasKey("rY", NBT.TAG_FLOAT)) tile.rotateY = packet.nbt.getFloat("rY");
			if (packet.nbt.hasKey("rZ", NBT.TAG_FLOAT)) tile.rotateZ = packet.nbt.getFloat("rZ");
			if (packet.nbt.hasKey("sX", NBT.TAG_FLOAT)) tile.scaleX = packet.nbt.getFloat("sX");
			if (packet.nbt.hasKey("sY", NBT.TAG_FLOAT)) tile.scaleY = packet.nbt.getFloat("sY");
			if (packet.nbt.hasKey("sZ", NBT.TAG_FLOAT)) tile.scaleZ = packet.nbt.getFloat("sZ");
		}

	}

}
