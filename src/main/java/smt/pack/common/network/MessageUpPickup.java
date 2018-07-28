package smt.pack.common.network;

import java.util.ArrayList;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import smt.pack.common.event.EventsForge;

public class MessageUpPickup implements IMessage {

	public int id;

	public MessageUpPickup() {}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(id);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		id = buf.readInt();
	}

	public static class Handler implements IMessageHandler<MessageUpPickup, IMessage> {

		@Override
		public IMessage onMessage(MessageUpPickup packet, MessageContext message) {
			if (message.side.isClient())
				act(packet);
			else
				act(message.getServerHandler().playerEntity, packet);
			return null;
		}

		@SideOnly(Side.CLIENT)
		private void act(MessageUpPickup packet) {
			Minecraft mc = Minecraft.getMinecraft();
			if (!EventsForge.pickup.containsKey(mc.thePlayer)) {
				ArrayList list = new ArrayList();
				list.add(packet.id);
				EventsForge.pickup.put(mc.thePlayer, list);
			} else {
				EventsForge.pickup.get(mc.thePlayer).add(packet.id);
			}
		}

		private void act(EntityPlayerMP player, MessageUpPickup packet) {
			if (!EventsForge.pickup.containsKey(player)) {
				ArrayList list = new ArrayList();
				list.add(packet.id);
				EventsForge.pickup.put(player, list);
			} else {
				EventsForge.pickup.get(player).add(packet.id);
			}
		}

	}

}
