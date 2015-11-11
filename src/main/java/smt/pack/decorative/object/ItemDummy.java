package smt.pack.decorative.object;

import smt.pack.decorative.SMTDecorative;

public abstract class ItemDummy extends net.minecraft.item.Item {

	private String tag;

	public ItemDummy(String tag) {
		super();
		setTag(tag);
		setUnlocalizedName(tag);
		//setCreativeTab(SMTDecorative.tabDecorative);
		setTextureName(SMTDecorative.TAG + ":" + tag);
	}

	public ItemDummy setTag(String tag) {
		this.tag = tag;
		return this;
	}

	public String getTag() {return tag;}

}
