package smt.pack.phytology.object;

import smt.pack.phytology.SMTPhytology;

public abstract class BlockDummy extends net.minecraft.block.Block {

	private String tag;

	public BlockDummy(String tag, net.minecraft.block.material.Material material) {
		super(material);
		setTag(tag);
		setBlockName(tag);
		//setCreativeTab(SMTPhytology.tabPhytology);
		setBlockTextureName(SMTPhytology.TAG + ":" + tag);
	}

	public BlockDummy setTag(String tag) {
		this.tag = tag;
		return this;
	}

	public String getTag() {return tag;}

}
