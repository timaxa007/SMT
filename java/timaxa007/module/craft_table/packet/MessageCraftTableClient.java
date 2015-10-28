package timaxa007.module.craft_table.packet;

import static timaxa007.core.CoreSMT.log;
import io.netty.buffer.ByteBuf;
import net.minecraft.item.ItemStack;
import timaxa007.module.craft_table.CraftTable;
import timaxa007.module.craft_table.CraftTable.BlockCraftTable;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageCraftTableClient implements IMessage {

	public int x;
	public int y;
	public int z;

	public ItemStack is1;
	public ItemStack is2;
	public ItemStack is3;
	public ItemStack is4;
	public ItemStack is5;
	public ItemStack is6;
	public ItemStack is7;
	public ItemStack is8;
	public ItemStack is9;

	public MessageCraftTableClient() {}
	public MessageCraftTableClient(BlockCraftTable bct) {
		this.x = bct.x;
		this.y = bct.y;
		this.z = bct.z;

		this.is1 = bct.inv[0];
		this.is2 = bct.inv[1];
		this.is3 = bct.inv[2];
		this.is4 = bct.inv[3];
		this.is5 = bct.inv[4];
		this.is6 = bct.inv[5];
		this.is7 = bct.inv[6];
		this.is8 = bct.inv[7];
		this.is9 = bct.inv[8];
	}

	@Override public void toBytes(ByteBuf buf) {
		buf.writeInt(x);
		buf.writeInt(y);
		buf.writeInt(z);

		ByteBufUtils.writeItemStack(buf, is1);
		ByteBufUtils.writeItemStack(buf, is2);
		ByteBufUtils.writeItemStack(buf, is3);
		ByteBufUtils.writeItemStack(buf, is4);
		ByteBufUtils.writeItemStack(buf, is5);
		ByteBufUtils.writeItemStack(buf, is6);
		ByteBufUtils.writeItemStack(buf, is7);
		ByteBufUtils.writeItemStack(buf, is8);
		ByteBufUtils.writeItemStack(buf, is9);
	}
	@Override public void fromBytes(ByteBuf buf) {
		x = buf.readInt();
		y = buf.readInt();
		z = buf.readInt();

		is1 = ByteBufUtils.readItemStack(buf);
		is2 = ByteBufUtils.readItemStack(buf);
		is3 = ByteBufUtils.readItemStack(buf);
		is4 = ByteBufUtils.readItemStack(buf);
		is5 = ByteBufUtils.readItemStack(buf);
		is6 = ByteBufUtils.readItemStack(buf);
		is7 = ByteBufUtils.readItemStack(buf);
		is8 = ByteBufUtils.readItemStack(buf);
		is9 = ByteBufUtils.readItemStack(buf);
	}
	//-----------------------------------------------------------------------------------------------
	public static class Handler implements IMessageHandler<MessageCraftTableClient, IMessage> {
		@Override public IMessage onMessage(MessageCraftTableClient packet, MessageContext message) {
			log.info("Receive MessageCraftTableClient");
			CraftTable.setCraftTableClient(packet.x, packet.y, packet.z, new ItemStack[] {
					packet.is1,
					packet.is2,
					packet.is3,
					packet.is4,
					packet.is5,
					packet.is6,
					packet.is7,
					packet.is8,
					packet.is9
			});
			return null;
		}
	}
	//-----------------------------------------------------------------------------------------------
}
