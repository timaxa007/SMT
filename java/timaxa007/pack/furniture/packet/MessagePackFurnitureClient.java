package timaxa007.pack.furniture.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessagePackFurnitureClient implements IMessage {

	public int button;
	public boolean buttonstate;

	public MessagePackFurnitureClient() {}

	public MessagePackFurnitureClient(int button, boolean buttonstate) {
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

	public static class Handler implements IMessageHandler<MessagePackFurnitureClient, IMessage> {

		@Override
		public IMessage onMessage(MessagePackFurnitureClient packet, MessageContext message) {
			int button = packet.button;
			boolean buttonstate = packet.buttonstate;
			EntityClientPlayerMP player = Minecraft.getMinecraft().thePlayer;

			switch(button) {
			//case 0:ActionWeapons.onReload(player);break;
			}

			return null;
		}

	}

}