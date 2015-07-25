package timaxa007.module.environment.util;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageEnvironment implements IMessage {

	//	public float weight;
	public float weight_max;

	public MessageEnvironment() {}

	public MessageEnvironment(float weight_max) {
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
	public static class Handler implements IMessageHandler<MessageEnvironment, IMessage> {

		@Override
		public IMessage onMessage(MessageEnvironment packet, MessageContext context) {
			//float weight = packet.weight;
			float weight_max = packet.weight_max;
			//EntityClientPlayerMP player = UtilSMT.getPlayerClient();
			//PlayerEnvironment.get(player).setWeight(weight);
			//PlayerEnvironment.get(player).setWeightMax(weight_max);
			return null;
		}

	}
	//----------------------------------------------------------------------------------
}
