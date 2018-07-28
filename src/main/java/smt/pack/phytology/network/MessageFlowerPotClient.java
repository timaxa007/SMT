package smt.pack.phytology.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityFlowerPot;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MessageFlowerPotClient implements IMessage {

	private static int x, y, z, metadata;

	public MessageFlowerPotClient() {}

	public MessageFlowerPotClient(int x, int y, int z, int metadata) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.metadata = metadata;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(x);
		buf.writeInt(y);
		buf.writeInt(z);
		buf.writeInt(metadata);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		x = buf.readInt();
		y = buf.readInt();
		z = buf.readInt();
		metadata = buf.readInt();
	}

	public static class Handler implements IMessageHandler<MessageFlowerPotClient, IMessage> {

		@Override
		public IMessage onMessage(MessageFlowerPotClient packet, MessageContext message) {
			act(packet.x, packet.y, packet.z, packet.metadata);
			return null;
		}

		@SideOnly(Side.CLIENT)
		private static void act(int x, int y, int z, int metadata) {
			Minecraft mc = Minecraft.getMinecraft();
			if (mc.theWorld.getTileEntity(x, y, z) != null && mc.theWorld.getTileEntity(x, y, z) instanceof TileEntityFlowerPot) {
				TileEntityFlowerPot tileentityflowerpot = (TileEntityFlowerPot)mc.theWorld.getTileEntity(x, y, z);
				tileentityflowerpot.func_145964_a(Item.getItemFromBlock(Blocks.sapling), metadata);
				//tileentityflowerpot.markDirty();
				mc.theWorld.markBlockForUpdate(x, y, z);
			}
		}

	}

}
