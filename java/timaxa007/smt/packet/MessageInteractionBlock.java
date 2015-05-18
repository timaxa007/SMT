package timaxa007.smt.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import timaxa007.pack.magic.util.ActionInteractionBlock;
import timaxa007.smt.util.Vex;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageInteractionBlock implements IMessage {

	public int block_x;
	public int block_y;
	public int block_z;

	public MessageInteractionBlock() {}

	public MessageInteractionBlock(int block_x, int block_y, int block_z) {
		this.block_x = block_x;
		this.block_y = block_y;
		this.block_z = block_z;
	}

	public MessageInteractionBlock(Vex.Integer3 vex) {
		this.block_x = vex.x;
		this.block_y = vex.y;
		this.block_z = vex.z;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(block_x);
		buf.writeInt(block_y);
		buf.writeInt(block_z);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		block_x = buf.readInt();
		block_y = buf.readInt();
		block_z = buf.readInt();
	}
	//----------------------------------------------------------------------------------
	public static class Handler implements IMessageHandler<MessageInteractionBlock, IMessage> {

		@Override
		public IMessage onMessage(MessageInteractionBlock packet, MessageContext message) {
			int block_x = packet.block_x;
			int block_y = packet.block_y;
			int block_z = packet.block_z;
			EntityPlayerMP player = message.getServerHandler().playerEntity;

			ActionInteractionBlock.actBlock1(player, block_x, block_y, block_z);

			return null;
		}

	}
	//----------------------------------------------------------------------------------
}
