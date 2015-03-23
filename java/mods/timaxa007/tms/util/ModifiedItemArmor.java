package mods.timaxa007.tms.util;

import mods.timaxa007.module.weight.api.IWeight;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ModifiedItemArmor extends ItemArmor implements IWeight {

	private String tag;

	public ModifiedItemArmor(String tag, ItemArmor.ArmorMaterial material, int render_id, int armor_type) {
		super(material, render_id, armor_type);
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

	@Override
	public float getWeight(ItemStack is) {
		return 0.0F;
	}

}
