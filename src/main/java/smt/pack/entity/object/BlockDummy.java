package smt.pack.entity.object;

import smt.pack.entity.SMTEntity;

public abstract class BlockDummy extends net.minecraft.block.Block {

	private String tag;

	public BlockDummy(String tag, net.minecraft.block.material.Material material) {
		super(material);
		setTag(tag);
		setBlockName(tag);
		//setCreativeTab(SMTEntity.tabEntity);
		setBlockTextureName(SMTEntity.TAG + ":" + tag);
	}

	public BlockDummy setTag(String tag) {
		this.tag = tag;
		return this;
	}

	public String getTag() {return tag;}

}
