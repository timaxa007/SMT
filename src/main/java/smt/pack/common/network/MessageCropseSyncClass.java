package smt.pack.common.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import smt.pack.common.entity.EntityCorpse;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MessageCropseSyncClass implements IMessage {

	public int entityID;
	public String corpse_class;

	public MessageCropseSyncClass() {}

	public MessageCropseSyncClass(int id, String corpse_class) {
		this.entityID = id;
		this.corpse_class = corpse_class;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(entityID);
		ByteBufUtils.writeUTF8String(buf, corpse_class);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		entityID = buf.readInt();
		corpse_class = ByteBufUtils.readUTF8String(buf);
	}

	public static class Handler implements IMessageHandler<MessageCropseSyncClass, IMessage> {

		@Override
		public IMessage onMessage(MessageCropseSyncClass packet, MessageContext message) {
			if (message.side.isClient())
				act(packet);
			else
				act(message.getServerHandler().playerEntity, packet);
			return null;
		}

		@SideOnly(Side.CLIENT)
		private void act(MessageCropseSyncClass packet) {
			Minecraft mc = Minecraft.getMinecraft();
			Entity entity = mc.theWorld.getEntityByID(packet.entityID);
			System.out.println(entity != null);
			if (entity instanceof EntityCorpse) {
				((EntityCorpse)entity).corpse_class = packet.corpse_class;
			}
		}

		private void act(EntityPlayerMP player, MessageCropseSyncClass packet) {
			Entity entity = player.worldObj.getEntityByID(packet.entityID);
			if (entity instanceof EntityCorpse) {
				((EntityCorpse)entity).corpse_class = packet.corpse_class;
			}
		}

	}

}
