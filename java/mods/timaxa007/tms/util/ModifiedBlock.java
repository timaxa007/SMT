package mods.timaxa007.tms.util;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class ModifiedBlock extends Block {

	private String tag;
	private float weight;

	public ModifiedBlock(String tag, Material Material) {
		super(Material);
		this.tag = tag;
		setBlockTextureName("timaxa007:" + tag);
		setBlockName(tag);
	}

	/**For block in constuctor not nbt.**/
	public Block setTag(String tag) {
		this.tag = tag;
		return this;
	}

	public String getTag() {
		return tag;
	}

	public Block setWeight(float weight) {
		this.weight = weight;
		return this;
	}

	public float getWeight() {
		return weight;
	}

}
