package mods.timaxa007.tms.util;

import mods.timaxa007.module.weight.api.IWeight;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModifiedItem extends Item implements IWeight {

	private String tag;

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

	@Override
	public float getWeight(ItemStack is) {
		return 0.0F;
	}

}
