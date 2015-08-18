package timaxa007.gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import timaxa007.gui.container.ItemStorageContainer;
import timaxa007.gui.gui.BookGui;
import timaxa007.gui.gui.ItemStorageGui;
import timaxa007.gui.iinventory.InventoryItemStorage;
import timaxa007.module.player_inventory.gui.ContainerPlayerInventory;
import timaxa007.module.player_inventory.gui.GuiPlayerInventory;
import timaxa007.pack.conjoint.PackConjoint;
import timaxa007.pack.conjoint.packet.MessageOpenContainer;
import timaxa007.pack.conjoint.packet.MessageOpenGui;
import timaxa007.smt.CoreSMT;
import timaxa007.smt.util.UtilSMT;
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
	//-------------------------------------------------------------------------------------------------
	//@SideOnly(Side.SERVER)
	public static Container getContainer(int ID, EntityPlayer player) {
		//---------------------------------------------------------------------------------------------
		//	Uses Player
		//---------------------------------------------------------------------------------------------
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (ID == GuiID.ITEM_STORAGE.ordinal()) return new ItemStorageContainer(player, new InventoryItemStorage(current));
			if (ID == GuiID.PLAYER_INVENTORY_STYLE1.ordinal()) return new ContainerPlayerInventory(player);
			//if (ID == GuiID.INFO_BOOK_CREATIVE.ordinal()) return new BookCreativeContainer(player);
		}
		//---------------------------------------------------------------------------------------------
		CoreSMT.log.error("HandlerGuiSMT - Container, id = " + ID + ".");
		return null;
	}
	//-------------------------------------------------------------------------------------------------
	@SideOnly(Side.CLIENT)
	public static GuiScreen getGui(int ID, EntityPlayer player) {
		//---------------------------------------------------------------------------------------------
		//	Uses Player
		//---------------------------------------------------------------------------------------------
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (ID == GuiID.ITEM_STORAGE.ordinal()) return new ItemStorageGui(player, new InventoryItemStorage(current));
			if (ID == GuiID.PLAYER_INVENTORY_STYLE1.ordinal()) return new GuiPlayerInventory(player);
			//if (ID == GuiID.INFO_BOOK_CREATIVE.ordinal()) return new BookCreativeGui(player);
		}
		//---------------------------------------------------------------------------------------------
		//	Only GUI
		//---------------------------------------------------------------------------------------------
		if (ID == GuiID.INFO_BOOK.ordinal()) return new BookGui(player);
		//---------------------------------------------------------------------------------------------
		CoreSMT.log.error("HandlerGuiSMT - Gui, id = " + ID + ".");
		return null;
	}
	//-------------------------------------------------------------------------------------------------
	public static enum GuiID {
		//---------------------------------------------------------------------------------------------
		//	Uses Player
		//---------------------------------------------------------------------------------------------
		ITEM_STORAGE,
		PLAYER_INVENTORY_STYLE1,
		//---------------------------------------------------------------------------------------------
		//	Only GUI
		//---------------------------------------------------------------------------------------------
		INFO_BOOK,
		//INFO_BOOK_CREATIVE
		//---------------------------------------------------------------------------------------------
		;
	}
	//-------------------------------------------------------------------------------------------------
	@Deprecated
	@SideOnly(Side.CLIENT)
	public static void openGui(GuiID gui_id, EntityPlayer player) {
		openGui(gui_id.ordinal(), player, false);
	}

	@Deprecated
	@SideOnly(Side.CLIENT)
	public static void openGui(int id, EntityPlayer player) {
		openGui(id, player, false);
	}

	@Deprecated
	@SideOnly(Side.CLIENT)
	public static void openGui(GuiID gui_id, EntityPlayer player, boolean flag) {
		openGui(gui_id.ordinal(), player, flag);
	}

	@SideOnly(Side.CLIENT)
	public static void openGui(int id, EntityPlayer player, boolean flag) {
		if (player == null) player = UtilSMT.getPlayerClient();
		openGui(HandlerGuiSMT.getGui(id, player));
		if (flag) PackConjoint.network.sendToServer(new MessageOpenContainer(id));
	}

	@SideOnly(Side.CLIENT)
	public static void openGui(GuiScreen gui) {
		if (gui != null) UtilSMT.getClient().displayGuiScreen(gui);
	}
	//-------------------------------------------------------------
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
			if (flag && player instanceof EntityPlayerMP) PackConjoint.network.sendTo(new MessageOpenGui(id), (EntityPlayerMP)player);
		}

	}

	public static void openContainer(Container container, EntityPlayer player) {
		if (player != null && container != null) player.openContainer = container;
	}
	//-------------------------------------------------------------------------------------------------
}
