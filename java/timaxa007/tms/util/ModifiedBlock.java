package timaxa007.tms.util;

import timaxa007.module.weight.api.IWeight;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModifiedBlock extends Block implements IWeight {

	private String tag;

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

	@Override
	public float getWeight(ItemStack is) {
		return 0.0F;
	}

}
