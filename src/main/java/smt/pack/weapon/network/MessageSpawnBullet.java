package smt.pack.weapon.network;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import smt.pack.weapon.SMTWeapon;
import smt.pack.weapon.entity.EntityBullet;
import smt.pack.weapon.registry.Reg;

public class MessageSpawnBullet implements IMessage {

	public int thowerID, entityID;
	public String bullet;

	public MessageSpawnBullet() {}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(thowerID);
		buf.writeInt(entityID);
		ByteBufUtils.writeUTF8String(buf, bullet);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		thowerID = buf.readInt();
		entityID = buf.readInt();
		bullet = ByteBufUtils.readUTF8String(buf);
	}

	public static class Handler implements IMessageHandler<MessageSpawnBullet, IMessage> {

		@Override
		public IMessage onMessage(MessageSpawnBullet packet, MessageContext message) {
			if (message.side.isClient())
				act(packet);
			else
				act(message.getServerHandler().playerEntity, packet);
			return null;
		}

		@SideOnly(Side.CLIENT)
		private void act(MessageSpawnBullet packet) {
			Minecraft mc = Minecraft.getMinecraft();
			EntityBullet entity_bullet = new EntityBullet(mc.theWorld, (EntityLivingBase)mc.theWorld.getEntityByID(packet.thowerID), Reg.bullets.get(packet.bullet));
			mc.theWorld.spawnEntityInWorld(entity_bullet);
			entity_bullet.setEntityId(packet.entityID);
		}

		private void act(EntityPlayerMP player, MessageSpawnBullet packet) {
			if (player.worldObj.getEntityByID(packet.entityID) != null) {
				MessageSpawnBullet message = new MessageSpawnBullet();
				message.thowerID = packet.thowerID;
				message.entityID = packet.entityID;
				message.bullet = packet.bullet;
				SMTWeapon.network.sendTo(message, player);
			} else {
				EntityBullet entity_bullet = new EntityBullet(player.worldObj, (EntityLivingBase)player.worldObj.getEntityByID(packet.thowerID), Reg.bullets.get(packet.bullet));
				player.worldObj.spawnEntityInWorld(entity_bullet);
				//entity_bullet.setEntityId(packet.entityID);
			}
		}

	}

}
