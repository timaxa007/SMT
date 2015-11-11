package smt.pack.common.object;

import smt.pack.common.SMTCommon;

public abstract class ItemDummy extends net.minecraft.item.Item {

	private String tag;

	public ItemDummy(String tag) {
		super();
		setTag(tag);
		setUnlocalizedName(tag);
		//setCreativeTab(SMTCommon.tabCommon);
		setTextureName(SMTCommon.TAG + ":" + tag);
	}

	public ItemDummy setTag(String tag) {
		this.tag = tag;
		return this;
	}

	public String getTag() {return tag;}

}
