package mods.timaxa007.pack.weapon.item;

import mods.timaxa007.pack.weapon.PackWeapons;
import mods.timaxa007.tms.util.ModifiedItem;

public class ItemsWeapons extends ModifiedItem {

	public ItemsWeapons(String tag) {
		super(tag);
		setCreativeTab(PackWeapons.tab_weapons);
		setTextureName("timaxa007:icon/weapon");
	}

}
