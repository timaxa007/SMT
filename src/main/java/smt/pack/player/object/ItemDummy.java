package smt.pack.player.object;

import smt.pack.player.SMTPlayer;

public abstract class ItemDummy extends net.minecraft.item.Item {

	private String tag;

	public ItemDummy(String tag) {
		super();
		setTag(tag);
		setUnlocalizedName(tag);
		//setCreativeTab(SMTPlayer.tabPlayer);
		setTextureName(SMTPlayer.TAG + ":" + tag);
	}

	public ItemDummy setTag(String tag) {
		this.tag = tag;
		return this;
	}

	public String getTag() {return tag;}

}
