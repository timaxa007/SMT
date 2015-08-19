package timaxa007.module.player_inventory.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import timaxa007.gui.HandlerGui;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageGui implements IMessage {

	public int act;

	public MessageGui() {}

	public MessageGui(int act) {
		this.act = act;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(act);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		act = buf.readInt();
	}
	//----------------------------------------------------------------------------------
	public static class Handler implements IMessageHandler<MessageGui, IMessage> {

		@Override
		public IMessage onMessage(MessageGui packet, MessageContext message) {
			EntityPlayerMP player = message.getServerHandler().playerEntity;
			//player.openContainer = new ContainerPlayerInventory(player);//is not normal
			switch(packet.act) {
			case 0:HandlerGui.openGui(HandlerGui.GuiID.PLAYER_INVENTORY_STYLE1, player);
			}
			return null;
		}

	}
	//----------------------------------------------------------------------------------
}
