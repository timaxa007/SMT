package smt.pack.technology.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import smt.pack.technology.block.BlockBlocksTechnology;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MessageReplacementBlocksTechnologyClient implements IMessage {

	private int x, y, z, id;

	public MessageReplacementBlocksTechnologyClient() {}

	public MessageReplacementBlocksTechnologyClient(int x, int y, int z, int id) {
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

	public static class Handler implements IMessageHandler<MessageReplacementBlocksTechnologyClient, IMessage> {

		@Override
		public IMessage onMessage(MessageReplacementBlocksTechnologyClient packet, MessageContext message) {
			act(packet.x, packet.y, packet.z, packet.id);
			return null;
		}

		@SideOnly(Side.CLIENT)
		private void act(int x, int y, int z, int id) {
			Minecraft mc = Minecraft.getMinecraft();
			//mc.theWorld.setTileEntity(x, y, z, BlockBlocksTechnology.tiles[id]);
			mc.theWorld.setBlockMetadataWithNotify(x, y, z, id, 3);
		}

	}

}
