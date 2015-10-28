package timaxa007.gui;

import static timaxa007.core.CoreSMT.log;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import timaxa007.gui.container.CraftTableContainer;
import timaxa007.gui.container.ItemStorageContainer;
import timaxa007.gui.gui.CraftTableGui;
import timaxa007.gui.gui.ItemStorageGui;
import timaxa007.gui.inventory.CraftTableInventory;
import timaxa007.gui.inventory.ItemStorageInventory;
import timaxa007.module.craft_table.CraftTable;
import cpw.mods.fml.common.network.IGuiHandler;

public class HandlerGui implements IGuiHandler {
	//-----------------------------------------------------------------------------------------------
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (CraftTable.get(world) != null) {
			CraftTable.BlockCraftTable bct = CraftTable.get(world).getCraftTable(x, y, z);
			if (ID == guiID.CRAFT_TABLE.ordinal() && bct != null) return new CraftTableContainer(player, new CraftTableInventory(world, x, y, z));
		}
		//-------------------------------------------------------------------------------------------
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (ID == guiID.STORAGE.ordinal()) return new ItemStorageContainer(player, new ItemStorageInventory(current));
		}
		//-------------------------------------------------------------------------------------------
		log.error("HandlerGui - Container, id = " + ID + ".");
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (CraftTable.get(world) != null) {
			CraftTable.BlockCraftTable bct = CraftTable.getCraftTableClient();
			if (ID == guiID.CRAFT_TABLE.ordinal() && bct != null) return new CraftTableGui(player, new CraftTableInventory(x, y, z));
		}
		//-------------------------------------------------------------------------------------------
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (ID == guiID.STORAGE.ordinal()) return new ItemStorageGui(player, new ItemStorageInventory(current));
		}
		//-------------------------------------------------------------------------------------------
		log.error("HandlerGui - Gui, id = " + ID + ".");
		return null;
	}
	//-----------------------------------------------------------------------------------------------
	public static enum guiID {
		STORAGE,
		CRAFT_TABLE;
	}
	//-----------------------------------------------------------------------------------------------
}
