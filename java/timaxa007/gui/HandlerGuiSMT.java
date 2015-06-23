package timaxa007.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class HandlerGuiSMT implements IGuiHandler {
	//-------------------------------------------------
	//public static int guiID = 0;

	public static final int INFO_BOOK = 1;

	public static final int furniture_machines = 1;
	public static final int furniture_chest = 15;
	public static final int bookshelf = 16;
	public static final int mincer = 17;
	public static final int grills = 18;
	public static final int mashine_water = 19;
	public static final int storage = 21;
	public static final int backpack = 32;
	public static final int bag = 33;

	public static final int magic_machines = 1;

	public static final int electric_machines = 1;

	public static final int modify_weapon = 19;
	//-------------------------------------------------
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tile = world.getTileEntity(x, y, z);
		if (tile != null && tile instanceof IInventory) {
			if (ID == storage) return new StorageContainer((IInventory)tile, player);
		}
		if (ID == bag) return new BagContainer(player);
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tile = world.getTileEntity(x, y, z);
		if (tile != null && tile instanceof IInventory) {
			if (ID == storage) return new StorageGui((IInventory)tile, player);
		}
		if (ID == INFO_BOOK) return new BookGui(player);
		if (ID == bag) return new BagGui(player);
		return null;
	}

}
