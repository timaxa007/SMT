package mods.timaxa007.tms.packet;

import io.netty.buffer.ByteBuf;
import mods.timaxa007.tms.util.ActionKey;
import net.minecraft.entity.player.EntityPlayerMP;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class PacketKey implements IMessage {

	public int button;
	public boolean buttonstate;

	public PacketKey() {}

	public PacketKey(int button, boolean buttonstate) {
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
	//----------------------------------------------------------------------------------
	public static class Handler implements IMessageHandler<PacketKey, IMessage> {

		@Override
		public IMessage onMessage(PacketKey packet, MessageContext context) {
			int button = packet.button;
			boolean buttonstate = packet.buttonstate;
			EntityPlayerMP player = context.getServerHandler().playerEntity;

			switch(button) {
			case -4:ActionKey.onLeftClickTick(player);break;
			case -3:ActionKey.onRightClickTick(player);break;
			case -2:ActionKey.onLeftClick(player, buttonstate);break;
			case -1:ActionKey.onRightClick(player, buttonstate);break;
			case 0:ActionKey.onReload(player);break;
			case 1:ActionKey.onCharge(player);break;
			case 2:ActionKey.onMode(player);break;
			case 3:ActionKey.onUse(player);break;
			case 4:ActionKey.onYawRight(player);break;
			case 5:ActionKey.onUp(player);break;
			case 6:ActionKey.onYawLeft(player);break;
			case 7:ActionKey.onMoveRight(player);break;
			case 8:ActionKey.onStop(player);break;
			case 9:ActionKey.onMoveLeft(player);break;
			case 10:ActionKey.onUse2(player);break;
			case 11:ActionKey.onDown(player);break;
			case 12:ActionKey.onUse1(player);break;
			}

			return null;
		}

	}
	//----------------------------------------------------------------------------------
}
