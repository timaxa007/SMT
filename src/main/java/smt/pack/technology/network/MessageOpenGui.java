package smt.pack.technology.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import smt.pack.technology.SMTTechnology;
import smt.pack.technology.registry.FurnaceMobile;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MessageOpenGui implements IMessage {

	public int id;

	public MessageOpenGui() {}

	public MessageOpenGui(int id) {
		this.id = id;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(id);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		id = buf.readInt();
	}

	public static class Handler implements IMessageHandler<MessageOpenGui, IMessage> {

		@Override
		public IMessage onMessage(MessageOpenGui packet, MessageContext message) {
			if (message.side.isClient())
				act(packet.id);
			else
				act(message.getServerHandler().playerEntity, packet.id);
			return null;
		}

		@SideOnly(Side.CLIENT)
		private void act(int id) {
			Minecraft mc = Minecraft.getMinecraft();
			switch(id) {
			case 0:{
				mc.displayGuiScreen(new smt.pack.technology.client.gui.CraftingGui(mc.thePlayer));break;
			}
			case 1:{
				FurnaceMobile fm = FurnaceMobile.get(mc.thePlayer);
				if (fm != null)
					mc.displayGuiScreen(new smt.pack.technology.client.gui.FurnaceGui(mc.thePlayer, fm));
				break;
			}
			}
		}

		private void act(EntityPlayerMP player, int id) {
			boolean submit = true;
			switch(id) {
			case 0:{
				//openContainer(player, new CraftingContainer(player), id);
				player.openContainer = new smt.pack.technology.inventory.CraftingContainer(player);
				break;
			}
			case 1:{
				FurnaceMobile fm = FurnaceMobile.get(player);
				if (fm != null)
					//openContainer(player, new FurnaceContainer(player, fm), id);
					player.openContainer = new smt.pack.technology.inventory.FurnaceContainer(player, fm);
				else submit = false;
				break;
			}
			}
			if (submit) SMTTechnology.network.sendTo(new MessageOpenGui(id), player);
		}
		/*This metod Glith - not working is normal
		private static void openContainer(EntityPlayerMP player, Container container, int id) {
			if (player.openContainer != player.inventoryContainer) player.closeScreen();
			player.getNextWindowId();
			SMTTechnology.network.sendTo(new MessageOpenGui(id), player);
			player.openContainer = container;
			player.openContainer.windowId = player.currentWindowId;
			player.openContainer.addCraftingToCrafters(player);
		}
		*/
	}

}
