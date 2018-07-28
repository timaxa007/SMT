package smt.pack.weapon.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import smt.pack.weapon.SMTWeapon;

public final class Items {

	public static Item
	itemsWeapon,
	weapon,
	throwable,
	grenade
	;

	public static final void init() {

		itemsWeapon = new ItemItemsWeapon().setUnlocalizedName("items_weapon").setCreativeTab(SMTWeapon.tabWeapon);
		GameRegistry.registerItem(itemsWeapon, "item_items_weapon");

		weapon = new ItemWeapon().setUnlocalizedName("weapon").setCreativeTab(SMTWeapon.tabWeapon).setHasSubtypes(true).setMaxDamage(0);
		GameRegistry.registerItem(weapon, "item_weapon");

		throwable = new ItemThrowable().setUnlocalizedName("throwable").setCreativeTab(SMTWeapon.tabWeapon);
		GameRegistry.registerItem(throwable, "item_throwable");

		grenade = new ItemGrenade().setUnlocalizedName("grenade").setCreativeTab(SMTWeapon.tabWeapon);
		GameRegistry.registerItem(grenade, "item_grenade");

	}

}
