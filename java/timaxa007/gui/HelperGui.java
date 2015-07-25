package timaxa007.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import timaxa007.smt.CoreSMT;

public class HelperGui {

	public static class GuiID {

		//public static int guiID = 0;


		public static final int FURNITURE_MACHINES = 1;
		public static final int FURNITURE_CHEST = 2;
		public static final int BOOKSHELF = 3;
		public static final int MINCER = 4;
		public static final int GRILLS = 5;
		public static final int MASHINE_WATER = 6;
		public static final int STORAGE = 7;
		public static final int BACKPACK = 30;
		public static final int BAG = 31;

		public static final int MAGIC_MACHINES = 32;

		public static final int ELECTRIC_MACHINES = 48;

		public static final int MODIFY_WEAPON = 56;

		public static final int INFO_BOOK = 128;

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
