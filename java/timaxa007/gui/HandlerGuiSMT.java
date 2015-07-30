package timaxa007.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import timaxa007.gui.HelperGui.GuiID;
import timaxa007.gui.client.*;
import timaxa007.gui.client.tile.*;
import timaxa007.gui.server.*;
import timaxa007.gui.server.tile.*;
import timaxa007.smt.CoreSMT;
import cpw.mods.fml.common.network.IGuiHandler;

public class HandlerGuiSMT implements IGuiHandler {
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
		if (ID == GuiID.BAG.ordinal()) return new BagContainer(player);
		if (ID == GuiID.BACKPACK.ordinal()) return new BackpackContainer(player);
		//---------------------------------------------------------------------------------------------
		CoreSMT.log.error("HandlerGuiSMT - Container, id = " + ID + ".");
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
			IInventory inv = (IInventory)tile;
			//-----------------------------------------------------------------------------------------
			//if (ID == GuiID.STORAGE.ordinal()) return new StorageGui(inv, player);
			//-----------------------------------------------------------------------------------------
		}
		//---------------------------------------------------------------------------------------------
		//	Uses Player
		//---------------------------------------------------------------------------------------------
		if (ID == GuiID.BAG.ordinal()) return new BagGui(player);
		if (ID == GuiID.BACKPACK.ordinal()) return new BackpackGui(player);
		//---------------------------------------------------------------------------------------------
		//	Only GUI
		//---------------------------------------------------------------------------------------------
		if (ID == GuiID.INFO_BOOK.ordinal()) return new BookGui(player);
		//---------------------------------------------------------------------------------------------
		CoreSMT.log.error("HandlerGuiSMT - Gui, id = " + ID + ".");
		return null;
	}
	//-------------------------------------------------------------------------------------------------
}
