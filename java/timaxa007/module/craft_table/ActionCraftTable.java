package timaxa007.module.craft_table;

import static timaxa007.core.CoreSMT.log;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import timaxa007.gui.container.CraftTableContainer;
import timaxa007.gui.gui.CraftTableGui;
import timaxa007.gui.inventory.CraftTableInventory;
import timaxa007.module.craft_table.CraftTable.BlockCraftTable;
import timaxa007.module.craft_table.packet.MessageCraftTableClient;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ActionCraftTable {

	@SideOnly(Side.CLIENT)
	public static void client(int x, int y, int z) {
		Minecraft mc = Minecraft.getMinecraft();
		mc.currentScreen = new CraftTableGui(mc.thePlayer, new CraftTableInventory(x, y, z));
	}

	public static void common(EntityPlayerMP player, int x, int y, int z) {
		BlockCraftTable bct = null;
		CraftTable ct = CraftTable.get(player.worldObj);
		if (ct != null) {
			for (int i = 0; i < ct.getList().size(); ++i) {
				BlockCraftTable bct_p = ct.getList().get(i);
				if (bct_p != null && bct_p.x == x && bct_p.y == y && bct_p.z == z) {
					bct = bct_p;
					break;
				}
			}
		}

		if (bct != null) {
			System.out.println("ActionCraftTable common true;");
			player.openContainer = new CraftTableContainer(player, new CraftTableInventory(bct));
		} else log.error("Not open gui.");
	}

}
