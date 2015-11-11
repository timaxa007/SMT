package smt.pack.magic.object;

import smt.pack.magic.SMTMagic;

public abstract class BlockDummy extends net.minecraft.block.Block {

	private String tag;

	public BlockDummy(String tag, net.minecraft.block.material.Material material) {
		super(material);
		setTag(tag);
		setBlockName(tag);
		//setCreativeTab(SMTMagic.tabMagic);
		setBlockTextureName(SMTMagic.TAG + ":" + tag);
	}

	public BlockDummy setTag(String tag) {
		this.tag = tag;
		return this;
	}

	public String getTag() {return tag;}

}
