package mods.timaxa007.pack.weapon.util;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class PacketWeapons implements IMessage {

	public int button;
	public boolean buttonstate;

	public PacketWeapons() {}

	public PacketWeapons(int button, boolean buttonstate) {
		this.button = button;
		this.buttonstate = buttonstate;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(button);
		buf.writeBoolean(buttonstate);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		button = buf.readInt();
		buttonstate = buf.readBoolean();
	}

	public static class Handler implements IMessageHandler<PacketWeapons, IMessage> {

		@Override
		public IMessage onMessage(PacketWeapons packet, MessageContext message) {
			int button = packet.button;
			boolean buttonstate = packet.buttonstate;
			EntityPlayerMP player = message.getServerHandler().playerEntity;

			switch(button) {
			case -2:ActionWeapons.onScope(player, buttonstate);;break;
			case -1:ActionWeapons.onFire(player, buttonstate);break;
			case 0:ActionWeapons.onReload(player);break;
			case 1:ActionWeapons.onCharge(player);break;
			case 2:ActionWeapons.onMode(player);break;
			}

			return null;
		}

	}

}
