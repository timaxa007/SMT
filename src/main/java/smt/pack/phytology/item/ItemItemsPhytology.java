package smt.pack.phytology.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import smt.pack.phytology.SMTPhytology;

public class ItemItemsPhytology extends Item {

	/*
	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		System.out.println("Side = " + side);
		return true;
	}
	 */
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		Item findItem = Items.stick;
		int i = 0;
		for (ItemStack item : player.inventory.mainInventory) {
			if (item != null && item.getItem() == findItem)
				i += item.stackSize;
			if (i >= 10) break;
		}
		if (i >= 10) {
			for (int j = 0; j < 10; ++i)
				player.inventory.consumeInventoryItem(findItem);

			if (!player.capabilities.isCreativeMode) --itemStack.stackSize;
		}
		return super.onItemRightClick(itemStack, world, player);
	}

}
