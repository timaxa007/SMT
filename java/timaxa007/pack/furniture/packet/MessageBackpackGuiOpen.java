package timaxa007.pack.furniture.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import timaxa007.pack.CorePack;
import timaxa007.pack.furniture.PackFurniture;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageBackpackGuiOpen implements IMessage {

	public int id_gui;

	public MessageBackpackGuiOpen() {}

	public MessageBackpackGuiOpen(int id_gui) {
		this.id_gui = id_gui;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(id_gui);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		id_gui = buf.readInt();
	}
	//----------------------------------------------------------------------------------
	public static class Handler implements IMessageHandler<MessageBackpackGuiOpen, IMessage> {

		@Override
		public IMessage onMessage(MessageBackpackGuiOpen packet, MessageContext context) {
			int id_gui = packet.id_gui;
			int id_gui_open = 0;
			EntityPlayerMP player = context.getServerHandler().playerEntity;
			
			switch(id_gui) {
			default:id_gui_open = PackFurniture.gui_backpack;
			case 1:id_gui_open = PackFurniture.gui_backpack_1;
			case 2:id_gui_open = PackFurniture.gui_backpack_2;
			case 3:id_gui_open = PackFurniture.gui_backpack_3;
			case 4:id_gui_open = PackFurniture.gui_backpack_4;
			case 5:id_gui_open = PackFurniture.gui_backpack_5;
			case 6:id_gui_open = PackFurniture.gui_backpack_6;
			case 7:id_gui_open = PackFurniture.gui_backpack_7;
			case 8:id_gui_open = PackFurniture.gui_backpack_8;
			case 9:id_gui_open = PackFurniture.gui_backpack_9;
			case 10:id_gui_open = PackFurniture.gui_backpack_10;
			case 11:id_gui_open = PackFurniture.gui_backpack_11;
			case 12:id_gui_open = PackFurniture.gui_backpack_12;
			case 13:id_gui_open = PackFurniture.gui_backpack_13;
			case 14:id_gui_open = PackFurniture.gui_backpack_14;
			case 15:id_gui_open = PackFurniture.gui_backpack_15;
			case 16:id_gui_open = PackFurniture.gui_backpack_16;
			}

			FMLNetworkHandler.openGui(player, CorePack.instance, id_gui_open, 
					player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);

			return null;
		}

	}
	//----------------------------------------------------------------------------------
}
