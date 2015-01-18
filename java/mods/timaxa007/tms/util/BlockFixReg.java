package mods.timaxa007.tms.util;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockFixReg extends Block {

	private String tag;

	public BlockFixReg(String tag, Material Material) {
		super(Material);
		this.tag = tag;
		setBlockTextureName("timaxa007:" + tag);
		setBlockName(tag);
	}

	public Block setTag(String tag) {
		this.tag = tag;
		return this;
	}

	public String getTag() {
		return tag;
	}

}
