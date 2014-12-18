package mods.timaxa007.pack.weapon;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class TabWeapons extends CreativeTabs {

	public TabWeapons(String name) {
		super(name);
	}

	@Override
	public Item getTabIconItem() {
		return Items.stone_sword;
	}

}
