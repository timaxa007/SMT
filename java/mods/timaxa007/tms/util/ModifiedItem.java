package mods.timaxa007.tms.util;

import net.minecraft.item.Item;

public class ModifiedItem extends Item {

	private String tag;
	private float weight;

	public ModifiedItem(String tag) {
		super();
		this.tag = tag;
		setTextureName("timaxa007:" + tag);
		setUnlocalizedName(tag);
	}

	/**For item in constuctor not nbt.**/
	public Item setTag(String tag) {
		this.tag = tag;
		return this;
	}

	public String getTag() {
		return tag;
	}

	public Item setWeight(float weight) {
		this.weight = weight;
		return this;
	}

	public float getWeight() {
		return weight;
	}

}
