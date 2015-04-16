package timaxa007.pack.weapon.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import timaxa007.pack.weapon.PackWeapons;
import timaxa007.tms.CoreTMS;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

@Deprecated
public class MessageOpenGui implements IMessage {

	public int gui_id;

	public MessageOpenGui() {}

	public MessageOpenGui(int gui_id) {
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

	public static class Handler implements IMessageHandler<MessageOpenGui, IMessage> {

		@Override
		public IMessage onMessage(MessageOpenGui packet, MessageContext message) {
			int gui_id = packet.gui_id;
			EntityClientPlayerMP player = Minecraft.getMinecraft().thePlayer;

			switch(gui_id) {
			case 1:player.openGui(CoreTMS.instance, PackWeapons.gui_scope_1, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);break;
			}

			return null;
		}

	}

}
