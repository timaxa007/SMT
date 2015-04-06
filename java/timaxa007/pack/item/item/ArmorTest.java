package timaxa007.pack.item.item;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import timaxa007.pack.item.PackItems;
import timaxa007.tms.util.ModifiedItem;

public class ArmorTest extends ModifiedItem {

	public int armor_type;

	public ArmorTest(String tag, int armor_type) {
		super(tag);
		setCreativeTab(PackItems.tab_items);
		setMaxStackSize(1);
		setMaxDamage(1024);
		this.armor_type = armor_type;
	}

	public boolean isValidArmor(ItemStack stack, int armorType, Entity entity) {
		if (armor_type == armorType) {
			return true;
		}
		return false;
	}

}
