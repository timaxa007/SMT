package smt.pack.decorative.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import smt.pack.decorative.tile.TileEntityModelView;

public class MessageSyncModelView implements IMessage {

	public int x, y, z;
	public byte act;
	public float par;
	/*
	public float
	translateX, translateY, translateZ,
	rotateX, rotateY, rotateZ,
	scaleX, scaleY, scaleZ;
	 */
	public MessageSyncModelView() {}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(x);
		buf.writeInt(y);
		buf.writeInt(z);

		buf.writeByte(act);
		buf.writeFloat(par);
		/*
		buf.writeFloat(translateX);
		buf.writeFloat(translateY);
		buf.writeFloat(translateZ);

		buf.writeFloat(rotateX);
		buf.writeFloat(rotateY);
		buf.writeFloat(rotateZ);

		buf.writeFloat(scaleX);
		buf.writeFloat(scaleY);
		buf.writeFloat(scaleZ);
		 */
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		x = buf.readInt();
		y = buf.readInt();
		z = buf.readInt();

		act = buf.readByte();
		par = buf.readFloat();

		/*
		translateX = buf.readFloat();
		translateY = buf.readFloat();
		translateZ = buf.readFloat();

		rotateX = buf.readFloat();
		rotateY = buf.readFloat();
		rotateZ = buf.readFloat();

		scaleX = buf.readFloat();
		scaleY = buf.readFloat();
		scaleZ = buf.readFloat();
		 */
	}

	public static class Handler implements IMessageHandler<MessageSyncModelView, IMessage> {

		@Override
		public IMessage onMessage(MessageSyncModelView packet, MessageContext message) {
			if (message.side.isClient())
				act(packet);
			else
				act(packet, message.getServerHandler().playerEntity);
			return null;
		}

		@SideOnly(Side.CLIENT)
		private void act(MessageSyncModelView packet) {
			TileEntityModelView te = (TileEntityModelView)Minecraft.getMinecraft().theWorld.getTileEntity(packet.x, packet.y, packet.z);
			switch(packet.act) {
			case 0:te.translateX = packet.par;break;
			case 1:te.translateY = packet.par;break;
			case 2:te.translateZ = packet.par;break;

			case 3:te.rotateX = packet.par;break;
			case 4:te.rotateY = packet.par;break;
			case 5:te.rotateZ = packet.par;break;

			case 6:te.scaleX = packet.par;break;
			case 7:te.scaleY = packet.par;break;
			case 8:te.scaleZ = packet.par;break;
			}
			/*
			te.translateX = packet.translateX;
			te.translateY = packet.translateY;
			te.translateZ = packet.translateZ;

			te.rotateX = packet.rotateX;
			te.rotateY = packet.rotateY;
			te.rotateZ = packet.rotateZ;

			te.scaleX = packet.scaleX;
			te.scaleY = packet.scaleY;
			te.scaleZ = packet.scaleZ;
			 */
		}

		private void act(MessageSyncModelView packet, EntityPlayerMP player) {
			TileEntityModelView te = (TileEntityModelView)player.worldObj.getTileEntity(packet.x, packet.y, packet.z);
			switch(packet.act) {
			case 0:te.translateX = packet.par;break;
			case 1:te.translateY = packet.par;break;
			case 2:te.translateZ = packet.par;break;

			case 3:te.rotateX = packet.par;break;
			case 4:te.rotateY = packet.par;break;
			case 5:te.rotateZ = packet.par;break;

			case 6:te.scaleX = packet.par;break;
			case 7:te.scaleY = packet.par;break;
			case 8:te.scaleZ = packet.par;break;
			}
			/*
			te.translateX = packet.translateX;
			te.translateY = packet.translateY;
			te.translateZ = packet.translateZ;

			te.rotateX = packet.rotateX;
			te.rotateY = packet.rotateY;
			te.rotateZ = packet.rotateZ;

			te.scaleX = packet.scaleX;
			te.scaleY = packet.scaleY;
			te.scaleZ = packet.scaleZ;
			 */
		}

	}

}
