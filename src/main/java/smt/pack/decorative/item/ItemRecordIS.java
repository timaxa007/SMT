package smt.pack.decorative.item;

import net.minecraft.item.ItemRecord;
import net.minecraft.util.ResourceLocation;
import smt.pack.decorative.SMTDecorative;

public class ItemRecordIS extends ItemRecord {

	public ItemRecordIS(String tag) {
		super(tag);
		setUnlocalizedName(tag);
		setCreativeTab(SMTDecorative.tabDecorative);
		setTextureName(SMTDecorative.MODID + ":" + tag);
	}

	@Override
	public ResourceLocation getRecordResource(String name) {
		return new ResourceLocation("rcservmod", name);
	}

}
