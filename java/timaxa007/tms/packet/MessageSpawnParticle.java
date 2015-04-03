package timaxa007.tms.packet;

import io.netty.buffer.ByteBuf;
import timaxa007.tms.util.ActionSpawnParticle;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

@Deprecated //Useless thing, it has alredy replaced by vanila.
public class MessageSpawnParticle implements IMessage {

	public int num;
	public double cordX;
	public double cordY;
	public double cordZ;

	public MessageSpawnParticle() {}

	public MessageSpawnParticle(int num, double cordX, double cordY, double cordZ) {
		this.num = num;
		this.cordX = cordX;
		this.cordY = cordY;
		this.cordZ = cordZ;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(num);
		buf.writeDouble(cordX);
		buf.writeDouble(cordY);
		buf.writeDouble(cordZ);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		num = buf.readInt();
		cordX = buf.readDouble();
		cordY = buf.readDouble();
		cordZ = buf.readDouble();
	}
	//----------------------------------------------------------------------------------
	public static class Handler implements IMessageHandler<MessageSpawnParticle, IMessage> {

		@Override
		public IMessage onMessage(MessageSpawnParticle packet, MessageContext context) {
			int num = packet.num;
			double cordX = packet.cordX;
			double cordY = packet.cordY;
			double cordZ = packet.cordZ;
			EntityClientPlayerMP player = Minecraft.getMinecraft().thePlayer;
			World world = player.worldObj;

			switch(num) {
			case 1:ActionSpawnParticle.on1(player, world, cordX, cordY, cordZ);break;
			case 2:ActionSpawnParticle.on1(player, world, cordX, cordY, cordZ);break;
			case 3:ActionSpawnParticle.on1(player, world, cordX, cordY, cordZ);break;
			case 4:ActionSpawnParticle.on1(player, world, cordX, cordY, cordZ);break;
			case 5:ActionSpawnParticle.on1(player, world, cordX, cordY, cordZ);break;
			case 6:ActionSpawnParticle.on1(player, world, cordX, cordY, cordZ);break;
			}

			return null;
		}

	}
	//----------------------------------------------------------------------------------
}
