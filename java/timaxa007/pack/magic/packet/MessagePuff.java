package timaxa007.pack.magic.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import timaxa007.pack.magic.util.ActionPuff;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessagePuff implements IMessage {

	public int act;
	public double cord_x, cord_y, cord_z;

	public MessagePuff() {}

	public MessagePuff(int act, double cord_x, double cord_y, double cord_z) {
		this.act = act;
		this.cord_x = cord_x;
		this.cord_y = cord_y;
		this.cord_z = cord_z;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(act);
		buf.writeDouble(cord_x);
		buf.writeDouble(cord_y);
		buf.writeDouble(cord_z);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		act = buf.readInt();
		cord_x = buf.readDouble();
		cord_y = buf.readDouble();
		cord_z = buf.readDouble();
	}

	public static class Handler implements IMessageHandler<MessagePuff, IMessage> {

		@Override
		public IMessage onMessage(MessagePuff packet, MessageContext message) {
			int act = packet.act;
			double cord_x = packet.cord_x;
			double cord_y = packet.cord_y;
			double cord_z = packet.cord_z;
			EntityClientPlayerMP player = Minecraft.getMinecraft().thePlayer;
			
			switch(act) {
			case 1:ActionPuff.puff1(player, cord_x, cord_y, cord_z);break;
			case 2:ActionPuff.craft1(player, cord_x, cord_y, cord_z);break;
			case 3:ActionPuff.fried1(player, cord_x, cord_y, cord_z);break;
			default:break;
			}

			return null;
		}

	}

}
