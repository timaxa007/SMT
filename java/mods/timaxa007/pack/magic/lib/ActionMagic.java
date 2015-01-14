package mods.timaxa007.pack.magic.lib;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ActionMagic {

	public static void actionVoid(World world, EntityPlayer player) {

	}

	public static void actionTackEntityItem(EntityItem entity, EntityPlayer player) {
		ItemStack drop_item = entity.getEntityItem();
		for (int i = 0; i < player.inventory.mainInventory.length; i++) {
			if (player.inventory.mainInventory[i] == null || player.inventory.mainInventory[i] == drop_item) {
				player.inventory.addItemStackToInventory(drop_item);
				entity.setDead();
				break;
			}
		}
	}

}
