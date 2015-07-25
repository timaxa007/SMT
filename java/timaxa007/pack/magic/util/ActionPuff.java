package timaxa007.pack.magic.util;

import net.minecraft.block.Block;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.item.ItemStack;
import timaxa007.smt.util.UtilSMT;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ActionPuff {

	@SideOnly(Side.CLIENT)
	public static void puff1(double cord_x, double cord_y, double cord_z) {
		EntityClientPlayerMP player = UtilSMT.getPlayerClient();
		WorldClient world = UtilSMT.getWorldClient();
		ItemStack current = player.getCurrentEquippedItem();

		world.spawnParticle("portal", cord_x + 0.15D, cord_y + 0.5D, cord_z + 0.15D, 0.0D, 0.0D, 0.0D);
		world.spawnParticle("portal", cord_x + 0.15D, cord_y + 0.5D, cord_z - 0.15D, 0.0D, 0.0D, 0.0D);
		world.spawnParticle("portal", cord_x - 0.15D, cord_y + 0.5D, cord_z - 0.15D, 0.0D, 0.0D, 0.0D);
		world.spawnParticle("portal", cord_x - 0.15D, cord_y + 0.5D, cord_z + 0.15D, 0.0D, 0.0D, 0.0D);

		world.spawnParticle("largesmoke", cord_x, cord_y + 0.35D, cord_z, 0.0D, 0.0D, 0.0D);

		world.playSound(cord_x, cord_y, cord_z, "portal.portal", 0.5F, 1.2F, false);

	}

	@SideOnly(Side.CLIENT)
	public static void craft1(double cord_x, double cord_y, double cord_z) {
		EntityClientPlayerMP player = UtilSMT.getPlayerClient();
		WorldClient world = UtilSMT.getWorldClient();
		ItemStack current = player.getCurrentEquippedItem();

		Block block = world.getBlock((int)cord_x, (int)cord_y - 1, (int)cord_z);

		world.spawnParticle("blockcrack_" + Block.getIdFromBlock(block) + "_0", cord_x + 0.15D, cord_y + 0.5D, cord_z + 0.15D, 0.0D, 0.0D, 0.0D);
		world.spawnParticle("blockcrack_" + Block.getIdFromBlock(block) + "_0", cord_x + 0.15D, cord_y + 0.5D, cord_z - 0.15D, 0.0D, 0.0D, 0.0D);
		world.spawnParticle("blockcrack_" + Block.getIdFromBlock(block) + "_0", cord_x - 0.15D, cord_y + 0.5D, cord_z - 0.15D, 0.0D, 0.0D, 0.0D);
		world.spawnParticle("blockcrack_" + Block.getIdFromBlock(block) + "_0", cord_x - 0.15D, cord_y + 0.5D, cord_z + 0.15D, 0.0D, 0.0D, 0.0D);

		world.spawnParticle("snowballpoof", cord_x, cord_y + 0.35D, cord_z, 0.0D, 0.0D, 0.0D);

		world.playSound(cord_x, cord_y, cord_z, "tile.piston.out", 0.5F, 1.2F, false);

	}

	@SideOnly(Side.CLIENT)
	public static void fried1(double cord_x, double cord_y, double cord_z) {
		EntityClientPlayerMP player = UtilSMT.getPlayerClient();
		WorldClient world = UtilSMT.getWorldClient();
		ItemStack current = player.getCurrentEquippedItem();

		world.spawnParticle("flame", cord_x + 0.15D, cord_y + 0.0D, cord_z + 0.15D, 0.0D, 0.0D, 0.0D);
		world.spawnParticle("flame", cord_x + 0.15D, cord_y + 0.0D, cord_z - 0.15D, 0.0D, 0.0D, 0.0D);
		world.spawnParticle("flame", cord_x - 0.15D, cord_y + 0.0D, cord_z - 0.15D, 0.0D, 0.0D, 0.0D);
		world.spawnParticle("flame", cord_x - 0.15D, cord_y + 0.0D, cord_z + 0.15D, 0.0D, 0.0D, 0.0D);

		world.spawnParticle("largesmoke", cord_x, cord_y + 0.35D, cord_z, 0.0D, 0.0D, 0.0D);

		world.playSound(cord_x, cord_y, cord_z, "fire.fire", 0.5F, 1.2F, false);

	}

}
