package timaxa007.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import timaxa007.gui.HelperGui.GuiID;
import timaxa007.smt.CoreSMT;

public class HelperGui {

	public static enum GuiID {

		FURNITURE_MACHINES,
		FURNITURE_CHEST,
		BOOKSHELF,
		MINCER,
		GRILLS,
		MASHINE_WATER,
		//STORAGE,
		BACKPACK,
		BAG,

		MAGIC_MACHINES,

		ELECTRIC_MACHINES,

		MODIFY_WEAPON,

		INFO_BOOK
		;

	}

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

}
