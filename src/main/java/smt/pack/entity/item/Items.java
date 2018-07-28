package smt.pack.entity.item;

import smt.pack.entity.SMTEntity;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public final class Items {

	public static Item
	itemsEntity
	;

	public static final void init() {

		itemsEntity = new ItemItemsEntity().setUnlocalizedName("items_entity").setMaxDamage(10).setMaxStackSize(1).setCreativeTab(SMTEntity.tabEntity);
		GameRegistry.registerItem(itemsEntity, "item_items_entity");

	}

}
