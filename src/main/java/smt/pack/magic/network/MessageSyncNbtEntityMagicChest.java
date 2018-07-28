package smt.pack.magic.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import smt.pack.magic.entity.EntityMagicChest;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MessageSyncNbtEntityMagicChest implements IMessage {

	public int entityID;
	public NBTTagCompound nbt;

	public MessageSyncNbtEntityMagicChest() {}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(entityID);
		ByteBufUtils.writeTag(buf, nbt);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		entityID = buf.readInt();
		nbt = ByteBufUtils.readTag(buf);
	}

	public static class Handler implements IMessageHandler<MessageSyncNbtEntityMagicChest, IMessage> {

		@Override
		public IMessage onMessage(MessageSyncNbtEntityMagicChest packet, MessageContext message) {
			if (message.side.isClient())
				act(packet);
			else
				act(message.getServerHandler().playerEntity, packet);
			return null;
		}

		@SideOnly(Side.CLIENT)
		private void act(MessageSyncNbtEntityMagicChest packet) {
			Minecraft mc = Minecraft.getMinecraft();
			Entity entity = mc.theWorld.getEntityByID(packet.entityID);
			System.out.println(entity != null);
			if (entity instanceof EntityMagicChest) {
				((EntityMagicChest)entity).onDataPacket(packet);
			}
		}

		private void act(EntityPlayerMP player, MessageSyncNbtEntityMagicChest packet) {
			Entity entity = player.worldObj.getEntityByID(packet.entityID);
			if (entity instanceof EntityMagicChest) {
				((EntityMagicChest)entity).onDataPacket(packet);
			}
		}

	}

}
