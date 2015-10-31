package timaxa007.core.object;

import static timaxa007.core.CoreSMT.MODID;
import net.minecraft.item.Item;

public abstract class ItemDummy extends Item {

	private String tag_name;

	public ItemDummy(String tag) {
		super();
		setTag(tag);
		setUnlocalizedName(tag);
		setTextureName(MODID + ":" + tag);
	}

	public ItemDummy setTag(String tag) {
		tag_name = tag;
		return this;
	}

	public String getTag() {
		return tag_name;
	}

}
