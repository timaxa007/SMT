package smt.pack.cookery.object;

import smt.pack.cookery.SMTCookery;

public abstract class ItemDummy extends net.minecraft.item.Item {

	private String tag;

	public ItemDummy(String tag) {
		super();
		setTag(tag);
		setUnlocalizedName(tag);
		//setCreativeTab(SMTCookery.tabCookery);
		setTextureName(SMTCookery.TAG + ":" + tag);
	}

	public ItemDummy setTag(String tag) {
		this.tag = tag;
		return this;
	}

	public String getTag() {return tag;}

}
