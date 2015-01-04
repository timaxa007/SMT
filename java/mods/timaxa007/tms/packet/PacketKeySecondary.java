package mods.timaxa007.tms.packet;

import io.netty.buffer.ByteBuf;
import mods.timaxa007.tms.util.ActionSecondaryKey;
import net.minecraft.entity.player.EntityPlayerMP;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class PacketKeySecondary implements IMessage {

	public int button;
	public boolean buttonstate;

	public PacketKeySecondary() {}

	public PacketKeySecondary(int button, boolean buttonstate) {
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
	public static class Handler implements IMessageHandler<PacketKeySecondary, IMessage> {

		@Override
		public IMessage onMessage(PacketKeySecondary packet, MessageContext context) {
			int button = packet.button;
			boolean buttonstate = packet.buttonstate;
			EntityPlayerMP player = context.getServerHandler().playerEntity;

			switch(button) {
			case -10:ActionSecondaryKey.onUse1Tick(player);break;
			case -9:ActionSecondaryKey.onDownTick(player);break;
			case -8:ActionSecondaryKey.onUse2Tick(player);break;
			case -7:ActionSecondaryKey.onMoveLeftTick(player);break;
			case -6:ActionSecondaryKey.onStopTick(player);break;
			case -5:ActionSecondaryKey.onMoveRightTick(player);break;
			case -4:ActionSecondaryKey.onYawLeftTick(player);break;
			case -3:ActionSecondaryKey.onUpTick(player);break;
			case -2:ActionSecondaryKey.onYawRightTick(player);break;
			case -1:ActionSecondaryKey.onUseTick(player);break;

			case 1:ActionSecondaryKey.onUse(player, buttonstate);break;
			case 2:ActionSecondaryKey.onYawRight(player, buttonstate);break;
			case 3:ActionSecondaryKey.onUp(player, buttonstate);break;
			case 4:ActionSecondaryKey.onYawLeft(player, buttonstate);break;
			case 5:ActionSecondaryKey.onMoveRight(player, buttonstate);break;
			case 6:ActionSecondaryKey.onStop(player, buttonstate);break;
			case 7:ActionSecondaryKey.onMoveLeft(player, buttonstate);break;
			case 8:ActionSecondaryKey.onUse2(player, buttonstate);break;
			case 9:ActionSecondaryKey.onDown(player, buttonstate);break;
			case 10:ActionSecondaryKey.onUse1(player, buttonstate);break;
			}

			return null;
		}

	}
	//----------------------------------------------------------------------------------
}
