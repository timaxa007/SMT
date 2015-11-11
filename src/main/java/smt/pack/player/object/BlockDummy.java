package smt.pack.player.object;

import smt.pack.player.SMTPlayer;

public abstract class BlockDummy extends net.minecraft.block.Block {

	private String tag;

	public BlockDummy(String tag, net.minecraft.block.material.Material material) {
		super(material);
		setTag(tag);
		setBlockName(tag);
		//setCreativeTab(SMTPlayer.tabPlayer);
		setBlockTextureName(SMTPlayer.TAG + ":" + tag);
	}

	public BlockDummy setTag(String tag) {
		this.tag = tag;
		return this;
	}

	public String getTag() {return tag;}

}
