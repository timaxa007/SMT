package timaxa007.pack.conjoint.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import timaxa007.pack.conjoint.util.ActionInteractionEntity;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageInteractionEntity implements IMessage {

	private static int entityID;

	public MessageInteractionEntity() {}

	public MessageInteractionEntity(int entityID) {
		this.entityID = entityID;
	}

	public MessageInteractionEntity(Entity entity) {
		this.entityID = entity.getEntityId();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(entityID);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		entityID = buf.readInt();
	}
	//----------------------------------------------------------------------------------
	public static class Handler implements IMessageHandler<MessageInteractionEntity, IMessage> {

		@Override
		public IMessage onMessage(MessageInteractionEntity packet, MessageContext message) {
			int entityID = packet.entityID;
			EntityPlayerMP player = message.getServerHandler().playerEntity;
			Entity entity = player.worldObj.getEntityByID(entityID);

			ActionInteractionEntity.act1(player, entity);

			return null;
		}

	}
	//----------------------------------------------------------------------------------
}
