package mods.timaxa007.pack.weapon.packet;

import io.netty.buffer.ByteBuf;
import mods.timaxa007.pack.weapon.PackWeapons;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayerMP;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

@Deprecated
public class PacketOpenGui implements IMessage {

	public int gui_id;

	public PacketOpenGui() {}

	public PacketOpenGui(int gui_id) {
		this.gui_id = gui_id;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(gui_id);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		gui_id = buf.readInt();
	}

	public static class Handler implements IMessageHandler<PacketOpenGui, IMessage> {

		@Override
		public IMessage onMessage(PacketOpenGui packet, MessageContext message) {
			int gui_id = packet.gui_id;
			EntityClientPlayerMP player = Minecraft.getMinecraft().thePlayer;

			switch(gui_id) {
			case 1:player.openGui(PackWeapons.instance, PackWeapons.proxy.gui_scope_1, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);break;
			}

			return null;
		}

	}

}
