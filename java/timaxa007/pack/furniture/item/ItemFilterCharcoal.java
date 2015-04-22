package timaxa007.pack.furniture.item;

import java.util.List;

import timaxa007.tms.object.ModifiedItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemFilterCharcoal extends ModifiedItem {

	public ItemFilterCharcoal(String tag) {
		super(tag);
		setMaxStackSize(1);
		setMaxDamage(8);
		//setCreativeTab(PackFurniture.tab_furniture);
		//setTextureName(PackInfo.MODID + ":filter_charcoal");
		setTextureName("timaxa007:filter_charcoal");
	}

	public void getSubItems(Item id, CreativeTabs table, List list) {
		list.add(new ItemStack(id, 1, 0));
	}

}
