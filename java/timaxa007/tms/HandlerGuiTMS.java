package timaxa007.tms;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import timaxa007.pack.furniture.PackFurniture;
import timaxa007.pack.furniture.gui.StorageContainer;
import timaxa007.pack.furniture.gui.StorageGui;
import cpw.mods.fml.common.network.IGuiHandler;

public class HandlerGuiTMS implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tile = world.getTileEntity(x, y, z);
		if (tile != null && tile instanceof IInventory) {
			if (ID == PackFurniture.gui_storage) return new StorageContainer((IInventory)tile, player);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tile = world.getTileEntity(x, y, z);
		if (tile != null && tile instanceof IInventory) {
			if (ID == PackFurniture.gui_storage) return new StorageGui((IInventory)tile, player);
		}
		return null;
	}

}
