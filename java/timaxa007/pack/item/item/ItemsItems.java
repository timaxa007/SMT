package timaxa007.pack.item.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import timaxa007.pack.item.PackItems;
import timaxa007.tms.object.ModifiedItem;

public class ItemsItems extends ModifiedItem {

	public ItemsItems(String tag) {
		super(tag);
		setCreativeTab(PackItems.tab_items);
		setTextureName("timaxa007:icon/item");
	}

	public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {
		ItemStack head = player.getCurrentArmor(3);
		Item helment[] = {Items.diamond_helmet, Items.iron_helmet, Items.golden_helmet, Items.leather_helmet, Items.chainmail_helmet};

		for (int i = 0; i < 5; i++) {
			if (player.getCurrentArmor(3) != null && player.getCurrentArmor(3).getItem() == helment[i]) {
				System.out.println("+");
				player.inventory.clearInventory(helment[i], -1);
				player.setCurrentItemOrArmor(4, new ItemStack(helment[i], 1));
			}
		}

		/*if (head == null) {
			player.setCurrentItemOrArmor(4, new ItemStack(helment[0]));
			--is.stackSize;
		}*/

		return super.onItemRightClick(is, world, player);
	}
}
