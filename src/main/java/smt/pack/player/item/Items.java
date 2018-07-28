package smt.pack.player.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import smt.pack.player.SMTPlayer;

public final class Items {

	public static Item
	itemsPlayer
	;

	public static final void init() {

		itemsPlayer = new ItemItemsPlayer().setUnlocalizedName("items_player").setCreativeTab(SMTPlayer.tabPlayer);
		GameRegistry.registerItem(itemsPlayer, "item_items_player");

	}

}
