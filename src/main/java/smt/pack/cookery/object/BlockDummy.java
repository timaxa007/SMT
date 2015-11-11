package smt.pack.cookery.object;

import smt.pack.cookery.SMTCookery;

public abstract class BlockDummy extends net.minecraft.block.Block {

	private String tag;

	public BlockDummy(String tag, net.minecraft.block.material.Material material) {
		super(material);
		setTag(tag);
		setBlockName(tag);
		//setCreativeTab(SMTCookery.tabCookery);
		setBlockTextureName(SMTCookery.TAG + ":" + tag);
	}

	public BlockDummy setTag(String tag) {
		this.tag = tag;
		return this;
	}

	public String getTag() {return tag;}

}
