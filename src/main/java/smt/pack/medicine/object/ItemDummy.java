package smt.pack.medicine.object;

import smt.pack.medicine.SMTMedicine;

public abstract class ItemDummy extends net.minecraft.item.Item {

	private String tag;

	public ItemDummy(String tag) {
		super();
		setTag(tag);
		setUnlocalizedName(tag);
		//setCreativeTab(SMTMedicine.tabMedicine);
		setTextureName(SMTMedicine.TAG + ":" + tag);
	}

	public ItemDummy setTag(String tag) {
		this.tag = tag;
		return this;
	}

	public String getTag() {return tag;}

}
