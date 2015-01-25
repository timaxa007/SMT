package mods.timaxa007.pack.weapon.packet;

import io.netty.buffer.ByteBuf;
import mods.timaxa007.pack.weapon.util.ActionWeapons;
import net.minecraft.entity.player.EntityPlayerMP;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageActionWeapons implements IMessage {

	public int button;
	//public boolean buttonstate;

	public MessageActionWeapons() {}

	public MessageActionWeapons(int button) {
		this.button = button;
		//this.buttonstate = buttonstate;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(button);
		//buf.writeBoolean(buttonstate);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		button = buf.readInt();
		//buttonstate = buf.readBoolean();
	}

	public static class Handler implements IMessageHandler<MessageActionWeapons, IMessage> {

		@Override
		public IMessage onMessage(MessageActionWeapons packet, MessageContext message) {
			int button = packet.button;
			//boolean buttonstate = packet.buttonstate;
			EntityPlayerMP player = message.getServerHandler().playerEntity;

			switch(button) {
			case 1:ActionWeapons.onFire(player);break;
			}

			return null;
		}

	}

}
