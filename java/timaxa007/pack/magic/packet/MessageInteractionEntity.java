package timaxa007.pack.magic.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import timaxa007.pack.magic.util.ActionInteractionEntity;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageInteractionEntity implements IMessage {

	private static int entityID;
	public int act;

	public MessageInteractionEntity() {}

	public MessageInteractionEntity(int entityID, int act) {
		this.entityID = entityID;
		this.act = act;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(entityID);
		buf.writeInt(act);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		entityID = buf.readInt();
		act = buf.readInt();
	}
	//----------------------------------------------------------------------------------
	public static class Handler implements IMessageHandler<MessageInteractionEntity, IMessage> {

		@Override
		public IMessage onMessage(MessageInteractionEntity packet, MessageContext message) {
			int entityID = packet.entityID;
			int act = packet.act;
			EntityPlayerMP player = message.getServerHandler().playerEntity;
			Entity entity = player.worldObj.getEntityByID(entityID);

			switch(act) {
			case 1:ActionInteractionEntity.act1(player, entity);break;
			}

			return null;
		}

	}
	//----------------------------------------------------------------------------------
}
