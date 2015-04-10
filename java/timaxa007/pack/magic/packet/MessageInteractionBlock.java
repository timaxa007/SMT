package timaxa007.pack.magic.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import timaxa007.pack.magic.util.ActionInteractionBlock;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageInteractionBlock implements IMessage {

	public int block_x;
	public int block_y;
	public int block_z;
	public int act;

	public MessageInteractionBlock() {}

	public MessageInteractionBlock(int block_x, int block_y, int block_z, int act) {
		this.block_x = block_x;
		this.block_y = block_y;
		this.block_z = block_z;
		this.act = act;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(block_x);
		buf.writeInt(block_y);
		buf.writeInt(block_z);
		buf.writeInt(act);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		block_x = buf.readInt();
		block_y = buf.readInt();
		block_z = buf.readInt();
		act = buf.readInt();
	}

	public static class Handler implements IMessageHandler<MessageInteractionBlock, IMessage> {

		@Override
		public IMessage onMessage(MessageInteractionBlock packet, MessageContext message) {
			int block_x = packet.block_x;
			int block_y = packet.block_y;
			int block_z = packet.block_z;
			int act = packet.act;
			EntityPlayerMP player = message.getServerHandler().playerEntity;

			switch(act) {
			case 1:ActionInteractionBlock.actBlock1(player, block_x, block_y, block_z);break;
			}

			return null;
		}

	}

}
