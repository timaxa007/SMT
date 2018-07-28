package smt.pack.technology.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import smt.pack.technology.SMTTechnology;
import smt.pack.technology.block.BlockBlocksTechnology;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageReplacementBlocksTechnologyServer implements IMessage {

	private int x, y, z, id;

	public MessageReplacementBlocksTechnologyServer() {}

	public MessageReplacementBlocksTechnologyServer(int x, int y, int z, int id) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.id = id;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(x);
		buf.writeInt(y);
		buf.writeInt(z);
		buf.writeInt(id);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		x = buf.readInt();
		y = buf.readInt();
		z = buf.readInt();
		id = buf.readInt();
	}

	public static class Handler implements IMessageHandler<MessageReplacementBlocksTechnologyServer, IMessage> {

		@Override
		public IMessage onMessage(MessageReplacementBlocksTechnologyServer packet, MessageContext message) {
			act(message.getServerHandler().playerEntity, packet.x, packet.y, packet.z, packet.id);
			return null;
		}

		private void act(EntityPlayerMP player, int x, int y, int z, int id) {
			//player.worldObj.setTileEntity(x, y, z, BlockBlocksTechnology.tiles[id]);
			player.worldObj.setBlockMetadataWithNotify(x, y, z, id, 3);
			SMTTechnology.network.sendToDimension(new MessageReplacementBlocksTechnologyClient(x, y, z, id), player.dimension);
		}

	}

}
