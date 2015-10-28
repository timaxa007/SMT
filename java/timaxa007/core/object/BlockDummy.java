package timaxa007.core.object;

import static timaxa007.core.CoreSMT.MODID;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public abstract class BlockDummy extends Block {

	private String tag_name;

	public BlockDummy(String tag, Material material) {
		super(material);
		setTag(tag);
		setBlockName(tag);
		setBlockTextureName(MODID + ":" + tag);
	}

	public BlockDummy setTag(String tag) {
		tag_name = tag;
		return this;
	}

	public String getTag() {
		return tag_name;
	}

}
