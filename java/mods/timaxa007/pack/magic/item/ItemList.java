package mods.timaxa007.pack.magic.item;

import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemList {

	public static Item items_for_magic;
	public static BowMagic magic_bow;
	public static Item wands;
	public static Item stuffs;
	public static Item arrow_mini;
	public static Item teleport;
	public static Item globular;

	public static void preInit() {

		items_for_magic = new ItemsMagic();
		magic_bow = new BowMagic();
		wands = new ItemWands();
		stuffs = new ItemStuffs();
		arrow_mini = new ItemArrowMini();
		teleport = new ItemTeleport();
		globular = new ItemGlobular();

		GameRegistry.registerItem(items_for_magic, "ItemsMagic");
		GameRegistry.registerItem(magic_bow, "BowMagic");
		GameRegistry.registerItem(wands, "ItemWands");
		GameRegistry.registerItem(stuffs, "ItemStuffs");
		GameRegistry.registerItem(arrow_mini, "ItemArrowMini");
		GameRegistry.registerItem(teleport, "ItemTeleport");
		GameRegistry.registerItem(globular, "ItemGlobular");

	}

}
