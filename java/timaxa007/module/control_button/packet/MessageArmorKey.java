package timaxa007.module.control_button.packet;

import io.netty.buffer.ByteBuf;
import timaxa007.module.control_button.util.ActionArmorKey;
import net.minecraft.entity.player.EntityPlayerMP;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageArmorKey implements IMessage {

	public int button;
	public boolean buttonstate;

	public MessageArmorKey() {}

	public MessageArmorKey(int button, boolean buttonstate) {
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
	public static class Handler implements IMessageHandler<MessageArmorKey, IMessage> {

		@Override
		public IMessage onMessage(MessageArmorKey packet, MessageContext context) {
			int button = packet.button;
			boolean buttonstate = packet.buttonstate;
			EntityPlayerMP player = context.getServerHandler().playerEntity;

			switch(button) {/*
			case -4:ActionArmorKey.actionBootsTick(player);break;
			case -3:ActionArmorKey.actionLeggingsTick(player);break;
			case -2:ActionArmorKey.actionChestplateTick(player);break;
			case -1:ActionArmorKey.actionHelmetTick(player);break;*/
			case 1:ActionArmorKey.actionHelmet(player, buttonstate);break;
			case 2:ActionArmorKey.actionChestplate(player, buttonstate);break;
			case 3:ActionArmorKey.actionLeggings(player, buttonstate);break;
			case 4:ActionArmorKey.actionBoots(player, buttonstate);break;
			}

			return null;
		}

	}
	//----------------------------------------------------------------------------------
}
