package timaxa007.module.control_button.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageControlButton implements IMessage {

//	public float weight;
	public float weight_max;

	public MessageControlButton() {}

	public MessageControlButton(float weight_max) {
//		this.weight = weight;
		this.weight_max = weight_max;
	}

	@Override
	public void toBytes(ByteBuf buf) {
//		buf.writeFloat(weight);
		buf.writeFloat(weight_max);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
//		weight = buf.readFloat();
		weight_max = buf.readFloat();
	}
	//----------------------------------------------------------------------------------
	public static class Handler implements IMessageHandler<MessageControlButton, IMessage> {

		@Override
		public IMessage onMessage(MessageControlButton packet, MessageContext context) {
	//		float weight = packet.weight;
			float weight_max = packet.weight_max;
			EntityPlayer player = Minecraft.getMinecraft().thePlayer;
	//		PlayerEnvironment.get(player).setWeight(weight);
	//		PlayerEnvironment.get(player).setWeightMax(weight_max);
			return null;
		}

	}
	//----------------------------------------------------------------------------------
}
