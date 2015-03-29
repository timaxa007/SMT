package timaxa007.pack.weapon.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import timaxa007.pack.weapon.util.ActionWeapons;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageActionWeapons implements IMessage {

	public int button;

	public MessageActionWeapons() {}

	public MessageActionWeapons(int button) {
		this.button = button;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(button);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		button = buf.readInt();
	}
	//----------------------------------------------------------------------------------
	public static class Handler implements IMessageHandler<MessageActionWeapons, IMessage> {

		@Override
		public IMessage onMessage(MessageActionWeapons packet, MessageContext message) {
			int button = packet.button;
			EntityPlayerMP player = message.getServerHandler().playerEntity;

			switch(button) {
			case 1:ActionWeapons.onFire(player);break;
			case 2:ActionWeapons.onScope(player, true);break;
			case -2:ActionWeapons.onScope(player, false);break;
			case 3:ActionWeapons.onReload(player);break;
			case 4:ActionWeapons.onMode(player);break;
			case 5:ActionWeapons.zoomIn(player);break;
			case 6:ActionWeapons.zoomOut(player);break;
			}

			return null;
		}

	}
	//----------------------------------------------------------------------------------
}
