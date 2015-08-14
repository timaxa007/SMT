package timaxa007.pack.weapon.item;

import timaxa007.pack.weapon.PackWeapon;
import timaxa007.pack.conjoint.object.ModifiedItem;

public class ItemsWeapons extends ModifiedItem {

	public ItemsWeapons(String tag) {
		super(tag);
		setCreativeTab(PackWeapon.tab_weapons);
		setTextureName("timaxa007:icon/weapon");
	}

}
