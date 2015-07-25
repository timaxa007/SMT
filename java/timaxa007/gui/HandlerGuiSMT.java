package timaxa007.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import timaxa007.gui.HelperGui.GuiID;
import timaxa007.gui.gui.BookGui;
import timaxa007.gui.player.BackpackContainer;
import timaxa007.gui.player.BackpackGui;
import timaxa007.gui.player.BagContainer;
import timaxa007.gui.player.BagGui;
import timaxa007.gui.tile.StorageContainer;
import timaxa007.gui.tile.StorageGui;
import cpw.mods.fml.common.network.IGuiHandler;

public class HandlerGuiSMT implements IGuiHandler {
	//-------------------------------------------------------------------------------------------------
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tile = world.getTileEntity(x, y, z);
		switch(ID) {
		//---------------------------------------------------------------------------------------------
		//	For TileEntity
		//---------------------------------------------------------------------------------------------
		case GuiID.STORAGE:return new StorageContainer((IInventory)tile, player);
		//---------------------------------------------------------------------------------------------
		//	Uses Player
		//---------------------------------------------------------------------------------------------
		case GuiID.BAG:return new BagContainer(player);
		case GuiID.BACKPACK:return new BackpackContainer(player);
		//---------------------------------------------------------------------------------------------
		default:return null;
		}
	}
	//-------------------------------------------------------------------------------------------------
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		//---------------------------------------------------------------------------------------------
		//	For TileEntity
		//---------------------------------------------------------------------------------------------
		TileEntity tile = world.getTileEntity(x, y, z);
		switch(ID) {
		//---------------------------------------------------------------------------------------------
		//	For TileEntity
		//---------------------------------------------------------------------------------------------
		case GuiID.STORAGE:return new StorageGui((IInventory)tile, player);
		//---------------------------------------------------------------------------------------------
		//	Uses Player
		//---------------------------------------------------------------------------------------------
		case GuiID.BAG:return new BagGui(player);
		case GuiID.BACKPACK:return new BackpackGui(player);
		//---------------------------------------------------------------------------------------------
		//	Only GUI
		//---------------------------------------------------------------------------------------------
		case GuiID.INFO_BOOK:return new BookGui(player);
		//---------------------------------------------------------------------------------------------
		default:return null;
		}
	}
	//-------------------------------------------------------------------------------------------------
}
