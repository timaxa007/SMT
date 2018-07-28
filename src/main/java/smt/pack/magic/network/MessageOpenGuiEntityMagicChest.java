package smt.pack.magic.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import smt.pack.magic.SMTMagic;
import smt.pack.magic.client.gui.EntityMagicChestGui;
import smt.pack.magic.entity.EntityMagicChest;
import smt.pack.magic.inventory.EntityMagicChestContainer;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MessageOpenGuiEntityMagicChest implements IMessage {

	public int entityID;

	public MessageOpenGuiEntityMagicChest() {}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(entityID);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		entityID = buf.readInt();
	}

	public static class Handler implements IMessageHandler<MessageOpenGuiEntityMagicChest, IMessage> {

		@Override
		public IMessage onMessage(MessageOpenGuiEntityMagicChest packet, MessageContext message) {
			if (message.side.isClient())
				act(packet);
			else
				act(message.getServerHandler().playerEntity, packet);
			return null;
		}

		@SideOnly(Side.CLIENT)
		private void act(MessageOpenGuiEntityMagicChest packet) {
			Minecraft mc = Minecraft.getMinecraft();
			Entity entity = mc.theWorld.getEntityByID(packet.entityID);
			if (entity instanceof EntityMagicChest)
				mc.displayGuiScreen(new EntityMagicChestGui((EntityMagicChest)entity, mc.thePlayer));
		}

		private void act(EntityPlayerMP player, MessageOpenGuiEntityMagicChest packet) {
			Entity entity = player.worldObj.getEntityByID(packet.entityID);
			if (entity instanceof EntityMagicChest)
				player.openContainer = new EntityMagicChestContainer((EntityMagicChest)entity, player);
			MessageOpenGuiEntityMagicChest packetClient = new MessageOpenGuiEntityMagicChest();
			packetClient.entityID = packet.entityID;
			SMTMagic.network.sendTo(packetClient, player);
		}

	}

}
