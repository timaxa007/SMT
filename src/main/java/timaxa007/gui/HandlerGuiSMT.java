package timaxa007.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import timaxa007.core.CoreSMT;
import timaxa007.core.packet.MessageOpenContainer;
import timaxa007.core.packet.MessageOpenGui;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
/**
 * Попытка создать свой <b>HandlerGui</b>, но не для <b>TileEntity</b>.<br>
 * А к примеру для:<br>
 * <b>EntityPlayer</b> - для открытия: книг, рюкзаков и т.п.,<br>
 * Других <b>Entity</b> - для открытия: окон для торговли и т.п.,<br>
 * Или просто открытия <b>GUI</b> окна.<br>
 * @author timaxa007<br>
 **/
public class HandlerGuiSMT {
	//-----------------------------------------------------------------------------------------------
	//@SideOnly(Side.SERVER)
	public static Container getContainer(int ID, EntityPlayer player) {
		//-------------------------------------------------------------------------------------------
		//	Uses Player
		//-------------------------------------------------------------------------------------------
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {

		}
		//-------------------------------------------------------------------------------------------
		CoreSMT.log.error("HandlerGuiSMT - Container, id = " + ID + ".");
		return null;
	}
	//-----------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public static GuiScreen getGui(int ID, EntityPlayer player) {
		//-------------------------------------------------------------------------------------------
		//	Uses Player
		//-------------------------------------------------------------------------------------------
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {

		}
		//-------------------------------------------------------------------------------------------
		//	Only GUI
		//-------------------------------------------------------------------------------------------

		//-------------------------------------------------------------------------------------------
		CoreSMT.log.error("HandlerGuiSMT - Gui, id = " + ID + ".");
		return null;
	}
	//-----------------------------------------------------------------------------------------------
	public static enum GuiID {
		//-------------------------------------------------------------------------------------------
		//	Uses Player
		//-------------------------------------------------------------------------------------------

		//-------------------------------------------------------------------------------------------
		//	Only GUI
		//-------------------------------------------------------------------------------------------

		//-------------------------------------------------------------------------------------------
		;
	}
	//-----------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public static void openGui(GuiID gui_id, EntityPlayer player) {
		openGui(gui_id.ordinal(), player, false);
	}

	@SideOnly(Side.CLIENT)
	public static void openGui(int id, EntityPlayer player) {
		openGui(id, player, false);
	}

	@SideOnly(Side.CLIENT)
	public static void openGui(GuiID gui_id, EntityPlayer player, boolean flag) {
		openGui(gui_id.ordinal(), player, flag);
	}

	@SideOnly(Side.CLIENT)
	public static void openGui(int id, EntityPlayer player, boolean flag) {
		if (player == null) player = Minecraft.getMinecraft().thePlayer;
		openGui(HandlerGuiSMT.getGui(id, player));
		if (flag) CoreSMT.network.sendToServer(new MessageOpenContainer(id));
	}

	@SideOnly(Side.CLIENT)
	public static void openGui(GuiScreen gui) {
		if (gui != null) Minecraft.getMinecraft().displayGuiScreen(gui);
	}
	//-----------------------------------------------------------------------------------------------
	public static void openContainer(GuiID gui_id, EntityPlayer player) {
		openContainer(gui_id.ordinal(), player, false);
	}

	public static void openContainer(int id, EntityPlayer player) {
		openContainer(id, player, false);
	}

	public static void openContainer(GuiID gui_id, EntityPlayer player, boolean flag) {
		openContainer(gui_id.ordinal(), player, flag);
	}

	public static void openContainer(int id, EntityPlayer player, boolean flag) {
		Container container = getContainer(id, player);
		if (player != null && container != null) {
			player.openContainer = container;
			if (flag && player instanceof EntityPlayerMP) CoreSMT.network.sendTo(new MessageOpenGui(id), (EntityPlayerMP)player);
		}

	}

	public static void openContainer(Container container, EntityPlayer player) {
		if (player != null && container != null) player.openContainer = container;
	}
	//-----------------------------------------------------------------------------------------------
}
