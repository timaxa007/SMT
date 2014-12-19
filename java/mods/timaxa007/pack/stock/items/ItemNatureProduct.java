package mods.timaxa007.pack.stock.items;

import mods.timaxa007.pack.stock.PackStock;
import net.minecraft.item.Item;

public class ItemNatureProduct extends Item {

	public ItemNatureProduct() {
		super();
		setHasSubtypes(true);
		setMaxDamage(0);
		setCreativeTab(PackStock.tab_food);
		setUnlocalizedName("NatureProduct");
	}

}
