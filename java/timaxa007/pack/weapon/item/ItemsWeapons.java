package timaxa007.pack.weapon.item;

import timaxa007.pack.weapon.PackWeapons;
import timaxa007.smt.object.ModifiedItem;

public class ItemsWeapons extends ModifiedItem {

	public ItemsWeapons(String tag) {
		super(tag);
		setCreativeTab(PackWeapons.tab_weapons);
		setTextureName("timaxa007:icon/weapon");
	}

}
