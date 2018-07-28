package smt.pack.decorative.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MessageSyncSit implements IMessage {

	private int entityID, sitID;

	public MessageSyncSit() {}

	public MessageSyncSit(int entityID, int sitID) {
		this.entityID = entityID;
		this.sitID = sitID;
	}

	public MessageSyncSit(Entity entity, Entity sit) {
		this.entityID = entity.getEntityId();
		this.sitID = sit.getEntityId();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(entityID);
		buf.writeInt(sitID);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		entityID = buf.readInt();
		sitID = buf.readInt();
	}

	public static class Handler implements IMessageHandler<MessageSyncSit, IMessage> {

		@Override
		public IMessage onMessage(MessageSyncSit packet, MessageContext message) {
			act(packet.entityID, packet.sitID);
			return null;
		}

		@SideOnly(Side.CLIENT)
		private void act(int entityID, int sitID) {
			Minecraft mc = Minecraft.getMinecraft();
			Entity entity = mc.theWorld.getEntityByID(entityID);
			Entity sit = mc.theWorld.getEntityByID(sitID);
			mc.theWorld.spawnEntityInWorld(sit);
			entity.mountEntity(sit);
		}

	}

}
