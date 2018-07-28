package smt.pack.common.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import smt.pack.common.entity.EntityCorpse;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MessageCropseSyncNBT implements IMessage {

	public int entityID;
	public NBTTagCompound nbt;

	public MessageCropseSyncNBT() {}

	public MessageCropseSyncNBT(int id, NBTTagCompound nbt) {
		this.entityID = id;
		this.nbt = nbt;
	}

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

	public static class Handler implements IMessageHandler<MessageCropseSyncNBT, IMessage> {

		@Override
		public IMessage onMessage(MessageCropseSyncNBT packet, MessageContext message) {
			if (message.side.isClient())
				act(packet);
			else
				act(message.getServerHandler().playerEntity, packet);
			return null;
		}

		@SideOnly(Side.CLIENT)
		private void act(MessageCropseSyncNBT packet) {
			Minecraft mc = Minecraft.getMinecraft();
			Entity entity = mc.theWorld.getEntityByID(packet.entityID);
			System.out.println(entity != null);
			if (entity instanceof EntityCorpse) {
				((EntityCorpse)entity).corpse_nbt = packet.nbt;
			}
		}

		private void act(EntityPlayerMP player, MessageCropseSyncNBT packet) {
			Entity entity = player.worldObj.getEntityByID(packet.entityID);
			if (entity instanceof EntityCorpse) {
				((EntityCorpse)entity).corpse_nbt = packet.nbt;
			}
		}

	}

}
