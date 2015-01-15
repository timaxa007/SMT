package mods.timaxa007.tms.util;

import net.minecraft.item.Item;

public class ItemFixReg extends Item {

	private String tag;

	public ItemFixReg(String tag) {
		super();
		this.tag = tag;
		setUnlocalizedName(tag);
	}

	public Item setTag(String tag) {
		this.tag = tag;
		return this;
	}

	public String getTag() {
		return tag;
	}

}
