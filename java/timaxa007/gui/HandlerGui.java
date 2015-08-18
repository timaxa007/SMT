package timaxa007.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import timaxa007.smt.CoreSMT;
import cpw.mods.fml.common.network.IGuiHandler;

public class HandlerGui implements IGuiHandler {
	//-------------------------------------------------------------------------------------------------
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tile = world.getTileEntity(x, y, z);
		//---------------------------------------------------------------------------------------------
		//	For TileEntity it is IInventory
		//---------------------------------------------------------------------------------------------
		if (tile != null && tile instanceof IInventory) {
			IInventory inv = (IInventory)tile;
			//-----------------------------------------------------------------------------------------
			//if (ID == GuiID.STORAGE.ordinal()) return new StorageContainer((IInventory)tile, player);
			//-----------------------------------------------------------------------------------------
		}
		//---------------------------------------------------------------------------------------------
		//	Uses Player
		//---------------------------------------------------------------------------------------------
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			//if (ID == GuiID.ITEM_STORAGE.ordinal()) return new ItemStorageContainer(player, new InventoryItemStorage(current));
		}
		CoreSMT.log.error("HandlerGui - Container, id = " + ID + ".");
		return null;
	}
	//-------------------------------------------------------------------------------------------------
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		//---------------------------------------------------------------------------------------------
		TileEntity tile = world.getTileEntity(x, y, z);
		//---------------------------------------------------------------------------------------------
		//	For TileEntity it is IInventory
		//---------------------------------------------------------------------------------------------
		if (tile != null && tile instanceof IInventory) {
			IInventory inv = (IInventory)tile;//ISidedInventory
			//-----------------------------------------------------------------------------------------
			//if (ID == GuiID.STORAGE.ordinal()) return new StorageGui(inv, player);
			//-----------------------------------------------------------------------------------------
		}
		//---------------------------------------------------------------------------------------------
		//	Uses Player
		//---------------------------------------------------------------------------------------------
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			//if (ID == GuiID.ITEM_STORAGE.ordinal()) return new ItemStorageGui(player, new InventoryItemStorage(current));
		}
		CoreSMT.log.error("HandlerGui - Gui, id = " + ID + ".");
		return null;
	}
	//-------------------------------------------------------------------------------------------------
	public static enum GuiID {
		//---------------------------------------------------------------------------------------------
		//	For TileEntity it is IInventory
		//---------------------------------------------------------------------------------------------
		FURNITURE_MACHINES,
		FURNITURE_CHEST,
		BOOKSHELF,
		MINCER,
		GRILLS,
		MASHINE_WATER,
		//STORAGE,
		MAGIC_MACHINES,
		ELECTRIC_MACHINES,
		//---------------------------------------------------------------------------------------------
		//	Uses Player
		//---------------------------------------------------------------------------------------------
		//ITEM_STORAGE,
		MODIFY_WEAPON,
		PLAYER_INVENTORY_STYLE1,
		//---------------------------------------------------------------------------------------------
		//	Only GUI
		//---------------------------------------------------------------------------------------------
		INFO_BOOK
		//---------------------------------------------------------------------------------------------
		;
	}
	//-------------------------------------------------------------------------------------------------
	public static void openGui(GuiID gui_id, EntityPlayer player) {
		openGui(gui_id.ordinal(), player);
	}

	public static void openGui(int id, EntityPlayer player) {
		player.openGui(CoreSMT.instance, id, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
	}

	public static void openGui(int id, EntityPlayer player, int x, int y, int z) {
		openGui(id, player, player.worldObj, x, y, z);
	}

	public static void openGui(int id, EntityPlayer player, World world, int x, int y, int z) {
		player.openGui(CoreSMT.instance, id, world, x, y, z);
	}
	//-------------------------------------------------------------------------------------------------
}
