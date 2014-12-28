package mods.timaxa007.tms.util;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class KeyPacket implements IMessage {

	public int key;

	public KeyPacket() {}

	public KeyPacket(int key) {
		this.key = key;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(key);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		key = buf.readInt();
	}

	public static class Handler implements IMessageHandler<KeyPacket, IMessage> {

		@Override
		public IMessage onMessage(KeyPacket message, MessageContext context) {
			int key = message.key;
			EntityPlayerMP player = context.getServerHandler().playerEntity;

			switch(key) {
			case -4:ActionKey.offLeftClick(player);break;
			case -3:ActionKey.offRightClick(player);break;
			case -2:ActionKey.onLeftClick(player);break;
			case -1:ActionKey.onRightClick(player);break;
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

}
